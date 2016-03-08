package com.yihukurama.mvc4a.view.activity.testactivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yihukurama.core.android.device.sdcard.FileType;
import com.yihukurama.core.android.device.sdcard.SDCardManager;
import com.yihukurama.mvc4a.R;
import com.yihukurama.mvc4a.view.activity.BaseActivity;

/**
 * Created by dengshuai on 16/1/13.
 */
public class SdcardActivity extends BaseActivity implements View.OnClickListener{
    private Button createFileButton;
    private Button deleteFileButton;
    private Button initButton;
    private Button checkButton;
    private TextView resultText;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard);

        //初始化控件
        initView();

        //初始化一些成员变量
        initData();


    }

    private void initView() {
        createFileButton = (Button)findViewById(R.id.btn_create_file);
        deleteFileButton = (Button)findViewById(R.id.btn_delete_file);
        initButton = (Button)findViewById(R.id.btn_init);
        checkButton = (Button)findViewById(R.id.btn_check);
        resultText       = (TextView)findViewById(R.id.text_result);

    }

    private void initData() {
        context = this;
        initButton.setOnClickListener(this);
        createFileButton.setOnClickListener(this);
        deleteFileButton.setOnClickListener(this);
        checkButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_init:
                SDCardManager.getInstance().initSDCardManager();
                resultText.setText("成功初始化sdcard文件系统");
                break;
            case R.id.btn_create_file:
                SDCardManager.getInstance().creatSDDir("test",FileType.image,true);
                resultText.setText("成功在image文件目录下建立test目录");
                break;
            case R.id.btn_delete_file:
                SDCardManager.getInstance().deleteSDDir("test", FileType.image);
                resultText.setText("成功在image文件目录下删除test目录");
                break;
            case R.id.btn_check:
                boolean isExist = SDCardManager.getInstance().isExists("test", FileType.image);
                if(isExist){
                    resultText.setText("image目录下存在test目录");
                }else{
                    resultText.setText("image目录下不存在test目录");
                }
                break;

        }
    }
}
