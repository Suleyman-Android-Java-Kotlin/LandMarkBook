package com.developer.suleymanekici.landmarkbook;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static Bitmap selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        final ArrayList<String> landmarkNames = new ArrayList<String>();
        landmarkNames.add("izmir");
        landmarkNames.add("istanbul");
        landmarkNames.add("ankara");



        Bitmap izmir = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.izmir);
        Bitmap istanbul = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.istanbul);
        Bitmap ankara = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.ankara);

        final ArrayList<Bitmap> landmarkImages = new ArrayList<>();

        landmarkImages.add(izmir);
        landmarkImages.add(istanbul);
        landmarkImages.add(ankara);


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkNames);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("name", landmarkNames.get(position));

                //selectedImage = landmarkImages.get(position);

                Bitmap bitmap = landmarkImages.get(position);

                Globals globals = Globals.getInstance();
                globals.setData(bitmap);

                startActivity(intent);

            }
        });


    }
}