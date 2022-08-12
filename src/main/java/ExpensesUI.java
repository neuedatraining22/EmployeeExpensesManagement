import domain.ExpenseClaim;
import domain.ExpenseItem;
import domain.ExpenseType;
import utils.ConsoleReports;
import utils.DatabaseUtils;
import utils.ReportingPlatform;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpensesUI {

    List<ExpenseClaim> expenseClaims = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int highestExpenseItemId = 0;

    public void setUpExampleClaims() {
        ExpenseClaim claim1 = new ExpenseClaim(1,104, LocalDate.of(2021,5,23));
        claim1.addExpenseItem(new ExpenseItem(1,1, ExpenseType.TRAVEL, "Plane to Chicago", 655.29));
        claim1.addExpenseItem(new ExpenseItem(2, 1, ExpenseType.ACCOMODATION, "Hilton Hotel", 199.99));
        expenseClaims.add(claim1);

        ExpenseClaim claim2 = new ExpenseClaim(2, 226, LocalDate.of(2022,6,19));
        claim2.addExpenseItem(new ExpenseItem(3, 2, ExpenseType.MEAL, "McDonalds", 4.99));
        expenseClaims.add(claim2);
        highestExpenseItemId = 3;
    }

    public void enterExpenseItem(ExpenseClaim claim) {
        highestExpenseItemId++;
        int expenseItemId = highestExpenseItemId;
        int claimId = claim.getId();

        System.out.println("Enter expense type (M)eal, (T)ravel, (A)ccomodation, (S)tationary");
        String expType = scanner.nextLine();
        ExpenseType type = null;
        while(type == null) {
            if (expType.toUpperCase().equals("M")) {
                type = ExpenseType.MEAL;
            }
            if (expType.toUpperCase().equals("T")) {
                type = ExpenseType.TRAVEL;
            }
            if (expType.toUpperCase().equals("A")) {
                type = ExpenseType.ACCOMODATION;
            }
            if (expType.toUpperCase().equals("S")) {
                type = ExpenseType.STATIONERY;
            }
            if (type==null) {
                System.out.println("Invalid expense type entered - try again");
            }
        }
        System.out.println("Enter the description");
        String description = scanner.nextLine();

        System.out.println("Enter the amount");
        double amount = -1;
        while (amount <= 0) {
            try {
                amount = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid amount entered - try again");
            }
        }

        claim.addExpenseItem(new ExpenseItem(expenseItemId, claimId, type,description, amount));
    }

    public void enterNewExpenseClaim() {
        int claimId = expenseClaims.size() + 1;
        int employeeId = -1;
        while (employeeId < 1) {
            try {
                System.out.println("Please enter the employee ID");
                employeeId = Integer.parseInt(scanner.nextLine());
                if (employeeId < 1) {
                    System.out.println("Invalid employee ID entered - try again");
                }
            } catch (Exception e) {
                System.out.println("Invalid employee ID entered - try again");
            }
        }

        ExpenseClaim newClaim = new ExpenseClaim(claimId, employeeId, LocalDate.now());
        expenseClaims.add(newClaim);

        boolean finishedEnteringExpenseItems = false;
        while (!finishedEnteringExpenseItems) {
            System.out.println("Do you want to enter an expense item? Y/N");
            String input = scanner.nextLine();
            if (input.toUpperCase().equals("Y")) {
                enterExpenseItem(newClaim);
            }
            else {
                finishedEnteringExpenseItems = true;
            }
        }


    }

    public void showReports() {

        String choice = "";
        while (!choice.toUpperCase().equals("X")) {
            System.out.println("Do you want to see a report?");
            System.out.println("1 - All expense claims");
            System.out.println("2 - All claims that are approved but not paid");
            System.out.println("3 - All expense claims that are not approved");
            System.out.println("4 - All expense claims above $200");
            System.out.println("X - Exit");
            choice = scanner.nextLine();

            ReportingPlatform reports = new ConsoleReports(expenseClaims);

            switch (choice.toUpperCase().charAt(0)) {
                case '1' : reports.listAllExpenseClaims();
                            break;
                case '2' : reports.listAllExpenseClaimsApprovedNotPaid();
                            break;
                case '3' : reports.listAllExpenseClaimsNotApproved();
                            break;
                case '4' : reports.listAllExpenseClaimsWhereTotalIsGreaterThan200();
                            break;
                case 'X' : break;
                default: System.out.println("Invalid entry - try again");
            }
        }
    }

    public void start() {
        setUpExampleClaims();

        boolean finishedEnteringClaims = false;
        while(!finishedEnteringClaims) {
            System.out.println("Do you want to enter an expense claim Y/N ?");
            String input = scanner.nextLine();
            if(input.toUpperCase().equals("Y")) {
                enterNewExpenseClaim();
            }
            else {
                finishedEnteringClaims = true;
            }
        }

        showReports();

        DatabaseUtils databaseUtils = new DatabaseUtils();
        try {
            databaseUtils.saveData(expenseClaims);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

