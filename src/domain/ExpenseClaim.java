package domain;

import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseClaim that = (ExpenseClaim) o;
        return id == that.id && employeeId == that.employeeId && Double.compare(that.totalAmount, totalAmount) == 0 && approved == that.approved && paid == that.paid && Objects.equals(dateOfClaim, that.dateOfClaim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, dateOfClaim, totalAmount, approved, paid);
    }

    @Override
    public String toString() {
        return "ExpenseClaim{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", dateOfClaim=" + dateOfClaim +
                ", totalAmount=" + totalAmount +
                ", approved=" + approved +
                ", paid=" + paid +
                '}';
    }
}
