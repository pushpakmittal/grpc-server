package com.myapp.grpcserver.service;

import com.myapp.grpc_server.proto.GreetingGrpc;
import com.myapp.grpc_server.proto.HelloRequest;
import com.myapp.grpc_server.proto.HelloResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloService extends GreetingGrpc.GreetingImplBase {
    @Override
    public void welcome(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        responseObserver.onNext(HelloResponse.newBuilder().setMessage("welcome : " + request.getName()).build());
        responseObserver.onCompleted();
    }
}
