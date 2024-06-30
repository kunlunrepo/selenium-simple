package com.kunlun.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTestNg {

    @Test
    public void testSetup() {
        System.out.println("testSetup");
    }

    @Test
    public void testAssert() {
        System.out.println("这是一个断言测试");
        int a = 9;
        int b = 100;
        Assert.assertTrue(a > b, "判断错误，出问题了");
    }
}
