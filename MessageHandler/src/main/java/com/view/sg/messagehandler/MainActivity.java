package com.view.sg.messagehandler;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    Handler mHandler;
    Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv);
        button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(v -> new Thread(() -> button.post(mRunnable)).start());

        mHandler = new Handler();
        mRunnable = () -> startActivity(new Intent(this,AsyncTaskActivity.class));
    }
}
