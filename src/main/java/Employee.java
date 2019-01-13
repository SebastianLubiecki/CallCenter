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
        if (employeeList.get(numberOfEmployee).isStatus()) {
            employeeList.get(numberOfEmployee).setGetStatus(true);
            return employeeList.get(numberOfEmployee);
        } else {
            int i = 0;
            while (!employeeList.get(i).isStatus()) {
                i++;
            }
            employeeList.get(i).setGetStatus(true);
            return employeeList.get(i);
        }
    }

    public void setGetStatus(boolean getStatus) {
        this.getStatus = getStatus;
    }


    private boolean isStatus() {
        return getStatus;
    }
}
