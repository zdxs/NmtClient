/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xs.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.xs.util.SendAjax;
import com.xs.util.http.Client;
import java.util.HashMap;
import java.util.Map;

/**
 * 翻译调用
 *
 * @author xiaosun
 */
public class TranslateController extends Controller {

    //配置文件链接字符
    private final String _PROPERTIES = "-";

    /**
     * 默认路径
     */
    public void index() {
        JSONObject result = new JSONObject();
        //创建key获取请求地址
        String source = getPara("source");//输入源语言类型
        String translate = getPara("translate");//输出语言类型
        String src = getPara("src");//等待翻译的内容
        SendAjax sa = new SendAjax();
        boolean success = false;
        result.put("success", success);
        if (null == src || null == translate || null == source) {
            renderJson(sa.toJsonString(result));
        } else {
            String translateUrl = PropKit.get(source + _PROPERTIES + translate).trim();
            //数据
            Map<String, String> createMap = new HashMap<>();
            createMap.put(PropKit.get("post-key").trim(), src);
            //发送请求，并且返回结果
            String resultStr = Client.getTranslateData(translateUrl, createMap, "UTF-8");
            JSONArray ja = JSON.parseArray(resultStr);
            result.put("data", ja);
            result.put("success", true);
            renderJson(sa.toJsonString(result));
        }
    }
}
