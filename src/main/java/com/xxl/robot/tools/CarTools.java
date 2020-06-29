package com.xxl.robot.tools;

import com.xxl.robot.enums.CarEnum;
import com.xxl.robot.time.GrabbingCarSchedule;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * todo 解析对话一行数据
 */
public class CarTools {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CarTools.class);

   public static Map<String,Object> analysis(String rowData){
       Map<String,Object> map = new HashMap<>();
       try {
           String to = null;
           String from = null;
           String startTime = null;
           int personNumber = 1;

           //起始-终点
           String toFrom = null;
           if (rowData.contains(CarEnum.MIDDLE_LINE1.getCode())) {
               toFrom = CarEnum.MIDDLE_LINE1.getCode();
           }
           if (rowData.contains(CarEnum.MIDDLE_LINE.getCode())) {
               toFrom = CarEnum.MIDDLE_LINE.getCode();
           }
           if (rowData.contains(CarEnum.ARRIVE.getCode())&&(!rowData.contains(CarEnum.ARRIVE_DA.getCode()))) {
               toFrom = CarEnum.ARRIVE.getCode();
           }
           if (rowData.contains(CarEnum.GO.getCode())) {
               toFrom = CarEnum.GO.getCode();
           }
           if (rowData.contains(CarEnum.BACK.getCode())&&(!rowData.contains(CarEnum.BACK_HOME.getCode()))&&(!rowData.contains(CarEnum.BACK_BACK.getCode()))) {
               toFrom = CarEnum.BACK.getCode();
           }

           int size = rowData.indexOf(toFrom);
           for(int i=0;i<size;i++){
               to = rowData.substring(rowData.indexOf(toFrom) - 2-i, rowData.indexOf(toFrom)-i);
               if(RegionTools.check(to)){
                   break;
               }
           }
          String ss = rowData.substring(size, rowData.length());
           for(int i=0;i<ss.length();i++){
               from = rowData.substring(rowData.indexOf(toFrom) + 1+i, rowData.indexOf(toFrom) + 3+i);
               if(RegionTools.check(from)){
                   break;
               }
           }

           //时间
           LocalDate today = LocalDate.now();
           if (rowData.contains(CarEnum.POINT.getCode())) {
               //解析几点转时间
               String times = rowData.substring(rowData.indexOf(CarEnum.POINT.getCode()) - 2, rowData.indexOf(CarEnum.POINT.getCode()));
               int time = pointTime(times);
               if (rowData.contains(CarEnum.TOMORROW.getCode())) {
                   if (rowData.contains(CarEnum.NOON.getCode()) || rowData.contains(CarEnum.AFTERNOON.getCode()) || rowData.contains(CarEnum.EVENING.getCode())) {
                       time += 12;
                   }
                   startTime = today.plusDays(1) + " " + addZeroForNum(time) + ":00:00";
                   log.info("几点------明天");
               } else if (rowData.contains(CarEnum.AFTER_TOMORROW.getCode())) {
                   if (rowData.contains(CarEnum.NOON.getCode()) || rowData.contains(CarEnum.AFTERNOON.getCode()) || rowData.contains(CarEnum.EVENING.getCode())) {
                       time += 12;
                   }
                   startTime = today.plusDays(2) + " " + addZeroForNum(time) + ":00:00";
                   log.info("几点------后天");
               } else {
                   if (rowData.contains(CarEnum.NUMBER.getCode()) && check(CarEnum.NUMBER.getCode(), rowData)) {
                       //包含几号
                       if (rowData.contains(CarEnum.NOON.getCode()) || rowData.contains(CarEnum.AFTERNOON.getCode()) || rowData.contains(CarEnum.EVENING.getCode())) {
                           time += 12;
                       }
                       String numbers = rowData.substring(rowData.indexOf(CarEnum.NUMBER.getCode()) - 2, rowData.indexOf(CarEnum.NUMBER.getCode()));
                       int number = numberAccount(numbers);
                       startTime = today.getYear() + "-" + addZeroForNum(today.getMonthValue()) + "-" + addZeroForNum(number) + " " + addZeroForNum(time) + ":00:00";
                       log.info("几点------几号");
                   } else {
                       if (rowData.contains(CarEnum.NOON.getCode()) || rowData.contains(CarEnum.AFTERNOON.getCode()) || rowData.contains(CarEnum.EVENING.getCode())) {
                           time += 12;
                       }
                       startTime = today + " " + addZeroForNum(time) + ":00:00";
                       log.info("几点------今天");
                   }
               }
           } else {
               if (rowData.contains(CarEnum.NUMBER.getCode()) && check(CarEnum.NUMBER.getCode(), rowData)) {

                   log.info("无点------号");
               } else {
                   if (rowData.contains(CarEnum.TOMORROW.getCode())) {
                       today = today.plusDays(1) ;
                    } else if (rowData.contains(CarEnum.AFTER_TOMORROW.getCode())) {
                       today = today.plusDays(2);
                   }
               }

               if (rowData.contains(CarEnum.MORNING.getCode()) || rowData.contains(CarEnum.MORNING1.getCode())) {
                   startTime = today + " " + "08:00:00";
               } else if (rowData.contains(CarEnum.NOON.getCode())) {
                   startTime = today + " " + "12:00:00";
               } else if (rowData.contains(CarEnum.NOON1.getCode())) {
                   startTime = today + " " + "14:00:00";
               } else if (rowData.contains(CarEnum.AFTERNOON.getCode())) {
                   startTime = today + " " + "16:00:00";
               } else if (rowData.contains(CarEnum.EVENING1.getCode())) {
                   startTime = today + " " + "18:00:00";
               } else if (rowData.contains(CarEnum.EVENING.getCode())) {
                   startTime = today + " " + "19:00:00";
               }
               log.info("无点------今天");

           }

           if (rowData.contains(CarEnum.INDIVIDUAL.getCode())) {
               try{
                   String personNumbers = rowData.substring(rowData.indexOf(CarEnum.INDIVIDUAL.getCode())-1, rowData.indexOf(CarEnum.INDIVIDUAL.getCode()));
                   personNumber = numberAccount(personNumbers);
               }catch (Exception e){};
           }

           if (rowData.contains(CarEnum.BELT.getCode())) {
               try{
                   String personNumbers = rowData.substring(rowData.indexOf(CarEnum.BELT.getCode()), rowData.indexOf(CarEnum.BELT.getCode()) + 1);
                   personNumber = numberAccount(personNumbers);
               }catch (Exception e){};
           }

           if (rowData.contains(CarEnum.POSITION.getCode())) {
               try{
                   String personNumbers = rowData.substring(rowData.indexOf(CarEnum.POSITION.getCode())-1, rowData.indexOf(CarEnum.POSITION.getCode()));
                   personNumber = numberAccount(personNumbers);
               }catch (Exception e){};
           }


           String mobile = StringTools.getMobile(rowData);

           if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(to)
                   && StringUtils.isNotBlank(from)&&(!startTime.equals("2020-06-26 24:00:00"))) {
               if (rowData.contains("车找人")) {
                   map.put("type", 1);
               } else if (rowData.contains("人找车")) {
                   map.put("type", 0);
               }
               map.put("mobile", mobile);
               map.put("to", to);
               map.put("from", from);
               map.put("startTime", startTime);
               map.put("personNumber", personNumber);
               map.put("rowData", rowData);
           }


       }catch (Exception e){
           log.info("对话数据解析出错：请针对性优化数据算法");
           e.printStackTrace();
       }

       return map;
   }




    /**
     * 几点转当前时间
     * @return
     */
    public  static int pointTime(String str){
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
    public static  String addZeroForNum(int time) {
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

    /**
     * todo 根据代码判断前面是否是数字
     * @param code 搜索代码
     * @param rowData 一行数据
     * @return
     */
    public static boolean check(String code,String rowData){
        boolean bool = false;
        if(rowData.contains(code)){
             String numbers = rowData.substring(rowData.indexOf(code)-2,rowData.indexOf(code));
            for(int i=1;i<32;i++){
                if(numbers.contains(""+i)){
                    return true;
                }
            }
            if(numbers.contains("一")||numbers.contains("二")||numbers.contains("三")||numbers.contains("四")||numbers.contains("五")||numbers.contains("六")
            ||numbers.contains("七")||numbers.contains("八")||numbers.contains("九")||numbers.contains("十")||numbers.contains("十一")||numbers.contains("十二")
            ||numbers.contains("十三")||numbers.contains("十四")||numbers.contains("十五")||numbers.contains("十六")||numbers.contains("十七")||numbers.contains("十八")
            ||numbers.contains("十九")||numbers.contains("二十")){
              return true;
            }
        }

        return bool;
    }


    //******************************************************************

    public static void main(String[] args){
        String str = "车找人 明天上午7－8点，泗洪到南京南站，市区，禄口机场，全程高速，诚信出行15052717819微信同号，包车随时，可以提前预约。 （当天下午南京回泗洪） 全能吃货不挑食加入本群。 【潜水】全能吃货不挑食";
         Map<String,Object> obj = analysis(str);

        System.out.println("to:{}"+ obj.get("to"));
        System.out.println("from:{}"+ obj.get("from"));
        System.out.println("mobile:{}"+ obj.get("mobile"));
        System.out.println("startTime:{}"+ obj.get("startTime"));
     }



}
