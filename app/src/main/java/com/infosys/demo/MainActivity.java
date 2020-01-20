package com.infosys.demo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.infosys.modelview.DataList;
import com.infosys.modelview.ResponseList;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final static String JSON_FILE_ARRIVAL_CITIES = "arrival_cities.json";


    RecyclerView follow_recycler;
    FollowersAdapter followersAdapter;
    ResponseList citiesList;
    ToolbarCenterTitle toolbar;
    ImageView img_refresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        follow_recycler=findViewById(R.id.follow_recycler);
        toolbar=findViewById(R.id.toolbar);
        img_refresh=findViewById(R.id.img_refresh);
        img_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                followersAdapter = new FollowersAdapter(getApplicationContext(), getArrivalCitiesData());
                follow_recycler.setHasFixedSize(true);

                follow_recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                follow_recycler.setAdapter(followersAdapter);
                followersAdapter.notifyDataSetChanged();

            }
        });
        //getArrivalCitiesData();

        followersAdapter = new FollowersAdapter(getApplicationContext(), getArrivalCitiesData());
        follow_recycler.setHasFixedSize(true);

        follow_recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        follow_recycler.setAdapter(followersAdapter);
        followersAdapter.notifyDataSetChanged();
        setupToolbar();
    }

    public ArrayList<DataList> getArrivalCitiesData() {
        String jsonString = getAssetsJSON(JSON_FILE_ARRIVAL_CITIES);
        Gson gson = new Gson();
         citiesList = gson.fromJson(jsonString, ResponseList.class);
        return citiesList.getDataList();
    }

    private String getAssetsJSON(String fileName) {
        String json = null;
        try {
            InputStream inputStream = getApplicationContext().getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();

        }

        return json;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        final ActionBar supportActionBar = getSupportActionBar();
        assert supportActionBar != null;
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setHomeButtonEnabled(true);
            supportActionBar.setTitle(citiesList.getAirportCode());

    }

}
