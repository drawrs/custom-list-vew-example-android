package com.khilman.customlistview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by root on 9/28/17.
 */

class ListViewAdapter extends BaseAdapter {
    // buat data menjadi global
    Context context;
    String[] namabuah;
    int[] gambarbuah;

    public ListViewAdapter(Context context, String[] namabuah, int[] gambarbuah) {
        this.context = context;
        this.namabuah = namabuah;
        this.gambarbuah = gambarbuah;
    }

    @Override
    public int getCount() {
        return namabuah.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_list_buah, null);
        // inisialisai
        ImageView gambar = (ImageView) view.findViewById(R.id.itemGambar);
        TextView judul = (TextView) view.findViewById(R.id.itemNama);
        // set value
        gambar.setImageResource(gambarbuah[position]);
        judul.setText(namabuah[position]);

        return view;
    }
}
