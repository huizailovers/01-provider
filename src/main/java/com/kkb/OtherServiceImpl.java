package com.kkb;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class OtherServiceImpl implements  OtherService {


    private void sleep(String method){
        long startTime = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long useTime = endTime-startTime;
        System.out.println(method+"方法执行时间"+ useTime);
    }

    @Override
    public String doFirst() {
        sleep("doFirst");
        return "doFirst";
    }

    @Override
    public String doSecond() {
        sleep("doSecond");
        return "doSecond";
    }

    @Override
    public CompletableFuture<String> doThird() {
        sleep("doThird");

        CompletableFuture<String> future = CompletableFuture.completedFuture("doThird()");
        return future;
    }

    @Override
    public CompletableFuture<String> doFourth() {
        sleep("doFourth");
        CompletableFuture<String> future = CompletableFuture.completedFuture("doFourth()");
        return future;
    }
}
