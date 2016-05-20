package com.view.sg.uritest;

import android.app.Activity;
import android.content.ContentUris;
import android.content.UriMatcher;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    private static final String TAG = "Test";
    private static final String AUTHORITY = "com.view.sg.uritest";
    private static final int PEOPLE = 1;
    private static final int PEOPLE_ID = 2;
    //UriMatcher.NO_MATCH表示不匹配任何路径的返回码
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(AUTHORITY,"people",PEOPLE);
        uriMatcher.addURI(AUTHORITY, "people/#", PEOPLE_ID);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse("content://" + AUTHORITY + "/people");
        Log.i(TAG, uri.toString());
        Log.i(TAG, getType(uri));

        Uri uri1 = Uri.parse("content://" + AUTHORITY + "/people/15");
        Log.i(TAG, uri1.toString());
        Log.i(TAG, getType(uri1));
        //通过withAppendedId方法，为该Uri加上ID
        Uri uri2 = ContentUris.withAppendedId(uri, 2);
        Log.i(TAG, uri2.toString());
        //ContentUris 类用于获取Uri路径后面的ID部分
        long id = ContentUris.parseId(uri1);
        Log.i(TAG, "id is " + id);
    }

    private String getType(Uri uri) {
        //match方法匹配后会返回一个匹配码Code，即在使用注册方法addURI时传入的第三个参数。
        int code = uriMatcher.match(uri);
        switch (code) {
            case PEOPLE:
                return "vnd.android.cursor.dir/person";
            case PEOPLE_ID:
                return "vnd.android.cursor.item/person";
        }
        return null;
    }
}
