package com.alphaplus.recyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class TestList extends AppCompatActivity {

    String[] titles, descriptions;
    ListView listView;
    int[] images = {R.drawable.cantock, R.drawable.cantock, R.drawable.cantock, R.drawable.cantock, R.drawable.cantock, R.drawable.cantock, R.drawable.cantock, R.drawable.cantock, R.drawable.cantock, R.drawable.cantock};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Resources res = getResources();
        titles = res.getStringArray(R.array.titles);
        descriptions = res.getStringArray(R.array.descriptions);
        listView = (ListView) findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(this, titles, descriptions, images);
        listView.setAdapter(adapter);
    }

    class CustomAdapter extends ArrayAdapter<String> {
        Context context;
        String[] titles, descriptions;
        int[] images;

        CustomAdapter(Context context, String[] titles, String[] descriptions, int[] images) {
            super(context, R.layout.single_row, R.id.txtTitles, titles);
            this.context = context;
            this.images = images;
            this.titles = titles;
            this.descriptions = descriptions;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View single_row = convertView;
            if (single_row == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                single_row = inflater.inflate(R.layout.single_row, parent, false);
                ImageView imgUser = (ImageView) single_row.findViewById(R.id.imgUser);
                TextView txtTitles = (TextView) single_row.findViewById(R.id.txtTitles);
                TextView txtDescriptions = (TextView) single_row.findViewById(R.id.txtDescriptions);
                /*imgUser.requestLayout();
                imgUser.getLayoutParams().height = 144;
                imgUser.getLayoutParams().width = 144;*/
                imgUser.setImageResource(images[position]);
                txtTitles.setText(titles[position]);
                txtDescriptions.setText(descriptions[position]);
            }
            return single_row;
        }
    }
}
