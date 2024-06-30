package com.kunlun.diff;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Select {

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
            webDriver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");

            // 切换到iframe
            WebElement iframeElement = webDriver.findElement(By.xpath("//div[@id=\"iframewrapper\"]/iframe"));
            webDriver.switchTo().frame(iframeElement);

            // 创建显示等待
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("cars")));

            // 点击
            WebElement element = webDriver.findElement(By.id("cars"));
            element.click();

            org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(element);
            List<WebElement> options = select.getOptions();
            for (WebElement option : options) {
                System.out.println(option.getText());
            }

            // 根据可见文本选择
            select.selectByVisibleText("Opel");
            select.selectByIndex(1);

            // 是否多项选择
            System.out.println(select.isMultiple());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
