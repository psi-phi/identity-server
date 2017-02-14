#!/usr/bin/env bash

rm common.proto
rm organization.proto
wget https://raw.githubusercontent.com/psi-phi/identity-protobuf/master/common.proto
wget https://raw.githubusercontent.com/psi-phi/identity-protobuf/master/organization.proto
protoc --java_out=../../java/ common.proto organization.proto