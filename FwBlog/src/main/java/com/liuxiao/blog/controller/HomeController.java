package com.liuxiao.blog.controller;

import com.hunantv.fw.Controller;
import com.hunantv.fw.db.DB;
import com.hunantv.fw.utils.FwLogger;
import com.hunantv.fw.view.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Home Page
 * Created by Sean on 16/1/9.
 */
public class HomeController extends Controller {
    protected static FwLogger logger = new FwLogger(HomeController.class);

    public View index() {
        return this.renderHtml("templates/home/home.ftl");
    }

    public View show(String permalink) {
        DB db = new DB();
        Map<String, Object> posts = db.get("SELECT * FROM posts WHERE permalink=?", permalink);
        return renderHtml("templates/posts.ftl", new HashMap<String, Object>(){
            {
                put("posts", posts);
            }
        });
    }

}
