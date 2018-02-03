package com.john.history.history.bean;

import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/1/31.
 */

public class Action{
    Name mName;
    String mFirstName;
    String mLastName;
    public void onClick(Name name) {
        name.firstname.set("强");
        name.lastname.set("张");
    }
}
