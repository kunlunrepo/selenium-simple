package com.kunlun.testng;

import org.testng.annotations.*;

public class AnnoTest {

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

    @Test
    public void test()
    {
        System.out.println("test");
    }

    @Test
    public void test2()
    {
        System.out.println("test2");
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
