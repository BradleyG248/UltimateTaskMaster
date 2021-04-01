import java.util.ArrayList;
import java.util.Collections;

public class ToDoList implements ToDoListInterface {
  private String name;
  private ArrayList<Task> tasks;

  /**
   * Create a to do list
   * 
   * @param name The name of the list, as a string
   */
  ToDoList(String name) {
    this.name = name;
    this.tasks = new ArrayList<Task>();
  }

  /**
   * Prints a summary of the to do list
   */
  public String toString() {
    String output = "---------------\n My To Do List \n---------------\n";
    for (Task t : tasks) {
      output += t.toString() + "\n";
    }
    return output;
  }

  /**
   * Returns the name of the to do list
   */
  public String getName() {
    return name;
  }

  /**
   * Adds a task you make
   * 
   * @param t The task you've made
   */
  public void addTask(Task t) {
    tasks.add(t);
  }

  /**
   * @param str Takes the title of the new task for your list
   */
  public void addTask(String str) {
    tasks.add(new Task(str));
  }

  public void addTask(String str, Category category) {
    tasks.add(new Task(str, category));
  }

  /**
   * Returns the highest priority task in your ToDo List
   */
  public Task getWork() {
    if (tasks.isEmpty()) {
      return null;
    }
    Task max = Collections.max(tasks);
    if (max.isComplete()) {
      return null;
    }
    return max;
  }

  /**
   * Get all the tasks as an ArrayList
   */
  public ArrayList<Task> getTaskList() {
    ArrayList<Task> tasksOut = new ArrayList<Task>(tasks);
    return tasksOut;
  }

}
