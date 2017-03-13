package com.hm.lambda;

import com.hm.lambda.inter.DefaultInterface;

/**
 * Created by dumingwei on 2017/3/13.
 */
public class OverrideImpl implements DefaultInterface {
    @Override
    public String sayHello() {
        return "OverrideImpl hello world";
    }

    @Override
    public void sayGood() {
        System.out.println("OverrideImpl say hello");
    }
}
