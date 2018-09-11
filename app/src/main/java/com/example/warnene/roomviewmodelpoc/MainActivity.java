package com.example.warnene.roomviewmodelpoc;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.warnene.roomviewmodelpoc.model.Repo;
import com.example.warnene.roomviewmodelpoc.model.ReposResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            InputStream inputStream = getAssets().open("OctocatReposList.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String jsonString = new String(buffer);
            Gson gson = new GsonBuilder().create();
            List<Repo> repos = Arrays.asList(new Gson().fromJson(jsonString, Repo[].class));

            Repo repo = repos.get(0);
            Log.d(TAG, "NJW->rep1-name" + repo.name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
