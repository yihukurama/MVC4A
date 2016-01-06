package com.yihukurama.mvc4a.View.activity;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.yihukurama.mvc4a.R;
/**
 * Created by dengshuai on 15/12/30.
 */
public class BaseActivity extends Activity {

    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mContext = this;


    }


    /**
     * show long toast
     * @param message
     */
    public void showToastLong(String message){
        Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();
    }

    /**
     * show short toast
     * @param message
     */
    public void showToastShort(String message){
        Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
    }
}
