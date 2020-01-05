package com.example.myapplication

import android.graphics.Bitmap
import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.KeyEvent
import android.webkit.*
import kotlinx.android.synthetic.main.activity_main.*
import android.webkit.JavascriptInterface

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = CustomWebViewClient()//WriteHandlingWebViewClient(webView)
        webView.webChromeClient = WebChromeClient()
        webView.addJavascriptInterface(FormDataInterface(), "SUBMIT")
        webView.loadUrl("https://www.instagram.com/")
    }

    private class FormDataInterface {
        @JavascriptInterface
        fun processFormData(url: String, formData: String) {
            Log.d("myapp", "Url:$url form data $formData")
//            Log.d(DEBUG_TAG, "Url:$url form data $formData")
//            if (url == paymentReturnUrl) {
//                val map = HashMap()
//                val values =
//                    formData.split("&".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
//                shouldInterceptRequestfor (pair in values) {
//                    val nameValue =
//                        pair.split("=".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
//                    if (nameValue.size == 2) {
//                        Log.d(DEBUG_TAG, "Name:" + nameValue[0] + " value:" + nameValue[1])
//                        map.put(nameValue[0], nameValue[1])
//                    }
//                }
//
//                return
//            }
        }
    }

    private class CustomWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            Log.d("myapp", "shouldOverrideUrlLoading")
            Log.d("myapp", "requestHeaders ${request?.requestHeaders}")
            Log.d("myapp", "method ${request?.method}")
            return super.shouldOverrideUrlLoading(view, request)
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            Log.d("myapp", "onPageStarted")
            Log.d("myapp", "url $url")
            super.onPageStarted(view, url, favicon)
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            Log.d("myapp", "onPageFinished")
            Log.d("myapp", "url $url")
            super.onPageFinished(view, url)
        }

        override fun onLoadResource(view: WebView?, url: String?) {
            Log.d("myapp", "onLoadResource")
            Log.d("myapp", "url $url")
            super.onLoadResource(view, url)
        }

        override fun onPageCommitVisible(view: WebView?, url: String?) {
            Log.d("myapp", "onPageCommitVisible")
            Log.d("myapp", "url $url")
            super.onPageCommitVisible(view, url)
        }

        override fun shouldInterceptRequest(
            view: WebView?,
            request: WebResourceRequest?
        ): WebResourceResponse? {
            Log.d("myapp", "shouldInterceptRequest")
            Log.d("myapp", "requestHeaders ${request?.requestHeaders}")
            Log.d("myapp", "method ${request?.method}")
            return super.shouldInterceptRequest(view, request)
        }

        override fun onTooManyRedirects(
            view: WebView?,
            cancelMsg: Message?,
            continueMsg: Message?
        ) {
            Log.d("myapp", "onTooManyRedirects")
            super.onTooManyRedirects(view, cancelMsg, continueMsg)
        }

        override fun onReceivedError(
            view: WebView?,
            request: WebResourceRequest?,
            error: WebResourceError?
        ) {
            Log.d("myapp", "onReceivedError")
            Log.d("myapp", "requestHeaders ${request?.requestHeaders}")
            Log.d("myapp", "method ${request?.method}")
            super.onReceivedError(view, request, error)
        }

        override fun onReceivedHttpError(
            view: WebView?,
            request: WebResourceRequest?,
            errorResponse: WebResourceResponse?
        ) {
            Log.d("myapp", "onReceivedHttpError")
            Log.d("myapp", "requestHeaders ${request?.requestHeaders}")
            Log.d("myapp", "method ${request?.method}")
            super.onReceivedHttpError(view, request, errorResponse)
        }

        override fun onReceivedSslError(
            view: WebView?,
            handler: SslErrorHandler?,
            error: SslError?
        ) {
            Log.d("myapp", "onReceivedSslError")
            super.onReceivedSslError(view, handler, error)
        }

        override fun onFormResubmission(
            view: WebView?,
            dontResend: Message?,
            resend: Message?
        ) {
            Log.d("myapp", "onFormResubmission")
            super.onFormResubmission(view, dontResend, resend)
        }

        override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
            Log.d("myapp", "doUpdateVisitedHistory")
            Log.d("myapp", "url $url")
            super.doUpdateVisitedHistory(view, url, isReload)
        }

        override fun onReceivedClientCertRequest(view: WebView?, request: ClientCertRequest?) {
            Log.d("myapp", "onReceivedClientCertRequest")
            Log.d("myapp", "host ${request?.host}")
            Log.d("myapp", "port ${request?.port}")
            Log.d("myapp", "keyTypes ${request?.keyTypes.toString()}")
            super.onReceivedClientCertRequest(view, request)
        }

        override fun onReceivedHttpAuthRequest(
            view: WebView?,
            handler: HttpAuthHandler?,
            host: String?,
            realm: String?
        ) {
            Log.d("myapp", "onReceivedHttpAuthRequest")
            Log.d("myapp", "host ${host}")
            Log.d("myapp", "realm ${realm}")
            super.onReceivedHttpAuthRequest(view, handler, host, realm)
        }

        override fun shouldOverrideKeyEvent(view: WebView?, event: KeyEvent?): Boolean {
            Log.d("myapp", "shouldOverrideKeyEvent")
            return super.shouldOverrideKeyEvent(view, event)
        }

        override fun onUnhandledKeyEvent(view: WebView?, event: KeyEvent?) {
            Log.d("myapp", "onUnhandledKeyEvent")
            super.onUnhandledKeyEvent(view, event)
        }

        override fun onScaleChanged(view: WebView?, oldScale: Float, newScale: Float) {
            Log.d("myapp", "onScaleChanged")
            super.onScaleChanged(view, oldScale, newScale)
        }

        override fun onReceivedLoginRequest(
            view: WebView?,
            realm: String?,
            account: String?,
            args: String?
        ) {
            Log.d("myapp", "onReceivedLoginRequest")
            super.onReceivedLoginRequest(view, realm, account, args)
        }

        override fun onRenderProcessGone(
            view: WebView?,
            detail: RenderProcessGoneDetail?
        ): Boolean {
            Log.d("myapp", "onRenderProcessGone")
            return super.onRenderProcessGone(view, detail)
        }

        override fun onSafeBrowsingHit(
            view: WebView?,
            request: WebResourceRequest?,
            threatType: Int,
            callback: SafeBrowsingResponse?
        ) {
            Log.d("myapp", "onSafeBrowsingHit")
            super.onSafeBrowsingHit(view, request, threatType, callback)
        }
    }
}