package com.tao.progressbutton;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @butterknife.InjectView(R.id.progressBtn)
    ProgressBtn mProgressBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.inject(this);
        mProgressBtn.setText("开始下载");
        mProgressBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "start download ...", Toast.LENGTH_SHORT).show();
        new MyAsyncTask().execute();
    }
    class MyAsyncTask extends AsyncTask<Void,Integer,Void>{
        @Override
        protected void onPreExecute() {
            mProgressBtn.setMax(100);

        }

        /**
         * 方法参数
            1. 类型由类上面的第一个泛型来指定
            2. 方法的参数由execute方法传递进来。
         * @param params
         * @return
         */
        @Override
        protected Void doInBackground(Void... params) {
            for (int i = 0; i < 100; i++) {
                publishProgress(i);
                SystemClock.sleep(50);
            }
            return null;
        }

        /**
         * 方法参数
             1. 类型由类上面的第二个泛型来指定
             2. 方法的参数由publishProgress方法传递进来。
         * @param values
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            mProgressBtn.setProgress(values[0]);
            mProgressBtn.setText("正在下载:"+values[0]+"%");
        }

        /**
         * 方法参数
             1. 类型由类上面的第三个泛型来指定
             2. 方法的参数由doInBackground的返回值传递进来。
         * @param aVoid
         */
        @Override
        protected void onPostExecute(Void aVoid) {
           mProgressBtn.setText("下载完成");
        }
    }
}
