import View.LoginView;
import View.SignUpView;
import View.View;

import java.sql.Connection;

public class Main {
    static Connection connection = DBConnection.getConnection();
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);


    }
}
