import java.util.List;

abstract class Employee {

    private boolean isEmployeeFree;
    private StatusOfEmployee statusOfEmployee;


    public Employee(boolean isEmployeeFree, StatusOfEmployee statusOfEmployee) {
        this.isEmployeeFree = isEmployeeFree;
        this.statusOfEmployee = statusOfEmployee;
    }

    void handleCall(List<Employee> employeeList) {

    }

    void eneterToCallCenter(Employee employee) {
        employee.setGetStatus(true);
    }

    void escalateCall(Call currentCall) {
        if (currentCall != null) {
            if (currentCall.incrementUrgencyLevel()) {
                CallCenter.getCallCenter().dispatchCall(currentCall);
                currentCall = null;
            }
        }
        getNewCall();
    }

    private void getNewCall() {
        if (!isStatus()) {
            return;
        }
        CallCenter.getCallCenter().assignCall(this);
    }

    void setGetStatus(boolean isEmployeeFree) {
        this.isEmployeeFree = isEmployeeFree;
    }

    boolean isStatus() {
        return isEmployeeFree;
    }

    public StatusOfEmployee getStatusOfEmployee() {
        return statusOfEmployee;
    }

    public void setEmployeeFree(boolean employeeFree) {
        isEmployeeFree = employeeFree;
    }
}
