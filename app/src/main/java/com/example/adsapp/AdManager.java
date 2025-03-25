package com.example.adsapp;

import android.app.Activity;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.net.ContentHandler;

public class AdManager {
    Activity activity;

    public AdManager(Activity activity) {
        this.activity = activity;
    }

    public void initAd(){
        if (Constant.AD_STATUS){
            if (Constant.AD_TYPE.equalsIgnoreCase(Constant.ADMOB_TYPE)){
                MobileAds.initialize(activity);
            }
        }
    }

    public void showBannerAd(LinearLayout container){
        if (Constant.AD_STATUS){
            if (Constant.AD_TYPE.equalsIgnoreCase(Constant.ADMOB_TYPE)){
                AdView adView = new AdView(activity);
                adView.setAdSize(AdSize.BANNER);
                adView.setAdUnitId(Constant.ADMOB_BANNER_ID);

                container.addView(adView);

                AdRequest adRequest = new AdRequest.Builder().build();
                adView.loadAd(adRequest);
            }
        }
    }
}
