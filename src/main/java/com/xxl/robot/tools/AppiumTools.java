package com.xxl.robot.tools;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AppiumTools {


    @SneakyThrows
    public static void process(){
       //1.添加配置，创建DesiredCapabilities对象
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //添加操作系统配置
        desiredCapabilities.setCapability("platformName", "Android");
        //添加操作系统版本设置
        desiredCapabilities.setCapability("platformVersion", "10");
        //指定测试设备的名称
        desiredCapabilities.setCapability("deviceName", "4ed14c6a");
        //指定想要测试应用的入口activity
        desiredCapabilities.setCapability("appActivity", ".launcher.Launcher t1");

        //2.创建驱动...URL是appium的固定地址；指定appium通讯的地址，将相对应的配置传入到驱动里边
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);


        MobileElement el10 = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"今日头条\"]");
        el10.click();



      /*  MobileElement el2 = (MobileElement) driver.findElementById("com.ss.android.article.news:id/cju");
        el2.click();
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("推荐");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("(//android.widget.RelativeLayout[@content-desc=\"A综合\"])[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageView[1]");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"书旗小说\"]");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementByXPath("//com.uc.webview.export.WebView[@content-desc=\"WVUCWebView\"]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[@content-desc=\"ActionBarActivity的根View\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.Button[2]");
        el8.click();
        driver.navigate().back();
        MobileElement el9 = (MobileElement) driver.findElementByXPath("//android.widget.RelativeLayout[@content-desc=\"ActionBarActivity的根View\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.Button[2]");
        el9.click();*/


    }

    public static void main(String[] args) {
        process();
    }


}
