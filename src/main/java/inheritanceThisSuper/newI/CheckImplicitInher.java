package inheritanceThisSuper.newI;

public class CheckImplicitInher {
    public static void main(String[] args) {
        Employee employee = new Employee("How");
        System.out.println(employee.name + " " + employee.getSurname());
        employee.setName("Goudy");
        System.out.println(employee.name + " " + employee.getSurname());
    }
}
class Person {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Employee extends Person {
    private String surname;

    public Employee(String surname) {
        this.surname = surname;
    }

    public Employee(String surname, String name) {
        this.name = name;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
