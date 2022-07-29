public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee(1,"Mr","Matt","Thornfield","Trainer","Tech Education");
        Employee employee2 = new Employee(2, "Mrs", "Jenny", "Smith", "Manager", "Tech Education");
        System.out.println(employee1.getFirstName());
        System.out.println(employee1.getJobTitle());

        ExpenseClaim expenseClaim = new ExpenseClaim(24,642,"2021-09-01",26.99);
        System.out.println(expenseClaim.getEmployeeId());
        expenseClaim.setPaid(true);
        System.out.println(expenseClaim.isPaid());
        expenseClaim.setApproved(true);
        expenseClaim.setPaid(true);
        System.out.println(expenseClaim.isPaid());

        ExpenseItem expenseItem = new ExpenseItem(24, 102, "hotel", "The Grand Hotel", 69.99);
        System.out.println(expenseItem.getDescription());
    }
}
