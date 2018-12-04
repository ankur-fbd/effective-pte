package com.genkitech.effectiveptetips;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private static Button button;
    private InterstitialAd mInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-6721913905554817~4600210559");

        //banner ad
//        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//       mAdView.loadAd(adRequest);

        // Prepare the Interstitial Ad
        mInterstitial = new InterstitialAd(MainActivity.this);
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

        onButtonClick();
    }

    public void onButtonClick() {
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.genkitech.effectiveptetips.SpeakingActivity");
                        startActivity(intent);
                    }
                }
        );

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.genkitech.effectiveptetips.ReadingActivity");
                        startActivity(intent);
                    }
                }
        );

        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.genkitech.effectiveptetips.ListeningActivity");
                        startActivity(intent);
                    }
                }
        );

        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.genkitech.effectiveptetips.WritingActivity");
                        startActivity(intent);
                    }
                }
        );

        button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.genkitech.effectiveptetips.VocabActivity");
                        startActivity(intent);
                    }
                }
        );

        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.genkitech.effectiveptetips.ResourcesActivity");
                        startActivity(intent);
                    }
                }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.exit_menu, menu);
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
            System.exit(0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (mInterstitial.isLoaded()) {
            mInterstitial.show();
        }
    }
}
