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

    @Test
    void testIfTimeIntervalWarningOccurs() throws InterruptedException {
        vcChecker.logIn();
        vcChecker.rentToPaymentView();

        Assertions.assertTrue(controller.getTimeErrorOccured()==1);
    }

    @Test
    void testIfUserEnteredValidPromotionCode() throws InterruptedException {
        vcChecker.logIn();
        vcChecker.enterValidPromotionCode();

        Assertions.assertTrue(model.getPromotionError()==0);
    }

    @Test
    void testIfUserEnteredUnvalidPromotionCode() throws InterruptedException {

        vcChecker.logIn();
        vcChecker.enterWrongPromotionCode();
        Assertions.assertTrue(model.getPromotionError()==1);
    }

    @Test
    void testIfExtrasAreFilledWrong() throws InterruptedException {

        vcChecker.logIn();
        vcChecker.dontFillDriver();
        vcChecker.fillDriverButDontFillPreference();
        vcChecker.dontFillTireChain();
        vcChecker.dontFillroofBox();
        vcChecker.dontFillProtection();

        Assertions.assertTrue(model.getSelectedExtrasError()==1);
    }

    @Test
    void testIfUserCanSelectDifferentPackages() throws InterruptedException {

        vcChecker.logIn();
        vcChecker.trySelectingDifferentPackagesAtTheSameTime();

        Assertions.assertTrue(view.getuView().getProtectionPackages()!=null);
    }

    @Test
    void testExtraPriceAccordingToExtraSelections() throws InterruptedException {

        vcChecker.logIn();
        vcChecker.selectRentDetailsAndseeNewTotal();

        String[] base=view.getpView().getRentFeeTextField().getText().split(" \\(");
        double baseAmount = Double.parseDouble(base[0]);
        double updatedAmount = Double.parseDouble(view.getpView().getTotalTextField().getText());

        Assertions.assertTrue(baseAmount < updatedAmount);
    }

    @Test
    void testIfProccesHasUnsatisfiedConditions() throws InterruptedException {

        vcChecker.logIn();
        vcChecker.pressContinueWithoutSearchingAndSelectingCar();

        Assertions.assertTrue(controller.getSelectionErrorOccured()==1);
    }
}
