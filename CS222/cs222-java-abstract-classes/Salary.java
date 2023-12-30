/*File name: Salary.java */
public class Salary extends Employee {
    public Salary(String name, String address, int number) {
        super(name, address, number);
        //TODO Auto-generated constructor stub
    }

    private double salary; //Annual salary
    public double computePay () {
        System.out.println("Computing salary pay for " + getName());
        return salary/52;
    }


    public void mailCheck() {
        System.out.println("within mailCheck of Salary class");
        System.out.println("Mailing check to " + getName() + " with salary" + salary);
    }
}
