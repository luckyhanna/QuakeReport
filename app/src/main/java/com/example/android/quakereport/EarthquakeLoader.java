package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by hanna on 6/29/2018.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    public static final String LOG_TAG = EarthquakeLoader.class.getName();

    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.i(LOG_TAG, "********************* loadInBackground()");
        if (mUrl == null){
            return null;
        }
        return QueryUtils.fetchEarthquakes(mUrl);
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "********************* onStartLoading()");
        forceLoad();
    }
}
