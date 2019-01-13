public class Call<T extends Client> {

    public T client;


    public Call(T client) {
        this.client = client;
    }

    public T getClient() {
        return client;
    }

}
