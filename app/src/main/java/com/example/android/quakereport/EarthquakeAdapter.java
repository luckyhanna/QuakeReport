package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(@NonNull Context context, @NonNull List<Earthquake> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_item, parent, false);
        }
        TextView magnitude = (TextView) listItemView.findViewById(R.id.mag_tv);
        TextView locationOffset = (TextView) listItemView.findViewById(R.id.location_offset_tv);
        TextView primaryLocation = (TextView) listItemView.findViewById(R.id.primary_location_tv);
        TextView dateTv = (TextView) listItemView.findViewById(R.id.date_tv);
        TextView time = (TextView) listItemView.findViewById(R.id.time_tv);

        Earthquake currentQuake = getItem(position);

        magnitude.setText(formatMagnitude(currentQuake.getMagnitude()));
        String place = currentQuake.getPlace();

        String offsetString = getContext().getString(R.string.near_the);;
        String locationString = place;
        if (place.contains(LOCATION_SEPARATOR)) {
            String[] parts = place.split(LOCATION_SEPARATOR);
            offsetString = parts[0] + LOCATION_SEPARATOR;
            locationString = parts[1];
        }
        locationOffset.setText(offsetString);
        primaryLocation.setText(locationString);

        Date date = new Date(currentQuake.getTime());

        dateTv.setText(formatDate(date));

        time.setText(formatTime(date));

        return listItemView;
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
        return sdf.format(date);
    }

    private String formatTime(Date date) {
        SimpleDateFormat sdfTime = new SimpleDateFormat("h:mm a");
        return sdfTime.format(date);
    }

    private String formatMagnitude(double mag) {
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(mag);
    }
}
