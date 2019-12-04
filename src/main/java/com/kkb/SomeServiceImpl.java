package com.kkb;

public class SomeServiceImpl implements  SomeService{

    @Override
    public String hello(String name) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("======");
        return name;
    }
}
