package co.edu.unillanos.msg.application.usecase;

/** Datos que digita el usuario para registrar una hipoteca. */
public record RegisterMortgageRequest(
        String mortgageNumber,
        double weeklyPrincipalAndInterest,
        double annualPropertyTax,
        double annualInsurancePremium,
        double coupleWeeklyIncome) {
}
