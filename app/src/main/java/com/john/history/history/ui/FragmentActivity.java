package com.john.history.history.ui;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.john.history.history.R;
import com.john.history.history.fragment.FragmentA;

public class FragmentActivity extends AppCompatActivity implements FragmentA.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FragmentA fragmentA;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        fragmentA=new FragmentA();
        getSupportFragmentManager().beginTransaction().replace(R.id.content,fragmentA).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
