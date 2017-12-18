/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *拦截器
 *
 *
 */
package com.xs.base.interceptor;

import com.jfinal.aop.Invocation;
import com.jfinal.aop.PrototypeInterceptor;
import com.jfinal.kit.PropKit;

/**
 *
 * @author xiaosun
 */
public class NmtInterceptor extends PrototypeInterceptor {

    @Override
    public void doIntercept(Invocation invctn) {
        //如果读取配置文件没有值则重新加载
        String ck = PropKit.get("ck");
        if (null == ck || ck.equals("")) {
            PropKit.use("config.properties");
        }
        System.out.println("before-------先执行代码-----------");
        invctn.invoke();
        System.out.println("after----------后执行代码实现aop---------");
    }

}
