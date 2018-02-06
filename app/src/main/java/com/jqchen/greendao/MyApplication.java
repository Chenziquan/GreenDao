package com.jqchen.greendao;

import android.app.Application;

/**
 * 应用名称:GreenDao
 * 包 名 称:com.jqchen.greendao
 * <p>
 * 文件描述:
 * 创 建 人:JQChen
 * 创建时间:2018/1/3
 */

public class MyApplication extends Application {
    private        DaoSession    mDaoSession;
    private static MyApplication Instance;

    public static MyApplication getInstance() {
        return Instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Instance = this;
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "USER");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession mDaoSession = daoMaster.newSession();
        UserDao userDao = mDaoSession.getUserDao();
    }

    public DaoSession getmDaoSession() {
        return mDaoSession;
    }
}
