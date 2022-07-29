package domain;

import java.util.Date;

public class ExpenseClaim {

    private int id;
    private int employeeId;
    private Date dateOfClaim;
    private double totalAmount;
    private boolean approved;
    private boolean paid;

    public ExpenseClaim(int id, int employeeId, Date dateOfClaim, double totalAmount) {
        this.id = id;
        this.employeeId = employeeId;
        this.dateOfClaim = dateOfClaim;
        this.totalAmount = totalAmount;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setPaid(boolean paid) {
        if(paid && !approved) {
            System.out.println("This item cannot be paid as it has not yet been approved");
        } else {
            this.paid = paid;
        }
    }

    public int getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Date getDateOfClaim() {
        return dateOfClaim;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isApproved() {
        return approved;
    }

    public boolean isPaid() {
        return paid;
    }


}
