package com.kunlun.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CookieAdd {

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
            webDriver.get("https://xdclass.net");

            // 创建隐式等待
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // 点击 关闭弹窗
            webDriver.findElement(By.cssSelector("#__nuxt > div > div.main-container > div > div > a > div > div > button")).click();
            TimeUnit.SECONDS.sleep(2);

            String token = "";
            // 创建cookie
            Cookie cookie = new Cookie.Builder("user", token)
                    .domain("xdclass.net")
                    .path("/")
                    .build();
            // 加到会话中
            webDriver.manage().addCookie(cookie);

            // 刷新
            webDriver.navigate().refresh();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
