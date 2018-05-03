package com.sexyhair.demoimitationmovie.bean;

/**
 * Created by sexyhair on 16/12/26.
 * 新闻类
 */

public class News {
    private Integer id;//id
    private String title;//标题
    private String content;//内容
    private Integer commentCount;//评论数
    private String reporter;//发布者
    private long publishTime;//发布时间,以毫秒为单位的
    private Integer pointCount;//点赞数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getPointCount() {
        return pointCount;
    }

    public void setPointCount(Integer pointCount) {
        this.pointCount = pointCount;
    }
}
