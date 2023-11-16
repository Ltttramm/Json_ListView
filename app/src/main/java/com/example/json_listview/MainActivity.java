package com.example.json_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Tui> mang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView) findViewById(R.id.listViewTui);
        mang = new ArrayList<Tui>();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new docJSON().execute("https://gist.githubusercontent.com/Ltttramm/86336a52a1e65b4d8ad520ac6ad1ab19/raw/8851f17559b7307422eddde63944b9ff241987d3/gistfile1.txt");
            }
        });
    }

    class docJSON extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {

            return docNoiDung_Tu_URL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONObject root = new JSONObject(s);
                JSONArray mangjson = root.getJSONArray("list");
                for(int i=0; i<mangjson.length(); i++){
                    JSONObject qg = mangjson.getJSONObject(i);
                    mang.add( new Tui(
                            qg.getString("ten"),
                            qg.getInt("gia"),
                            qg.getString("hinh")
                    ));
                }
//                Toast.makeText(getApplicationContext(), ""+ mang.size(), Toast.LENGTH_LONG).show();
////                Log.d("MainActivity", "onPostExecute: " + s);  // Thêm dòng này để kiểm tra giá trị của s
                ListAdapter adapter = new ListAdapter(
                        getApplicationContext(),
                        R.layout.activity_dong_tui,
                        mang
                );
                lv.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
//            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();

        }


        private String docNoiDung_Tu_URL(String theUrl) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(theUrl);
                URLConnection urlConnection = url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line + "\n");
                }
                bufferedReader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return content.toString();
        }
    }
}