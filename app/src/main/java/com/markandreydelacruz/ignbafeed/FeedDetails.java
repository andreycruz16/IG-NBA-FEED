package com.markandreydelacruz.ignbafeed;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.markandreydelacruz.ignbafeed.Models.FeedModel;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class FeedDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeddetails);
        // Showing and Enabling clicks on the Home/Up button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        setTitle("Details");

        final ImageView imageViewProfilePicture = (ImageView) findViewById(R.id.imageViewProfilePicture);
        TextView textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        final ImageView imageViewInstagramFeed = (ImageView) findViewById(R.id.imageViewInstagramFeed);
        final ProgressBar progressBarInstagramFeed = (ProgressBar) findViewById(R.id.progressBarInstagramFeed);
        TextView textViewCaption = (TextView) findViewById(R.id.textViewCaption);
        TextView textViewLikes = (TextView) findViewById(R.id.textViewLikes);
        TextView textViewComments = (TextView) findViewById(R.id.textViewComments);
        TextView textViewCommentSection = (TextView) findViewById(R.id.textViewCommentsSection);

        Bundle bundle = getIntent().getExtras();
        String json = bundle.getString("feedDetails"); // getting the model from MainActivity send via extras
        FeedModel feedModel = new Gson().fromJson(json, FeedModel.class);

        ImageLoader.getInstance().displayImage(feedModel.getUser().getProfile_picture(), imageViewProfilePicture, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                imageViewProfilePicture.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                imageViewProfilePicture.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                imageViewProfilePicture.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                imageViewProfilePicture.setVisibility(View.VISIBLE);
            }
        });

        textViewUsername.setText("@" + feedModel.getUser().getUsername());

        ImageLoader.getInstance().displayImage(feedModel.getImages().getStandard_resolution().getUrl(), imageViewInstagramFeed, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                progressBarInstagramFeed.setVisibility(View.VISIBLE);
                imageViewInstagramFeed.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                progressBarInstagramFeed.setVisibility(View.GONE);
                imageViewInstagramFeed.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBarInstagramFeed.setVisibility(View.GONE);
                imageViewInstagramFeed.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                progressBarInstagramFeed.setVisibility(View.GONE);
                imageViewInstagramFeed.setVisibility(View.VISIBLE);
            }
        });

        textViewCaption.setText(feedModel.getCaption().getText());
        textViewLikes.setText("Likes " + String.valueOf(feedModel.getLikes().getCount()));
        textViewComments.setText("Comments " + String.valueOf(feedModel.getComments().getCount()));



        StringBuilder stringBuilder = new StringBuilder();
        for(FeedModel.CommentsBean.DataBeanX comments: feedModel.getComments().getData()){
            stringBuilder.append("-"+comments.getText()+"\n\n");
        }
        textViewCommentSection.setText(stringBuilder);


//        Toast.makeText(this, json, Toast.LENGTH_LONG).show();
//        List<FeedModel.CommentsBean> commentsList;
//        try {
//            JSONObject jsonObject = new JSONObject(new String(json));
//            JSONArray jsonArray = jsonObject.optJSONArray("data");
//            commentsList = new ArrayList<>();
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject post = jsonArray.optJSONObject(i);
//                FeedModel.CommentsBean commentsBean = new Gson().fromJson(post.toString(), FeedModel.CommentsBean.class);
////                        MovieModel movieModel = new MovieModel();
////                        movieModel.setMovie(post.optString("movie"));
////                        movieModel.setTagline(post.optString("tagline"));
//                commentsList.add((FeedModel.CommentsBean) commentsList);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
////        StringBuilder stringBuilder = new StringBuilder();
////        for(FeedModel.CommentsBean commentsBean: commentsList){
////            stringBuilder.append(castBean.getName()).append(", ");
////        }
////        holder.textViewCast.setText("Cast: " + stringBuilder);
//
//        textViewCommentSection.setText(commentsList.ge);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
