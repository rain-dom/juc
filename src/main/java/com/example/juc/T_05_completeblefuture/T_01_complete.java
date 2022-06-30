package com.example.juc.T_05_completeblefuture;

import java.util.concurrent.CompletableFuture;

public class T_01_complete {

    public static void main(String[] args) {


        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "success";
        });
        future.whenComplete((reutle, error) -> {
            System.out.println("result: " + reutle);
            error.printStackTrace();
        });
//        future.handleAsync()

    }

}
