package com.liuxiao.blog.admin.controller;

import com.hunantv.fw.Controller;
import com.hunantv.fw.db.DB;
import com.hunantv.fw.utils.FwLogger;
import com.hunantv.fw.utils.StringUtil;
import com.hunantv.fw.view.View;

import java.util.Map;

/**
 * AdminController
 * Created by Sean on 16/1/17.
 */
public class AdminController extends Controller{
    protected static FwLogger logger = new FwLogger(AdminController.class);

    public View admin(){
        return this.renderHtml("templates/admin/home/login.ftl");
    }

    public View login(){
        //admin service

        DB db = new DB();
        String account = this.getStrParam("account");
        String password = StringUtil.toMd5Str(this.getStrParam("password"));
        Map<String, Object> record = db.get("SELECT * FROM users WHERE account = ? AND password = ?", account, password);
        if (null == record) {
            return this.redirect("admin/error");
        }
        return this.renderHtml("templates/admin/home/home.ftl");
    }

}
