package co.edu.unillanos.msg.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OperatingExpensesTest {

    @Test void weeklyAmountSpreadsAnnualExpensesOver52Weeks() {
        OperatingExpenses e = new OperatingExpenses(39000.00);
        assertEquals(750.00, e.weeklyAmount(), 1e-6);
    }
}
