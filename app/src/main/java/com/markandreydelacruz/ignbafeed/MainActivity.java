package com.markandreydelacruz.ignbafeed;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.markandreydelacruz.ignbafeed.Adapters.FeedAdapter;
import com.markandreydelacruz.ignbafeed.Models.FeedModel;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    private static final String URL_INSTAGRAM_FEED = "http://api.instagram.com/nba/media";
//    private static final String URL_INSTAGRAM_FEED = "http://192.168.137.1/json/instagram_nba.json";
    private boolean doubleBackToExitPressedOnce = false;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<FeedModel> feedModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Display Icon on toolbar
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        }
        setTitle("NBA Instagram Feed");
        // Create default options which will be used for every
        //  displayImage(...) call if no options will be passed to this method
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .build();
        ImageLoader.getInstance().init(config); // Do it on Application start

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        E/RecyclerView: No adapter attached; skipping layout

        getInformation(URL_INSTAGRAM_FEED);
    }

    private void getInformation(String URL_MOVIE_FEED) {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(MainActivity.this, URL_MOVIE_FEED, new AsyncHttpResponseHandler() {

            ProgressDialog dialog;

            @Override
            public void onStart() {
                super.onStart();
                dialog = new ProgressDialog(MainActivity.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setMessage("Please wait...");
                dialog.setIndeterminate(false);
                dialog.setCancelable(false);
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(getApplicationContext(), "Canceled", Toast.LENGTH_LONG).show();
                    }
                });
                dialog.show();
                recyclerView.setAdapter(null);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, final byte[] responseBody) {
                if (this.dialog.isShowing()) {
                    this.dialog.dismiss();
                }

//                JsonParser jsonParser = new JsonParser();
//                JsonArray jsonArray = jsonParser.parse(new String(responseBody))
//                        .getAsJsonObject().getAsJsonArray("movies");
//                Log.d("jsonArray:", String.valueOf(jsonArray));

                try {
                    JSONObject jsonObject = new JSONObject(new String(responseBody));
                    JSONArray jsonArray = jsonObject.optJSONArray("items");
                    feedModelList = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject post = jsonArray.optJSONObject(i);

                        FeedModel feedModel = new Gson().fromJson(post.toString(), FeedModel.class);
//                        MovieModel movieModel = new MovieModel();
//                        movieModel.setMovie(post.optString("movie"));
//                        movieModel.setTagline(post.optString("tagline"));

                        feedModelList.add(feedModel);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                Toast.makeText(getApplicationContext(), new String(responseBody), Toast.LENGTH_LONG).show();
//                List<MovieModel> movieModels = Collections.singletonList(new Gson().fromJson(new String(responseBody), MovieModel.class));
                adapter = new FeedAdapter(feedModelList, null);
                recyclerView.setAdapter(adapter);

//                MovieModel movieModel = new Gson().fromJson(new String(responseBody), MovieModel.class);
//                List<MovieModel> test = Collections.singletonList(new Gson().fromJson(new String(responseBody), MovieModel.class));
//                movieModelList.add(movieModel);
//                Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_LONG).show();
//                adapter = new MovieAdapter(test, getApplicationContext());
//                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if (this.dialog.isShowing()) {
                    this.dialog.dismiss();
                }
                Toast.makeText(getApplicationContext(), "Connection failed. Try again.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                if (this.dialog.isShowing()) {
                    this.dialog.dismiss();
                }
            }
        });
    }

}
