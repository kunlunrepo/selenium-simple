package com.kunlun.diff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Alert {

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
            webDriver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

            // 切换到iframe
            WebElement iframeElement = webDriver.findElement(By.xpath("//div[@id=\"iframewrapper\"]/iframe"));
            webDriver.switchTo().frame(iframeElement);

            // 创建显示等待
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/button")));

            // 点击
            WebElement element = webDriver.findElement(By.xpath("/html/body/button"));
            element.click();

            // 切换到alert
            org.openqa.selenium.Alert alert = webDriver.switchTo().alert();
            System.out.println("alert 文本"+alert.getText());

            // 接受
//            alert.accept();

            // 拒绝
            alert.dismiss();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
