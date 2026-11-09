package co.edu.unillanos.msg.domain;

/**
 * Gastos operativos anuales estimados de la MSG Foundation.
 * Rol responsable: Inversiones.
 */
public final class OperatingExpenses {

    private static final double WEEKS_PER_YEAR = 52.0;

    private final double annualAmount;

    public OperatingExpenses(double annualAmount) {
        this.annualAmount = annualAmount;
    }

    public double annualAmount() {
        return annualAmount;
    }

    /** RN7: gasto anual repartido igual entre 52 semanas, con 2 decimales. */
    public double weeklyAmount() {
        return annualAmount / WEEKS_PER_YEAR;
    }
}
