package com.liuxiao.blog.admin.controller;

import com.hunantv.fw.Controller;
import com.hunantv.fw.db.DB;
import com.hunantv.fw.utils.FwLogger;
import com.hunantv.fw.utils.StringUtil;
import com.hunantv.fw.view.View;
import com.liuxiao.blog.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AdminController
 * Created by Sean on 16/1/17.
 */
public class AdminController extends Controller {
    protected static FwLogger logger = new FwLogger(AdminController.class);


    public View login() {
        return this.renderHtml("templates/admin/home/login.ftl");
    }

    public View access() {
        //admin service

        String account = this.getStrParam("account");
        String password = StringUtil.toMd5Str(this.getStrParam("password"));

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        System.out.println(user);
//        DB db = new DB();
//        Map<String, Object> record = db.get("SELECT * FROM users WHERE account = ? AND password = ?", account, password);
//        if (null == record) {
//            return this.redirect("/error");
//        }
//        HttpSession session = this.getRequest().getSession();
//        session.setAttribute("user", user);
        return this.redirect("/admin/home");
    }

    public View home() {

        User user = new User();
        user.setAccount("admin");
        return this.renderHtml("templates/admin/home/home.ftl", new HashMap<String, Object>() {
            {
                put("user", user);
            }
        });
    }

    public View show() {
        DB db = new DB();
        List<Map<String, Object>> posts = db.query("SELECT * FROM posts");
        return this.renderHtml("templates/admin/home/posts.ftl", new HashMap<String, Object>(){
            {
                put("posts", posts);
            }
        });
    }

    public View settings() {
        DB db = new DB();
        Map<String, Object> settings = db.get("SELECT * FROM users");
        return this.renderHtml("templates/admin/home/settings.ftl", new HashMap<String, Object>(){
            {
                put("settings", settings);
            }
        });
    }

    public View _new() {
        return this.renderHtml("templates/admin/posts/edit.ftl");
    }

    public View update(int id) {
        DB db = new DB();
        Map<String, Object> posts = db.get("SELECT * FROM posts WHERE id=?", id);
        return this.renderHtml("templates/admin/posts/edit.ftl", new HashMap<String, Object>(){
            {
                put("posts", posts);
            }
        });
    }

}
