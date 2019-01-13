public class Call<T extends Client> {

    private T client;
    private Employee employee;
    private int status;


    public Call(T client, Employee employee) {
        this.client = client;
        this.employee = employee;
        this.status = 1;
    }

    public Call(T client, int status) {
        this.client = client;
        this.status = status;
    }

    public T getClient() {
        return client;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean incrementUrgencyLevel() {
        setStatus(getStatus() + 1);

        return true;
    }

}
