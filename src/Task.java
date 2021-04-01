public class Task implements Comparable<Task> {
  private String description;
  private int priority;
  private boolean complete;
  private Category category;

  /**
   * Create a task with a description and a priority.
   * 
   * @param description
   * @param priority
   */
  Task(String description, int priority, Category category) {
    this.description = description;
    this.priority = priority;
    this.complete = false;
    this.category = category;
  }

  Task(String description, int priority) {
    this.description = description;
    this.priority = priority;
    this.complete = false;
    this.category = Category.NONE;
  }

  Task(String description, Category category) {
    this.description = description;
    this.priority = 10;
    this.complete = false;
    this.category = category;
  }

  Task(String description) {
    this.description = description;
    this.priority = 10;
    this.complete = false;
    this.category = Category.NONE;
  }

  /**
   * @return The description of this task.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Determines if two tasks are the same.
   * 
   * @param other The task you're determining equality of
   * @return Whether or not the two tasks are equal
   */
  public boolean equals(Task other) {
    if (this.description.equalsIgnoreCase(other.getDescription()) && this.category == other.getCategory()) {
      return true;
    }
    return false;
  }

  /**
   * Compares two tasks, and determines whether this task is of higher or lower
   * value
   * 
   * @param other The task you're comparing
   * @return An integer value--0 is equal, 1 is greater, and -1 is lesser
   */
  @Override
  public int compareTo(Task other) {
    if (this.complete == other.isComplete()) {
      if (other.getPriority() > this.priority) {
        return -1;
      } else if (other.getPriority() < this.priority) {
        return 1;
      }
    } else if (this.complete && !other.isComplete()) {
      return -1;
    } else if (!this.complete && other.isComplete()) {
      return 1;
    }
    return 0;
  }

  /**
   * Sets the description of this task.
   * 
   * @param description
   * @return The new description of this task.
   */
  public String setDescription(String description) {
    if (description != null) {
      this.description = description;
    }
    return description;
  }

  /**
   * @return This task's priority.
   */
  public int getPriority() {
    return this.priority;
  }

  /**
   * Sets the priority with the value you provide.
   * 
   * @param priority An integer priority--The lower the value, the higher the
   *                 priority
   * @return The new priority
   */
  public int setPriority(int priority) {
    this.priority = priority;
    return this.priority;
  }

  /**
   * 
   * @return Whether or not the task is complete
   */
  public boolean isComplete() {
    return this.complete;
  }

  /**
   * Set this task as complete or not.
   * 
   * @param complete
   * @return The current complete status
   */
  public boolean setComplete(boolean complete) {
    this.complete = complete;
    return this.complete;
  }

  /**
   * 
   * @return category The category this task belongs to
   */
  public Category getCategory() {
    return category;
  }

  /**
   * Sets the category of this task
   * 
   * @param category The category you want this task to have
   */
  public void setCategory(Category category) {
    this.category = category;
  }

  /**
   * @return A string representation of this object
   */
  public String toString() {
    String check = " ";
    if (this.isComplete()) {
      check = "X";
    }
    String state = "[" + check + "] " + this.description + ", " + this.category + ", " + this.priority;
    return state;
  }
}