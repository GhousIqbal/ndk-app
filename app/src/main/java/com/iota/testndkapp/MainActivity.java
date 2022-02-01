package com.iota.testndkapp;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("nativelib");
    }

    public static native int startServer(int port);
    public static native void stopServer();
    public static native int sum(int num1,int num2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View view) {
        int res = startServer(7999);
        String str = Integer.toString(res);
        ((TextView)findViewById(R.id.editTextNumber)).setText(str);
        Toast.makeText(getApplicationContext(), "Result: " + str, Toast.LENGTH_SHORT).show();
    }

    public void onBtnClick2(View view) {
        stopServer();
    }

    public void onBtnClick3(View view) {
        int result = sum(7999,1);
        String str = Integer.toString(result);
        ((TextView)findViewById(R.id.editTextNumber)).setText(str);
        Toast.makeText(getApplicationContext(), "Result: " + str, Toast.LENGTH_SHORT).show();
    }
}