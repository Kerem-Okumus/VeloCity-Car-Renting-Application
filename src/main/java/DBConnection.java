import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    //pulladığınızda sadece nameofthedatabase ve password kısmını kendinizinki yapın.pushlarken de eski halinde bırakın
    final static String url="jdbc:mysql://localhost:3306/name_of_the_database";
    final static String user = "root";
    final static String password= "your_password";


    public static Connection getConnection(){
        Connection myConn=null;

        try{
            myConn = DriverManager.getConnection(url,user,password);
        }catch (Exception e) {
            System.out.println("\n>>> ERROR! The program Can Not Connect to the Database. <<<");
        }
        return myConn;
    }

}
