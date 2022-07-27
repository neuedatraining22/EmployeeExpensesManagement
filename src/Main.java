public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee(1,"Mr","Matt","Thornfield","Trainer","Tech Education");
        Employee employee2 = new Employee(2, "Mrs", "Jenny", "Smith", "Manager", "Tech Education");
        System.out.println(employee1.getFirstName());
        System.out.println(employee1.getJobTitle());
    }
}
