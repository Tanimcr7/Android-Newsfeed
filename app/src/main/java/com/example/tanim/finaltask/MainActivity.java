package com.example.tanim.finaltask;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
//import android.support.design.widget.AppBarLayout;
//import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.view.Menu;
import android.widget.ListView;


//import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      //  prepareAlbums();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(this, albumList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
       prepareAlbums();

    }

    private void prepareAlbums() {

       /* URL url = new URL("http://www.weatherinthehud.com/wordpress/wp-content/uploads/2015/11/rain.jpg");
        Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

        View view;
        ImageView thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        thumbnail.setImageBitmap(bmp);*/








    /*Parsing .json file
    */

        // Reading json file from assets folder
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader( getAssets().open("TestJSON.json")));
            String temp;
            while ((temp = br.readLine()) != null)
                sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close(); // stop reading
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        // Try to parse JSON
        try {
            // Creating JSONObject from String
            // Log.v("NEWS: ",sb.toString());
            JSONObject jsonObjMain = new JSONObject(sb.toString());

            // Creating JSONArray from JSONObject
            JSONArray jsonArray = jsonObjMain.getJSONArray("newsFeed");



            // JSONArray has four JSONObject
            for (int i = 0; i < jsonArray.length(); i++) {

                // Creating JSONObject from JSONArray
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                // Getting data from individual JSONObject

                String nid=jsonObj.getString("newsId");
                String nTitle = jsonObj.getString("newsTitle");
                String nUrl = jsonObj.getString("cardImageURL");
                String likecnt = jsonObj.getString("likeCount");
                String commentcnt =jsonObj.getString("commentCount");
                boolean isurgent = jsonObj.getBoolean("isUrgentPost");
                String posttype = jsonObj.getString("postType");
                String miniappname = jsonObj.getString("miniAppName");
                String miniappimage = jsonObj.getString("miniAppIconImage");
                String miniappcolor = jsonObj.getString("miniAppColor");
                //    Log.v("COLOR input", miniappcolor);
                String nlink = jsonObj.getString("newsFeedLinkText");
                boolean isliked = jsonObj.getBoolean("isLiked");
                boolean isCommented = jsonObj.getBoolean("isCommented");
                String posttime = jsonObj.getString("postTime");


          /*      String sr="null";

                if(miniappname.equals(sr) ){
                    miniappname="b";
                    miniappcolor="b";
                    miniappimage="b";

                }else
                {



                }
                Log.v("COLOR", miniappname);*/
                //boolean isurgent = jsonObj.getBoolean("isUrgentPost");

                Album a = new Album(nid,nTitle,nUrl,likecnt,commentcnt,isurgent,posttype,miniappname,miniappimage,miniappcolor,nlink,isliked,isCommented,posttime);

                //   Album a = new Album(nTitle, nlink, nUrl, like[0]);
                albumList.add(a);


            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String myjsonstring = sb.toString();


    }

}
