package com.example.json_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Tui> {
    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, List<Tui> items){
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null){
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.activity_dong_tui, null);
        }
        Tui q = getItem(position);
        if (q!= null) {
            //Anh xa + Gan gia tri
            TextView tt1 = (TextView) v.findViewById(R.id.textViewTen);
            tt1.setText(q.ten);
            TextView tt2 = (TextView) v.findViewById(R.id.textViewGia);
            tt2.setText(String.valueOf(q.gia));
            ImageView imgv = (ImageView)  v.findViewById(R.id.imageViewHinh);
            Picasso.get().load(q.hinh).into(imgv);
        }
        return v;
    }
}
