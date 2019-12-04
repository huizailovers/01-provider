package com.kkb;

public class NewSomeServiceImpl implements  SomeService {
    @Override
    public String hello(String name) {

        System.out.println("new === ");
        return "新的 实现类";
    }
}
