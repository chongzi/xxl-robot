package com.xxl.robot.app.appium;

import com.xxl.robot.constants.AppConstants;
import com.xxl.robot.constants.PhoneConstants;
import com.xxl.robot.entity.PhoneCode;
import com.xxl.robot.tools.AdbTools;
import com.xxl.robot.tools.AppiumTools;
import com.xxl.robot.tools.MouseTools;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import java.awt.*;
import java.io.IOException;
import java.io.StringReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;
import java.util.Iterator;

/**
 * todo App抖音
 * app-用户行为操作(签到，看视频，关注，点赞，收藏，评论，开宝箱，种菜，走路)
 */



public class App抖音 {
    private static Logger log = LoggerFactory.getLogger(App抖音.class);



    /**
     * todo 1.
     * 以category分类定位，再点击用户行为,用一category下不可多次点击category,否则试为程序运行
     * 传相应的app_code对应的phoneCodeDtos
     */




    public static void handle(Robot robot,String robotCode, String event){
        log.info("robotCode:{}" + robotCode);
        String androidId = "";
        if (robotCode.equals("phone001")) {
            androidId = PhoneConstants.phone001;
        } else if (robotCode.equals("phone002")) {
            androidId = PhoneConstants.phone002;
        } else if (robotCode.equals("phone003")) {
            androidId = PhoneConstants.phone003;
        } else if (robotCode.equals("phone0031")) {
            androidId = PhoneConstants.phone0031;
        } else if (robotCode.equals("phone0032")) {
            androidId = PhoneConstants.phone0032;
        } else if (robotCode.equals("phone0033")) {
            androidId = PhoneConstants.phone0033;
        } else if (robotCode.equals("phone0034")) {
            androidId = PhoneConstants.phone0034;
        } else if (robotCode.equals("phone0035")) {
            androidId = PhoneConstants.phone0035;
        }

        if(StringUtils.isBlank(androidId))return;
//*************************************************************业务处理  START ***************************************************************************
        if(!AdbTools.screen(androidId)) {
            log.info("0.唤醒手机屏幕");
            String operateScreen = "adb -s " + androidId + " shell input keyevent 26";
            MouseTools.fastNormalEvent(robot, operateScreen);
        }
        log.info("0.返回主界面");
        String operateHome = "adb -s " + androidId + " shell input keyevent 3";
        MouseTools.fastNormalEvent(robot, operateHome);

        log.info("0.调取缓存");
        String operateDispath = "adb -s " + androidId + " shell input keyevent 82";
        MouseTools.fastNormalEvent(robot, operateDispath);

        log.info("0.删除缓存");
        String operateDelete = "";
        if (androidId.equals(PhoneConstants.phone001)) {
            operateDispath = "adb -s " + androidId + " shell input tap 770 2280";
            MouseTools.fastNormalEvent(robot, operateDispath);
            operateDelete = AdbTools.tap(androidId, String.valueOf(540), String.valueOf(2080));
        } else if (androidId.equals(PhoneConstants.phone002)) {
            operateDelete = AdbTools.tap(androidId, String.valueOf(540), String.valueOf(2000));
        } else if (androidId.equals(PhoneConstants.phone003)||androidId.equals(PhoneConstants.phone0031)
                ||androidId.equals(PhoneConstants.phone0032)||androidId.equals(PhoneConstants.phone0033)
                ||androidId.equals(PhoneConstants.phone0034)||androidId.equals(PhoneConstants.phone0035)) {
            operateDelete = AdbTools.tap(androidId, String.valueOf(540), String.valueOf(1860));
        }
        MouseTools.fastNormalEvent(robot, operateDelete);

        log.info("0.返回主界面");
        MouseTools.fastNormalEvent(robot, operateHome);

        log.info("1.动作");
        String operate1 =  " 抖音-" + event;
        MouseTools.fastNormalEvent(robot, operate1);


        switch (event){
            case AppConstants.CHECK_IN://签到
                handle1(robot, robotCode,  event);
                break;
            case AppConstants.WATCH_VIDEOS://看视频（看视频，看广告-点攒）
                handle2(robot, robotCode,  event, androidId);
                break;
        }

    }




    /**
     * todo 1.签到
     * @param robot

     */




    public static void handle1(Robot robot,String robotCode, String  event){

    }



    /**
     * todo 2.看视频
     * @param robot

     */




    @SneakyThrows
    public static void handle2(Robot robot, String robotCode, String  event, String androidId)  {

        String appinit = "adb -s" + androidId + " shell am start -n " +"com.ss.android.ugc.aweme.lite/com.ss.android.ugc.aweme.splash.SplashActivity";
        AdbTools.process(robot,appinit);

        AndroidDriver driver = AppiumTools.init(robotCode);


        String operate45 = AdbTools.tap(androidId, "110", "2140");;
        AdbTools.process(robot,operate45);
        System.out.println("*************************首页 START****************************");
        System.out.println(LocalDateTime.now());




        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        System.out.println(LocalDateTime.now());
        System.out.println("*************************首页 END****************************");

        robot.delay(1000);
        String operate44 = AdbTools.tap(androidId, "540", "2140");;
        AdbTools.process(robot,operate44);
        robot.delay(1000);
        driver.runAppInBackground(Duration.ofSeconds(1));

        System.out.println("*************************金币 START****************************");
        System.out.println(LocalDateTime.now());
        pageSource = driver.getPageSource();
        System.out.println(pageSource);
        System.out.println(LocalDateTime.now());
        System.out.println("*************************金币 END****************************");





        String operateBack = "adb -s " + androidId + " shell input keyevent BACK";

        MobileElement el3 = (MobileElement) driver.findElementByName("每20分钟完成一次广告任务，单日最高可赚21960金币");//看广告
        el3.click();
        AdbTools.process(robot, operateBack);

        MobileElement el4 = (MobileElement) driver.findElementByXPath("//android.widget.Image[@text='开宝箱得金币']");//开宝箱
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='看广告视频再赚']");//开宝箱
        el5.click();
        AdbTools.process(robot, operateBack);

        MobileElement el6 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='睡觉赚金币']");//睡觉
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@text,'开启')]");//开启
        el7.click();
        AdbTools.process(robot, operateBack);


        MobileElement el8 = (MobileElement) driver.findElementByXPath("//android.view.View[@text='走路赚金币']");//走路赚金币
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementById("app']");//领取金币
        el9.click();
        AdbTools.process(robot, operateBack);





    }




    public static List xmlElements(String xmlDoc) {

        //创建一个新的字符串
        StringReader read = new StringReader(xmlDoc);
        //创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
        InputSource source = new InputSource(read);
        //创建一个新的SAXBuilder
        SAXBuilder sb = new SAXBuilder();

        try {
            //通过输入源构造一个Document
            Document doc = sb.build(source);
            //取的根元素
            Element root = doc.getRootElement();
            System.out.println(root.getName());//输出根元素的名称（测试）
            //得到根元素所有子元素的集合
            List jiedian = root.getChildren();



            Element et = null;
            for(int i=0;i<jiedian.size();i++){
                et = (Element) jiedian.get(i);//循环依次得到子元素
                System.out.println("------------------------------------------------");
                //if(StringUtils.isNotBlank(et.getAttributeValue("text"))&&"开宝箱得金币".equals("et.getAttributeValue(\"text\")")) {
                System.out.println("name:" + et.getAttributeValue("text"));
                System.out.println("num:" + et.getAttributeValue("bounds"));
                //}


            }

        } catch (JDOMException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String args[]) throws AWTException {
        Robot robot = new Robot();
        handle(robot, "phone002", AppConstants.WATCH_VIDEOS);



    }


}


