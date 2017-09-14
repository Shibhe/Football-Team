package com.example.josephsibiya.baclayspremierleague.services;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.josephsibiya.baclayspremierleague.adapters.FixtureAdapter;
import com.example.josephsibiya.baclayspremierleague.models.FixtureModel;
import com.example.josephsibiya.baclayspremierleague.models.GameResults;

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
 * Created by josephsibiya on 2017/09/04.
 */

public class FetchFixture extends AsyncTask<Void, Void, Void> {

    private FixtureAdapter adapter;
    private int URLID;
    private Context context;
    private String type = "";
    private ProgressDialog pDialog;

    public FetchFixture(FixtureAdapter adapter, int URLID, Context context) {
        this.adapter = adapter;
        this.URLID = URLID;
        this.context = context;
        //this.type = type;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;
        int count = 0;

        /**String strUrl = null;

        if (type == "teamFixture")
        {
            strUrl = "http://api.football-data.org/v1/teams/" + URLID + "/fixtures";
        }
        else if (type == "allTeams"){

            strUrl = "http://api.football-data.org/v1/competitions/" + URLID + " /fixtures";
        }**/


        try {

            URL url = new URL("http://api.football-data.org/v1/competitions/" + URLID + "/fixtures");
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

            JSONObject object = new JSONObject(buffer.toString());

            JSONArray fixtures = (JSONArray) object.get("fixtures");

            for (int i = 0; i < object.length(); i++) {

                JSONObject jsonObject = (JSONObject) fixtures.get(i);

                JSONArray result = (JSONArray) object.get("result");

                //Date date = new Date();
                String status;
                String matchDay;
                String odds;
                String date;
                String goalsHomeTeam;
                String goalsAwayTeam;
                GameResults gameGoals = new GameResults();
                String homeTeamName;
                String awayTeamName;


                status = jsonObject.getString("status");
                date = jsonObject.getString("date");
                odds = jsonObject.getString("odds");
                homeTeamName = jsonObject.getString("homeTeamName");
                awayTeamName = jsonObject.getString("awayTeamName");
                matchDay = jsonObject.getString("matchDay");


                for (int x=0;x < result.length();x++)
                {
                    JSONObject results = (JSONObject) fixtures.get(i);

                    gameGoals.setGoalsHomeTeam(results.getString("goalsHomeTeam"));
                    gameGoals.setGoalsAwayTeam(results.getString("goalsAwayTeam"));
                }

                FixtureModel teamFixture = new FixtureModel();


                teamFixture.setStatus(status);
                teamFixture.setAwayTeamName(awayTeamName);
                teamFixture.setDate(date);
                teamFixture.setMatchDay(matchDay);
                teamFixture.setOdds(odds);
                teamFixture.setHomeTeamName(homeTeamName);


                adapter.fixtureModels.add(teamFixture);

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
    protected void onPreExecute() {

        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Please wait while loading...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.getProgress();
        pDialog.show();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
