import View.View;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    static Connection connection = DBConnection.getConnection();
    public static void main(String[] args) throws SQLException {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);

    }
}
