package com.example.juc.completeblefuture;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class T_02_async {

    @Async
    public CompletableFuture<List<String>> getOrage() throws InterruptedException {
        System.out.println("start:" + Thread.currentThread().getName());
        Thread.sleep(5000);
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");

        System.out.println("end:" + Thread.currentThread().getName());
        return new AsyncResult<>(list).completable();
    }

    @Async
    public CompletableFuture<List<String>> getPlay() throws InterruptedException {
        System.out.println("start:" + Thread.currentThread().getName());
        Thread.sleep(5000);
        List<String> list = new ArrayList<>();
        list.add("pen");
        list.add("ruler");
        System.out.println("end:" + Thread.currentThread().getName());
        return new AsyncResult<>(list).completable();
    }





}
