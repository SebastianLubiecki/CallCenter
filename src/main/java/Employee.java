import java.util.List;

abstract class Employee {


    private boolean getStatus;

    Employee(boolean getStatus) {
        this.getStatus = getStatus;
    }

    boolean handleCall(List<Employee> employeeList) {

        return false;
    }

    void escalateCall(Call currentCall) {
        if (currentCall != null) {
            if (currentCall.incrementUrgencyLevel()) {
                CallCenter.getInstanceOfCallCenter().dispatchCall(currentCall);
                currentCall = null;
            }
        }
        getNewCall();
    }

    private  boolean getNewCall() {
        if (!isStatus()) {

            return false;
        }

        return CallCenter.getInstanceOfCallCenter().assignCall(this); //metoda assignCall to takie proszneie o rozmowe
    }

    public void setGetStatus(boolean getStatus) {
        this.getStatus = getStatus;
    }

    public boolean isStatus() {
        return getStatus;
    }
}
