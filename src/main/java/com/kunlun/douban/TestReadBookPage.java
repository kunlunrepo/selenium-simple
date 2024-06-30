package com.kunlun.douban;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestReadBookPage extends SeleniumBase{

    /**
     * 初始化
     */
    @BeforeClass
    public void setupClass()
    {
        setup();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://www.douban.com");
    }

    /**
     * 资源清理
     */
    @AfterClass
    public void testDownClass()
    {
        tearDown();
    }

    @Test(priority = 1)
    public void testHomePageTitle()
    {
        String title = webDriver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("豆瓣"), "标题不包含豆瓣");
    }

    @Test(priority = 2)
    public void testEnterBookPage() {
        webDriver.findElement(By.xpath("//*[@id=\"anony-nav\"]/div[1]/ul/li[1]/a")).click();

        // 切换窗口
        webDriver.getWindowHandles().forEach(handle -> webDriver.switchTo().window(handle));

        // 当前窗口
        String currentUrl = webDriver.getCurrentUrl();
        System.out.println("当前" + currentUrl);
        Assert.assertTrue(currentUrl.contains("book.douban.com"), "当前页面不是图书页面");
    }

    @Test(priority = 3)
    public void testSearchPage() {
        // 输入框
        webDriver.findElement(By.id("inp-query")).sendKeys("java");

        // 搜索
        webDriver.findElement(By.xpath("//*[@id=\"db-nav-book\"]/div[1]/div/div[2]/form/fieldset/div[2]/input")).click();

        // 当前窗口
        String currentUrl = webDriver.getCurrentUrl();
        System.out.println("当前" + currentUrl);
        Assert.assertTrue(currentUrl.contains("java"), "当前页面不是搜索页面");
    }

    @Test(priority = 4)
    public void testSearchResult() {
        // 输入框
        WebElement element = webDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div[1]/div[1]/div[3]/div/div/div[1]"));

        String text = element.getText();
        System.out.println(text);

        Assert.assertTrue(text.contains("Java核心技术"), "搜索结果不包含java");
    }

}
