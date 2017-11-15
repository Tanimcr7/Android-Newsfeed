package com.example.tanim.finaltask;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.bumptech.glide.Glide;
//import com.squareup.picasso.Picasso;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Tanim on 11/12/2017.
 */

public class AlbumsAdapter  extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder>{
    private Context mContext;
    private List<Album> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow, like, comment, alert, miniAppIconImage;
        public TextView newsID, likeCount, commentCount, postType, miniAppName, postTime;
        public boolean isUrgentPost, isLiked, isCommented;
        public String miniappclr,miniappname,miniappiconimage;

        public LinearLayout linlayout1, linlayout2;


        //public String url;





        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.link);

            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

            //newsID
            likeCount = (TextView) view.findViewById(R.id.likecount);
            commentCount = (TextView) view.findViewById(R.id.commentcount);
            //postType

            // miniAppColor=view.findViewById(R.id.apptext);
            // miniAppColor.setTextColor(miniAppColor);
            postTime = (TextView) view.findViewById(R.id.count);


            like = (ImageView) view.findViewById(R.id.like);
            comment = (ImageView) view.findViewById(R.id.comment);
            alert = (ImageView) view.findViewById(R.id.alert);
            //     overflow = (ImageView) view.findViewById(R.id.appicon);


            linlayout1 = (LinearLayout) view.findViewById(R.id.linearLayout1);
            linlayout2 = (LinearLayout) view.findViewById(R.id.linearLayout2);
            miniAppName = (TextView) view.findViewById(R.id.apptext);
            miniAppIconImage = (ImageView) view.findViewById(R.id.appicon);

;

        }
    }


    public AlbumsAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.title.setText(album.getName());
     //   holder.count.setText(album.getLink());

        if(album.getLink().equals(""))
        {
            holder.count.setVisibility(View.GONE);
        }else
        {
            holder.count.setVisibility(View.VISIBLE);
            holder.count.setText(album.getLink());
        }
        holder.likeCount.setText(album.getLikecount());
        holder.commentCount.setText(album.getCommentcount());
      //   holder.miniAppName.setText(album.getMiniAppName());
      //  holder.miniappclr(album.getMiniAppColor());
        holder.postTime.setText(album.getPostTime());
        holder.isUrgentPost = album.getisUrgentPost();
       // holder.miniappclr = album.getMiniAppColor();
        //Log.v("COLOR input", holder.miniappclr);


/*

        holder.linlayout1.setBackgroundColor(Color.parseColor("album.getMiniAppColor()"));
        holder.linlayout2.setBackgroundColor(Color.parseColor("album.getMiniAppColor()"));

*/
        //if (album.getMiniAppColor().equals("a") )

        String sar = "null";

        if (album.getMiniAppColor().equals(sar) ) {
            holder.linlayout1.setVisibility(View.GONE);
            holder.linlayout2.setVisibility(View.GONE);
            holder.miniAppName.setVisibility(View.GONE);
            holder.miniAppIconImage.setVisibility(View.GONE);
        } else {
            holder.linlayout1.setVisibility(View.VISIBLE);
            holder.linlayout2.setVisibility(View.VISIBLE);

            holder.miniAppName.setVisibility(View.VISIBLE);
            holder.miniAppIconImage.setVisibility(View.VISIBLE);
            String sr=album.getMiniAppColor();
            holder.linlayout2.setBackgroundResource(R.drawable.corner_rad);
           // holder.linlayout2.setBackground(ContextCompat.getDrawable(mContext, R.drawable.corner_rad));

            //   holder.linlayout1.setBackgroundColor(sr);
            holder.linlayout2.setBackgroundResource(R.drawable.corner_rad);
            GradientDrawable drawable = (GradientDrawable) holder.linlayout2.getBackground();
            drawable.setColor(Color.parseColor(sr));


            holder.linlayout1.setBackgroundColor(Color.parseColor(sr));
          //  holder.linlayout2.setBackgroundColor(Color.parseColor(sr));

/*
            GradientDrawable shape = new GradientDrawable();
          //  shape.setShape(GradientDrawable.RECTANGLE);
            shape.setCornerRadii(new float[] { 8, 8, 8, 8, 0, 0, 0, 0 });
            //shape.setColor(backgroundColor);
           // shape.setStroke(3, borderColor);
            holder.linlayout2.setBackgroundDrawable(shape);*/
            holder.miniAppName.setText(album.getMiniAppName());
            holder.miniAppIconImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.appicon));



            // holder.linlayout2.setBackgroundColor(Color.parseColor(album.getMiniAppColor()));
            // holder.miniAppName.setText(album.getMiniAppName());
            // holder.miniAppIconImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_dots));


        }








        //  Log.v("URGENT",String.valueOf(holder.isUrgentPost));


        if(holder.isUrgentPost)
        {
         /*   holder.linlayout1.setVisibility(View.VISIBLE);
            holder.linlayout2.setVisibility(View.VISIBLE);
            holder.linlayout1.setBackgroundColor(Color.parseColor("#109265"));
            holder.linlayout2.setBackgroundColor(Color.parseColor("#109265"));*/
            holder.alert.setVisibility(View.VISIBLE);
            holder.alert.setImageDrawable(mContext.getResources().getDrawable(R.drawable.alert));

//            Picasso.with(mContext).load(R.drawable.ic_dots).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
//                    .into(holder.alert,new  com.squareup.picasso.Callback(){
//
//                        @Override
//                        public void onSuccess() {
//
//                        }
//
//                        @Override
//                        public void onError() {
//
//                        }
//                    });
        }else{
            holder.alert.setVisibility(View.GONE);

           /* holder.linlayout1.setVisibility(View.GONE);
            holder.linlayout2.setVisibility(View.GONE);*/
        }


/*

        if(album.getMiniAppColor() == null)
        {
            holder.linlayout1.setVisibility(View.GONE);
            holder.linlayout2.setVisibility(View.GONE);


//            Picasso.with(mContext).load(R.drawable.ic_dots).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
//                    .into(holder.alert,new  com.squareup.picasso.Callback(){
//
//                        @Override
//                        public void onSuccess() {
//
//                        }
//
//                        @Override
//                        public void onError() {
//
//                        }
//                    });
        }else{
            holder.linlayout1.setVisibility(View.VISIBLE);
            holder.linlayout2.setVisibility(View.VISIBLE);
            holder.linlayout1.setBackgroundColor(Color.parseColor("#109265"));
            holder.linlayout2.setBackgroundColor(Color.parseColor("#109265"));

        }
        //holder.like=album.getOverflow();

*/



        //holder.url=album.getThumbnail();
        Picasso.with(mContext).load(album.getThumbnail()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .into(holder.thumbnail,new  com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });



        // loading album cover using Glide library
        // Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
        Picasso.with(mContext).load(R.drawable.like).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .into(holder.like,new  com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });


        Picasso.with(mContext).load(R.drawable.comment).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .into(holder.comment,new  com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });




        // Glide.with(mContext).load(album.getOverflow()).into(holder.like);

        //  Glide.with(mContext).load(album.getOverflow()).into(holder.comment);
 /*       if(holder.isUrgentPost == true){
            Glide.with(mContext).load(album.getOverflow()).into(holder.alert);
        }*/


    }

    @Override
    public int getItemCount () {
        return albumList.size();
    }
}
