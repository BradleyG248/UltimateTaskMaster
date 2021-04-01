import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;

public class ToDoListPanel extends JPanel {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private ToDoList list;

  public ToDoListPanel(String listName) {
    list = new ToDoList(listName);
    JLabel listLabel = new JLabel(listName);
    add(listLabel);
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
  }

  public void addTask(Task task) {
    if (task != null) {
      list.addTask(task);
      TaskButton taskButton = new TaskButton(task);
      add(taskButton);
      revalidate();
    }
  }

  public Task getWork() {
    return list.getWork();
  }

}
