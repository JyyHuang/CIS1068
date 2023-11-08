package assignments.assignment09;

import java.time.LocalDateTime;

public class TaskMain {
    public static void main(String[] args) {
    // invalid constructor, throws IllegalArgumentException
    // Task studyTest = new Task("study for 1068 exam", -1, 100, LocalDateTime.of(2023, 11, 10, 9, 30));
    
    // valid constructor
    Task codeHW = new Task("code 1068 homework", 1, 180, LocalDateTime.of(2024, 3, 23, 13, 0));
    
    // Test getters
    System.out.println(codeHW.getName());
    System.out.println(codeHW.getWhenDue());
    
    // Test setters
    codeHW.setEstMinsToComplete(200);
    codeHW.setWhenDue(LocalDateTime.of(2023, 11, 7, 10, 0));
    
    System.out.println(codeHW.toString());
    
    // Test increase priority
    codeHW.increasePriority(2);
    System.out.println(codeHW.getPriority()); // 3
    codeHW.increasePriority(-1); // does nothing
    System.out.println(codeHW.getPriority());
    
    // Test decrease priority
    codeHW.decreasePriority(2);
    System.out.println(codeHW.getPriority()); // 1
    codeHW.decreasePriority(2);
    System.out.println(codeHW.getPriority()); // 0
    
    // Test overdue
    System.out.println(codeHW.overdue()); // true
    
    }
}
