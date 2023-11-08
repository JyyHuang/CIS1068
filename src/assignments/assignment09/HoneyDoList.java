package assignments.assignment09;

public class HoneyDoList {
    private Task[] tasks;
    private int numTasks;
    private static final int INITIAL_CAPACITY = 10;

    public HoneyDoList(){
        this.numTasks = 0;
        this.tasks = new Task[INITIAL_CAPACITY];
    }
}
