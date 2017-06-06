package com.markandreydelacruz.ignbafeed;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * Created by mark on 6/3/2017.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private List<FeedModel> feedModelList;
    private Context context;

    public FeedAdapter(List<FeedModel> feedModelList, Context context) {
        this.feedModelList = feedModelList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_feed, parent, false); //false parameter is optional
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final FeedModel feedModel = feedModelList.get(position);

        ImageLoader.getInstance().displayImage(feedModel.getImages().getThumbnail().getUrl(), holder.imageViewInstagramFeed, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                holder.progressBarInstagramFeed.setVisibility(View.VISIBLE);
                holder.imageViewInstagramFeed.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                holder.progressBarInstagramFeed.setVisibility(View.GONE);
                holder.imageViewInstagramFeed.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                holder.progressBarInstagramFeed.setVisibility(View.GONE);
                holder.imageViewInstagramFeed.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                holder.progressBarInstagramFeed.setVisibility(View.GONE);
                holder.imageViewInstagramFeed.setVisibility(View.INVISIBLE);
            }
        });
        holder.textViewLikes.setText(feedModel.getLikes().getCount()+" likes");
        holder.textViewUsername.setText("@"+feedModel.getUser().getUsername());
        holder.textViewCaption.setText(feedModel.getCaption().getText());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "You clicked " + movieModel.getMovie(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(view.getContext(), FeedDetails.class);
                intent.putExtra("feedDetails", new Gson().toJson(feedModel)); // converting model json into string type and sending it via intent
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return feedModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewInstagramFeed;
        ProgressBar progressBarInstagramFeed;
        TextView textViewUsername;
        TextView textViewCaption;
        TextView textViewLikes;
        LinearLayout linearLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            imageViewInstagramFeed = (ImageView) itemView.findViewById(R.id.imageViewInstagramFeed);
            progressBarInstagramFeed = (ProgressBar) itemView.findViewById(R.id.progressBarInstagramFeed);
            textViewUsername = (TextView) itemView.findViewById(R.id.textViewUsername);
            textViewCaption = (TextView) itemView.findViewById(R.id.textViewCaption);
            textViewLikes = (TextView) itemView.findViewById(R.id.textViewLikes);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}
