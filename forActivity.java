package com.gdufe322.studyassistant;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.reflect.AccessibleObject;

/**
 * Created by john on 2016/3/24.
 */
public class forActivity extends FragmentActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.for_men_activity);

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

    public void initView() {
        RadioGroup myTabRg;
        Fragmentuser chatt = new Fragmentuser();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, chatt).commit();
        myTabRg =(RadioGroup) findViewById(R.id.tab_menu);
        myTabRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                // TODO Auto-generated method stub
                switch (checkedId)
                {
                    case R.id.ruser:
                        Fragmentuser chat = new Fragmentuser();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, chat).commit();
                        break;

                    case R.id.rdownload:
                        Fragmentdownload download = new Fragmentdownload();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, download).commit();
                        break;

                    case R.id.rupdate:
                        Fragmentupdate update = new Fragmentupdate();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, update).commit();
                        break;

                    case R.id.rnote:
                        Fragmentnote note = new Fragmentnote();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, note).commit();
                        break;

                    case R.id.rnoteadd:
                        Fragmentnoteadd na = new Fragmentnoteadd();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, na).commit();
                        break;

                    default:
                        break;
                }

            }
        });
     };
}
