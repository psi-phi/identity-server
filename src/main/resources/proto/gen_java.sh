#!/usr/bin/env bash

protoc --java_out=$PROTO_JAVA_OUT_DIR common.proto organization.proto
