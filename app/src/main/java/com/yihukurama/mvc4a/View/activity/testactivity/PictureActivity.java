package com.yihukurama.mvc4a.view.activity.testactivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.yihukurama.core.sdk.imageloader.ImageLoaderApi;
import com.yihukurama.mvc4a.R;
import com.yihukurama.mvc4a.view.activity.BaseActivity;

public class PictureActivity extends BaseActivity {
    ImageView imageView;
    ImageLoader imageLoader;
    String imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        initView();
        initData();
    }

    private void initData() {
        imageUri = "http://pic.cnr.cn/pic/guoji/20160311/W020160311292109845023.jpg";
        imageLoader = ImageLoaderApi.getInstance();
        imageLoader.displayImage(imageUri, imageView);
    }

    private void initView() {

        imageView = (ImageView)findViewById(R.id.imageView);

    }
}
