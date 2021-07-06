package com.example.a7julyasign1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mbtn;
    private static final int Request_code=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtn=findViewById(R.id.btn);

        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permission={Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this,permission,Request_code);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Toast.makeText(MainActivity.this,"granted",Toast.LENGTH_SHORT).show();
        }else if(grantResults[0]== PackageManager.PERMISSION_DENIED){
            Toast.makeText(MainActivity.this," denied",Toast.LENGTH_SHORT).show();
        }
    }
}
