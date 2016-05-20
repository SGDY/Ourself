package com.view.sg.dialogfragmentdemo;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.view.sg.dialogfragmentdemo.model1.AlterDialogFragment;
import com.view.sg.dialogfragmentdemo.model1.PromptDialogFragment;

public class MainActivity1 extends AppCompatActivity {

    //设置告警框、提示框和帮助框的dialog fragment的tag。
    public final static String ALERT_DIALOG_TAG = "ALERT_DIALOG_TAG";
    public final static String PROMPT_DIALOG_TAG = "PROMPT_DIALOG_TAG";
    public final static String HELP_DIALOG_TAG = "HELP_DIALOG_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
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

        findViewById(R.id.alter_dialog).setOnClickListener(v -> alterDialogTestCase());
        findViewById(R.id.prompt_dialog).setOnClickListener(v -> promptDialogTestCase());
    }

    private void alterDialogTestCase(){
        AlterDialogFragment adf = AlterDialogFragment.newInstance("Alert", "This is the Alter Message for test!");
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        adf.show(ft, ALERT_DIALOG_TAG);
    }

    /* 弹出提示框 */
    private void promptDialogTestCase(){
        PromptDialogFragment pdf = PromptDialogFragment.newInstance("This is a Prompt Dialog!");
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        pdf.show(ft, PROMPT_DIALOG_TAG);
    }

    /* 此为用户按对话框按键时被调用的方法，通过Toast显示相关信息。*/
    public void onDialogDone(String tag, boolean cancelled, CharSequence message) {
        String s = tag + " responds with: " + message;
        if(cancelled)
            s = tag + " was cancelled by the user";
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
