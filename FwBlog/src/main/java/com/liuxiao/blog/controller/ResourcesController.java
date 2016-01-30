package com.liuxiao.blog.controller;

import com.hunantv.fw.Controller;
import com.hunantv.fw.utils.FwLogger;
import com.hunantv.fw.utils.SysConf;
import com.hunantv.fw.view.BytesView;
import com.hunantv.fw.view.View;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Static resources controller
 * Created by Sean on 16/1/10.
 */
public class ResourcesController extends Controller {
    protected static FwLogger logger = new FwLogger(HomeController.class);

    public View loadJs(String filename) {

        try (InputStream is = new FileInputStream(new SysConf().getSysPath() + "views/js/" + filename)) {
            return BytesView.fromInputStream(is);
        } catch (Exception e) {
            throw new RuntimeException("File: " + filename + " not found");
        }

    }

    public View loadCSS(String name) {
        this.getResponse().setContentType("text/css");
        try (InputStream is = new FileInputStream(new SysConf().getSysPath() + "views/css/" + name)) {
            return BytesView.fromInputStream(is);
        } catch (Exception e) {
            throw new RuntimeException("File: " + name + " not found");
        }
    }

    public View loadImg(String filename) {

        try (InputStream is = new FileInputStream(new SysConf().getSysPath() + "views/images/" + filename)) {
            return BytesView.fromInputStream(is);
        } catch (Exception e) {
            throw new RuntimeException("File: " + filename + " not found");
        }

    }


}
