package assignments.assignment09;


public class HoneyDoList {
    private Task[] tasks;
    private int numTasks;
    private static final int INITIAL_CAPACITY = 10;

    public HoneyDoList(){
        numTasks = 0;
        tasks = new Task[INITIAL_CAPACITY];
    }

    // calls toString on each task and appends to a new String variable
    public String toString(){
        String taskString = "";
        for (int i = 0; i < numTasks; i++){
            taskString += tasks[i].toString() + "\n";
        }
        return taskString;
    }

    public int find(String name){
        for (int i = 0; i < numTasks; i++){
            if (tasks[i].getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }

    // Adds the new task to index of number of tasks
    // If the number of tasks is equal to the length of the array, then the array is full
    // That is when we create a new array with added size of our current array
    // prevTasks points to our current array
    // We copy our old array into our new array and then finally add our newTask 
    public void addTask(Task newTask){
        if (numTasks == tasks.length) 
        {
            Task[] prevTasks = tasks;
            tasks = new Task[tasks.length + INITIAL_CAPACITY];
            for (int i = 0; i < prevTasks.length; i++){
                tasks[i] = prevTasks[i];
            }
            tasks[prevTasks.length] = newTask;
            numTasks += 1;
        } 
        else
        {
        tasks[numTasks] = newTask;
        numTasks += 1;
        }
    }

    public int totalTime(){
        int total = 0;
        for (int i = 0; i < numTasks; i++){
            total += tasks[i].getEstMinsToComplete();
        }
        return total;
    }

    public int shortestTime(){
        int leastAmount = Integer.MAX_VALUE;
        int leastIndex = 0;
        if (numTasks == 0){
            return -1;
        }
        for (int i = 0; i < numTasks; i++){
            if(tasks[i].getEstMinsToComplete() <= leastAmount){
                leastAmount = tasks[i].getEstMinsToComplete();
                leastIndex = i;
            }
        }
        return leastIndex;
    }

    public Task completeTask(int index){
        if (index >= tasks.length || index < 0){
            return null;
        }
        Task tempTask = tasks[index];
        for (int i = index; i < numTasks; i++){
            tasks[i] = tasks[i + 1];
        }
        numTasks -= 1;
        return tempTask;
    }

    public Task getTask(int index){
        if (index >= tasks.length || index < 0){
            return null;
        }
        return tasks[index];
    }

    public Task[] overdueTasks(){
        Task[] overdue = new Task[tasks.length];
        for (int i = 0; i < numTasks; i++){
            if (tasks[i].overdue()){
                overdue[i] = tasks[i];
            }
        }
        return overdue;
    }
}
