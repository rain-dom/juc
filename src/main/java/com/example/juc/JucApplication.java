package com.example.juc;

import com.example.juc.completeblefuture.T_02_async;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableAsync
public class JucApplication {

    @SneakyThrows
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JucApplication.class, args);
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        T_02_async t_02_async = (T_02_async)context.getBean("t_02_async");

        CompletableFuture<List<String>> fruit  = t_02_async.getOrage();
        CompletableFuture<List<String>> desk = t_02_async.getPlay();
        List<String> list = fruit.thenCombine(desk, (stuff1, stuff2) -> {
            List<String> collect = Stream.of(stuff1, stuff2)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
            return collect;
        }).join();
        System.out.println(list);
    }

}
