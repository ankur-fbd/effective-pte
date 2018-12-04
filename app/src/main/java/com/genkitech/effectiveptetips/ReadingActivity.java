package com.genkitech.effectiveptetips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class ReadingActivity extends AppCompatActivity {
    private InterstitialAd mInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
       // MobileAds.initialize(this, "ca-app-pub-6721913905554817~4600210559");

        //banner ad
//        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//       mAdView.loadAd(adRequest);

        // Prepare the Interstitial Ad
        mInterstitial = new InterstitialAd(ReadingActivity.this);
        // Insert the Ad Unit ID
        mInterstitial.setAdUnitId(getString(R.string.admob_interstitial_id));
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitial.loadAd(adRequest);
        // Prepare an Interstitial Ad Listener
        mInterstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });
    }

    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (mInterstitial.isLoaded()) {
            mInterstitial.show();
        }
    }
}
