package com.liuxiao.blog;

import com.hunantv.fw.Application;
import com.hunantv.fw.route.Route;
import com.hunantv.fw.route.Routes;
import com.liuxiao.blog.admin.controller.AdminController;
import com.liuxiao.blog.controller.*;
import com.hunantv.fw.utils.SysConf;

/**
 *
 * Created by Sean on 16/1/9.
 */
public class Server {
    public static Routes initRoutes() {
        Routes routes = new Routes(
                Route.get("/", HomeController.class, "index"),
                Route.get("/css/bootstrap.min.css", ResourcesController.class, "load"),
                Route.get("/admin", AdminController.class, "admin"),
                Route.get("/admin/login", AdminController.class, "login")
        );
        return routes;
    }

    public static void main(String[] args) throws Exception {
        int port = 3333;
        if (args.length >= 1) {
            port = Integer.valueOf(args[0]);
        }
        Application app = Application.getInstance();
        app.setRoutes(initRoutes());
        app.listener(port);
        app.setDebug(false);
        System.out.println(port);
        System.out.println(new SysConf().getSysPath() + "views");
        app.start();
    }
}
