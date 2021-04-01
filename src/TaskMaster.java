public class TaskMaster {
  public static void main(String[] args) throws Exception {
    ToDoList list = new ToDoList("My List");
    System.out.println();
    // Declaring tasks
    Task task1 = new Task("Finish Activity 14", 1);
    Task task2 = new Task("Give Tigger a Bath", 10);
    Task task3 = new Task("Finish Activity 14", 1);

    list.addTask(task1);
    list.addTask(task2);
    list.addTask(task3);
    list.addTask("Eat Dinner");
    // Printing task 1 to the console
    System.out.println(task1.toString());
    task1.setComplete(true);
    // Testing my mutator function
    if (task1.isComplete()) {
      System.out.println("Task1 is complete!");
    } else {
      System.out.println("Task1 is not complete...");
    }
    // Printing out task 1 in the console
    System.out.println(task1.toString());
    System.out.println();
    // Printing out task 2 in the console
    System.out.println(task2.toString());
    task2.setPriority(20);
    // Setting and telling task 2's priority
    System.out.println("Task 2's priority is " + task2.getPriority());
    // Showing task 2 in the console
    System.out.println(task2.toString());
    System.out.println();
    // Checking if task 1 is the same as task 3
    System.out.println(task1.equals(task3));
    // Comparing task 1 to task 2
    int priority = task1.compareTo(task2);
    // Testing my compareTo function
    if (priority > 0) {
      System.out.println("Task 1 is a greater priority than Task 2.");
    } else if (priority < 0) {
      System.out.println("Task 1 is a lesser priority than Task 2.");
    } else {
      System.out.println("Task 1 and Task 2 are equal priority.");
    }
    // Printing out a summary of my list
    System.out.println(list);
    // Showing the highest priority task in my list
    System.out.println(list.getWork());
    task1.setCategory(Category.WORK);
    task2.setCategory(Category.NONE);
    task3.setCategory(Category.PERSONAL);
    System.out.println(list.getTaskList());

  }
}
