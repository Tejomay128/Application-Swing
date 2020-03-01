import java.sql.*;
public class DBUtil {
    private static Connection conn;
    public static synchronized Connection getConn(){
//        if(conn == null){
            try{
                String url = "jdbc:mysql://localhost:3306/project";
                String usrname = "root";
                String passwd = "Gurudev@ 2000";
                conn = DriverManager.getConnection(url, usrname, passwd);
            }catch(SQLException e){
//                throw new DBException(e);
                System.out.println("Cant connect!!!!!");
            }
//        } 
        return conn;
    }
    
    public static synchronized void closeConn(){
        if(conn!=null){
            try{
                
                conn.close();
            }catch(SQLException e){
                System.out.println("Close error!!");
            }finally{
                conn = null;
            }
        }
    }
}    
