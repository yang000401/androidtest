package com.example.myapp;

import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class JsInterface {
    Context context;
    Activity activity;
    WebView webView;
    public JsInterface(Context context, WebView webView){
        this.context = context;
        this.webView= webView;
        this.activity= (Activity) context;


    }
    @JavascriptInterface
    public void appFunction(String msg){
        Toast.makeText(context, "in app="+msg, Toast.LENGTH_SHORT).show();
    activity.runOnUiThread(new Runnable() {
        @Override
        public void run() {
            webView.loadUrl("javascript:jsFunction('app msg')");
        }
    });
    }


}
