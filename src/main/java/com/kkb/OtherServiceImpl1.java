package com.kkb;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class OtherServiceImpl1 implements  OtherService {

    private void sleep(String method){
        long startTime = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long useTime = endTime -startTime;
        System.out.println("方法用时 "+ useTime);
    }
    @Override
    public String doFirst() {

        sleep("doFirst()");
        return "doFirst()";
    }

    @Override
    public String doSecond() {
        sleep("doFirst()");
        return "doSecond()";
    }

    @Override
    public CompletableFuture<String> doThird() {

        long startTime = System.currentTimeMillis();
        sleep("doThird()");
        CompletableFuture<String> future = CompletableFuture.completedFuture("doThird()");
        long endTime =  System.currentTimeMillis();

        long useTime = endTime - startTime;

        System.out.println("doThird() 方法执行用时"+ useTime);

        return future;
    }

    @Override
    public CompletableFuture<String> doFourth() {

        long startTime = System.currentTimeMillis();
        sleep("doFourth()");
        CompletableFuture<String> future = CompletableFuture.completedFuture("doFourth()");
        long endTime =  System.currentTimeMillis();

        long useTime = endTime - startTime;

        System.out.println("doFourth() 方法执行用时"+ useTime);

        return future;
    }
}
