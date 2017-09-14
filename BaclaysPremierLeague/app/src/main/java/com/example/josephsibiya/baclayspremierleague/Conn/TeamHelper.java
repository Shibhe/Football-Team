package com.example.josephsibiya.baclayspremierleague.Conn;

/**
 * Created by josephsibiya on 2017/09/11.
 */

/**public class TeamHelper {

    public String getJSONData(String stringURL) {

        HttpURLConnection urlConnection = null;
        BufferedReader bufferedReader = null;

        try {
            URL url = new URL(stringURL);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("X-Auth-Token", "1ef07188cb3a49c48ea1ce543a8b8212");
            urlConnection.connect();
            InputStream stream = urlConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(stream));

            String line = null;
            StringBuffer buffer = new StringBuffer();

            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }

            if (buffer.length() == 0) {
                return null;
            }



        } catch (IOException ignored) {

        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (final IOException e) {
                    Log.e("MainActivity", "Error closing stream", e);
                }
            }
        }
        //return buffer.toString();
    }
}**/
