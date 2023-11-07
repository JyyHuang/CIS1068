package assignments.assignment09;

public class Task {
    private String name;
    private int priority;
    private int estMinsToComplete;
    private java.time.LocalDateTime whenDue;

    public Task(String name, int priority, int estMinsToComplete, java.time.LocalDateTime whenDue){
        this.name = name;
        this.priority = priority;
        this.estMinsToComplete = estMinsToComplete;
        this.whenDue = whenDue;
    }
}
