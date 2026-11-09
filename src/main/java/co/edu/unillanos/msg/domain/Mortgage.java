package co.edu.unillanos.msg.domain;

import java.util.Objects;

/**
 * Hipoteca otorgada por la MSG Foundation a una pareja.
 * Rol responsable: Hipotecas.
 */
public final class Mortgage {

    private static final double WEEKS_PER_YEAR = 52.0;
    private static final double MAX_INCOME_SHARE = 0.28;

    private final String mortgageNumber;
    private final double weeklyPrincipalAndInterest;
    private final double annualPropertyTax;
    private final double annualInsurancePremium;
    private final double coupleWeeklyIncome;

    public Mortgage(String mortgageNumber, double weeklyPrincipalAndInterest,
                    double annualPropertyTax, double annualInsurancePremium,
                    double coupleWeeklyIncome) {
        this.mortgageNumber = Objects.requireNonNull(mortgageNumber);
        if (coupleWeeklyIncome <= 0) {
            throw new IllegalArgumentException("El ingreso semanal de la pareja debe ser positivo");
        }
        this.weeklyPrincipalAndInterest = weeklyPrincipalAndInterest;
        this.annualPropertyTax = annualPropertyTax;
        this.annualInsurancePremium = annualInsurancePremium;
        this.coupleWeeklyIncome = coupleWeeklyIncome;
    }

    public String mortgageNumber() {
        return mortgageNumber;
    }

    /** RN2: costo semanal de impuesto predial y seguro. */
    public double weeklyEscrow() {
        return (annualPropertyTax + annualInsurancePremium) / WEEKS_PER_YEAR;
    }

    /** RN3: capital e intereses más el costo semanal de impuesto y seguro. */
    public double totalWeeklyPayment() {
        return weeklyPrincipalAndInterest + weeklyEscrow();
    }

    /** RN4: lo máximo que la pareja aporta por semana. */
    public double maxCoupleContribution() {
        return coupleWeeklyIncome * MAX_INCOME_SHARE;
    }

    /** RN5: lo que cubre la fundación; nunca es negativo. */
    public double weeklyGrant() {
        return Math.max(0.0, totalWeeklyPayment() - maxCoupleContribution());
    }

    /** Lo que paga la pareja: cuota total menos subsidio. */
    public double weeklyCoupleContribution() {
        return totalWeeklyPayment() - weeklyGrant();
    }
}
