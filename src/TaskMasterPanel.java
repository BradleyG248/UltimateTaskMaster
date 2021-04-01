import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
  TaskButton button1 = new TaskButton(new Task("yolo"));
  ToDoListPanel listPanel = new ToDoListPanel("My List");
  JPanel controlPanel = new JPanel();

  /**
   * Creates a new TaskMasterPanel.
   */
  public TaskMasterPanel() {
    this.setPreferredSize(new Dimension(500, 400));
    this.setLayout(new BorderLayout());
    listPanel.addTask(new Task("Fix the leaky roof", 1));
    listPanel.addTask(new Task("Buy clothes", Category.PERSONAL));
    listPanel.addTask(new Task("Get groceries", 10, Category.PERSONAL));
    listPanel.addTask(new Task("File taxes", 5, Category.WORK));
    // Control Panel setup
    JButton getWorkButton = new JButton();
    getWorkButton.setText("Get Work");
    getWorkButton.addActionListener(new GetWorkButtonListener());
    controlPanel.add(getWorkButton);
    add(listPanel, BorderLayout.CENTER);
    add(controlPanel, BorderLayout.SOUTH);
  }

  private class GetWorkButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub

    }

  }
}