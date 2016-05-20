package com.view.sg.messagehandler;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AsyncTaskActivity extends AppCompatActivity {

    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        show = (TextView) findViewById(R.id.show);
    }

    /**
     * 按钮的响应方法
     * @param source
     * @throws MalformedURLException
     */
    public void download(View source) throws MalformedURLException {
        DownloadTask task = new DownloadTask(this);
        //每个AsyncTask只能被执行一次，多次调用将会引发异常。
        task.execute(new URL("http://www.crazyit.org/ethos.php"));
    }

    /**
     * AsyncTask<Params,Progress,Result>是一个抽象类，通常用于被继承，继承时需要指定如下三个泛型参数。
     * Params:启动任务执行的输入参数的类型。
     * Progress:后台任务完成的进度值的类型。
     * Result:后台执行任务完成后返回结果的类型。
     * 创建AsyncTask的子类，并为三个泛型参数指定类型。如果某个泛型参数不需要指定类型，则可将它指定为void。
     * 根据需要，实现AsyncTask的方法。
     */
    class DownloadTask extends AsyncTask<URL, Integer, String> {

        ProgressDialog progressDialog;
        int hasRead;//记录已经读取行的数量
        Context mContext;

        public DownloadTask(Context mContext) {
            this.mContext = mContext;
        }

        /**
         * 重写该方法就是后台线程要完成的任务。该方法可以调用publishProgress(Progress... values)方法更新任务的执行进度。
         * @param params
         * @return
         */
        @Override
        protected String doInBackground(URL... params) {
            StringBuilder sb = new StringBuilder();
            try {
                URLConnection conn = params[0].openConnection();
                //打开conn连接对应的输入流，并将它包装成BufferedReader
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                    hasRead++;
                    publishProgress(hasRead);
                }
                return sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * 该方法将在执行后台耗时操作前被调用。通常该方法用于完成一些初始化的准备工作，比如在界面上显示进度条等。
         */
        @Override
        protected void onPreExecute() {
            //初始化对话框
            progressDialog = new ProgressDialog(mContext);
            //设置对话框的标题
            progressDialog.setTitle("任务执行中");
            //设置对话框显示的内容
            progressDialog.setMessage("任务正在执行中，敬请等待...");
            //设置对话框不能用返回键关闭
            progressDialog.setCancelable(false);
            //设置进度条的最大进度值
            progressDialog.setMax(202);
            //设置对话框的进度条风格
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            //设置对话框的进度条是否显示进度
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }

        /**
         * 当doInBackground方法完成后，系统会自动调用onPostExecute方法，并将doInBackground方法的返回值传给该方法。
         * @param s
         */
        @Override
        protected void onPostExecute(String s) {
            //返回HTML页面的内容
            show.setText(s);
            progressDialog.dismiss();
        }

        /**
         * 在doInBackground方法中调用publishProgress方法更新任务的进度后，将会触发该方法。
         * @param values
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            //更新进度
            show.setText("已经读取了【" + values[0] + "】行！");
            progressDialog.setProgress(values[0]);
        }
    }
}
