package com.example.tanim.finaltask;

/**
 * Created by Tanim on 11/12/2017.
 */

public class Album {


    private  String id;
    private String name;
    private String thumbnail;
    private String likeCount;
    private String commentCount;
    private boolean isUrgentPost;
    private String postType;
    private String miniAppName;
    private String miniAppIconImage;
    private String miniAppColor;
    private String link;
    private boolean isLiked;
    private boolean isCommented;
    private String postTime;

    private int overflow;








    public Album() {
    }

    public Album(String id, String name, String thumbnail , String likeCount, String commentCount, boolean isUrgentPost, String postType, String miniAppName, String miniAppIconImage,String miniAppColor, String link, boolean isLiked, boolean isCommented,String postTime) {
        this.id= id;
        this.name = name;
        this.link = link;
        this.thumbnail = thumbnail;
        this.overflow = overflow;
        this.likeCount=likeCount;
        this.commentCount=commentCount;
        this.isUrgentPost=isUrgentPost;
        this.postType=postType;
        this.miniAppName=miniAppName;
        this.miniAppColor=miniAppColor;
        this.miniAppIconImage=miniAppIconImage;
        this.isLiked=isLiked;
        this.isCommented=isCommented;
        this.postTime=postTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }

    public void setOverflow(int overflow) {
        this.overflow = overflow;
    }

    public int getOverflow() { return overflow; }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLikecount() {
        return likeCount;
    }

    public void setLikecount(String likeCount) {
        this.likeCount = likeCount;
    }

    public String getCommentcount() {
        return commentCount;
    }

    public void setCommentcount(String commentCount) {
        this.commentCount = commentCount;
    }

    public boolean getisUrgentPost() {
        return isUrgentPost;
    }

    public void setisUrgentPost(boolean isurgentPost) {
        isUrgentPost = isurgentPost;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getMiniAppName() {
        return miniAppName;
    }

    public void setMiniAppName(String miniAppName) {
        this.miniAppName = miniAppName;
    }

    public String getMiniAppIconImage() {
        return miniAppIconImage;
    }

    public void setMiniAppIconImage(String miniAppIconImage) {
        this.miniAppIconImage = miniAppIconImage;
    }

    public String getMiniAppColor() {
        return miniAppColor;
    }

    public void setMiniAppColor(String miniAppColor) {
        this.miniAppColor = miniAppColor;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }
}
