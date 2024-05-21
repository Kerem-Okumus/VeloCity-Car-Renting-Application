import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    final static String url="jdbc:mysql://localhost:3306/velocity";
    final static String user = "localhost";
    final static String password= "Jd5.rS<7,hZ!2";


    public static Connection getConnection(){
        Connection myConn=null;

        try{
            myConn = DriverManager.getConnection(url,user,password);
        }catch (Exception e) {

        }
        return myConn;
    }

}
