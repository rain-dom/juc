package com.example.juc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @GetMapping("/test")
    public String test() {
        System.out.println(Thread.currentThread().getName() + "start");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "end");
        return Thread.currentThread().getName();

    }

}
