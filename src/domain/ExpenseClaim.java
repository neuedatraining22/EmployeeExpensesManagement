package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ExpenseClaim {

    private int id;
    private int employeeId;
    private Date dateOfClaim;
    private boolean approved;
    private boolean paid;
    private List<ExpenseItem> expenseItems; // = new ArrayList<>();

    public ExpenseClaim(int id, int employeeId, Date dateOfClaim) {
        this.id = id;
        this.employeeId = employeeId;
        this.dateOfClaim = dateOfClaim;
        this.expenseItems = new ArrayList<>();
    }

    public Double getTotalAmount() {
        Double total = 0d;
        for(ExpenseItem ei : expenseItems) {
            total += ei.getAmount();
        }
        return total;
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

    public List<ExpenseItem> getExpenseItems() {
        return expenseItems;
    }

    public void addExpenseItem(ExpenseItem item) {
        expenseItems.add(item);
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

    public boolean isApproved() {
        return approved;
    }

    public boolean isPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "ExpenseClaim{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", dateOfClaim=" + dateOfClaim +
                ", approved=" + approved +
                ", paid=" + paid +
                ", expenseItems=" + expenseItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseClaim that = (ExpenseClaim) o;
        return id == that.id && employeeId == that.employeeId && approved == that.approved && paid == that.paid && Objects.equals(dateOfClaim, that.dateOfClaim) && Objects.equals(expenseItems, that.expenseItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, dateOfClaim, approved, paid, expenseItems);
    }
}

