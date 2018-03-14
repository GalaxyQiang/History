package com.john.history.history.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.john.history.history.R;
import com.john.history.history.bean.SingleInstance;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent intent=new Intent(this,FragmentActivity.class);
        findViewById(R.id.buttontest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("xxx",Integer.toString(SingleInstance.getInstance().anInt));
//        Log.d("xxx",Boolean.toString(((Activity)SingleInstance.getInstance().mContext).isFinishing()));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("xxx","TestActivity"+Boolean.toString(((Activity)SingleInstance.getInstance().mContext).isFinishing()));
    }

}
