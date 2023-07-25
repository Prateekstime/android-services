package com.example.day24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.day24.databinding.ActivityMainBinding;
//Services

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = new Intent(MainActivity.this,MyService.class);
        binding.btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
            }
        });

        binding.btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
            }
        });


        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();

                for (int i = 0; i < 60; i++) {
                    int finalI = i;
//                    Log.e("Numbers", i+"");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            binding.tv1.setText(finalI+"");
                        }
                    });

                }
            }
        };
        thread.start();


    }

}