package com.example.josephsibiya.baclayspremierleague.services;

/**
 * Created by josephsibiya on 2017/08/31.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.josephsibiya.baclayspremierleague.adapters.CompetitionAdapter;
import com.example.josephsibiya.baclayspremierleague.models.CompetitionModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchCompetition extends AsyncTask<Void, Void, Void> {

    private CompetitionAdapter adapter;
    private Context context;

    public FetchCompetition(CompetitionAdapter adapter, Context context) {
        this.adapter = adapter;
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {


        HttpURLConnection urlConnection = null;
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL("http://api.football-data.org/v1/competitions");
             urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("X-Auth-Token", "1ef07188cb3a49c48ea1ce543a8b8212");
            urlConnection.connect();

            InputStream stream = urlConnection.getInputStream();
             bufferedReader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = null;


            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }

            while (buffer.length() == 0) {
                return null;
            }

            JSONArray array = new JSONArray(buffer.toString());

            for (int x = 0; x < array.length(); x++) {

                JSONObject compObj = (JSONObject) array.get(x);

                int id;
                String caption;
                String league;
                String year;
                String currentMatchDay;
                String numberOfMatchDays;
                String numberOfTeams;
                String numberOfGames;
                String lastUpdated;

                CompetitionModel competitionModel = new CompetitionModel();

                id = compObj.getInt("id");
                caption = compObj.getString("caption");
                league = compObj.getString("league");
                year = compObj.getString("year");
                currentMatchDay = compObj.getString("currentMatchday");
                numberOfMatchDays = compObj.getString("numberOfMatchdays");
                numberOfTeams = compObj.getString("numberOfTeams");
                numberOfGames = compObj.getString("numberOfGames");
                lastUpdated = compObj.getString("lastUpdated");

                competitionModel.setNumberOfGames(numberOfGames);
                competitionModel.setCaption(caption);
                competitionModel.setId(id);
                competitionModel.setNumberOfMatchDays(numberOfMatchDays);
                competitionModel.setCurrentMatchDay(currentMatchDay);
                competitionModel.setYear(year);
                competitionModel.setLeague(league);
                competitionModel.setNumberOfTeams(numberOfTeams);
                competitionModel.setLastUpdated(lastUpdated);


                adapter.competitionModels.add(competitionModel);

            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
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
