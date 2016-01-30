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
                Route.get("/css/<str:name>", ResourcesController.class, "loadCSS"),
                Route.get("/js/<str:name>", ResourcesController.class, "loadJs"),
                Route.get("/images/<str:name>", ResourcesController.class, "loadImg"),

                Route.get("/admin/login", AdminController.class, "login"),
                Route.post("/admin/access", AdminController.class, "access"),
                Route.get("/admin/home", AdminController.class, "home"),
                Route.get("/admin/posts", AdminController.class, "show"),
                Route.get("/admin/posts/new", AdminController.class, "_new"),
                Route.get("/admin/posts/<int:id>", AdminController.class, "update"),
                Route.get("/admin/settings", AdminController.class, "settings")

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
