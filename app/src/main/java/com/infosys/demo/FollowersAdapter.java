package com.infosys.demo;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.infosys.modelview.DataList;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FollowersAdapter extends RecyclerView.Adapter<FollowersAdapter.MyViewHolder> {

    private ArrayList<DataList> followersResponse;
    private Context context;

    public FollowersAdapter(Context context, ArrayList<DataList> followersResponse) {
        this.followersResponse = followersResponse;
        this.context = context;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.following_item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final DataList followerResponse = followersResponse.get(position);



        // holder.date.setText(transactionResponse.getTransDate());
        holder.txt_userid.setText(followerResponse.getTitle());
        holder. txt_usernmae.setText(followerResponse.getDescription());

     /*   Glide.with(context).load(followerResponse.getImageHref())
                .thumbnail(0.5f)
                .into(holder.circleImageView);*/

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher);
        Glide.with(context).load(followerResponse.getImageHref()).apply(options).into(holder.circleImageView);



    }

    @Override
    public int getItemCount() {
        return followersResponse.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CustomTextView txt_usernmae;
        CustomTextView txt_userid;
        ImageView circleImageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            txt_userid = itemView.findViewById(R.id.txt_userid);

            txt_usernmae=itemView.findViewById(R.id.txt_usernmae);
            circleImageView=itemView.findViewById(R.id.user_image);


        }
    }
}
