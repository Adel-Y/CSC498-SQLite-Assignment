package com.csc498.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import android.webkit.WebViewClient;

public class Webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        WebView view = (WebView) findViewById(R.id.webview);

        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient( new WebViewClient());
        view.loadUrl("http://www.google.com");


    }


}