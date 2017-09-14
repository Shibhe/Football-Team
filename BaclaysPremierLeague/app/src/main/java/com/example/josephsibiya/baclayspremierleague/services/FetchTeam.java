package com.example.josephsibiya.baclayspremierleague.services;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.josephsibiya.baclayspremierleague.adapters.TeamsAdapter;
import com.example.josephsibiya.baclayspremierleague.models.TeamsModel;

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
 * Created by josephsibiya on 2017/08/31.
 */

public class FetchTeam extends AsyncTask<Void, Void,Void> {

    private TeamsAdapter teamAdapter;
    private int URLID;
    private Context context;

    public FetchTeam(TeamsAdapter teamAdapter, int URLID, Context context) {
        this.teamAdapter = teamAdapter;
        this.URLID = URLID;
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;


        try {

            URL url = new URL("http://api.football-data.org/v1/competitions/" + URLID + "/teams");
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

            JSONArray teamsArray = (JSONArray) object.get("teams");

            for (int i = 0; i < teamsArray.length(); i++) {

                JSONObject jsonObject = (JSONObject) teamsArray.get(i);
                Object jsonSelf =  jsonObject.getJSONObject("_links").getJSONObject("self").get("href");
                //Object jsonPlayers = jsonObject.getJSONObject("_links").getJSONObject("players").get("href");
                //Object jsonFixture = jsonObject.getJSONObject("_links").getJSONObject("fixtures").get("href");

                String strSelf = jsonSelf.toString();
                //String players = jsonPlayers.toString();
                //String fixture = jsonFixture.toString();
                int teamID = Integer.parseInt(strSelf.substring(strSelf.lastIndexOf("/") + 1, strSelf.length()));


                //Teams
                String name;
                String code;
                String shortName;
                String squadMarketValue;
                String crestUrl;

                name = jsonObject.getString("name");
                code = jsonObject.getString("code");
                shortName = jsonObject.getString("shortName");
                squadMarketValue = jsonObject.getString("squadMarketValue");
                crestUrl = jsonObject.getString("crestUrl");

                TeamsModel teamModel = new TeamsModel();

                if (shortName.equals("null"))
                {
                    teamModel.setShortName("");
                }
                else
                {
                    teamModel.setShortName(shortName);
                }

                teamModel.setId(teamID);
                teamModel.setCrestUrl(crestUrl);
                teamModel.setSquadMarketValue(squadMarketValue);
                teamModel.setCode(code);
                teamModel.setName(name);

                teamAdapter.teamModels.add(teamModel);

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
        teamAdapter.notifyDataSetChanged();
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
