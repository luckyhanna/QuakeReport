package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


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
        TextView place = (TextView) listItemView.findViewById(R.id.place_tv);
        TextView time = (TextView) listItemView.findViewById(R.id.time_tv);

        Earthquake currentQuake = getItem(position);

        magnitude.setText(String.valueOf(currentQuake.getMagnitude()));
        place.setText(currentQuake.getPlace());
        Date date = new Date(currentQuake.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("LLL dd, yyyy");
        String dateString = sdf.format(date);
        time.setText(dateString);

        return listItemView;
    }
}
