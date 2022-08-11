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

    }

    @Override
    public void listAllExpenseClaimsNotApproved() {
        expenseClaims.stream()
                .filter( claim -> !claim.isApproved())
                .forEach( claim ->System.out.println(claim));
    }

    @Override
    public void listAllExpenseClaimsApprovedNotPaid() {

    }

    @Override
    public void listAllExpenseClaimsWhereTotalIsGreaterThan200() {

    }
}
