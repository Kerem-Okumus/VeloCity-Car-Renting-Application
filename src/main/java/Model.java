import Objects.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Model {

    static Connection connection = DBConnection.getConnection();

    private ArrayList<User> userArrayList =new ArrayList<>();// aşağıdaki örnek method customer olduğu için böyle koydum bunu driver, car vs için yapabiliriz

    public Model() {} //buraya da kod gelebilir textten çekerken burda direkt dosyayı okuyup userları arrayliste atıyodu bunun sql veriyonu gibi.

    // bu kod admin varmış gibi düşünüldü o yüzden sadece sql ile birlikte nasıl çalıştığının örneği olsun diye koydum
    public int addUser(User user)  {
        userArrayList.add(user);

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


            statement.executeUpdate("INSERT INTO User (userId, age, userName, password, name_surname,cardNumber, gender,phoneNumber) VALUES ( '" + userId
                    + "' , '" + user.getAge() + "', '" + user.getUsername() + "' , '" + user.getPassword() + "' , '" + user.getName_surname() + "' , '" + user.getCardNumber()
                    + "' , '" + user.getGender() + "' , '" + user.getPhoneNumber() + "')");
            System.out.println("NOTIFICATION >>> Customer " + user.getName_surname() + " with id " + userId + " added to Users <<<");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    } //sample method for adding a customer with a unique id ama username için de unique yaptıralım

    //buraları fonksiyonlarla doldurucaz userın yapacağı sonra controllerdaki actionperformed classında kullanıcaz

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }
}
