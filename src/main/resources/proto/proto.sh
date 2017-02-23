#!/usr/bin/env bash

rm common.proto
rm organization.proto
rm gen_java.sh
wget https://raw.githubusercontent.com/psi-phi/identity-protobuf/master/common.proto
wget https://raw.githubusercontent.com/psi-phi/identity-protobuf/master/organization.proto
wget https://raw.githubusercontent.com/psi-phi/identity-protobuf/master/gen_java.sh
chmod +x gen_java.sh
PROTO_JAVA_OUT_DIR=../../java/ ./gen_java.sh