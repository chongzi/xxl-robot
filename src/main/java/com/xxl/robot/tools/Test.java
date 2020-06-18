package com.xxl.robot.tools;

import com.xxl.robot.enums.CarEnum;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.time.LocalDate;

public class Test {
    /**
     * 几点转当前时间
     * @return
     */
    public static int pointTime(String str){
        int time = 0;
        if(str.contains("一")){
            time = 1;
        }else  if(str.contains("二")){
            time = 2;
        }else  if(str.contains("三")){
            time = 3;
        }else  if(str.contains("四")){
            time = 4;
        }else  if(str.contains("五")){
            time = 5;
        }else  if(str.contains("六")){
            time = 6;
        }else  if(str.contains("七")){
            time = 7;
        }else  if(str.contains("八")){
            time = 8;
        }else  if(str.contains("九")){
            time = 9;
        }else  if(str.contains("十")){
            time = 10;
        }else  if(str.contains("十一")){
            time = 11;
        }else  if(str.contains("十二")){
            time = 12;
        }
        for(int i=1;i<13;i++){
            if(str.contains(""+i)){
                time = i;
            }
        }
        return time;
    }

    /**
     * todo 时间自动补 0
     * @param time
     * @return
     */
    public  static String addZeroForNum(int time) {
        String str = String.valueOf(time);
        int strLen = str.length();
        if (strLen < 2) {
            while (strLen < 2) {
                StringBuffer sb = new StringBuffer();
                sb.append("0").append(str);// 左补0
                str = sb.toString();
                strLen = str.length();
            }
        }
        return str;
    }

    public static int  numberAccount(String str){
        int number = 1;
        if(str.contains("一")){
            number = 1;
        }else if(str.contains("二")){
            number = 2;
        }else if(str.contains("三")){
            number = 3;
        }else if(str.contains("四")){
            number = 4;
        }else if(str.contains("五")){
            number = 5;
        }else if(str.contains("六")){
            number = 6;
        }else if(str.contains("七")){
            number = 7;
        }else if(str.contains("八")){
            number = 8;
        }else if(str.contains("九")){
            number = 9;
        }else if(str.contains("十")){
            number = 10;
        }else if(str.contains("十一")){
            number = 11;
        }else if(str.contains("十二")){
            number = 12;
        }else if(str.contains("十三")){
            number = 13;
        }else if(str.contains("十四")){
            number = 14;
        }else if(str.contains("十五")){
            number = 15;
        }else if(str.contains("十六")){
            number = 16;
        }else if(str.contains("十七")){
            number = 17;
        }else if(str.contains("十八")){
            number = 18;
        }else if(str.contains("十九")){
            number = 19;
        }
        for(int i=1;i<32;i++){
            if(str.contains(""+i)){
                number = i;
            }
        }

        return number;
    }
    public static void main(String[] args) throws InterruptedException {
        String to = null;
        String from = null;
        String startTime = null;
        String rowData = "车找人：今天下午4点左右宿迁，泗阳回上海还有2个位置，有需要的老乡抓紧联系，接送到位，联系电话17601324907微信同号";
        //起始-终点
        if (rowData.contains(CarEnum.BACK.getCode())||rowData.contains(CarEnum.ARRIVE.getCode()) ||rowData.contains(CarEnum.GO.getCode())
                ||rowData.contains(CarEnum.MIDDLE_LINE.getCode())||rowData.contains(CarEnum.MIDDLE_LINE1.getCode())) {
            to = rowData.substring(rowData.indexOf(CarEnum.BACK.getCode())-2,rowData.indexOf(CarEnum.BACK.getCode()));
            from = rowData.substring(rowData.indexOf(CarEnum.BACK.getCode())+1,rowData.indexOf(CarEnum.BACK.getCode())+3);
        }
        //时间
        LocalDate today = LocalDate.now();
        if(rowData.contains(CarEnum.POINT.getCode())){
            //解析几点转时间
            String times = rowData.substring(rowData.indexOf(CarEnum.POINT.getCode())-2, rowData.indexOf(CarEnum.POINT.getCode()));
            int time = pointTime(times);
            if(rowData.contains(CarEnum.TOMORROW.getCode())){
                if(rowData.contains(CarEnum.NOON.getCode())||rowData.contains(CarEnum.AFTERNOON.getCode())||rowData.contains(CarEnum.EVENING.getCode())){
                    time+=12;
                }
                startTime = today.plusDays(1)+" "+addZeroForNum(time)+":00:00";
            }else if(rowData.contains(CarEnum.AFTER_TOMORROW.getCode())){
                if(rowData.contains(CarEnum.NOON.getCode())||rowData.contains(CarEnum.AFTERNOON.getCode())||rowData.contains(CarEnum.EVENING.getCode())){
                    time+=12;
                }
                startTime = today.plusDays(2)+" "+addZeroForNum(time)+":00:00";
            }else{
                if(rowData.contains(CarEnum.NUMBER.getCode())){
                    //包含几号
                    if(rowData.contains(CarEnum.NOON.getCode())||rowData.contains(CarEnum.AFTERNOON.getCode())||rowData.contains(CarEnum.EVENING.getCode())){
                        time+=12;
                    }
                    String numbers = rowData.substring(rowData.indexOf(CarEnum.NUMBER.getCode())-2, rowData.indexOf(CarEnum.NUMBER.getCode()));
                    int number = numberAccount(times);
                    startTime = today.getYear()+"-"+today.getMonth()+"-"+addZeroForNum(number)+" "+addZeroForNum(time)+":00:00";
                }else{
                    if(rowData.contains(CarEnum.NOON.getCode())||rowData.contains(CarEnum.AFTERNOON.getCode())||rowData.contains(CarEnum.EVENING.getCode())){
                        time+=12;
                    }
                    startTime = today+" "+addZeroForNum(time)+":00:00";
                }
            }
        }else{
            if(rowData.contains(CarEnum.MORNING.getCode())){
                startTime = today+" "+"08:00:00";
            }else if(rowData.contains(CarEnum.NOON.getCode())){
                startTime = today+" "+"12:00:00";
            }else if(rowData.contains(CarEnum.AFTERNOON.getCode())){
                startTime = today+" "+"16:00:00";
            }else if(rowData.contains(CarEnum.EVENING.getCode())){
                startTime = today+" "+"19:00:00";
            }
        }

        String mobile = StringTools.getMobile(rowData);


        System.out.println("startTime: " + startTime);
        System.out.println("mobile: " + mobile);
        System.out.println("to: " + to);
        System.out.println("from: " + from);
    }

    /**
     * 把文本设置到剪贴板（复制）
     */
    public static void setClipboardString(String text) {
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 封装文本内容
        Transferable trans = new StringSelection(text);
        // 把文本内容设置到系统剪贴板
        clipboard.setContents(trans, null);
    }

    /**
     * 从剪贴板中获取文本（粘贴）
     */
    public static String getClipboardString() {
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        // 获取剪贴板中的内容
        Transferable trans = clipboard.getContents(null);

        if (trans != null) {
            // 判断剪贴板中的内容是否支持文本
            if (trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    // 获取剪贴板中的文本内容
                    String text = (String) trans.getTransferData(DataFlavor.stringFlavor);
                    return text;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

}