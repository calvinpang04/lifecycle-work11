package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private SeekBar seekbar;
    private TextView text;
    private TextView text2;
    private EditText text3;
    private Button btn1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text2 = (TextView) findViewById(R.id.text);
        text3 = (EditText) findViewById(R.id.edit1);
        btn1 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setText(text3.getText().toString());
            }
        });

        seekbar = (SeekBar) findViewById(R.id.seekBar);
        text = (TextView) findViewById(R.id.text2);
        seekbar.setMax(150);//設定SeekBar最大值
        seekbar.setProgress(80);//設定SeekBar拖移初始值
        text.setText("目前拖移植：" +seekbar.getProgress() + "  /  最大值："+seekbar.getMax());
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text.setText("目前拖移植：" + progress + "  /  最大值："+seekbar.getMax());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity2.this, "觸碰SeekBar", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity2.this, "放開SeekBar", Toast.LENGTH_SHORT).show();
            }
        });

        Spinner spinner = (Spinner)findViewById(R.id.activity_main);
        final String[] lunch = {"魯肉飯", "控肉飯", "雞排飯", "炸醬麵", "水餃"};
        ArrayAdapter<String> lunchList = new ArrayAdapter<>(MainActivity2.this, android.R.layout.simple_spinner_dropdown_item, lunch);
        spinner.setAdapter(lunchList);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity2.this, "您選擇了:" + lunch[position], Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

        // The activity is about to become visible.
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // The activity is between stopped and started.
    }
    public void Turn(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity2.this, MainActivity.class);
        startActivity(intent);

    }

}