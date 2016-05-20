package com.view.sg.customview.togglebutton;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.view.sg.customview.R;

public class ToggleButtonActivity extends AppCompatActivity {

    private TextView tvSound;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tvSound = (TextView) findViewById(R.id.tvSound);
        toggleButton = (ToggleButton) findViewById(R.id.tglSound);
        toggleButton.setOnCheckedChangeListener((buttonView,isChecked) -> {
            if(isChecked){
                tvSound.setText("已开启");
            }else{
                tvSound.setText("已关闭");
                startActivity(new Intent(ToggleButtonActivity.this,ToggleButtonActivity2.class));
            }
        });
    }

}
