package com.kunlun.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitApi {

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
        try{
            webDriver.get("https://baidu.com");

            // 创建显示等待，最大10秒
//            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//            // 等待元素可见
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kw")));

            // 隐式等待，可以用一个不存在的元素做测试
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // 输入
            WebElement element = webDriver.findElement(By.id("kw"));
            element.sendKeys("苹果手机10000");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
