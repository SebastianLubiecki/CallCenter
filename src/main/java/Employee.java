abstract class Employee {

    private boolean getStatus;

    Employee(boolean getStatus) {
        this.getStatus = getStatus;
    }

    boolean handleCall() {
        return false;
    }

    boolean escalateCall() {
        return false;
    }

    public boolean isGetStatus() {
        return getStatus;
    }
}
