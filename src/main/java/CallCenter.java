import java.util.List;
import java.util.Queue;
import java.util.Random;

public class CallCenter {

    private static CallCenter callCenter;

    private Queue<Call> callList;
    private List<Employee> consultant;
    private List<Employee> managers;
    private List<Employee> director;

    private CallCenter() {
    }

    public CallCenter(Queue<Call> callList, List<Employee> consultant,
                      List<Employee> managers, List<Employee> director) {
        this.callList = callList;
        this.consultant = consultant;
        this.managers = managers;
        this.director = director;
    }

    public static CallCenter getInstanceOfCallCenter() {
        if (callCenter == null) {
            callCenter = new CallCenter();
        }

        return callCenter;
    }

    public Queue<Call> addCallTolistofCalls(Call call) {
        callList.add(call);
        return callList;
    }


    boolean dispatchCall(Call call) {
        if (call.getStatus() == 1) {
            algorithmOfDispatchCall(call, consultant);
            return true;
        } else if (call.getStatus() == 2) {
            algorithmOfDispatchCall(call, managers);
            return true;
        } else if (call.getStatus() == 3) {
            algorithmOfDispatchCall(call, director);
            return true;
        }

        return false;
    }


    private static void algorithmOfDispatchCall(Call call, List<Employee> employeeList) {
        Random random = new Random();
        int numberOfEmployee = random.nextInt(employeeList.size());

        if (employeeList.get(numberOfEmployee).isStatus()) {
            employeeList.get(numberOfEmployee).setGetStatus(true);
            call.setEmployee(employeeList.get(numberOfEmployee));

        } else {
            int i = 0;
            while (!employeeList.get(i).isStatus()) {
                i++;
            }
            employeeList.get(i).setGetStatus(true);
            call.setEmployee(employeeList.get(i));
        }
    }

    public void setCallList(Queue<Call> callList) {
        this.callList = callList;
    }

    public boolean deleteCallFromQueue(Call call) {
        callList.remove(call);
        return !callList.contains(call);
    }

}



