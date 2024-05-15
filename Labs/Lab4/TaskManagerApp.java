package app;

import taskmanager.Task; 
import taskmanager.TaskList;

public class TaskManagerApp {
  public static void main(String[] args) {
    
    TaskList taskList = new TaskList(2); 
    
    Task t1 = new Task(1, "Task1", "this is a new task");
    Task t2 = new Task(2, "Task2", "this is a newer task");
    
    taskList.addTask(t1);
    taskList.addTask(t2);
    
    taskList.getAllTask();
  }
}