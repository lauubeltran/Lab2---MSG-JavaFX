package co.edu.unillanos.msg.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InvestmentTest {

    @Test void weeklyReturnIsAnnualOver52() {
        Investment i = new Investment("I-01", "Bonos del Tesoro", 52000.00);
        assertEquals(1000.00, i.weeklyReturn(), 1e-6);
    }
}
