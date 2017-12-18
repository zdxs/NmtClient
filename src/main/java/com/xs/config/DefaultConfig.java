/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xs.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.template.Engine;
import com.xs.base.interceptor.NmtInterceptor;
import com.xs.controller.HelloController;
import com.xs.controller.IndexController;
import com.xs.controller.TranslateController;

/**
 *
 * @author xiaosun
 */
public class DefaultConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants me) {
        /*取值方式PropKit.get("password").trim())*/
        PropKit.use("config.properties"); // 加载配置文件，发觉不管放到哪里都可以，没有路径  
        me.setEncoding("UTF-8");
        me.setDevMode(true);
    }

    @Override
    public void configHandler(Handlers arg0) {
        // TODO Auto-generated method stub  

    }

    @Override
    public void configInterceptor(Interceptors in) {
        // TODO Auto-generated method stub  
        in.add(new NmtInterceptor());
    }

    @Override
    public void configPlugin(Plugins arg0) {
        // TODO Auto-generated method stub  

    }

    @Override
    public void configRoute(Routes me) {
        String text = PropKit.get("post-key");
        //访问根目录
        me.add("/", IndexController.class);
        me.add("/hello", HelloController.class);
        //翻译调用
        me.add("/translate", TranslateController.class);
    }

    @Override
    public void configEngine(Engine engine) {
    }

}
