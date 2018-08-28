package com.yeqiu.hailhydra.app;

import org.litepal.LitePalApplication;

/**
 * @project：android_tools
 * @author：小卷子
 * @date 2018/4/14 下午4:33
 * @describe：
 * @fix：
 */
public class App extends LitePalApplication {

    private static App app;


    public static synchronized App getInstance() {
        if (app == null) {
            app = new App();
        }
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        init();
    }


    private void init() {

        // TODO: 2018/7/12 初始化第三方的配置


    }

}
