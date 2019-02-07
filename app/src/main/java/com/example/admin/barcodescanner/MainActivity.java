package com.example.admin.barcodescanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity {

    private ZXingScannerView zXingScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scan(View view) {
        zXingScannerView=new ZXingScannerView(this);
        zXingScannerView.setResultHandler(new zxinghandler());

        setContentView(zXingScannerView);
        zXingScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        zXingScannerView.stopCamera();
    }

    class zxinghandler implements ZXingScannerView.ResultHandler{
        @Override
        public void handleResult(Result result) {
            String resultcode=result.getText();
            Toast.makeText(MainActivity.this, resultcode, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
            zXingScannerView.stopCamera();
        }
    }
}
