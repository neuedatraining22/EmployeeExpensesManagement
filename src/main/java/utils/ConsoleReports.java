package utils;

import domain.ExpenseClaim;

import java.util.List;

public class ConsoleReports implements ReportingPlatform {

    List<ExpenseClaim> expenseClaims;

    public ConsoleReports(List<ExpenseClaim> expenseClaims) {
        this.expenseClaims = expenseClaims;
    }

    @Override
    public void listAllExpenseClaims() {
        expenseClaims.stream().forEach( c -> System.out.println(c) );
    }

    @Override
    public void listAllExpenseClaimsNotApproved() {
        expenseClaims.stream()
                .filter( claim -> !claim.isApproved())
                .forEach( claim ->System.out.println(claim));
    }

    @Override
    public void listAllExpenseClaimsApprovedNotPaid() {
        expenseClaims.stream()
                .filter(claim -> !claim.isPaid() )
                .filter(claim -> claim.isApproved())
                .forEach(claim ->System.out.println(claim));
    }

    @Override
    public void listAllExpenseClaimsWhereTotalIsGreaterThan200() {
        expenseClaims.stream()
                .filter( claim -> claim.getTotalAmount() > 200)
                .forEach( claim ->System.out.println(claim));
    }
}
