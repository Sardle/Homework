package lesson14.homework;

public class IncomingCall {
    private String idCall;
    private String goalCall;

    public IncomingCall(String idCall, String goalCall) {
        this.idCall = idCall;
        this.goalCall = goalCall;
    }

    public String getIdCall() {
        return idCall;
    }

    public String getGoalCall() {
        return goalCall;
    }

    public static String getRandomId() {
        return String.valueOf((int) (Math.random() * 99999999 + 10000000));
    }

    public static String getRandomGoal() {
        String[] strings = new String[]{"Problem", "Commercial proposal", "Purchase of equipment", "System failure",
                "Error in operation", "Wrong number"};
        return strings[(int) (Math.random() * 6)];
    }
}
