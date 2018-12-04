package com.genkitech.effectiveptetips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.InterstitialAd;

public class ResourcesActivity extends AppCompatActivity {

    private InterstitialAd mInterstitial;
    private WebView appsWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        appsWebView = findViewById(R.id.webView);
        WebSettings webSettings = appsWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // enter required URL here (make sure webpage is responsive i.e. it can resize automatically)
        appsWebView.loadUrl("https://genkitechblog.wordpress.com/effective-pte-a-tips-1/");
        appsWebView.setWebViewClient(new WebViewClient());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.secondary_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
