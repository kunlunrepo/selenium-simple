package com.kunlun.diff;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

public class SnapshotScreenshot {

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
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // 获取输入框
            WebElement element = webDriver.findElement(By.id("kw"));
            element.sendKeys("苹果手机1000");

            // 点击搜索
            webDriver.findElement(By.id("su")).click();

            // 存储快照截图
            File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);

            // 保存到本地
            String path = "./1.png";
            File targetFile = new File(path);
            try(FileOutputStream fos = new FileOutputStream(targetFile);
                FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[1024];
                int total = 0;
                while ((total = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, total);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
