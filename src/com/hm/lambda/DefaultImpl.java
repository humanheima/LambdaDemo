package com.hm.lambda;

import com.hm.lambda.inter.DefaultInterface;

/**
 * Created by dumingwei on 2017/3/13.
 */
public class DefaultImpl implements DefaultInterface {
    @Override
    public void sayGood() {
        System.out.println("DefaultImpl say hello");
    }
}
