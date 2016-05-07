package com.gdufe322.studyassistant;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;

/**
 * Created by john on 2016/4/21.
 */
public class TwoActivity extends Activity {
    private Button but;//创建一个按钮对象，导入包
    private EditText et1;
    private EditText et2;
    private final String DEBUG_TAG = "Activity04";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_activity);

        et1 = (EditText) findViewById(R.id.phone);
        et2 = (EditText) findViewById(R.id.editText2);
        final String phone = et1.getText().toString().trim();
        final String password =et2.getText().toString().trim();


        but = (Button) findViewById(R.id.button3);
        but.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //Login
                String connectURL = "http://172.25.198.26:8081/study/login.php/";
                boolean suc=true;

                URL url=null;
                try
                {
                    url=new URL(connectURL);
                }
                catch(MalformedURLException e)
                {
                    Log.e("DEBUG_TAG", "IOException");
                }
                if(url!=null)
                {
                    try {
                        HttpURLConnection urlconn = (HttpURLConnection) url.openConnection();
                        urlconn.setDoOutput(true);
                        urlconn.setDoInput(true);
                        urlconn.setRequestMethod("POST");
                        urlconn.setInstanceFollowRedirects(true);
                        urlconn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        urlconn.connect();
                        DataOutputStream out = new DataOutputStream(urlconn.getOutputStream());
                        String content = "par=" + URLEncoder.encode(phone, password);
                        out.writeBytes(content);
                        out.flush();
                        out.close();

                        BufferedReader reader = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
                        String inputLine = null;
                        String resultData = "";
                        //使用循环来读取获得的数据
                        while (((inputLine = reader.readLine()) != null))
                        {
                            //我们在每一行后面加上一个"\n"来换行
                            resultData += inputLine + "\n";
                        }
                        reader.close();//关闭http连接
                        urlconn.disconnect();//设置显示取得的内容
                        if ( resultData != null )
                        {
                            Intent in = new Intent(TwoActivity.this, forActivity.class);
                            startActivity(in);
                        }
                        else
                        {
                            Log.e("DEBUG_TAG","登入错误");
                        }

                    } catch (IOException e) {
                        Log.e("DEBUG_TAG", "IOException");
                    }

                }

                if (suc) {

                   Intent in = new Intent(TwoActivity.this, forActivity.class);
                   startActivity(in);

                } else {

                    Log.e("DEBUG_TAG","登入错误");

                }
                //Login end

            }

        });

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
