package com.kunlun.testng;

import org.testng.annotations.*;

public class VerifyOrderTest {

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass()
    {
        System.out.println("afterClass");
    }

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("beforeMethod");
    }

    @AfterMethod
    public void afterMethod()
    {
        System.out.println("afterMethod");
    }

    @Test(priority = 3)
    public void test()
    {
        System.out.println("test");
    }

    @Test(priority = 2)
    public void test2()
    {
        System.out.println("test2");
    }

    @Test(priority = 1, dependsOnMethods = {"test4"}) // 优先级 数值越小，优先级越高
    public void test3()
    {
        System.out.println("test3");
    }

    @Test(priority = 5) // 优先级 数值越小，优先级越高
    public void test4()
    {
        System.out.println("test4");
    }


    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider()
    {
        return new Object[][]{
                {"1", "老王1"},
                {"3", "老王3"},
                {"8", "老王8"},
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testDataProvider(String name, String age) {
        System.out.println("name:" + name + ",age:" + age);
    }

}
