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
        this.getResponse().setContentType("text/css");
        try (InputStream is = new FileInputStream(new SysConf().getSysPath()+ "views/css/blog.css")){
            return BytesView.fromInputStream(is);
        } catch (Exception e) {
            throw new RuntimeException("File: bootstrap.min.css not found");
        }
    }

    public View loadAdminCss() {
        this.getResponse().setContentType("text/css");
        try (InputStream is = new FileInputStream(new SysConf().getSysPath()+ "views/css/admin.css")){
            return BytesView.fromInputStream(is);
        } catch (Exception e) {
            throw new RuntimeException("File: admin.css not found");
        }

    }

    public View loadJs() {
        String path = this.getRequest().getContextPath();
        System.out.println(path);
        try (InputStream is = new FileInputStream(new SysConf().getSysPath()+ "views/css/admin.css")){
            return BytesView.fromInputStream(is);
        } catch (Exception e) {
            throw new RuntimeException("File: admin.css not found");
        }

    }

}
