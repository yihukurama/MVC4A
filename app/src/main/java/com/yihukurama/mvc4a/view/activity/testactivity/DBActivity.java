package com.yihukurama.mvc4a.view.activity.testactivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yihukurama.mvc4a.R;
import com.yihukurama.mvc4a.model.access.DBManager;
import com.yihukurama.mvc4a.model.access.greendao.User;
import com.yihukurama.mvc4a.model.access.greendao.UserDao;
import com.yihukurama.mvc4a.view.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dengshuai on 16/1/13.
 */
public class DBActivity extends BaseActivity implements View.OnClickListener{
    private Button insertDataButton;
    private Button deleteDataButton;
    private Button selectDataButton;
    private Button updateDataButton;
    private TextView resultText;
    private DBManager dbManager;
    private Context context;
    private User userEntity;
    private List<User> userEntityList;
    private User us = new User();
    private User us3 = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        //初始化控件
        initView();

        //初始化一些成员变量
        initData();


    }

    private void initView() {
        insertDataButton = (Button)findViewById(R.id.btn_insert);
        deleteDataButton = (Button)findViewById(R.id.btn_delete);
        selectDataButton = (Button)findViewById(R.id.btn_update);
        updateDataButton = (Button)findViewById(R.id.btn_select);
        resultText       = (TextView)findViewById(R.id.text_result);

    }

    private void initData() {
        insertDataButton.setOnClickListener(this);
        deleteDataButton.setOnClickListener(this);
        selectDataButton.setOnClickListener(this);
        updateDataButton.setOnClickListener(this);
        context = this;
        userEntityList = new ArrayList<User>();
        userEntity = new User();
        userEntity.setAICHAID("110");
        userEntity.setMOBILE("110");
        userEntity.setHEAD_URL("http://123");
        userEntity.setNICKNAME("bear1");
        dbManager = DBManager.getInstance(context);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_insert:
                try {
                    dbManager.getDaoSession().getUserDao().insertOrReplace(userEntity);


                    us.setAICHAID("111");
                    us.setNICKNAME("bear2");
                    dbManager.getDaoSession().getUserDao().insertOrReplace(us);

                    us3.setAICHAID("112");
                    us3.setNICKNAME("bear3");
                    dbManager.getDaoSession().getUserDao().insertOrReplace(us3);
                    resultText.setText("成功插入或更新3条记录");
                }catch (Exception e){
                    showToastLong(getResources().getString(R.string.string9));
                }
                break;
            case R.id.btn_delete:
                try {
                    dbManager.getDaoSession().getUserDao().delete(userEntity);
                    resultText.setText("成功删除id为110的记录");
                }catch (Exception e){
                    showToastLong(getResources().getString(R.string.string9));
                }

                break;
            case R.id.btn_update:
                try {
                    us.setNICKNAME("rabbit");
                    dbManager.getDaoSession().getUserDao().insertOrReplace(us);
                    resultText.setText("成功把id为111的记录数据变更昵称为rabbit");
                }catch (Exception e){
                    showToastLong(getResources().getString(R.string.string9));
                }

                break;
            case R.id.btn_select:
                String result = "没有查询结果";
                try {
                    List<User> users = dbManager.getDaoSession().getUserDao().queryBuilder()
                            .where(UserDao.Properties.AICHAID.eq("111"))
                            .list();
                    for (User u:
                            users) {
                        result = "id为111的用户昵称是 "+u.getNICKNAME() + "\n";
                        Log.i("test",u.getNICKNAME());
                    }
                    Log.i("test","--------------------------");
                    userEntityList = dbManager.getDaoSession().loadAll(User.class);
                    for (User u:
                            userEntityList) {
                        result += "查询结果：id:"+ u.getAICHAID() + "  昵称:"+ u.getNICKNAME() +"\n";
                        Log.i("test",u.getAICHAID());
                    }
                    resultText.setText(result);
                }catch (Exception e){
                    showToastLong(getResources().getString(R.string.string9));
                }


                break;

        }
    }
}
