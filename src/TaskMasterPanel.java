import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Lesson 18-19: Activity - Task Master GUI
 * 
 * This class represents the main TaskMaster JPanel.
 * 
 * It contains a ToDoListPanel and the control sub-panel.
 * 
 * @author CS121 Instructors
 * @version [semester]
 * @author [your name]
 */
@SuppressWarnings("serial")
public class TaskMasterPanel extends JPanel {
  JTextField descriptionField = new JTextField(null, 15);
  ToDoListPanel listPanel = new ToDoListPanel("My List");
  JPanel controlPanel = new JPanel();
  JScrollPane listScrollPane = new JScrollPane();

  /**
   * Creates a new TaskMasterPanel.
   */
  public TaskMasterPanel() {
    this.setPreferredSize(new Dimension(500, 400));
    this.setLayout(new BorderLayout());
    // List Panel setup
    listPanel.addTask(new Task("Fix the leaky roof", 1));
    listPanel.addTask(new Task("Buy clothes", Category.PERSONAL));
    listPanel.addTask(new Task("Get groceries", 10, Category.PERSONAL));
    listPanel.addTask(new Task("File taxes", 5, Category.WORK));
    // Control Panel setup
    descriptionField.addActionListener(new AddTaskListener());
    JButton getWorkButton = new JButton("Get Work");
    getWorkButton.addActionListener(new GetWorkButtonListener());
    JButton addTaskButton = new JButton("Add Task");
    addTaskButton.addActionListener(new AddTaskListener());
    controlPanel.add(getWorkButton);
    controlPanel.add(descriptionField);
    controlPanel.add(addTaskButton);
    add(listPanel, BorderLayout.CENTER);
    add(controlPanel, BorderLayout.SOUTH);
  }

  private class GetWorkButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      showWorkDialog();
    }
  }

  private class AddTaskListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      addTask();
    }
  }

  public void addTask() {
    listPanel.addTask(new Task(descriptionField.getText()));
    listPanel.revalidate();
  }

  public void showWorkDialog() {
    Task currentTask = listPanel.getWork();
    if (currentTask != null) {
      JOptionPane.showMessageDialog(this, "Next on your list is \"" + currentTask.getDescription() + "\".");
    } else {
      JOptionPane.showMessageDialog(this, "There is no task to do, yet...");
    }
  }
}