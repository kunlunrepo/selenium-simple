package com.kunlun.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class BrowserApi {
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

    private static void test(WebDriver webDriver) {
        try {
            webDriver.get("https://baidu.com");

            // 输入 苹果电脑
            webDriver.findElement(By.id("kw")).sendKeys("苹果电脑");

            webDriver.findElement(By.id("su")).click();
            TimeUnit.SECONDS.sleep(2);

            WebDriver.Navigation navigate = webDriver.navigate();
            // 刷新
            navigate.refresh();
            TimeUnit.SECONDS.sleep(2);
            // 后退
            navigate.back();
            TimeUnit.SECONDS.sleep(2);
            // 前进
            navigate.forward();

            // 调整浏览器大小
            webDriver.manage().window().setSize(new Dimension(300,300));
            TimeUnit.SECONDS.sleep(2);

            // 全屏
            webDriver.manage().window().fullscreen();
            TimeUnit.SECONDS.sleep(2);

            // 退出
            webDriver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
