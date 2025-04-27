package src;

import com.formdev.flatlaf.FlatDarkLaf;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import src.PromptWindows.*;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;


public class TaskifyApp extends javax.swing.JFrame {
    private String currentUser;

    private Map<LocalDate, List<Task>> tasksByDate = new HashMap<>();
    private Map<String, Task> tasksByTitle = new HashMap<>();
    
    public TaskifyApp(String username) {
        this.currentUser = username;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Taskify - " + username);
        currentUsername.setText(username);
        loadTasksFromDatabase();
        updateCalendarDisplay();
        setResizable(false);
    }
    
    public JTabbedPane getTaskEntries() {
        revalidate();
        repaint();
        return taskEntries;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        tabPanel = new javax.swing.JTabbedPane();
        menuPanel = new javax.swing.JPanel();
        logOutButton = new javax.swing.JButton();
        currentUsername = new javax.swing.JLabel();
        tasksPanel = new javax.swing.JPanel();
        taskListContainer = new javax.swing.JPanel();
        taskEntries = new javax.swing.JTabbedPane();
        addTaskButton = new javax.swing.JButton();
        removeTaskButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        calendarPanel = new javax.swing.JPanel();
        calendarContainer = new javax.swing.JPanel();
        calendar = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        container.setBackground(new java.awt.Color(39, 39, 39));

        tabPanel.setBackground(new java.awt.Color(102, 102, 102));
        tabPanel.setForeground(new java.awt.Color(255, 255, 255));
        tabPanel.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabPanel.setToolTipText("");
        tabPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabPanel.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        menuPanel.setBackground(new java.awt.Color(51, 51, 51));
        menuPanel.setForeground(new java.awt.Color(255, 255, 255));
        menuPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        logOutButton.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
        logOutButton.setText("Log out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        currentUsername.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        currentUsername.setForeground(new java.awt.Color(255, 255, 255));
        currentUsername.setText("[Username here]");

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(454, 454, 454)
                        .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(currentUsername)))
                .addContainerGap(442, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(currentUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 368, Short.MAX_VALUE)
                .addComponent(logOutButton)
                .addGap(40, 40, 40))
        );

        tabPanel.addTab("Menu", menuPanel);

        tasksPanel.setBackground(new java.awt.Color(51, 51, 51));
        tasksPanel.setForeground(new java.awt.Color(255, 255, 255));
        tasksPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        taskListContainer.setBackground(new java.awt.Color(51, 51, 51));
        taskListContainer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        taskEntries.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        javax.swing.GroupLayout taskListContainerLayout = new javax.swing.GroupLayout(taskListContainer);
        taskListContainer.setLayout(taskListContainerLayout);
        taskListContainerLayout.setHorizontalGroup(
            taskListContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(taskEntries, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );
        taskListContainerLayout.setVerticalGroup(
            taskListContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(taskEntries, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        addTaskButton.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        addTaskButton.setForeground(new java.awt.Color(255, 255, 255));
        addTaskButton.setText("Add");
        addTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskButtonActionPerformed(evt);
            }
        });

        removeTaskButton.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        removeTaskButton.setForeground(new java.awt.Color(255, 255, 255));
        removeTaskButton.setText("Remove");
        removeTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTaskButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tasksPanelLayout = new javax.swing.GroupLayout(tasksPanel);
        tasksPanel.setLayout(tasksPanelLayout);
        tasksPanelLayout.setHorizontalGroup(
            tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tasksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addTaskButton)
                    .addComponent(removeTaskButton)
                    .addComponent(editButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taskListContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        tasksPanelLayout.setVerticalGroup(
            tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tasksPanelLayout.createSequentialGroup()
                .addGroup(tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tasksPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(taskListContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tasksPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(addTaskButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeTaskButton)
                        .addGap(18, 18, 18)
                        .addComponent(editButton)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tabPanel.addTab("Tasks", tasksPanel);

        calendarPanel.setBackground(new java.awt.Color(51, 51, 51));

        calendarContainer.setBackground(new java.awt.Color(51, 51, 51));
        calendarContainer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        javax.swing.GroupLayout calendarContainerLayout = new javax.swing.GroupLayout(calendarContainer);
        calendarContainer.setLayout(calendarContainerLayout);
        calendarContainerLayout.setHorizontalGroup(
            calendarContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendar, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE))
        );
        calendarContainerLayout.setVerticalGroup(
            calendarContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendar, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout calendarPanelLayout = new javax.swing.GroupLayout(calendarPanel);
        calendarPanel.setLayout(calendarPanelLayout);
        calendarPanelLayout.setHorizontalGroup(
            calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(calendarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        calendarPanelLayout.setVerticalGroup(
            calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(calendarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tabPanel.addTab("Calendar", calendarPanel);

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPanel)
                .addContainerGap())
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanel)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTaskButtonActionPerformed
        AddTaskWindow addWindow = new AddTaskWindow(this, this.currentUser);
        addWindow.setVisible(true);
    }//GEN-LAST:event_addTaskButtonActionPerformed

    private void removeTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeTaskButtonActionPerformed
        int selectedIndex = taskEntries.getSelectedIndex();
    if (selectedIndex != -1) {
        String taskTitle = taskEntries.getTitleAt(selectedIndex);

        Task taskToDelete = tasksByTitle.get(taskTitle);
        if (taskToDelete == null) {
            JOptionPane.showMessageDialog(this, "Task not found.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete the task: " + taskTitle + "?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = TaskDatabase.deleteTask(taskTitle);
            if (success) {
                taskEntries.remove(selectedIndex);

                LocalDate deadline = taskToDelete.getDeadline().toLocalDateTime().toLocalDate();
                List<Task> tasksOnDate = tasksByDate.get(deadline);
                if (tasksOnDate != null) {
                    tasksOnDate.remove(taskToDelete);
                    if (tasksOnDate.isEmpty()) {
                        tasksByDate.remove(deadline);
                    }
                }

                tasksByTitle.remove(taskTitle);

                JOptionPane.showMessageDialog(this, "Task deleted successfully.");

                // Crucially, refresh the calendar highlighting here
                refreshCalendarHighlighting();

            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete task from database.");
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a task to remove.");
    }
    }//GEN-LAST:event_removeTaskButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        Task selectedTask = getCurrentlySelectedTask();
        if (selectedTask != null) {
            new EditTaskWindow(this, selectedTask).setVisible(true); // Modify this line
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task first!");
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        new LogIn().setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_logOutButtonActionPerformed

    private Task getCurrentlySelectedTask() {
        int selectedIndex = taskEntries.getSelectedIndex();
        if (selectedIndex == -1) return null;

        String title = taskEntries.getTitleAt(selectedIndex);
        // Implement logic to find the Task object by title
        for (List<Task> taskList : tasksByDate.values()) {
            for (Task task : taskList) {
                if (task.getTitle().equals(title)) {
                    return task;
                }
            }
        }
        return null;
    }
    
    public void removeTaskFromMaps(String oldTitle) {
        Task task = tasksByTitle.remove(oldTitle);
        if (task != null && task.getDeadline() != null) {
            LocalDate oldDate = task.getDeadline().toLocalDateTime().toLocalDate();
            List<Task> tasksOnDate = tasksByDate.get(oldDate);
            if (tasksOnDate != null) {
                tasksOnDate.remove(task);
                if (tasksOnDate.isEmpty()) {
                    tasksByDate.remove(oldDate);
                }
            }
        }
    }

    public void addTaskToMaps(Task task) {
        tasksByTitle.put(task.getTitle(), task);
        LocalDate newDate = task.getDeadline().toLocalDateTime().toLocalDate();
        tasksByDate.computeIfAbsent(newDate, k -> new ArrayList<>()).add(task);
    }
    
    public void addTaskToPanel(Task task) {
    JPanel taskPanel = new JPanel();
    taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
    taskPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    taskPanel.setBackground(new Color(60, 60, 60));

    JLabel descLabel = new JLabel("<html><b>Description:</b> " + task.getDescription() + "</html>");
    descLabel.setName("descriptionLabel");

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
    String formatted = task.getDeadline() != null ? format.format(task.getDeadline()) : "None";

    JLabel deadlineLabel = new JLabel("<html><b>Deadline:</b> " + formatted + "</html>");
    deadlineLabel.setName("deadlineLabel");

    descLabel.setForeground(Color.WHITE);
    deadlineLabel.setForeground(Color.WHITE);

    taskPanel.add(descLabel);
    taskPanel.add(Box.createRigidArea(new Dimension(0, 5)));
    taskPanel.add(deadlineLabel);

    taskEntries.addTab(task.getTitle(), taskPanel);
    taskEntries.setSelectedComponent(taskPanel);

    tasksByTitle.put(task.getTitle(), task);
}
       
    public void loadTasksFromDatabase() {
        tasksByDate.clear();
        tasksByTitle.clear();

        try (Connection connect = InsertUserToDatabase.LocalDatabaseConnect();
             Statement statement = connect.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT taskTitle, taskDescription, taskDeadline FROM task")) {

            while (resultSet.next()) {
                String title = resultSet.getString("taskTitle");
                String description = resultSet.getString("taskDescription");
                java.sql.Date deadline = resultSet.getDate("taskDeadline");

        // Create new Task object here
                Task task = new Task(title, description, new java.sql.Timestamp(deadline.getTime())); // ✅


        // Add to tasksByTitle map
                tasksByTitle.put(title, task);

        // Add to both the UI and tasksByDate map
                addTaskToPanel(task);
    
        if (deadline != null) {
            LocalDate localDate = deadline.toLocalDate();
            tasksByDate.computeIfAbsent(localDate, k -> new ArrayList<>())
                      .add(task);
        }
    }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        taskEntries.revalidate();
        taskEntries.repaint();
}
    
    private void updateCalendarDisplay() {
        // Add date evaluator to highlight task dates
        // For older JCalendar versions:
        calendar.getDayChooser().addDateEvaluator(new TaskDateEvaluator(tasksByDate));

        // Refresh calendar UI
        calendar.updateUI();

        // Add click listener for dates
        calendar.addPropertyChangeListener("calendar", evt -> {
            Date selectedDate = calendar.getDate();
            if (selectedDate != null) {
                showTasksForDate(selectedDate);
            }
    });
}
    
    private void showTasksForDate(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        java.util.List<Task> tasks = tasksByDate.get(localDate); // Fully qualified or use import

        if (tasks != null && !tasks.isEmpty()) {
            StringBuilder message = new StringBuilder("Tasks for " + localDate.toString() + ":\n\n");
            for (Task task : tasks) {
                message.append("• ").append(task.getTitle());
                if (task.isCompleted()) {
                    message.append(" (Completed)");
                }
                message.append("\n");
            }
            JOptionPane.showMessageDialog(this, message.toString());
        } else {
            JOptionPane.showMessageDialog(this, "No tasks for " + localDate.toString());
      }
}

    private void openTaskDetails(Task task) {
        // Reuse your existing edit window or create a new one
        EditTaskWindow editWindow = new EditTaskWindow(this, task);
        editWindow.setVisible(true);
}
    
    public static void main(String args[]) {
        FlatDarkLaf.setup();
        
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch( Exception ex ) {
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    public class TaskDateEvaluator implements com.toedter.calendar.IDateEvaluator {
    private Date currentDateBeingEvaluated;
    private Map<LocalDate, List<Task>> tasksByDate; // Add this line

    public TaskDateEvaluator(Map<LocalDate, List<Task>> tasksByDate) { // Modify constructor
        this.tasksByDate = tasksByDate;
    }

    @Override
    public boolean isSpecial(Date date) {
        currentDateBeingEvaluated = date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        LocalDate localDate = LocalDate.of(year, month, day);
        return tasksByDate.containsKey(localDate);
    }

    @Override
    public Color getSpecialForegroundColor() {
        return Color.WHITE;
    }

    @Override
    public Color getSpecialBackroundColor() {
        if (currentDateBeingEvaluated == null) return null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDateBeingEvaluated);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        LocalDate localDate = LocalDate.of(year, month, day);
        List<Task> tasks = tasksByDate.getOrDefault(localDate, new ArrayList<>());
        boolean hasIncomplete = tasks.stream().anyMatch(task -> !task.isCompleted());

        System.out.println("Evaluating background for: " + localDate + ", tasks present: " + tasksByDate.containsKey(localDate) + ", has incomplete: " + hasIncomplete);

        return hasIncomplete ? new Color(0, 150, 0) : new Color(100, 100, 100);
    }

    @Override
    public String getSpecialTooltip() {
        return "Tasks due";
    }

    @Override public boolean isInvalid(Date date) { return false; }
    @Override public Color getInvalidForegroundColor() { return null; }
    @Override public Color getInvalidBackroundColor() { return null; }
    @Override public String getInvalidTooltip() { return null; }
}
    
    public void refreshCalendarHighlighting() {
    loadAllTasksForCalendar(); // Reload all tasks needed for highlighting

    // Temporarily set the calendar to a different date and then back
    Date currentDate = calendar.getDate();
    Calendar tempCal = Calendar.getInstance();
    tempCal.add(Calendar.DAY_OF_MONTH, 1); // Move one day forward
    calendar.setDate(tempCal.getTime());
    calendar.setDate(currentDate); // Set it back to the original date

    // Add the new DateEvaluator
    calendar.getDayChooser().addDateEvaluator(new TaskDateEvaluator(tasksByDate));

    calendar.getDayChooser().repaint(); // Repaint the DayChooser
    calendar.repaint(); // Repaint the entire calendar
}
    
    private void loadAllTasksForCalendar() {
    tasksByDate.clear();
    List<Task> allTasks = TaskDatabase.getAllTasks();
    for (Task task : allTasks) {
        LocalDate deadline = task.getDeadline().toLocalDateTime().toLocalDate();
        tasksByDate.computeIfAbsent(deadline, k -> new ArrayList<>()).add(task);
    }
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTaskButton;
    private com.toedter.calendar.JCalendar calendar;
    private javax.swing.JPanel calendarContainer;
    private javax.swing.JPanel calendarPanel;
    private javax.swing.JPanel container;
    private javax.swing.JLabel currentUsername;
    private javax.swing.JButton editButton;
    private javax.swing.JButton logOutButton;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton removeTaskButton;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTabbedPane taskEntries;
    private javax.swing.JPanel taskListContainer;
    private javax.swing.JPanel tasksPanel;
    // End of variables declaration//GEN-END:variables
}
