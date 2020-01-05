package com.example.myapplication

import android.content.Context
import android.util.Log
import android.webkit.WebView

class CustomWebView(context:Context):WebView(context) {
    override fun postUrl(url: String?, postData: ByteArray?) {
        Log.d("myapp","postUrl")
        super.postUrl(url, postData)
    }
//    @Override
//    public void  postUrl(String  url, byte[] postData)
//    {
//        System.out.println("postUrl can modified here:" +url);
//        super.postUrl(url, postData);
//    }};
}