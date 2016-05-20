package com.view.sg.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.view.sg.customview.adapterviewanimator.AdapterViewFlipperActivity;
import com.view.sg.customview.adapterviewanimator.StackViewActivity;
import com.view.sg.customview.gridlayout.GridLayoutActivity;
import com.view.sg.customview.image.DrawViewActivity;
import com.view.sg.customview.image.MatrixActivity;
import com.view.sg.customview.image.MoveBackActivity;
import com.view.sg.customview.image.MyViewActivity;
import com.view.sg.customview.image.PathActivity;
import com.view.sg.customview.image.PinBallActivity;
import com.view.sg.customview.image.SearchAssetsImageActivity;
import com.view.sg.customview.image.TextOnPathActivity;
import com.view.sg.customview.imagebutton.ImageButtonActivity;
import com.view.sg.customview.imageview.ImageViewActivity;
import com.view.sg.customview.imageview.QuickContactBadgeActivity;
import com.view.sg.customview.textview.ChronometerActivity;
import com.view.sg.customview.textview.TextClockActivity;
import com.view.sg.customview.togglebutton.ToggleButtonActivity;
import com.view.sg.customview.viewanimator.ImageSwitcherActivity;
import com.view.sg.customview.viewanimator.TextSwitcherActivity;
import com.view.sg.customview.viewanimator.ViewFlipperActivity;
import com.view.sg.customview.viewanimator.ViewSwitcherActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        initComponent();
    }

    private void initComponent() {

        findViewById(R.id.button_chronometer).setOnClickListener(v -> startActivity(new Intent(this, ChronometerActivity.class)));
        findViewById(R.id.button_gridlayout).setOnClickListener(v -> startActivity(new Intent(this, GridLayoutActivity.class)));
        findViewById(R.id.button_toggle).setOnClickListener(v -> startActivity(new Intent(this, ToggleButtonActivity.class)));
        findViewById(R.id.button_text_clock).setOnClickListener(v -> startActivity(new Intent(this, TextClockActivity.class)));
        findViewById(R.id.button_image_view).setOnClickListener(v -> startActivity(new Intent(this, ImageViewActivity.class)));
        findViewById(R.id.button_image_button).setOnClickListener(v -> startActivity(new Intent(this, ImageButtonActivity.class)));
        findViewById(R.id.button_quick_contact_badge).setOnClickListener(v -> startActivity(new Intent(this, QuickContactBadgeActivity.class)));
        findViewById(R.id.button_adapter_view_flipper).setOnClickListener(v -> startActivity(new Intent(this, AdapterViewFlipperActivity.class)));
        findViewById(R.id.button_stack_view).setOnClickListener(v -> startActivity(new Intent(this, StackViewActivity.class)));
        findViewById(R.id.button_view_switcher).setOnClickListener(v -> startActivity(new Intent(this, ViewSwitcherActivity.class)));
        findViewById(R.id.button_image_switcher).setOnClickListener(v -> startActivity(new Intent(this, ImageSwitcherActivity.class)));
        findViewById(R.id.button_text_switcher).setOnClickListener(v -> startActivity(new Intent(this, TextSwitcherActivity.class)));
        findViewById(R.id.button_view_flipper).setOnClickListener(v -> startActivity(new Intent(this, ViewFlipperActivity.class)));
        findViewById(R.id.button_search_asset_image).setOnClickListener(v -> startActivity(new Intent(this, SearchAssetsImageActivity.class)));
        findViewById(R.id.button_my_view).setOnClickListener(v -> startActivity(new Intent(this, MyViewActivity.class)));
        findViewById(R.id.button_path).setOnClickListener(v -> startActivity(new Intent(this, PathActivity.class)));
        findViewById(R.id.button_text_on_path).setOnClickListener(v -> startActivity(new Intent(this, TextOnPathActivity.class)));
        findViewById(R.id.button_draw_view).setOnClickListener(v -> startActivity(new Intent(this, DrawViewActivity.class)));
        findViewById(R.id.button_pin_ball).setOnClickListener(v -> startActivity(new Intent(this, PinBallActivity.class)));
        findViewById(R.id.button_matrix).setOnClickListener(v -> startActivity(new Intent(this, MatrixActivity.class)));
        findViewById(R.id.button_plane).setOnClickListener(v -> startActivity(new Intent(this, MoveBackActivity.class)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
