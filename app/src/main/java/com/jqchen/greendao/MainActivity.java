package com.jqchen.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserDao mUserDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserDao = MyApplication.getInstance().getmDaoSession().getUserDao();
//        testAdd();
        testLoad();
        testDelete();
    }

    private void testDelete() {
        User user = new User((long)1,"Jqchen");
        mUserDao.update(user);
        mUserDao.delete(user);
        mUserDao.deleteByKey((long)1);
    }

    private void testLoad() {
        List<User> list = mUserDao.loadAll();
        for (User user :
                list) {
            Log.i("info",user.toString());
        }
    }

    private void testAdd() {
        User user = new User();
        user.setName("JQChen");
        mUserDao.insert(user);
    }
}
