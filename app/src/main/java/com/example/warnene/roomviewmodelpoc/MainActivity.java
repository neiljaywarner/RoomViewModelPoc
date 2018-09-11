package com.example.warnene.roomviewmodelpoc;

import android.drm.DrmStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.warnene.roomviewmodelpoc.model.Repo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
            List<Repo> repos = Arrays.asList(new Gson().fromJson(jsonString, Repo[].class));


            for (Repo repo : repos) {
                Log.d(TAG, "***NJW->repo-name" + repo.name);

                if (repo.license == null) {
                    Log.e(TAG, "***NJW->repo-license is null");
                } else {
                    Log.d(TAG, "***NJW->repo-license is " + repo.license.name);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
