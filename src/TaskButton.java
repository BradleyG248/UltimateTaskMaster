import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Color;

public class TaskButton extends JButton {
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Task task;

  public TaskButton(Task task) {
    this.task = task;
    if (task.isComplete()) {
      setForeground(Color.BLACK);
    } else {
      setForeground(Color.GRAY);
    }
    this.setText(task.toString());
    addActionListener(new TaskButtonListener());
  }

  private class TaskButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      if (task.isComplete()) {
        task.setComplete(false);
        setForeground(Color.GRAY);
      } else {
        task.setComplete(true);
        setForeground(Color.BLACK);
      }
      setText(task.toString());
    }

  }

}
