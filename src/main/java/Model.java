import Objects.Customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Model {

    static Connection connection = DBConnection.getConnection();

    private ArrayList<Customer> customerArray=new ArrayList<>();// aşağıdaki örnek method customer olduğu için böyle koydum bunu driver, car vs için yapabiliriz

    public Model() throws IOException {} //buraya da kod gelebilir textten çekerken burda direkt dosyayı okuyup userları arrayliste atıyodu bunun sql veriyonu gibi.

    // bu kod admin varmış gibi düşünüldü o yüzden sadece sql ile birlikte nasıl çalıştığının örneği olsun diye koydum
    public int addUser(String username, String password, String name_surname, String email, int age, String phoneNumber, String gender, String cardNumber)  {
        int lastId = 0;
        int userId = 0;

        try {
            Statement statement = connection.createStatement();
            ResultSet rs1 = statement.executeQuery("SELECT MAX(userId) FROM User");

            while (rs1.next()) {
                lastId = rs1.getInt(1);
            }

            if (lastId == 0) {
                userId = 1;
            } else {
                userId = lastId + 1;
            }


            statement.executeUpdate("INSERT INTO User (userId, age, userName, password, name_surname,cardNumber, gender,phoneNumber) VALUES ( '" + userId + "' , '" + age + "', '" + username + "' , '" + password + "' , '" + name_surname + "' , '" + cardNumber + "' , '" + gender + "' , '" + phoneNumber + "')");
            System.out.println("NOTIFICATION >>> Customer " + name_surname + " with id " + userId + " added to Customers <<<");

        } catch (SQLException e) {
            e.printStackTrace();
        }
//customerArray.add(new Customer(id,username vs))
        return userId;
    } //sample method for adding a customer with a unique id ama username için de unique yaptıralım

    //buraları fonksiyonlarla doldurucaz userın yapacağı sonra controllerdaki actionperformed classında kullanıcaz

}
