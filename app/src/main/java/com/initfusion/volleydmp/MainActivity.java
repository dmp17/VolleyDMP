package com.initfusion.volleydmp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.initfusion.volley.JsonRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Context context = this;

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

                JsonRequest.ResponseListener responseListener=new JsonRequest.ResponseListener() {
                    @Override
                    public void onResult(Object result, String msg) {

                        LoginResponse loginResponse = (LoginResponse) result;

                    }
                };

                JsonRequest.with(context).load("http://52.35.166.109/bairows/api/shared?prcid=GETREQPEN&Param=10")
                        .execute();

                JsonRequest.with(context).load("http://52.35.166.109/bairows/api/shared?prcid=SIGNIN&Param=ddharmesh@gmail.com|123")
                        .execute();

                JsonRequest.with(context)
                        .load("http://52.35.166.109/bairows/api/shared?prcid=SIGNIN&Param=ddenish@gmail.com|123")
                        .setCallback(responseListener)
                        .setResponseClass(LoginResponse.class)
                        .execute();

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