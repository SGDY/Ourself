package com.view.sg.customview.image;

import android.app.Activity;
import android.os.Bundle;

import com.view.sg.customview.R;

public class MatrixActivity extends Activity {

    MatrixView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);

        myView = (MatrixView) findViewById(R.id.my_view);
        //向左倾斜
        findViewById(R.id.btn_left).setOnClickListener(v -> {
            myView.isScale = false;
            myView.sx += 0.1;
            myView.invalidate();
        });
        //向右倾斜
        findViewById(R.id.btn_right).setOnClickListener(v -> {
            myView.isScale = false;
            myView.sx -= 0.1;
            myView.invalidate();
        });
        //放大
        findViewById(R.id.btn_big).setOnClickListener(v -> {
            myView.isScale = true;
            if (myView.scale < 2.0) {
                myView.scale += 0.1;
            }
            myView.invalidate();
        });
        //缩小
        findViewById(R.id.btn_small).setOnClickListener(v -> {
            myView.isScale = true;
            if (myView.scale > 0.5) {
                myView.scale -= 0.1;
            }
            myView.invalidate();
        });
    }
}
