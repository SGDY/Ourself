package com.view.sg.customview.gridlayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.view.sg.customview.R;

public class GridLayoutActivity extends AppCompatActivity {

    GridLayout layout;

    String[] chars = new String[]{
            "7","8","9","÷",
            "4","5","6","×",
            "1","2","3","-",
            ".","0","=","+"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
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

        layout = (GridLayout) findViewById(R.id.root);
        for (int i = 0; i < chars.length; i++) {

            Button button = new Button(this);
            button.setText(chars[i]);
            button.setTextSize(40);
            button.setPadding(5, 35, 5, 35);


            GridLayout.Spec rowSpec = GridLayout.spec(i / 4 + 2);
            GridLayout.Spec columnSpec = GridLayout.spec(i % 4);
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(rowSpec, columnSpec);
            layoutParams.setGravity(Gravity.FILL);
            layout.addView(button,layoutParams);
        }
    }
}
