package com.hm;

import com.hm.lambda.DefaultFactory;
import com.hm.lambda.DefaultImpl;
import com.hm.lambda.OverrideImpl;
import com.hm.lambda.inter.DefaultInterface;

public class Main {

    public static void main(String[] args) {
        DefaultInterface defaultInterface = DefaultFactory.create(DefaultImpl::new);
        DefaultInterface overrideInterface = DefaultFactory.create(OverrideImpl::new);
        System.out.println(defaultInterface.sayHello());
        System.out.println(overrideInterface.sayHello());
    }


}
