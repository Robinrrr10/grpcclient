package com.github;

import com.github.models.userGrpc;
import com.github.models.User.AccountRequest;
import com.github.models.User.LoginLogoutResponse;
import com.github.models.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args) {
 
    ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
    
    userBlockingStub stub = userGrpc.newBlockingStub(managedChannel); // newBlockingStub - this is sync (wait for response) , newStub - this is async(wont wait for response), newFutureStub is also there

    AccountRequest accountRequest = AccountRequest.newBuilder().setName("Babu").setPassword("Babu").build();
    LoginLogoutResponse response = stub.login(accountRequest);

    System.out.println("response status is:" + response.getStatus());
    System.out.println("response message is:" + response.getMessage());
    }
}
