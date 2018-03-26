package com.john.history.history.ui;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.john.history.history.R;
import com.john.history.history.bean.SingleInstance;
import com.john.history.history.fragment.FragmentA;
import com.john.history.history.fragment.FragmentB;

public class FragmentActivity extends AppCompatActivity implements FragmentA.OnFragmentInteractionListener ,FragmentB.OnFragmentInteractionListener{
    private String LOG_TAG="FragmentActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        addFragment();
    }

    private void addFragment() {
        FragmentA fragmentA=new FragmentA();
        getSupportFragmentManager().beginTransaction().add(R.id.content,fragmentA).commit();
    }

    private void leakContext() {
        //单例类的静态变量持有activity的引用，在activity销毁的时候造成内存泄露
        SingleInstance.getInstance().setmContext(this,5);
    }

    private void testFragment() {
        FragmentA fragmentA;
        FragmentB fragmentB;
        fragmentA=new FragmentA();
        fragmentB=new FragmentB();

        android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
        /*fm.findFragmentById()的参数不仅可以是静态Fragment的id，也可以是已经动态加载完毕后Fragment的id
        * fm.findFragmentByTag()，必须等任务完成后才能根据TAG标签找到Fragment，如果希望任务立刻被执行可以调用
        * fm.executePendingTransactions()方法*/
        fm.beginTransaction().add(R.id.content,fragmentA,"FragmentA").addToBackStack("FragmentA").commit();
        fm.executePendingTransactions();
        Log.d("aaa",String.valueOf(fm.findFragmentById(R.id.content)));
        Log.d("aaa",fm.findFragmentByTag("FragmentA").toString());

        fm.beginTransaction().add(R.id.content,fragmentB,"FragmentB").addToBackStack("FragmentB").commit();
        fm.executePendingTransactions();
        Log.d("aaa",String.valueOf(fm.findFragmentById(R.id.content)));
        Log.d("aaa",fm.findFragmentByTag("FragmentB").toString());
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();

//        Log.d(LOG_TAG,"F"+Boolean.toString(((Activity)SingleInstance.getInstance().mContext).isFinishing()));
    }

    //非静态内部类持有外部类的引用，当activity在6分钟内退出，由于LeakThread拥有activity的引用，任务没有执行完毕造成内存泄露
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
