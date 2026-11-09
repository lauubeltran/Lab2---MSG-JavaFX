package co.edu.unillanos.msg.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MortgageTest {

    private static void assertMoney(double expected, double actual) {
        assertEquals(expected, actual, 1e-6,
            () -> "esperado " + expected + " pero fue " + actual);
    }

    private final Mortgage m1 = new Mortgage("M-001",
            300.00, 2600.00, 1040.00, 1000.00);
    private final Mortgage m2 = new Mortgage("M-002",
            200.00, 1560.00, 520.00, 1000.00);

    @Test void weeklyEscrowSpreadsTaxAndInsuranceOver52Weeks() {
        assertMoney(70.00, m1.weeklyEscrow());
    }

    @Test void totalWeeklyPaymentAddsPrincipalInterestAndEscrow() {
        assertMoney(370.00, m1.totalWeeklyPayment());
    }

    @Test void grantCoversWhatExceeds28PercentOfIncome() {
        assertMoney(90.00, m1.weeklyGrant());
    }

    @Test void grantIsZeroWhenCoupleCanPayEverything() {
        assertMoney(0.00, m2.weeklyGrant());
    }

    @Test void coupleContributionIsTotalMinusGrant() {
        assertMoney(280.00, m1.weeklyCoupleContribution());
        assertMoney(240.00, m2.weeklyCoupleContribution());
    }

    @Test void rejectsNonPositiveIncome() {
        assertThrows(IllegalArgumentException.class, () -> new Mortgage("M-003",
                100.00, 0, 0, 0));
    }
}
