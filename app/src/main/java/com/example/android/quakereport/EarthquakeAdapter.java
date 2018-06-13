package com.example.android.quakereport;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
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

        final Earthquake currentQuake = getItem(position);

        magnitude.setText(formatMagnitude(currentQuake.getMagnitude()));
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentQuake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


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

        /*listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = currentQuake.getUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                    getContext().startActivity(intent);
                }
            }
        });*/

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitude1Color = 0;
        int mag = (int) Math.floor(magnitude);
        switch (mag) {
            case 0:
            case 1:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return magnitude1Color;
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
