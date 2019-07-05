package com.firstreactnativeapp.module;

import android.net.http.SslError;
import android.os.Build;
import android.support.annotation.Nullable;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by Bruce on 2019/7/4.
 */

public class ReactWebViewManager extends SimpleViewManager<WebView> {

  @Override
  public String getName() {
    return "RCTWebView";
  }

  @Override
  protected WebView createViewInstance(ThemedReactContext reactContext) {
    WebView webView = new WebView(reactContext);
    settings(webView);
    webView.setWebViewClient(new WebViewClient(){

      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
      }
      // 处理 Https 等待证书响应
      @Override
      public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        handler.proceed();
      }
    });
    webView.setWebChromeClient(new WebChromeClient());
    return webView;
  }

  public void settings(WebView webView) {
    webView.requestFocusFromTouch(); //支持获取焦点

    WebSettings settings = webView.getSettings();
    settings.setJavaScriptEnabled(true); //开启 JS
    settings.setJavaScriptCanOpenWindowsAutomatically(true);
    settings.setUseWideViewPort(true);
    settings.setAllowFileAccess(true);
    settings.setDefaultTextEncodingName("utf-8");//设置编码格式
//        settings.setUserAgentString("TBJ");
    settings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
    settings.setLoadsImagesAutomatically(true); //支持自动加载图片
    // 自适应屏幕
    settings.setUseWideViewPort(true);//将图片调整到适合webview的大小
    settings.setLoadWithOverviewMode(true);// 缩放至屏幕的大小
    //缩放操作
//    settings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
//    settings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放。
//    settings.setDisplayZoomControls(false); //隐藏原生的缩放控件。
//    //如果不保存在本地的话，启动缓存策略
////        settings.setAppCacheEnabled(true);
////        settings.setAppCachePath(LoanApplication.getContext().getCacheDir().getAbsolutePath());
////        settings.setDomStorageEnabled(true);
//    settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
////        if(sNetworkInfo.isAvailable()){
////            settings.setCacheMode(WebSettings.LOAD_DEFAULT);
////        }else{
////            settings.setCacheMode(WebSettings.LOAD_CACHE_ONLY);
////        }
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//      settings.setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
//    }
  }

  @ReactProp(name = "url")
  public void setUrl(
    WebView view, @Nullable String url) {
    view.loadUrl(url);
  }

  @ReactProp(name = "html")
  public void setHtml(
    WebView view,@Nullable String html) {
    view.loadData(html, "text/html; charset=utf-8", "UTF-8");
  }
}
