package src.PromptWindows;

import src.Task;
import src.TaskDatabase;
import java.util.Date;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;
import src.TaskifyApp;
import javax.swing.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class AddTaskWindow extends javax.swing.JFrame {
    private TaskifyApp parent;
    private String currentUser;
    
    public AddTaskWindow(TaskifyApp taskifyApp, String username) {
        initComponents();

        // 🛠 Custom configuration goes here
        SpinnerDateModel timeModel = new SpinnerDateModel();
        timeSpinner.setModel(timeModel);

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "hh:mm a");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date());
        timeSpinner.setToolTipText("Use arrow keys or type time in hh:mm AM/PM format");

        timePreviewLabel.setText("Selected time: --:--");
        timePreviewLabel.setFont(new java.awt.Font("Monospaced", 0, 12));
        timePreviewLabel.setForeground(java.awt.Color.WHITE);

        timeSpinner.addChangeListener(e -> {
            Date time = (Date) timeSpinner.getValue();
            SimpleDateFormat fmt = new SimpleDateFormat("hh:mm a");
            timePreviewLabel.setText("Selected time: " + fmt.format(time));
        });

        setLocationRelativeTo(parent);
        this.parent = taskifyApp;
        this.currentUser = username;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        taskTitleLabel = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField();
        descLabel = new javax.swing.JLabel();
        scrollableTextArea = new javax.swing.JScrollPane();
        descTextArea = new javax.swing.JTextArea();
        confirmButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        selectDeadline = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        timeSpinner = new javax.swing.JSpinner();
        timePreviewLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(590, 455));

        container.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        taskTitleLabel.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        taskTitleLabel.setText("Task Title:");

        titleTextField.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        descLabel.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        descLabel.setText("Description:");

        descTextArea.setColumns(20);
        descTextArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        descTextArea.setRows(5);
        scrollableTextArea.setViewportView(descTextArea);

        confirmButton.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        selectDeadline.setFocusable(false);
        selectDeadline.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel1.setText("Select time:");

        timePreviewLabel.setText("\"Selected time: --:--\"");

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(taskTitleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(descLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollableTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addContainerGap(193, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addGap(44, 44, 44)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(containerLayout.createSequentialGroup()
                        .addComponent(confirmButton)
                        .addGap(18, 18, 18)
                        .addComponent(timePreviewLabel)))
                .addGap(73, 73, 73))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taskTitleLabel)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descLabel)
                            .addComponent(scrollableTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(selectDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(timeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelButton)
                            .addComponent(confirmButton)))
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(timePreviewLabel)))
                .addContainerGap(106, Short.MAX_VALUE))
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

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        String title = titleTextField.getText().trim();
        String description = descTextArea.getText().trim();
        Date selectedDate = selectDeadline.getDate();
        Date selectedTime = (Date) timeSpinner.getValue();

        if (title.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Title cannot be empty!");
            return;
        }

        if (selectedDate == null || selectedTime == null) {
            JOptionPane.showMessageDialog(this, "Please select a valid date and time!");
            return;
        }

        // Merge date and time properly
        Calendar finalCal = Calendar.getInstance();
        finalCal.setTime(selectedDate);

        Calendar timeCal = Calendar.getInstance();
        timeCal.setTime(selectedTime);

        finalCal.set(Calendar.HOUR, timeCal.get(Calendar.HOUR));
        finalCal.set(Calendar.MINUTE, timeCal.get(Calendar.MINUTE));
        finalCal.set(Calendar.SECOND, 0);
        finalCal.set(Calendar.AM_PM, timeCal.get(Calendar.AM_PM));

        Date finalDeadline = finalCal.getTime();

        Task newTask = new Task(title, description, new java.sql.Timestamp(finalDeadline.getTime()));
        boolean success = TaskDatabase.insertTask(newTask);
        if (success) {
            parent.refreshCalendarHighlighting();
            parent.addTaskToPanel(newTask);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to save task.");
        }
    }//GEN-LAST:event_confirmButtonActionPerformed
    
    
    public static void main(String args[]) {
        FlatDarkLaf.setup();

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(() -> {
            TaskifyApp taskifyApp = new TaskifyApp("testuser");
            taskifyApp.setVisible(true);

            AddTaskWindow addWindow = new AddTaskWindow(taskifyApp, "testuser");
            addWindow.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JPanel container;
    private javax.swing.JLabel descLabel;
    private javax.swing.JTextArea descTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scrollableTextArea;
    private com.toedter.calendar.JDateChooser selectDeadline;
    private javax.swing.JLabel taskTitleLabel;
    private javax.swing.JLabel timePreviewLabel;
    private javax.swing.JSpinner timeSpinner;
    private javax.swing.JTextField titleTextField;
    // End of variables declaration//GEN-END:variables
}
