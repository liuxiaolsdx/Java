package com.liuxiao.blog.controller;

import com.hunantv.fw.Controller;
import com.hunantv.fw.utils.FwLogger;
import com.hunantv.fw.view.View;

/**
 * Home Page
 * Created by Sean on 16/1/9.
 */
public class HomeController extends Controller {
    protected static FwLogger logger = new FwLogger(HomeController.class);

    public View index() {
        return this.renderHtml("/home.ftl");
    }


}
