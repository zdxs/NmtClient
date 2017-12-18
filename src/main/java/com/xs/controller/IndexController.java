/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xs.controller;

import com.jfinal.core.Controller;

/**
 *
 * @author xiaosun
 */
public class IndexController extends Controller {

    /**
     * 默认路径
     */
    public void index() {
        render("/index.html");
    }
}
