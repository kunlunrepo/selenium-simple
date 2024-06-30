package com.kunlun.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebElementApi {

    public static void main(String[] args) {
        // 指定驱动路径
        System.setProperty("webdriver.chrome.driver", "D:\\learn\\xd\\chromedriver-win64\\chromedriver.exe");
        // 谷歌驱动
        ChromeOptions options = new ChromeOptions();
        // 允许所有请求
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        // 最大化浏览器窗口
        webDriver.manage().window().maximize();

        // 测试
        test(webDriver);
    }
    public static void test(WebDriver webDriver) {
        try {
            webDriver.get("https://baidu.com");
            TimeUnit.SECONDS.sleep(2);

            // 输入苹果手机
            webDriver.findElement(By.id("kw")).sendKeys("苹果手机");
            TimeUnit.SECONDS.sleep(2);

            // 清空输入框
            webDriver.findElement(By.id("kw")).clear();

            // 输入ipad
            webDriver.findElement(By.id("kw")).sendKeys("ipad");

            // 点击搜索
            webDriver.findElement(By.id("su")).click();

            // 获取点击按钮的属性值
            String value = webDriver.findElement(By.id("su")).getAttribute("value");
            System.out.println(value);

            String type = webDriver.findElement(By.id("su")).getAttribute("type");
            System.out.println(type);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
