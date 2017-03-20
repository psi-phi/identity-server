#!/usr/bin/env bash

rm common.proto
rm organization.proto
rm gen_java.sh
rm -r ../../java/com/psiphiglobal/identity/proto
wget https://raw.githubusercontent.com/psi-phi/identity-protobuf/sopra-steria/common.proto
wget https://raw.githubusercontent.com/psi-phi/identity-protobuf/sopra-steria/organization.proto
wget https://raw.githubusercontent.com/psi-phi/identity-protobuf/sopra-steria/gen_java.sh
chmod +x gen_java.sh
PROTO_JAVA_OUT_DIR=../../java/ ./gen_java.sh