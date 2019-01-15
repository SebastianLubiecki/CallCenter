import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class CallCenter {

    private static CallCenter callCenter;

    private Queue<Call> callQueue;
    private List<Employee> consultant;
    private List<Employee> managers;
    private List<Employee> director;
    private Map<Enum<StatusOfEmployee>, List<Employee>> employeeMap;
    private Map<Enum<StatusOfEmployee>, Queue<Call>> callMap;

    private CallCenter(Queue<Call> callList, List<Employee> consultant, List<Employee> managers,
                       List<Employee> director, Map<Enum<StatusOfEmployee>, List<Employee>> employeeMap,
                       Map<Enum<StatusOfEmployee>, Queue<Call>> callMap) {
        this.callQueue = callList;
        this.consultant = consultant;
        this.managers = managers;
        this.director = director;
        this.employeeMap = employeeMap;
        this.callMap = callMap;
    }

    static CallCenter getInstanceOfCallCenter(Queue<Call> callQueue, List<Employee> consultant, List<Employee> managers,
                                              List<Employee> director, Map<Enum<StatusOfEmployee>, List<Employee>> employeeMap,
                                              Map<Enum<StatusOfEmployee>, Queue<Call>> callMap) {
        if (callCenter == null) {
            callCenter = new CallCenter(callQueue, consultant, managers, director, employeeMap, callMap);
        }

        return callCenter;
    }

    public Map<Enum<StatusOfEmployee>, Queue<Call>> addNewCallToCallMap(Call call) {
        addCallToTheQueueOfCalls(call);
        callMap.put(call.getStatus(), callQueue);

        return callMap;
    }

    private void addCallToTheQueueOfCalls(Call call) {
        callQueue.add(call);
    }

    public boolean removeCallFromCallMap(Call call) {

        return callMap.remove(call.getStatus(), call);
    }

    void dispatchCall(Call call) {
            algorithmOfDispatchCall(call, employeeMap.get(call.getStatus()));
    }

    boolean assignCall(Employee employee) {
        if (callQueue.peek() != null) {
            Call call = callQueue.peek();
            call.setEmployee(employee);
            employee.setGetStatus(false);

            return true;
        }
        System.out.println("Queue is empty! Lest's make some tea and rest");

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

    static CallCenter getCallCenter() {
        return callCenter;
    }
}