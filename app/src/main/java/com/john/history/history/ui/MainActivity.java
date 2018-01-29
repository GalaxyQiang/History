package com.john.history.history.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.john.history.history.R;
import com.john.history.history.database.Itemyyy;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private int i;
//    private CharSequence ;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    MutableLiveData<String> aaa=new MutableLiveData<String>();
    MutableLiveData<Itemyyy> bbb=new MutableLiveData<Itemyyy>();

    Date mDate=new Date(1988-1900,1,12);
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        aaa.setValue("galaxy");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        aaa.observe(this,x->{
            date.setText(x);
        });

        bbb.observeForever( x->{
            text.setText(x.text);
        });
//        setSupportActionBar(toolbar);


//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                aaa.postValue("ggg "+i);
//                bbb.postValue(new Itemyyy("hhh "+i));
//                i+=1;
//            }
//        });


    }

    @OnClick(R.id.fab)
    public void fabOnClick(){
        aaa.postValue("ggg "+i);
        bbb.postValue(new Itemyyy(date2string(mDate)+i));
        i+=1;
    }

    private String date2string(Date date){
//        SimpleDateFormat format1 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss")
        return new SimpleDateFormat("YYYY-MM-dd").format(date);
    }

}
