package DAO;
import VO.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    //连接数据库
    private Connection getConnection() throws Exception{
        String dburl="jdbc:mysql://127.0.0.1:3306/javaee";
        String username="root";
        String password="82486842";
        Connection conn=null;
        try{
            conn=DriverManager.getConnection(dburl,username,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    //添加用户方法
    public void addUser(User user) throws Exception {
        String sql="insert into users(account,password,username) values(?,?,?)";
        try(Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1, user.getAccount());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getUsername());
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //获得用户信息
    public User getUser(String account) throws Exception {
        ResultSet resultSet=null;
        User user=null;
        String sql="select * from users where account=?";
        try(Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,account);
            resultSet=pstmt.executeQuery();
            if(resultSet.next()){
                user=new User();
                user.setAccount(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setUsername(resultSet.getString(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    //获取全部用户信息
    public ArrayList<User> getAllUser() throws Exception {
        String sql="select * from users";
        ResultSet resultSet=null;
        ArrayList<User> users=new ArrayList<User>();
        try(Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            resultSet=pstmt.executeQuery();
            while (resultSet.next()){
                User user=new User();
                user.setAccount(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setUsername(resultSet.getString(4));
                users.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }
}
