package com.john.history.history.ui;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.john.history.history.R;
import com.john.history.history.bean.SingleInstance;
import com.john.history.history.fragment.FragmentA;

public class FragmentActivity extends AppCompatActivity implements FragmentA.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FragmentA fragmentA;
        //单例持有activity的引用

        SingleInstance.getInstance().setmContext(this,5);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        fragmentA=new FragmentA();
        getSupportFragmentManager().beginTransaction().replace(R.id.content,fragmentA).commit();

//        LeakThread leakThread = new LeakThread();
//        leakThread.start();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("xxx","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("xxx","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("xxx","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("xxx","F"+Boolean.toString(((Activity)SingleInstance.getInstance().mContext).isFinishing()));
    }

    //非静态内部类持有外部类的引用
    class LeakThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(6 * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
