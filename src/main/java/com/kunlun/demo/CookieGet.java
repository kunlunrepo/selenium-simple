package com.kunlun.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CookieGet {

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

            // 点击 登录
            WebElement element = webDriver.findElement(By.xpath("//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div[1]/div[2]/div/span[1]"));
            element.click();

            // 输入账号密码
            webDriver.findElement(By.id("form_item_account")).sendKeys("123456");
            webDriver.findElement(By.id("form_item_password")).sendKeys("888888");
            TimeUnit.SECONDS.sleep(2);

            // 登录
            webDriver.findElement(By.cssSelector("#__nuxt > div > div:nth-child(1) > div.header-container > div.reg-modal > div > div > div:nth-child(2) > form > div:nth-child(4) > div > div > div > button")).click();

            // 获取cookie
            Set<org.openqa.selenium.Cookie> cookies = webDriver.manage().getCookies();
            for (org.openqa.selenium.Cookie cookie : cookies) {
                System.out.println(cookie.getName() + ":" + cookie.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
