package com.kunlun.diff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Iframe {

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
            webDriver.get("https://www.126.com");
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // 切换到对应的iframe才可以
            WebElement element = webDriver.findElement(By.xpath("//div[@id='loginDiv']/iframe")); // iframe的上一级
            webDriver.switchTo().frame(element);

            // 定位账号输入框
            WebElement userName = webDriver.findElement(By.xpath("//div[@class='u-input box']/input[@name='email']"));
            userName.sendKeys("kunlun");

            // 定位密码输入框
            WebElement password = webDriver.findElement(By.xpath("//div[@class='u-input box']/input[@name='password']"));
            password.sendKeys("123456");

            String text = webDriver.findElement(By.id("dologin")).getText();
            System.out.println(text);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
