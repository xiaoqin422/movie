package com.zbsx.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 包名: com.zbsx.test
 * 类名: Test
 * 创建用户: Administrator
 * 创建日期: 2021年07月13日 13:57
 * 项目名: movie
 **/
public class Test {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(new Date());
        System.out.println(now);
//        Manager manager = new Manager("123456","123","123","123","售票人员",1,"123");
//        System.out.println(MovieFactory.getManagerDaoInstance().add(manager));
//        manager.setPassword("手机号");
//        System.out.println(MovieFactory.getManagerDaoInstance().update(manager));
//        System.out.println(MovieFactory.getManagerDaoInstance().findById("123456").toString());
//        System.out.println( MovieFactory.getManagerDaoInstance().delete("123456"));
//        System.out.println(MovieFactory.getManagerDaoInstance().findManager("admin","").toString());
//        Movie movie = new Movie(555,"中文名","又名","演员","导演","电影简介","电影时长","电影类型",9,5,5,"2021-07-16 15:50:50","海报图","制片商",1);
//        System.out.println(MovieFactory.getMovieInstance().add(movie));
//        List<Movie> movies = MovieFactory.getMovieInstance().findAll();
//        System.out.println(movies.toString());
//        System.out.println(MovieFactory.getMovieInstance().findById(movie.getMovie_id()).toString());
//        movie.setMovie_cn_name("名称修改");
//        System.out.println(MovieFactory.getMovieInstance().update(movie));
//        System.out.println(MovieFactory.getMovieInstance().updateState(movie.getMovie_id(),0));
//        User user = new User(156,"用户"+Math.random(),"123456","15735111403","2578908933@qq.com",1,"用户头像",1);
//        System.out.println(MovieFactory.getUserInstance().findUser("user",1).toString());
//        System.out.println(MovieFactory.getUserInstance().add(user));
//        System.out.println(MovieFactory.getUserInstance().login(user.getUser_name(),user.getUser_pwd()));
//        System.out.println(MovieFactory.getUserInstance().findAll().toString());
//        user.setUser_email("测试修改-----------");
//        System.out.println(MovieFactory.getUserInstance().update(user));
//        System.out.println(MovieFactory.getUserInstance().updateRole(user.getUser_name(),0));
//        System.out.println(MovieFactory.getUserInstance().updateState(user.getUser_name(),0));
//        System.out.println(MovieFactory.getUserInstance().findByName(user.getUser_name()).toString());
//        System.out.println(MovieFactory.getUserInstance().delete(user.getUser_name()));
//        Cinema cinema = new Cinema(4,"山西剧院","山西省太原市迎泽区");
//        System.out.println(MovieFactory.getCinemaInstance().add(cinema));
//        cinema.setCinema_name("影院测试修改");
//        System.out.println(MovieFactory.getCinemaInstance().update(cinema));
//        System.out.println(MovieFactory.getCinemaInstance().findById(4).toString());
//        System.out.println(MovieFactory.getCinemaInstance().delete(4));
//        System.out.println(MovieFactory.getCinemaInstance().findCinema(cinema.getCinema_name()).toString());
//        System.out.println(MovieFactory.getCinemaInstance().findAll().toString());
//        System.out.println("------------------------------------------------");
//        Hall hall = new Hall(4,"测试影厅",3,2);
//        System.out.println(MovieFactory.getHallInstance().add(hall));
//        System.out.println(MovieFactory.getHallInstance().findAll().toString());
//        hall.setHall_name("修改测试");
//        System.out.println(MovieFactory.getHallInstance().update(hall));
//        System.out.println(MovieFactory.getHallInstance().findById(2));
//        System.out.println(MovieFactory.getHallInstance().delete(2));
//        System.out.println(MovieFactory.getHallInstance().findHall("一号厅",50,150));
    }
}