package lesson14.homework;

import java.util.ArrayDeque;

public class CallCenter {

    private static ArrayDeque<IncomingCall> createCalls() {
        ArrayDeque<IncomingCall> incomingCalls = new ArrayDeque<>();
        for (int i = 0; i < 8; i++) {
            incomingCalls.add(new IncomingCall(IncomingCall.getRandomId(), IncomingCall.getRandomGoal()));
        }
        return incomingCalls;
    }

    private static void acceptCall() {
        ArrayDeque<IncomingCall> incomingCalls = createCalls();
        Runnable runnable = () -> {
            while (incomingCalls.peekFirst() != null){
                synchronized (incomingCalls) {
                    if (!incomingCalls.isEmpty()) {
                        System.out.println("Call id = " + incomingCalls.peekFirst().getIdCall()
                                + "; Goal call = " + incomingCalls.pollFirst().getGoalCall()
                                + "; Processed by an employee = " + Thread.currentThread().getName());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };

        Thread employeeVova = new Thread(runnable);
        Thread employeeMikita = new Thread(runnable);
        Thread employeeMax = new Thread(runnable);

        employeeVova.setName("Vova");
        employeeMikita.setName("Mikita");
        employeeMax.setName("Max");

        employeeVova.start();
        employeeMikita.start();
        employeeMax.start();
    }

    public static void main(String[] args) {
        acceptCall();
    }
}
