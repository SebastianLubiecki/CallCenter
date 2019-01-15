public class Call<T extends Client> {

    private T client;
    private Employee employee;
    private StatusOfEmployee status;


    public Call(T client, Employee employee) {
        this.client = client;
        this.employee = employee;
        this.status = StatusOfEmployee.CONSULTANT;
    }

    public Call(T client) {
        this.client = client;
        this.status =  StatusOfEmployee.CONSULTANT;
    }

    public T getClient() {
        return client;
    }

    void setEmployee(Employee employee) {
        this.employee = employee;
    }


    StatusOfEmployee getStatus() {
        return status;
    }

    private void setStatus(StatusOfEmployee status) {
        this.status = status;
    }

    boolean incrementUrgencyLevel() {
        if (getStatus().equals(StatusOfEmployee.CONSULTANT)){
            setStatus(StatusOfEmployee.MANAGER );
        }
        if (getStatus().equals(StatusOfEmployee.MANAGER)){
            setStatus(StatusOfEmployee.DIRECTOR );
        }
        return !getStatus().equals(StatusOfEmployee.DIRECTOR);
    }

    public Employee getEmployee() {
        return employee;
    }
}
