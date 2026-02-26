public class NameSource {

    private static int currentID = 0;

    public static String genFreshName(String prefix) {
        String name = "_" + prefix + Integer.toString(currentID);
        currentID++;
        return name;
    }
    public static String genFreshName() {
        return genFreshName("_fresh");
    }

}
