package com.kunlun.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class KeyboardApi {

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

            // 输入
            WebElement element = webDriver.findElement(By.cssSelector("#kw"));
            element.sendKeys("iphone100教程");
            TimeUnit.SECONDS.sleep(2);

            // 删除一个字
            element.sendKeys(Keys.BACK_SPACE);
            TimeUnit.SECONDS.sleep(2);
            // 输入空格
            element.sendKeys(Keys.SPACE);
            // 输入
            element.sendKeys("程 最新");
            // 搜索
            element.sendKeys(Keys.ENTER);

            // 全选
            element.sendKeys(Keys.CONTROL, "a");
            // 剪切
            element.sendKeys(Keys.CONTROL, "x");
            TimeUnit.SECONDS.sleep(2);
            // 粘贴
            element.sendKeys(Keys.CONTROL, "v");
            element.sendKeys(Keys.CONTROL, "v");
            element.sendKeys(Keys.CONTROL, "v");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
