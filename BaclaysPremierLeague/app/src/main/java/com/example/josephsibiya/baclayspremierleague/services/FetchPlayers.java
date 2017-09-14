package com.example.josephsibiya.baclayspremierleague.services;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.josephsibiya.baclayspremierleague.adapters.PlayersAdapter;
import com.example.josephsibiya.baclayspremierleague.models.PlayersModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by josephsibiya on 2017/09/12.
 */

public class FetchPlayers extends AsyncTask<Void, Void, Void> {
    private PlayersAdapter adapter;
    private int URLID;
    private Context context;

    public FetchPlayers(PlayersAdapter adapter, int URLID, Context context) {
        this.adapter = adapter;
        this.URLID = URLID;
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;
        //int count = 0;

        try {

            URL url = new URL("http://api.football-data.org/v1/teams/" + URLID + "/players");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Auth-Token", "1ef07188cb3a49c48ea1ce543a8b8212");
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = null;
            StringBuffer buffer = new StringBuffer();

            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }

            if (buffer.length() == 0) {
                return null;
            }

            JSONObject playersObj = new JSONObject(buffer.toString());

            JSONArray player = (JSONArray) playersObj.get("players");

            for (int i = 0; i < playersObj.length(); i++) {

                JSONObject jsonObject = (JSONObject) player.get(i);

                PlayersModel playersModel = new PlayersModel();

                 String name;
                 String position;
                 String jerseyNumber;
                 String dateOfBirth;
                 String nationality;
                 String contractUntil;
                 String marketValue;


                name = jsonObject.getString("name");
                position = jsonObject.getString("position");
                jerseyNumber = jsonObject.getString("jerseyNumber");
                dateOfBirth = jsonObject.getString("dateOfBirth");
                nationality = jsonObject.getString("nationality");
                contractUntil = jsonObject.getString("contractUntil");
                marketValue = jsonObject.getString("marketValue");

                playersModel.setName(name);
                playersModel.setContractUntil(contractUntil);
                playersModel.setPosition(position);
                playersModel.setJerseyNumber(jerseyNumber);
                playersModel.setDateOfBirth(dateOfBirth);
                playersModel.setNationality(nationality);
                playersModel.setMarketValue(marketValue);


                adapter.playersModelArrayList.add(playersModel);

            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (final IOException e) {
                    Log.e("MainActivity", "Error closing stream", e);
                }
            }

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        adapter.notifyDataSetChanged();
    }
    @Override
    protected void onPreExecute() {
        ProgressDialog pDialog = new ProgressDialog(context);
        pDialog.setMessage("Please wait while loading...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }
}
