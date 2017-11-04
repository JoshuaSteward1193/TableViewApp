package com.example.joshuas.starwarsplanets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Joshua S on 11/3/2017.
 */

public class ItemAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    String[] planets;
    String[] descriptions;

    public ItemAdapter(Context c, String[] i, String[] d){
        planets = i;
        descriptions = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return planets.length;
    }

    @Override
    public Object getItem(int i) {
        return planets[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView  nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView  descriptionTextView = (TextView) v.findViewById(R.id.descriptionTextView);

        String name = planets[i];
        String desc = descriptions[i];

        nameTextView.setText(name);
        descriptionTextView.setText(desc);

        return v;
    }
}
