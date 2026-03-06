import ast.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Interp {
    public Interp() {

    }

    public int unwrapInt(Value v) {
        if (v instanceof VInt) {
            return ((VInt) v).getValue();
        } else {
            throw new TypeErrorException("Type Error: " +v.toString() + "not integer value in (unwrapInt)");
        }
    }

    public boolean unwrapBool(Value v) {
        if (v instanceof VBool) {
            return ((VBool) v).getValue();
        } else {
            throw new TypeErrorException("Type Error: " + v.toString() + "not boolean value in (unwrapBool)");
        }
    }
    public InterpResult interpExpr(Expr expr) {
        if (expr instanceof EInt) {
            EInt e = (EInt) expr;
            return new InterpResult(new VInt(e.getValue()), new ArrayList<>());

        } else if (expr instanceof ELambda) {
            ELambda e = (ELambda) expr;
            return new InterpResult(new VLambda(e.getParameter(), e.getParameterType(), e.getBody()), new ArrayList<>());

        } else if (expr instanceof ERec) {
            ERec e = (ERec) expr;
            return new InterpResult(new VRec(e.getFunName(), e.getArgName(), e.getArgType(), e.getResultType(), e.getBody()), new ArrayList<>());

        } else if (expr instanceof ECond) {
            ECond e = (ECond) expr;
            InterpResult predicate = interpExpr(e.getTest());
            VBool res = (VBool) predicate.getValue();
            if (unwrapBool(res)) {
                InterpResult thenBranch = interpExpr(e.getThenBranch());
                thenBranch.getInstructions().addAll(predicate.getInstructions());
                return thenBranch;
            } else {
                InterpResult elseBranch = interpExpr(e.getElseBranch());
                elseBranch.getInstructions().addAll(predicate.getInstructions());
                return elseBranch;
            }

        } else if (expr instanceof EFst) {
            EFst e = (EFst) expr;
            EPair p = (EPair) e.getPair();
            return interpExpr(p.getFirst());
            
        } else if (expr instanceof EForward) {
            EForward e = (EForward) expr;
            InterpResult move = interpExpr(e.getAmount());
            VInt amount = (VInt) move.getValue();

            List<Instruction> l = new ArrayList<>();
            l.add(new IMove(amount.getValue()));
            l.addAll(move.getInstructions());

            return new InterpResult(new VUnit(), l);

        } else if (expr instanceof EBackward) {
            EBackward e = (EBackward) expr;
            InterpResult move = interpExpr(e.getAmount());
            VInt amount = (VInt) move.getValue();

            List<Instruction> l = new ArrayList<>();
            l.add(new IMove(-amount.getValue()));
            l.addAll(move.getInstructions());

            return new InterpResult(new VUnit(), l);

        } else if (expr instanceof ETurnRight) {
            ETurnRight e = (ETurnRight) expr;
            InterpResult move = interpExpr(e.getAmount());
            VInt amount = (VInt) move.getValue();

            List<Instruction> l = new ArrayList<>();
            l.add(new ITurn(amount.getValue()));
            l.addAll(move.getInstructions());

            return new InterpResult(new VUnit(), l);

        } else if (expr instanceof ETurnLeft) {
            ETurnLeft e = (ETurnLeft) expr;
            InterpResult move = interpExpr(e.getAmount());
            VInt amount = (VInt) move.getValue();

            List<Instruction> l = new ArrayList<>();
            l.add(new ITurn(amount.getValue()));
            l.addAll(move.getInstructions());

            return new InterpResult(new VUnit(), l);

        } else if (expr instanceof ESetPen) {
            ESetPen e = (ESetPen) expr;
            List<Instruction> l = new ArrayList<>();

            l.add(new ISetPen(e.isPenDown()));    
            return new InterpResult(new VUnit(), l);

        } else if (expr instanceof ESetCol) {
            ESetCol e = (ESetCol) expr;
            
            InterpResult res = interpExpr(e.getColour());
            VColour colour = (VColour) res.getValue();

            List<Instruction> l = new ArrayList<>();
            l.add(new IChangeColour(colour.getColour()));
            l.addAll(res.getInstructions());

            return new InterpResult(new VUnit(), l);

        } else if (expr instanceof ERandCol) {
            ERandCol e = (ERandCol) expr;

            InterpResult res = interpExpr(e.getColourList());
            VList vl = (VList) res.getValue();

            if (vl.getContents().isEmpty()) {
                List<Instruction> l = new ArrayList<>();
                l.addAll(res.getInstructions());
                return new InterpResult(new VUnit(), l);
            } else {
                Random rng = new Random();
                int k = rng.nextInt(vl.getContents().size());

                List<Instruction> l = new ArrayList<>();
                VColour colour = (VColour) vl.getContents().get(k);
                l.add(new IChangeColour(colour.getColour()));
                l.addAll(res.getInstructions());

                return new InterpResult(new VUnit(), l);
            }

        } else if (expr instanceof ESnd) {
            EPair p = (EPair) ((ESnd) expr).getPair();
            return interpExpr(p.getSecond());

        } else if (expr instanceof EUnit) {
            return new InterpResult(new VUnit(), new ArrayList<>());

        } else if (expr instanceof ESequence) {
            ESequence e = (ESequence) expr;
            InterpResult v = interpExpr(e.getE1());
            InterpResult res = interpExpr(e.getE2());
            res.getInstructions().addAll(v.getInstructions());
            return res;

        } else if (expr instanceof EPair) {
            EPair e = (EPair) expr;
            InterpResult v = interpExpr(e.getFirst());
            InterpResult w = interpExpr(e.getSecond());

            InterpResult res =  new InterpResult(new VPair(v.getValue(), w.getValue()), new ArrayList<>());
            res.getInstructions().addAll(v.getInstructions());
            res.getInstructions().addAll(w.getInstructions());
            return res;

        } else if (expr instanceof ECase) {
            ECase e = (ECase) expr;
            InterpResult scrut = interpExpr(e.getScrutinee());
            VList l = (VList) scrut.getValue();
            if (l.toExpr() instanceof ENil) {
                InterpResult empty = interpExpr(e.getEmptyCase());
                empty.getInstructions().addAll(scrut.getInstructions());
                return empty;
            } else {
                ECons oldCons = (ECons) l.toExpr();
                ECons newCons = (ECons) e.getConsCase();
                Expr substHead = Subst.subst(oldCons.getHead(), newCons.getHead(), e.getHeadBinder());
                Expr substTail = Subst.subst(oldCons.getTail(), newCons.getTail(), e.getTailBinder());
                ECons substCons = new ECons(substHead, substTail);
                return interpExpr(substCons);
            }
        } else if (expr instanceof ENil) {
            return new InterpResult(new VList(new ArrayList<>()), new ArrayList<>());

        } else if (expr instanceof EBinOp) {
            EBinOp e = (EBinOp) expr;
            InterpResult v1 = interpExpr(e.getE1());
            InterpResult v2 = interpExpr(e.getE2());
            InterpResult res = null;

            switch (e.getOp()) {
                case ADD -> res = new InterpResult(new VInt(unwrapInt(v1.getValue()) + unwrapInt(v2.getValue())), new ArrayList<>());
                case AND -> res = new InterpResult(new VBool(unwrapBool(v1.getValue()) && unwrapBool(v2.getValue())), new ArrayList<>());
                case DIV -> res = new InterpResult(new VInt(unwrapInt(v1.getValue()) / unwrapInt(v2.getValue())), new ArrayList<>());
                case EQ -> res = new InterpResult(new VBool(unwrapInt(v1.getValue()) == unwrapInt(v2.getValue())), new ArrayList<>());
                case GT -> res = new InterpResult(new VBool(unwrapInt(v1.getValue()) > unwrapInt(v2.getValue())), new ArrayList<>());
                case GTE -> res = new InterpResult(new VBool(unwrapInt(v1.getValue()) >= unwrapInt(v2.getValue())), new ArrayList<>());
                case LT -> res = new InterpResult(new VBool(unwrapInt(v1.getValue()) < unwrapInt(v2.getValue())), new ArrayList<>());
                case LTE -> res = new InterpResult(new VBool(unwrapInt(v1.getValue()) <= unwrapInt(v2.getValue())), new ArrayList<>());
                case MUL -> res = new InterpResult(new VInt(unwrapInt(v1.getValue()) * unwrapInt(v2.getValue())), new ArrayList<>());
                case OR -> res = new InterpResult(new VBool(unwrapBool(v1.getValue()) || unwrapBool(v2.getValue())), new ArrayList<>());
                case SUB -> res = new InterpResult(new VInt(unwrapInt(v1.getValue()) - unwrapInt(v2.getValue())), new ArrayList<>());
            }

            if (res == null) {
                throw new TypeErrorException("Type Error: Unhandled operator: " + e.getOp().toString());
            }

            res.getInstructions().addAll(v1.getInstructions());
            res.getInstructions().addAll(v2.getInstructions());
            return res;
        } else if (expr instanceof ECons) {
            ECons e = (ECons) expr;
            InterpResult m = interpExpr(e.getHead());
            InterpResult n = interpExpr(e.getTail());
            VList l = (VList) n.getValue();
            l.getContents().addFirst(m.getValue());
            n.getInstructions().addAll(m.getInstructions());
            return n;
        } else if (expr instanceof EApp) {
            EApp e = (EApp) expr;
            InterpResult ir = interpExpr(e.getFunction());
            Value v1 = ir.getValue();
            if (v1 instanceof VLambda) {
                VLambda l =  (VLambda) v1;
                InterpResult arg = interpExpr(e.getArgument());
                Expr subst = Subst.subst(l.getBody(), arg.getValue().toExpr(), l.getParameter());
                InterpResult res = interpExpr(subst);
                res.getInstructions().addAll(arg.getInstructions());
                res.getInstructions().addAll(ir.getInstructions());
                return res;
            } else if (v1 instanceof VRec) {
                VRec rec = (VRec) v1;
                InterpResult arg = interpExpr(e.getArgument());
                Expr subst = Subst.subst(rec.getBody(), arg.getValue().toExpr(), rec.getArgName());
                Expr substRec = Subst.subst(subst, rec.toExpr(), rec.getFunName());
                InterpResult res = interpExpr(substRec);
                res.getInstructions().addAll(arg.getInstructions());
                res.getInstructions().addAll(ir.getInstructions());
                return res;
            } else {
                throw new TypeErrorException("Type Error: Unhandled expression in EApp (interpExpr): " + e.toString());
            }
        } else if (expr instanceof ELet) {
            ELet e = (ELet) expr;
            InterpResult M = interpExpr(e.getSubject());
            Expr cont = Subst.subst(e.getContinuation(), M.getValue().toExpr(), e.getBinder());
            InterpResult N = interpExpr(cont);
            N.getInstructions().addAll(M.getInstructions());
            return N;
        } else if (expr instanceof EColour) {
            EColour e = (EColour) expr;
            return new InterpResult(new VColour(e.getColour()), new ArrayList<>());
        } else {
            throw new TypeErrorException("Type Error: Unhandled expression in (interpExpr): " + expr.getClass() + "\nInstructions: "+ expr.toString() );
        }
    }


}
