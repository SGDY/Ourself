package com.view.sg.customview.textview;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;

import com.view.sg.customview.R;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/12/8
 */
public class ChronometerActivity extends Activity {

    Button start;
    Chronometer ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer);

        start = (Button) findViewById(R.id.button_chronometer);
        ch = (Chronometer) findViewById(R.id.chronometer);
        ch.setFormat(null);

        start.setOnClickListener(v -> {
            ch.setBase(SystemClock.elapsedRealtime());
            ch.start();
            start.setEnabled(false);
        });

        ch.setOnChronometerTickListener(ch -> {
            if (SystemClock.elapsedRealtime() - ch.getBase() > 20 * 1000) {
                ch.stop();
                start.setEnabled(true);
            }
        });
    }
}
