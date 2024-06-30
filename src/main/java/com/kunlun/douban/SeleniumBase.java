package com.kunlun.douban;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumBase {

    protected WebDriver webDriver;

    /**
     * 初始化
     */
    public void setup() {
        // 指定驱动路径
        System.setProperty("webdriver.chrome.driver", "D:\\learn\\xd\\chromedriver-win64\\chromedriver.exe");
        // 谷歌驱动
        ChromeOptions options = new ChromeOptions();
        // 允许所有请求
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        // 最大化浏览器窗口
        webDriver.manage().window().maximize();
    }

    /**
     * 退出浏览器
     */
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    /**
     * 定位元素
     */
    public void findElement() {
        // 获取元素
        webDriver.findElement(null);
        // 获取元素列表
        webDriver.findElements(null);
    }
}
