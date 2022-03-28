package com.zbsx.dao.impl;

import com.zbsx.bean.Movie;
import com.zbsx.dao.MovieDao;
import com.zbsx.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 包名: com.zbsx.dao.impl
 * 类名: MovieDaoImpl
 * 创建用户: Administrator
 * 创建日期: 2021年07月16日 14:52
 * 项目名: movie
 **/
public class MovieDaoImpl implements MovieDao {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private boolean flag;

    /**
     * 方法名称：findAll <br/>
     * 功能描述: 遍历电影列表 <br/>
     * 方法参数：[] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.Movie> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/16 14:46 <br/>
     */
    @Override
    public List<Movie> findAll() {
        con = DBUtil.getConnection();
        List<Movie> list = new ArrayList<>();
        try{
            if(con != null){
                pstm = con.prepareStatement("select * from movie");
                rs = pstm.executeQuery();
                while(rs.next()){
                    Movie movie = new Movie(
                            rs.getInt("movie_id"),rs.getString("movie_cn_name"),
                            rs.getString("movie_fg_name"),rs.getString("movie_actor"),
                            rs.getString("movie_director"),rs.getString("movie_detail"),
                            rs.getString("movie_duration"),rs.getString("movie_type"),
                            rs.getFloat("movie_score"),rs.getFloat("movie_boxOffice"),
                            rs.getInt("movie_commentCount"),rs.getString("movie_releaseDate"),
                            rs.getString("movie_picture"),rs.getString("movie_country"),
                            rs.getInt("movie_state")
                    );
                    list.add(movie);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm,rs);
        }
        return list;
    }

    /**
     * 方法名称：add <br/>
     * 功能描述: 电影信息添加 <br/>
     * 方法参数：[movie] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/16 14:46 <br/>
     *
     * @param movie
     */
    @Override
    public boolean add(Movie movie) {
        con = DBUtil.getConnection();
        try{
            if(con != null){
                pstm = con.prepareStatement("INSERT INTO movie (movie_cn_name, movie_fg_name, movie_actor, movie_director, movie_detail, movie_duration, movie_type, movie_score, movie_boxOffice, movie_commentCount, movie_releaseDate, movie_picture, movie_country, movie_state) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                pstm.setString(1,movie.getMovie_cn_name());
                pstm.setString(2,movie.getMovie_fg_name());;
                pstm.setString(3,movie.getMovie_actor());
                pstm.setString(4,movie.getMovie_director());
                pstm.setString(5, movie.getMovie_detail());
                pstm.setString(6,movie.getMovie_duration());
                pstm.setString(7,movie.getMovie_type());;
                pstm.setFloat(8,movie.getMovie_score());
                pstm.setFloat(9,movie.getMovie_boxOffice());
                pstm.setInt(10,movie.getMovie_commentCount());
                pstm.setString(11,movie.getMovie_releaseDate());
                pstm.setString(12,movie.getMovie_picture());
                pstm.setString(13,movie.getMovie_country());
                pstm.setInt(14,movie.getMovie_state());
                int rs = pstm.executeUpdate();
                if(rs > 0){
                    flag = true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm);
        }
        return flag;
    }

    /**
     * 方法名称：findByName <br/>
     * 功能描述: 通过name查找电影 <br/>
     * 方法参数：[movie_name] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/16 14:47 <br/>
     *
     * @param movie_name
     */
    @Override
    public boolean findByName(String movie_name) {
        con = DBUtil.getConnection();
        Movie movie = null;
        try{
            if(con != null){
                pstm = con.prepareStatement("select * from movie where movie_cn_name = ?");
                pstm.setString(1,movie_name);
                rs = pstm.executeQuery();
                if(rs.next()){
                    flag = true;
                }
//                while(rs.next()){
//                    movie = new Movie(
//                            rs.getInt("movie_id"),rs.getString("movie_cn_name"),
//                            rs.getString("movie_fg_name"),rs.getString("movie_actor"),
//                            rs.getString("movie_director"),rs.getString("movie_detail"),
//                            rs.getString("movie_duration"),rs.getString("movie_type"),
//                            rs.getFloat("movie_score"),rs.getFloat("movie_boxOffice"),
//                            rs.getInt("movie_commentCount"),rs.getString("movie_releaseDate"),
//                            rs.getString("movie_picture"),rs.getString("movie_country"),
//                            rs.getInt("movie_state")
//                    );
//                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm,rs);
        }
        return flag;
    }

    /**
     * 方法名称：update <br/>
     * 功能描述: 电影信息修改 <br/>
     * 方法参数：[movie] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/16 14:47 <br/>
     *
     * @param movie
     */
    @Override
    public boolean update(Movie movie) {
        con = DBUtil.getConnection();
        try{
            if(con != null){
                pstm = con.prepareStatement("UPDATE movie set movie_cn_name = ? , movie_fg_name = ?, movie_actor = ?, movie_director = ?, movie_detail = ?, movie_duration = ?, movie_type = ?, movie_score = ?, movie_boxOffice = ?, movie_commentCount = ?, movie_releaseDate = ?, movie_picture = ?, movie_country = ?, movie_state = ? where movie_id = ?");
                pstm.setString(1,movie.getMovie_cn_name());
                pstm.setString(2,movie.getMovie_fg_name());;
                pstm.setString(3,movie.getMovie_actor());
                pstm.setString(4,movie.getMovie_director());
                pstm.setString(5, movie.getMovie_detail());
                pstm.setString(6,movie.getMovie_duration());
                pstm.setString(7,movie.getMovie_type());;
                pstm.setFloat(8,movie.getMovie_score());
                pstm.setFloat(9,movie.getMovie_boxOffice());
                pstm.setInt(10,movie.getMovie_commentCount());
                pstm.setString(11,movie.getMovie_releaseDate());
                pstm.setString(12,movie.getMovie_picture());
                pstm.setString(13,movie.getMovie_country());
                pstm.setInt(14,movie.getMovie_state());
                pstm.setInt(15,movie.getMovie_id());
                int rs = pstm.executeUpdate();
                if(rs > 0){
                    flag = true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm);
        }
        return flag;
    }

    /**
     * 方法名称： updateState<br/>
     * 功能描述: 电影上架/下架 <br/>
     * 方法参数：[movie_id, movie_state] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/16 23:27 <br/>
     *
     * @param movie_id
     * @param movie_state
     */
    @Override
    public boolean updateState(int movie_id, int movie_state) {
        con = DBUtil.getConnection();
        try{
            if(con != null){
                pstm = con.prepareStatement("UPDATE movie set  movie_state = ? where movie_id = ?");
                pstm.setInt(1,movie_state);
                pstm.setInt(2,movie_id);
                int rs = pstm.executeUpdate();
                if(rs > 0){
                    flag = true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm);
        }
        return flag;
    }

    /**
     * 方法名称：findNoBan <br/>
     * 功能描述: 根据状态查找电影 <br/>
     * 方法参数：[state] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.Movie> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/21 20:17 <br/>
     *
     * @param state
     */
    @Override
    public List<Movie> findNoBan(int state) {
        con = DBUtil.getConnection();
        List<Movie> list = new ArrayList<>();
        try{
            if(con != null){
                pstm = con.prepareStatement("select * from movie where movie_state = ?");
                pstm.setInt(1,state);
                rs = pstm.executeQuery();
                while(rs.next()){
                    Movie movie = new Movie(
                            rs.getInt("movie_id"),rs.getString("movie_cn_name"),
                            rs.getString("movie_fg_name"),rs.getString("movie_actor"),
                            rs.getString("movie_director"),rs.getString("movie_detail"),
                            rs.getString("movie_duration"),rs.getString("movie_type"),
                            rs.getFloat("movie_score"),rs.getFloat("movie_boxOffice"),
                            rs.getInt("movie_commentCount"),rs.getString("movie_releaseDate"),
                            rs.getString("movie_picture"),rs.getString("movie_country"),
                            rs.getInt("movie_state")
                    );
                    list.add(movie);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm,rs);
        }
        return list;
    }

    /**
     * 方法名称：findById <br/>
     * 功能描述: 通过id查找相关电影 <br/>
     * 方法参数：[movie_id] <br/>
     * 结果返回：com.zbsx.bean.Movie <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/23 23:59 <br/>
     *
     * @param movie_id
     */
    @Override
    public Movie findById(int movie_id) {
        con = DBUtil.getConnection();
        Movie movie = null;
        try{
            if(con != null){
                pstm = con.prepareStatement("select * from movie where movie_id = ?");
                pstm.setInt(1,movie_id);
                rs = pstm.executeQuery();
                while(rs.next()){
                    movie = new Movie(
                            rs.getInt("movie_id"),rs.getString("movie_cn_name"),
                            rs.getString("movie_fg_name"),rs.getString("movie_actor"),
                            rs.getString("movie_director"),rs.getString("movie_detail"),
                            rs.getString("movie_duration"),rs.getString("movie_type"),
                            rs.getFloat("movie_score"),rs.getFloat("movie_boxOffice"),
                            rs.getInt("movie_commentCount"),rs.getString("movie_releaseDate"),
                            rs.getString("movie_picture"),rs.getString("movie_country"),
                            rs.getInt("movie_state")
                    );
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm,rs);
        }
        return movie;
    }


}