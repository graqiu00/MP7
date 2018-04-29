package com.example.graceqiu.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Request extends AsyncTask<String, Integer, String> {
        public String def;
        Context context;
        TextView textView;

        Request(Context context, TextView textView) {
            this.context = context;
            this.textView = textView;
        }

        @Override
        protected String doInBackground(String... params) {

            final String app_id = "20b3d407";
            final String app_key = "ec1ea0cddfe2f9e89819498b025ae262";

            try {
                URL url = new URL(params[0]);
                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                urlConnection.setRequestProperty("Accept","application/json");
                urlConnection.setRequestProperty("app_id",app_id);
                urlConnection.setRequestProperty("app_key",app_key);

                // read the output from the server
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }

                return stringBuilder.toString();

            }
            catch (Exception e) {
                e.printStackTrace();
                return e.toString();
            }
        }

        @Override
        protected void onPostExecute(String result) {

            super.onPostExecute(result);

            try {
                JSONObject obj = new JSONObject(result);
                JSONArray resultsArray = obj.getJSONArray("results");
                JSONObject lexicalEntries = resultsArray.getJSONObject(0);
                JSONArray lexArray = lexicalEntries.getJSONArray("lexicalEntries");
                JSONObject entries = lexArray.getJSONObject(0);
                JSONArray entriesArray = entries.getJSONArray("entries");
                JSONObject senses = entriesArray.getJSONObject(0);
                JSONArray sensesArray = senses.getJSONArray("senses");
                JSONObject definition = sensesArray.getJSONObject(0);
                JSONArray definitionArray = definition.getJSONArray("definitions");

                def = definitionArray.getString(0);
                textView.setText(def);



            } catch(JSONException e) {
                e.printStackTrace();
            }
        }
}
