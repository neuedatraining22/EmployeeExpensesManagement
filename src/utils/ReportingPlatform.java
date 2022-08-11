package utils;

public interface ReportingPlatform {

    public void listAllExpenseClaims();
    public void listAllExpenseClaimsNotApproved();
    public void listAllExpenseClaimsApprovedNotPaid();
    public void listAllExpenseClaimsWhereTotalIsGreaterThan200();
}
