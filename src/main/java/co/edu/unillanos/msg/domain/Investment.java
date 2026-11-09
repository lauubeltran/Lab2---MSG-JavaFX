package co.edu.unillanos.msg.domain;

import java.util.Objects;

/**
 * Inversión de la MSG Foundation.
 * Rol responsable: Inversiones.
 *
 * Decisión D3 (tomada, revisable): la clase está declarada final.
 * ¿La mantienen así? Anoten en la hoja una ventaja y un riesgo.
 */
public final class Investment {

    private static final double WEEKS_PER_YEAR = 52.0;

    private final String investmentId;
    private final String description;
    private final double annualExpectedReturn;

    public Investment(String investmentId, String description, double annualExpectedReturn) {
        this.investmentId = Objects.requireNonNull(investmentId);
        this.description = Objects.requireNonNull(description);
        this.annualExpectedReturn = annualExpectedReturn;
    }

    public String investmentId() {
        return investmentId;
    }

    public String description() {
        return description;
    }

    public double annualExpectedReturn() {
        return annualExpectedReturn;
    }

    /** RN6: rendimiento anual esperado / 52, en dólares con 2 decimales. */
    public double weeklyReturn() {
        return annualExpectedReturn / WEEKS_PER_YEAR;
    }
}
