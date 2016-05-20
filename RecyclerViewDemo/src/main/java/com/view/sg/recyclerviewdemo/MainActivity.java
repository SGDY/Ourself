package com.view.sg.recyclerviewdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(v -> Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        mRecycler = (RecyclerView) findViewById(R.id.recycler);
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
        if (id == R.id.action_list_normal) {
            //list的标准显示
            loadListData(false,true);
            return true;
        }else if (id == R.id.action_list_vertical_reverse) {
            //list的垂直反向显示
            loadListData(true,true);
            return true;
        }else if (id == R.id.action_list_horizontal) {
            //list的水平方向展示
            loadListData(false,false);
            return true;
        }else if (id == R.id.action_list_horizontal_reverse) {
            //list的水平反向展示
            loadListData(true, false);
            return true;
        }else if (id == R.id.action_grid_normal) {
            //grid的标准展示
            loadGridData(false,true);
            return true;
        }else if (id == R.id.action_grid_horizontal) {
            //grid的水平展示
            loadGridData(false,false);
            return true;
        }else if (id == R.id.action_grid_horizontal_reverse) {
            //grid的水平反向展示
            loadGridData(true,false);
            return true;
        }else if (id == R.id.action_grid_vertical_reverse) {
            //grid的垂直反向展示
            loadGridData(true, true);
            return true;
        }else if (id == R.id.action_staggered_normal) {
            //staggered的标准展示
            loadStaggeredData(false, true);
            return true;
        }else if (id == R.id.action_staggered_horizontal) {
            //staggered的水平展示
            loadStaggeredData(false, false);
            return true;
        }else if (id == R.id.action_staggered_horizontal_reverse) {
            //staggered的水平反向展示
            loadStaggeredData(true, false);
            return true;
        }else if (id == R.id.action_staggered_vertical_reverse) {
            //staggered的垂直反向展示
            loadStaggeredData(true, true);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadListData(boolean reverse,boolean isVertical) {
        List<DataBeans> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataBeans dataBeans = new DataBeans();
            dataBeans.icon = R.mipmap.ic_launcher;
            dataBeans.title = "图片 - " + i;
            datas.add(dataBeans);
        }
        //给RecyclerView设置数据
        //1、设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置显示的方向
        layoutManager.setOrientation(isVertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        //设置是否反向展示
        layoutManager.setReverseLayout(reverse);
        mRecycler.setLayoutManager(layoutManager);
        //2、设置适配器
        mRecycler.setAdapter(new ListAdapter(this, datas));
    }

    private void loadGridData(boolean reverse,boolean isVertical) {
        List<DataBeans> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataBeans dataBeans = new DataBeans();
            dataBeans.icon = R.mipmap.ic_launcher;
            dataBeans.title = "图片 - " + i;
            datas.add(dataBeans);
        }
        //1、设置布局管理器
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        //设置显示的方向
        layoutManager.setOrientation(isVertical ? GridLayoutManager.VERTICAL : GridLayoutManager.HORIZONTAL);
        //设置是否反向展示
        layoutManager.setReverseLayout(reverse);
        mRecycler.setLayoutManager(layoutManager);

        //2、设置适配器
        mRecycler.setAdapter(new GridAdapter(this, datas));
    }

    private void loadStaggeredData(boolean reverse,boolean isVertical) {

        List<DataBeans> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataBeans dataBeans = new DataBeans();
            dataBeans.icon = R.mipmap.ic_launcher;
            dataBeans.title = "图片 - " + i;
            datas.add(dataBeans);
        }
        //1、设置布局管理器
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,isVertical ? StaggeredGridLayoutManager.VERTICAL : StaggeredGridLayoutManager.HORIZONTAL);
        layoutManager.setReverseLayout(reverse);
        mRecycler.setLayoutManager(layoutManager);

        //2、设置适配器
        mRecycler.setAdapter(new GridAdapter(this, datas));
    }
}
