package com.liuxiao.blog.controller;

import com.hunantv.fw.Controller;
import com.hunantv.fw.utils.FwLogger;
import com.hunantv.fw.utils.SysConf;
import com.hunantv.fw.view.BytesView;
import com.hunantv.fw.view.View;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Sean on 16/1/10.
 */
public class ResourcesController extends Controller {
    protected static FwLogger logger = new FwLogger(HomeController.class);

    public View load() {
        try (InputStream is = new FileInputStream(new SysConf().getSysPath()+"views/css/bootstrap.min.css")){
            BytesView view = BytesView.fromInputStream(is);
            return view;
        } catch (Exception e) {
            throw new RuntimeException("File: bootstrap.min.css not found");
        }
    }

}
