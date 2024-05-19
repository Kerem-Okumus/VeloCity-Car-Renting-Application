import View.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;


public class VcCheckerTest {
    Controller controller;
    View view;
    Model model;
    VcChecker vcChecker;
    static Connection connection = DBConnection.getConnection();


    @BeforeEach
    void setUp() throws SQLException, AWTException {
        view = new View();
        model = new Model();
        controller = new Controller(model,view);
        vcChecker = new VcChecker();
    }

    @Test
    void testExtraPriceAccordingToLocation() throws AWTException, InterruptedException {
        vcChecker.logIn();
        vcChecker.reserveCarWithoutChangingLocation();
        double totalPrice = controller.sameCarPriceCalculator();

        controller.clearPaymentPage();
        vcChecker.reserveCarChangingLocation();
        double totalPrice2 = controller.sameCarPriceCalculator();

        Assertions.assertTrue(totalPrice2>totalPrice);
    }
}
