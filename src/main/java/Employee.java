import java.util.List;
import java.util.Random;

abstract class Employee {

    private boolean getStatus;

    Employee(boolean getStatus) {
        this.getStatus = getStatus;
    }

    boolean handleCall() {
        return false;
    }

    Employee escalateCall(List<Employee> employeeList) {
        Random random = new Random();
        int numberOfEmployee = random.nextInt(employeeList.size());
        return employeeList.get(numberOfEmployee);
    }

    public boolean isGetStatus() {
        return getStatus;
    }
}
