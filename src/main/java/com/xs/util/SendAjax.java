/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xs.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xiaosun
 */
public class SendAjax {

    private static SerializerFeature[] features = {SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteDateUseDateFormat};

    public String toJsonString(JSONObject jo) {
        if (null == jo) {
            return null;
        }
        String result = JSON.toJSONString(jo, features);
        return result;
    }

    public void generateAndSend(JSONObject result, String msg, boolean success, HttpServletResponse response) {
        if (result == null) {
            result = new JSONObject();
        }
        result.put("msg", msg);
        result.put("success", success);
        try {
            String s = JSON.toJSONString(result, features);
//            System.out.println(s);
            sendAjaxMsg(s, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /**
     * 发送ajax消息
     *
     * @param msg
     * @param response
     * @throws IOException author : xiaoyang
     */
    public synchronized void sendAjaxMsg(String msg, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(msg);
        writer.flush();
    }
}
