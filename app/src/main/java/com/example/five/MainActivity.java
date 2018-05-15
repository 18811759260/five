package com.example.five;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnWrite = (Button)findViewById(R.id.btnWrite);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OutputStream out=null;
                try {
                    FileOutputStream fileOutputStream = openFileOutput("MyFileName", MODE_PRIVATE);
                    out = new BufferedOutputStream(fileOutputStream);
                    String content = "牛敏航 2015011426";
                    try {
                        out.write(content.getBytes("UTF-8"));
                        Toast.makeText(MainActivity.this, "write successful", Toast.LENGTH_SHORT).show();
                    } finally {
                        if (out != null)
                            out.close();
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


        Button btnread=(Button)findViewById(R.id.button);
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileInputStream in=null;
                BufferedReader reader=null;
                StringBuilder content=new StringBuilder();
                try {
                    in = openFileInput("MyFileName");
                    reader = new BufferedReader(new InputStreamReader(in));
                    String line ="";
                    try{
                        while((line=reader.readLine())!=null){
                            content.append(line);
                        }
                        Toast.makeText(MainActivity.this,content.toString(),Toast.LENGTH_LONG).show();;
                    }
                    finally {
                        if (in != null)
                            in.close();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }
}
