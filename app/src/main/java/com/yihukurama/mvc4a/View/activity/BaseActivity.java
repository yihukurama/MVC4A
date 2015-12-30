package com.yihukurama.mvc4a.View.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yihukurama.mvc4a.R;
/**
 * Created by dengshuai on 15/12/30.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
