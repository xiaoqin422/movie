package com.zbsx.bean;

/**
 * 包名: com.zbsx.bean
 * 类名: Movie
 * 创建用户: Administrator
 * 创建日期: 2021年07月16日 14:39
 * 项目名: movie
 **/
public class Movie {
//    `movie_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
//            `movie_cn_name` varchar(255) DEFAULT NULL COMMENT '电影名',
//            `movie_fg_name` varchar(255) DEFAULT NULL COMMENT '电影外名',
//            `movie_actor` varchar(255) DEFAULT NULL COMMENT '饰演人员',
//            `movie_director` varchar(255) DEFAULT NULL COMMENT '导演',
//            `movie_detail` text COMMENT '电影简介',
//            `movie_duration` varchar(255) DEFAULT NULL COMMENT '电影时长',
//            `movie_type` varchar(255) DEFAULT NULL COMMENT '电影类型',
//            `movie_score` float(10,1) DEFAULT NULL COMMENT '评分',
//            `movie_boxOffice` float(10,2) DEFAULT NULL COMMENT '票房',
//            `movie_commentCount` bigint(20) DEFAULT '0' COMMENT '评论条数',
//            `movie_releaseDate` datetime DEFAULT NULL COMMENT '上映时间',
//            `movie_picture` varchar(255) DEFAULT NULL COMMENT '海报图',
//            `movie_country` varchar(255) DEFAULT NULL COMMENT '制片商',
//            `movie_state` int(11) DEFAULT NULL COMMENT '电影状态 1 上映 0下架',
    private int movie_id;
    private String movie_cn_name;
    private String movie_fg_name;
    private String movie_actor;
    private String movie_director;
    private String movie_detail;
    private String movie_duration;
    private String movie_type;
    private float movie_score;
    private float movie_boxOffice;
    private int movie_commentCount;
    private String movie_releaseDate;
    private String movie_picture;
    private String movie_country;
    private int movie_state;

    /**
     * 方法名称：Movie <br/>
     * 功能描述: 电影的无参构造函数 <br/>
     * 方法参数：[] <br/>
     * 结果返回： <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/16 14:43 <br/>
     */
    public Movie() {
    }

    /**
     * 方法名称：Movie <br/>
     * 功能描述: 电影的有参构造函数 <br/>
     * 方法参数：[movie_id, movie_cn_name, movie_fg_name, movie_actor, movie_director, movie_detail, movie_duration, movie_type, movie_score, movie_boxOffice, movie_commentCount, movie_releaseDate, movie_picture, movie_country, movie_state] <br/>
     * 结果返回： <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/16 14:48 <br/>
     */
    public Movie(int movie_id, String movie_cn_name, String movie_fg_name, String movie_actor, String movie_director, String movie_detail, String movie_duration, String movie_type, float movie_score, float movie_boxOffice, int movie_commentCount, String movie_releaseDate, String movie_picture, String movie_country, int movie_state) {
        this.movie_id = movie_id;
        this.movie_cn_name = movie_cn_name;
        this.movie_fg_name = movie_fg_name;
        this.movie_actor = movie_actor;
        this.movie_director = movie_director;
        this.movie_detail = movie_detail;
        this.movie_duration = movie_duration;
        this.movie_type = movie_type;
        this.movie_score = movie_score;
        this.movie_boxOffice = movie_boxOffice;
        this.movie_commentCount = movie_commentCount;
        this.movie_releaseDate = movie_releaseDate;
        this.movie_picture = movie_picture;
        this.movie_country = movie_country;
        this.movie_state = movie_state;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", movie_cn_name='" + movie_cn_name + '\'' +
                ", movie_fg_name='" + movie_fg_name + '\'' +
                ", movie_actor='" + movie_actor + '\'' +
                ", movie_director='" + movie_director + '\'' +
                ", movie_detail='" + movie_detail + '\'' +
                ", movie_duration='" + movie_duration + '\'' +
                ", movie_type='" + movie_type + '\'' +
                ", movie_score=" + movie_score +
                ", movie_boxOffice=" + movie_boxOffice +
                ", movie_commentCount=" + movie_commentCount +
                ", movie_releaseDate='" + movie_releaseDate + '\'' +
                ", movie_picture='" + movie_picture + '\'' +
                ", movie_country='" + movie_country + '\'' +
                ", movie_state=" + movie_state +
                '}';
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_cn_name() {
        return movie_cn_name;
    }

    public void setMovie_cn_name(String movie_cn_name) {
        this.movie_cn_name = movie_cn_name;
    }

    public String getMovie_fg_name() {
        return movie_fg_name;
    }

    public void setMovie_fg_name(String movie_fg_name) {
        this.movie_fg_name = movie_fg_name;
    }

    public String getMovie_actor() {
        return movie_actor;
    }

    public void setMovie_actor(String movie_actor) {
        this.movie_actor = movie_actor;
    }

    public String getMovie_director() {
        return movie_director;
    }

    public void setMovie_director(String movie_director) {
        this.movie_director = movie_director;
    }

    public String getMovie_detail() {
        return movie_detail;
    }

    public void setMovie_detail(String movie_detail) {
        this.movie_detail = movie_detail;
    }

    public String getMovie_duration() {
        return movie_duration;
    }

    public void setMovie_duration(String movie_duration) {
        this.movie_duration = movie_duration;
    }

    public String getMovie_type() {
        return movie_type;
    }

    public void setMovie_type(String movie_type) {
        this.movie_type = movie_type;
    }

    public float getMovie_score() {
        return movie_score;
    }

    public void setMovie_score(float movie_score) {
        this.movie_score = movie_score;
    }

    public float getMovie_boxOffice() {
        return movie_boxOffice;
    }

    public void setMovie_boxOffice(float movie_boxOffice) {
        this.movie_boxOffice = movie_boxOffice;
    }

    public int getMovie_commentCount() {
        return movie_commentCount;
    }

    public void setMovie_commentCount(int movie_commentCount) {
        this.movie_commentCount = movie_commentCount;
    }

    public String getMovie_releaseDate() {
        return movie_releaseDate;
    }

    public void setMovie_releaseDate(String movie_releaseDate) {
        this.movie_releaseDate = movie_releaseDate;
    }

    public String getMovie_picture() {
        return movie_picture;
    }

    public void setMovie_picture(String movie_picture) {
        this.movie_picture = movie_picture;
    }

    public String getMovie_country() {
        return movie_country;
    }

    public void setMovie_country(String movie_country) {
        this.movie_country = movie_country;
    }

    public int getMovie_state() {
        return movie_state;
    }

    public void setMovie_state(int movie_state) {
        this.movie_state = movie_state;
    }
}