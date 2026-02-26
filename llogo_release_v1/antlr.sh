#!/usr/bin/env bash
pushd src/antlr
java -jar ../../lib/antlr.jar -no-listener -visitor LLogo.g4
popd
rm -rf src/antlr/.antlr
