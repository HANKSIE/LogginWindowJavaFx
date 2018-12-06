package sample;

import java.sql.*;

public class DBconnection {

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://210.70.80.21:3306/s106021014?useUnicode=true&characterEncoding=utf8&autoReconnect=true";
    private Connection dbconn;

    public DBconnection(String id, String pw){
        try{
            Class.forName(driver);
            dbconn = DriverManager.getConnection(url, id,pw);
            System.out.println("資料庫連線成功!");
        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ResultSet getData(){
        ResultSet rs = null;
        try {
            Statement stm = dbconn.createStatement();
            String sqlStr = "SELECT * FROM `user` WHERE 1";
            rs = stm.executeQuery(sqlStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}
