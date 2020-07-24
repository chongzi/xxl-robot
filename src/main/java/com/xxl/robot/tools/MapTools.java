package com.xxl.robot.tools;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * todo 地图 API封装
 * 高德
 */
public class MapTools {

    private static String key = "85a9ea5e6f565ee7eaa0bfc17d9d0888";

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url 发送请求的URL
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            return null;
        } finally { // 使用finally块来关闭输入流
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 逆地理编码url
     *
     * @param location 经纬度坐标,经度在前,纬度在后，经纬度间以“,”分割
     * @return
     */
    public static String getRegeoUrl(String location) {
        return "http://restapi.amap.com/v3/geocode/regeo?location=" + location + "&key=" + key;
    }


    /**
     * 获取地理位置名称
     *
     * @param location 经纬度坐标,经度在前,纬度在后，经纬度间以“,”分割
     * @return
     */
    public static String getAddressNameByGeocoder(String location) {
        String jsonString = sendGet(getRegeoUrl(location));
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        String addressName = jsonObject.getJSONObject("regeocode").getString("formatted_address");
        return addressName;
    }



    /**
     * 距离测量API服务地址
     *
     * @param origins     出发点
     * @param destination 目的地
     * @return
     */
    public static String getDistanceUrl(String origins, String destination) {
        String urlString = "http://restapi.amap.com/v3/distance?type=0&origins=" + origins + "&destination=" + destination + "&key=" + key;
        return urlString;
    }

    /**
     * 获取二个地点之间的直线距离
     * @param origins 出发地
     * @param destination 目的地
     * @return
     */
    public static String getDistance(String origins, String destination) {
        String jsonString = sendGet(getDistanceUrl(origins,destination));
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        String distance = jsonObject.getJSONArray("results").getJSONObject(0).getString("distance");
        return distance;
    }


     public static  void main(String args[]){
        String str  = getDistanceUrl("上海","洋河");

         System.out.println(str);
     }

}
