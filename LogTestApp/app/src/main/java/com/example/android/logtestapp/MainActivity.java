package com.example.android.logtestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView firstTextView = (TextView) findViewById(R.id.menu_item_1);
        Log.i("First TextView content",(String) firstTextView.getText());
        // Find second menu item TextView and print the text to the logs
        TextView secondTextView = (TextView) findViewById(R.id.menu_item_2);
        Log.i("Second TextView content",(String) secondTextView.getText());
        // Find third menu item TextView and print the text to the logs
        TextView thirdTextView = (TextView) findViewById(R.id.menu_item_3);
        Log.i("Third TextView content",(String) thirdTextView.getText());
    }
}