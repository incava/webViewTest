package com.incava.webviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.incava.webviewtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        webView = binding.webview;
        WebSettings wSetting = webView.getSettings();
        webView.setWebChromeClient(new WebChromeClient()); // 크롬으로 열기
        webView.setWebViewClient(new WebViewClient()); // 내부 웹뷰로 열기
        wSetting.setJavaScriptEnabled(true); // 자바 스크립트 사용가능 여부
        wSetting.setSupportMultipleWindows(true); // 멀티 창 가능.
        wSetting.setUseWideViewPort(true); // wide viewport 설정
//  설정값이 false인 경우, layout 너비는 디바이스 픽셀에 맞추어 설정된다.
//  값이 true이고 페이지에 뷰포트 메타 태그가 있으면 태그에 지정된 너비 값이 사용된다.
//  페이지에 태그가 없거나 너비가 없는 경우 넓은 뷰포트가 사용된다.
        wSetting.setJavaScriptCanOpenWindowsAutomatically(true);// 자바스크립트가 자동으로 창을 열수 있게 하기.
        webView.loadUrl("https://iba.or.kr/");
    }

    //back 처리
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else super.onBackPressed();
    }
}