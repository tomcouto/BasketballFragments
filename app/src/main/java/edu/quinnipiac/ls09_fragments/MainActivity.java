package edu.quinnipiac.ls09_fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final String LOG_TAG = MainActivity.class.getSimpleName();
    Button generate;
    String urlStr = "https://free-nba.p.rapidapi.com/players/";
    Handler handler = new Handler();
    int[] players = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generate = findViewById(R.id.generate);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FetchInfo().execute("");
            }
        });
    }

    public class FetchInfo extends AsyncTask<String,Void,ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(String... strings) {
            HttpURLConnection urlConnection =null;
            BufferedReader reader =null;
            String name = null;
            String position = null;
            String team = null;
            String division = null;
            String conference = null;
            ArrayList<String> allInfo = new ArrayList<String>();

            Random random = new Random();
            int rand = random.nextInt(30);

            try {
                URL url = new URL(urlStr + players[rand]);

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("X-RapidAPI-Key", "0a9270f7c4msh96b366785c6eadfp1c9548jsn8b5221c19819");

                urlConnection.connect();

                InputStream in = urlConnection.getInputStream();
                if (in == null) {
                    return null;
                }
                reader  = new BufferedReader(new InputStreamReader(in));

                // call getBufferString to get the string from the buffer.
                // add all the strings to the arraylist
                String JsonString = getBufferStringFromBuffer(reader).toString();
                allInfo.add(handler.getName(JsonString));
                allInfo.add(handler.getPosition(JsonString));
                allInfo.add(handler.getTeam(JsonString));
                allInfo.add(handler.getDivision(JsonString));
                allInfo.add(handler.getConference(JsonString));

            } catch(Exception e){
                Log.e(LOG_TAG,"Error" + e.getMessage());
                return null;
            }finally{
                if (urlConnection != null){
                    urlConnection.disconnect();
                }
                if (reader != null){
                    try{
                        reader.close();
                    }catch (IOException e){
                        Log.e(LOG_TAG,"Error" + e.getMessage());
                        return null;
                    }
                }
            }
            return allInfo;
        }


        protected void onPostExecute(ArrayList<String> allInf) {

            Bundle args = new Bundle();
            args.putString("name", allInf.get(0));
            args.putString("position", allInf.get(1));
            args.putString("team", allInf.get(2));
            args.putString("division",allInf.get(3));
            args.putString("conference",allInf.get(4));

            Fragment fr = new FragmentTwo();
            fr.setArguments(args);

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.fragment,fr);
            fragmentTransaction.commit();

        }

    }

    private StringBuffer getBufferStringFromBuffer(BufferedReader br) throws Exception{
        StringBuffer buffer = new StringBuffer();

        String line;
        while((line = br.readLine()) != null){
            buffer.append(line + '\n');
        }

        if (buffer.length() == 0)
            return null;

        return buffer;
    }
}
