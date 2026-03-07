import java.util.Scanner;


class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee[ID=" + id + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

// EmployeeManagementSystem class
class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;
    private static final int MAX_SIZE = 20;

    public EmployeeManagementSystem() {
        employees = new Employee[MAX_SIZE];
        count = 0;
    }

    public void addEmployee(Scanner sc) {
        if (count >= MAX_SIZE) {
            System.out.println("Employee list is full! Cannot add more employees.");
            return;
        }

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        // Check for duplicate ID using equals()
        Employee tempEmployee = new Employee(id, "", "", 0);
        for (int i = 0; i < count; i++) {
            if (employees[i].equals(tempEmployee)) {
                System.out.println("Employee with ID " + id + " already exists! Cannot add duplicate.");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employees[count] = new Employee(id, name, department, salary);
        count++;

        System.out.println("Employee added successfully!");
        System.out.println("Current Employees:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public void displayEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
            return;
        }

        System.out.println("\n=== All Employees ===");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + employees[i]);
        }
    }

    public void updateEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getId() == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee with ID " + id + " not found!");
            return;
        }

        System.out.println("Current Details: " + employees[index]);
        System.out.println("\nWhat do you want to update?");
        System.out.println("1. Name");
        System.out.println("2. Department");
        System.out.println("3. Salary");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter new Name: ");
                String name = sc.nextLine();
                employees[index].setName(name);
                System.out.println("Name updated successfully!");
                break;
            case 2:
                System.out.print("Enter new Department: ");
                String department = sc.nextLine();
                employees[index].setDepartment(department);
                System.out.println("Department updated successfully!");
                break;
            case 3:
                System.out.print("Enter new Salary: ");
                double salary = sc.nextDouble();
                employees[index].setSalary(salary);
                System.out.println("Salary updated successfully!");
                break;
            default:
                System.out.println("Invalid choice!");
        }

        System.out.println("Updated Details: " + employees[index]);
    }

    public void deleteEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getId() == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee with ID " + id + " not found!");
            return;
        }

        System.out.println("Deleting: " + employees[index]);

        // Shift remaining employees to the left
        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[count - 1] = null;
        count--;

        System.out.println("Employee deleted successfully!");
    }

    public void searchEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (employees[i].getId() == id) {
                System.out.println("Found Employee:");
                System.out.println(employees[i]);
                return;
            }
        }

        System.out.println("Employee with ID " + id + " not found!");
    }

    public void countByDepartment(Scanner sc) {
        System.out.print("Enter department to count: ");
        sc.nextLine(); // consume any leftover newline
        String department = sc.nextLine();

        int departmentCount = 0;
        for (int i = 0; i < count; i++) {
            if (employees[i].getDepartment().equalsIgnoreCase(department)) {
                departmentCount++;
            }
        }

        System.out.println("Number of employees in " + department + ": " + departmentCount);
    }
}

public class Employee_ki_management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        System.out.println("Welcome to Employee Management System");

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee by ID");
            System.out.println("6. Count Employees by Department");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ems.addEmployee(sc);
                    break;
                case 2:
                    ems.displayEmployees();
                    break;
                case 3:
                    ems.updateEmployee(sc);
                    break;
                case 4:
                    ems.deleteEmployee(sc);
                    break;
                case 5:
                    ems.searchEmployee(sc);
                    break;
                case 6:
                    ems.countByDepartment(sc);
                    break;
                case 7:
                    System.out.println("Exiting... Thank you for using Employee Management System!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}