package assignments.assignment09;

public class Task {
    private String name;
    private int priority;
    private int estMinsToComplete;
    private java.time.LocalDateTime whenDue;

    public Task(String name, int priority, int estMinsToComplete, java.time.LocalDateTime whenDue){
        if (priority < 0){
            throw new IllegalArgumentException("Priority needs to be positive");
        }
        if (estMinsToComplete < 0){
            throw new IllegalArgumentException("EstMinsToComplete needs to be positive");
        }
        this.name = name;
        this.priority = priority;
        this.estMinsToComplete = estMinsToComplete;
        this.whenDue = whenDue;
    }

    public String getName(){
        return this.name;
    }

    public int getPriority(){
        return this.priority;
    }

    public int getEstMinsToComplete(){
        return this.estMinsToComplete;
    }

    public java.time.LocalDateTime getWhenDue(){
        return this.whenDue;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEstMinsToComplete(int estMinsToComplete){
        this.estMinsToComplete = estMinsToComplete;
    }

    public void setWhenDue(java.time.LocalDateTime whenDue){
        this.whenDue = whenDue;
    }

    public String toString(){
        return "Name: " + this.name + "\n" +
        "Priority: " + this.priority + "\n" +
        "Minutes To Complete: " + this.estMinsToComplete +"\n" +
        "Date: " + this.whenDue;
    }

    public void increasePriority(int amount){
        if (amount < 0){
            return;
        }
        this.priority += amount;
    }

    public void decreasePriority(int amount){
        if (amount > this.priority){
            this.priority = 0;
        } else{
            this.priority -= amount;
        }
    }

    public boolean overdue(){
        if (java.time.LocalDateTime.now().isAfter(this.whenDue)){
            return true;
        }
        return false;
    }
}
