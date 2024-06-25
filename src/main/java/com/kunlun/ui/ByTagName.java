package com.kunlun.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class ByTagName {
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
        tagNameTest(webDriver);
    }

    private static void tagNameTest(WebDriver webDriver) {
        try{
            // 启动需要打开的网页
            // 判断网页是否打开
            webDriver.get("https://www.baidu.com");
            TimeUnit.SECONDS.sleep(2);

            // 定位元素
            List<WebElement> elements = webDriver.findElements(By.tagName("a"));
            for (WebElement element : elements) {
                String text = element.getText();
                System.out.println(text);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
