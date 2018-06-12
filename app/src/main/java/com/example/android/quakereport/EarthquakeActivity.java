/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        earthquakes.add(new Earthquake(BigDecimal.valueOf(7.2),"San Francisco", (new Date()).getTime()));
        earthquakes.add(new Earthquake(BigDecimal.valueOf(6.1),"London", (new Date()).getTime()));
        earthquakes.add(new Earthquake(BigDecimal.valueOf(3.9),"Tokyo", (new Date()).getTime()));
        earthquakes.add(new Earthquake(BigDecimal.valueOf(5.4),"Mexico City", (new Date()).getTime()));
        earthquakes.add(new Earthquake(BigDecimal.valueOf(2.8),"Moscow", (new Date()).getTime()));
        earthquakes.add(new Earthquake(BigDecimal.valueOf(4.9),"Rio de Janeiro", (new Date()).getTime()));
        earthquakes.add(new Earthquake(BigDecimal.valueOf(1.6),"Paris", (new Date()).getTime()));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}
