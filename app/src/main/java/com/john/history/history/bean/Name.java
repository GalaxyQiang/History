package com.john.history.history.bean;

import android.databinding.Observable;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/1/31.
 */

public class Name {
    public ObservableField<String> firstname=new ObservableField<>();
    public ObservableField<String> lastname=new ObservableField<>();;

    public void onClickChangName(View view) {
        firstname.set("qiang");
        lastname.set("zhang");
    }
}
