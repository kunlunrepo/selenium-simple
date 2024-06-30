package com.kunlun.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseApi {

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

            // 输入
            webDriver.findElement(By.cssSelector("#kw")).sendKeys("iphone100");
            TimeUnit.SECONDS.sleep(2);

            // 点击搜索
            webDriver.findElement(By.cssSelector("#su")).click();
            TimeUnit.SECONDS.sleep(2);

            // 选择文库
            WebElement element = webDriver.findElement(By.cssSelector("#s_tab > div > a.s-tab-item.s-tab-item_1CwH-.s-tab-wenku_GwhrW.s-tab-wenku"));
            TimeUnit.SECONDS.sleep(2);

            // 鼠标右键
            Actions actions = new Actions(webDriver);
            // 鼠标移动到元素
            actions.moveToElement(element).contextClick().perform();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
