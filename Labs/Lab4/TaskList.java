package taskmanager;

public class TaskList{
  private static Task[] tasks;
  private static int size;
  public TaskList(int capacity){
    this.tasks = new Task[capacity];
    this.size = 0;
  }
  public void addTask(Task myTask){
    if(size < this.tasks.length){
      this.tasks[size++] = myTask;
    }else{
      System.out.print("Maximum capacity reacched");
    }
  }
  public Task[] getAllTask(){
    Task[] allTask = new Task[size];
    for(int i = 0; i < allTask.length; i++){
      allTask[i] = this.tasks[i];
      System.out.print(allTask[i].toString());
    }
    return allTask;
  }
}