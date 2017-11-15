package com.example.tanim.finaltask;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanvir Yasin on 11/15/2017.
 */

public class FragmaentView extends Fragment {

    public   RecyclerView recyclerView;
    public AlbumsAdapter adapter;
    public List<Album> albumList;
    Context ncontext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.newsfeed_fragment,container,false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        albumList = new ArrayList<>();
        //adapter = new AlbumsAdapter(this, albumList);
       // adapter = new AlbumsAdapter(this,albumList);
        prepareAlbums();
        adapter = new AlbumsAdapter(getActivity(),albumList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        return v;
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
            br = new BufferedReader(new InputStreamReader( getActivity().getAssets().open("TestJSON.json")));
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
