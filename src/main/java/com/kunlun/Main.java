package com.kunlun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class Main {
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
        idTest(webDriver);
    }

    private static void idTest(WebDriver webDriver) {
        try{
            // 启动需要打开的网页
            // 判断网页是否打开
            webDriver.get("https://xdclass.net");
            TimeUnit.SECONDS.sleep(2);

            // 点击事件 关闭弹窗
            webDriver.findElement(By.cssSelector("#__nuxt > div > div.main-container > div > div > a > div > div > button")).click();

            // 利用ID定位元素，输入javase课程
            WebElement element = webDriver.findElement(By.id("rc_select_0"));
            element.sendKeys("javase");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
