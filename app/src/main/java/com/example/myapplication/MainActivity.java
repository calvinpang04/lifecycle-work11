package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG," oncreate");
    }

    protected void onStart() {
        super.onStart();
        Log.d(TAG," onstart");
    }

    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }


    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }


    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }


    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }


    public void changenum1(View view) {
        EditText firstName = (EditText)findViewById(R.id.kkkk);
        TextView textvw = (TextView)findViewById(R.id.counter);
        textvw.setText(firstName.getText().toString());

    }

    public void link(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        startActivity(browserIntent);
    }

    public void Call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:8005551234"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);}
        }
    public void Turn(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, MainActivity2.class);
        startActivity(intent);

    }
}