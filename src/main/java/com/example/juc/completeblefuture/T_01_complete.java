package com.example.juc.completeblefuture;

import java.util.concurrent.CompletableFuture;

public class T_01_complete {

    public static void main(String[] args) {
        

        CompletableFuture.supplyAsync(()->{
            return "success";
        });
    }

}
