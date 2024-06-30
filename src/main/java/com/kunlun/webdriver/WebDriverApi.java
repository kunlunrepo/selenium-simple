package com.kunlun.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class WebDriverApi {
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
        try{
            // 启动需要打开的网页
            // 判断网页是否打开
            webDriver.get("https://xdclass.net");
            TimeUnit.SECONDS.sleep(2);

            // 获取当前url
            String url = webDriver.getCurrentUrl();
            System.out.println("当前url：" + url);
            // 获取当前title
            String title = webDriver.getTitle();
            System.out.println("当前title：" + title);
            // 获取源码
//            String pageSource = webDriver.getPageSource();
//            System.out.println("当前源码：" + pageSource);
            // 获取当前句柄
            String windowHandle = webDriver.getWindowHandle();
            System.out.println("当前句柄：" + windowHandle);
            // 获取当前所有句柄
            Set<String> windowHandles = webDriver.getWindowHandles();
            for (String handle : windowHandles) {
                System.out.println("当前句柄：" + handle);
            }
            // 关闭浏览器
//            webDriver.quit();
            // 关闭当前窗口
//            webDriver.close();
            // 刷新浏览器
            webDriver.navigate().refresh();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
