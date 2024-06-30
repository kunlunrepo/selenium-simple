package com.kunlun.diff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Set;

/**
 * 多tab页切换
 */
public class MulTab {

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
            // 打开网页
            webDriver.get("https://baidu.com");
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // 获取句柄
            String defaultHandle = webDriver.getWindowHandle();
            System.out.println("默认句柄：" + defaultHandle);

            // 获取 新闻页面
            webDriver.findElement(By.cssSelector("#s-top-left > a:nth-child(1)")).click();

            // 获取全部句柄
            Set<String> windowHandles = webDriver.getWindowHandles();
            String newHandle = "";
            for (String handle : windowHandles) {
                System.out.println("handle：" + handle);
                // 记录最后一个窗口的句柄
                if (!handle.equals(defaultHandle)) {
                    newHandle = handle;
                }
            }

            // 切换窗口,如果没调用切换，则操作会失败
            if (!newHandle.equals("")) {
//                webDriver.switchTo().window(newHandle);
            }

            String text = webDriver.findElement(By.cssSelector("#headline-tabs > ul > li > a")).getText();
            System.out.println("text：" + text);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
