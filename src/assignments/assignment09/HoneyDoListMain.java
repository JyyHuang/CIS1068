package assignments.assignment09;

import java.time.LocalDateTime;

public class HoneyDoListMain {
    public static void main(String[] args) {
        // create a new empty list
        HoneyDoList honeydo = new HoneyDoList();
		
        // add Tasks
        honeydo.addTask(new Task("take aspirin", 1, 120, LocalDateTime.of(2024, 3, 23, 13, 0)));
        honeydo.addTask(new Task("code 1068 homework", 2, 180, LocalDateTime.of(2023, 3, 23, 13, 0)));
        honeydo.addTask(new Task("eat food", 3, 30, LocalDateTime.of(2023, 4, 23, 13, 0)));
        System.out.println(honeydo);

        // find function
        System.out.println(honeydo.find("take aspirin") + "\n"); // 0

        System.out.println(honeydo.totalTime() + "\n"); //330

        // print the item in the list which should
        // take the least amount of time
        System.out.println(honeydo.getTask(honeydo.shortestTime()) + "\n"); // eat food task

        System.out.println(honeydo.completeTask(0) + "\n"); // aspirin task

        // aspirin task is removed now
        System.out.println(honeydo + "\n");

        // returns the memory address, but if you index into it, then you can see the tasks.
        System.out.println(honeydo.overdueTasks());
    }
}
