/*
package com.xxl.robot.tools;

import com.xxl.robot.constants.PhoneConstants;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

*/
/**
 * todo appium 公共操作类
 *//*

public class AppiumTools {

    public static AndroidDriver init(String robotCode){
        AndroidDriver driver = null;
        if(robotCode.equals("phone001")){
            driver = process("9", PhoneConstants.phone001,PhoneConstants.appActivity001);
        }else if(robotCode.equals("phone002")){
            driver = process("10", PhoneConstants.phone002,PhoneConstants.appActivity002);
        }else if(robotCode.equals("phone003")){
            driver = process("9", PhoneConstants.phone003,PhoneConstants.appActivity003);
        }else if(robotCode.equals("phone0031")){
            driver = process("9", PhoneConstants.phone0031,PhoneConstants.appActivity0031);
        }else if(robotCode.equals("phone0032")){
            driver = process("9", PhoneConstants.phone0032,PhoneConstants.appActivity0032);
        }else if(robotCode.equals("phone0033")){
            driver = process("9", PhoneConstants.phone0033,PhoneConstants.appActivity0033);
        }else if(robotCode.equals("phone0034")){
            driver = process("9", PhoneConstants.phone0034,PhoneConstants.appActivity0034);
        }else if(robotCode.equals("phone0035")){
            driver = process("9", PhoneConstants.phone0035,PhoneConstants.appActivity0035);
        }


      return driver;
    }


    @SneakyThrows
    public static AndroidDriver process(String platformVersion,String deviceName, String appActivity){
       //1.添加配置，创建DesiredCapabilities对象
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //添加操作系统配置
        desiredCapabilities.setCapability("platformName", "Android");
        //添加操作系统版本设置
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        //指定测试设备的名称
        desiredCapabilities.setCapability("deviceName", deviceName);
        //指定想要测试应用的入口activity   (adb shell dumpsys activity | findstr "mResume")
        desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("instrumentApp", true);//added now
        desiredCapabilities.setCapability("showXcodeLog", true);
        desiredCapabilities.setCapability("cssSelectorsEnabled", true);
        desiredCapabilities.setCapability("nativeEvents", true);
        desiredCapabilities.setCapability("nativeWebTap", true);



        //2.创建驱动...URL是appium的固定地址；指定appium通讯的地址，将相对应的配置传入到驱动里边
        AndroidDriver driver = null;
        if(null==driver){
               driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        }
       // AndroidDriver   driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
       // driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        return  driver;
    }



}
*/
