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

    private static boolean getNewCall() {


        return false;
    }


    public void setGetStatus(boolean getStatus) {
        this.getStatus = getStatus;
    }


    public boolean isStatus() {
        return getStatus;
    }
}
