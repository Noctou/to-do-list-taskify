package src.PromptWindows;

import src.Task;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;
import src.TaskifyApp;
import java.util.Date;
import javax.swing.*;
import java.awt.Component;
import java.text.SimpleDateFormat;
import src.TaskDatabase;
import java.util.Calendar;


public class EditTaskWindow extends javax.swing.JFrame {

    private TaskifyApp taskifyApp;
    private Task task;
    
    public EditTaskWindow(TaskifyApp taskifyApp, Task task) {
        initComponents();
        setLocationRelativeTo(null);
        this.taskifyApp = taskifyApp;
        
        SpinnerDateModel timeModel = new SpinnerDateModel();
        jSpinner1.setModel(timeModel);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(jSpinner1, "HH:mm");
        jSpinner1.setEditor(timeEditor);
        jSpinner1.setValue(new Date(task.getDeadline().getTime()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        descLabel = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        descTextArea = new javax.swing.JTextArea();
        titleField = new javax.swing.JTextField();
        selectDeadline = new com.toedter.calendar.JDateChooser();
        cancelButton = new javax.swing.JButton();
        confirmButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        titleLabel.setText("Task Title:");

        descLabel.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        descLabel.setText("Description:");

        descTextArea.setColumns(20);
        descTextArea.setRows(5);
        scrollPane.setViewportView(descTextArea);

        cancelButton.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        confirmButton.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel1.setText("Select Time:");

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(titleLabel)
                        .addGap(25, 25, 25)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cancelButton)
                            .addComponent(selectDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmButton)
                            .addGroup(containerLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(descLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descLabel)
                            .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(confirmButton))
                .addContainerGap(109, Short.MAX_VALUE))
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
        JTabbedPane taskEntries = taskifyApp.getTaskEntries();
        int selectedIndex = taskEntries.getSelectedIndex();

        String getTitle = titleField.getText();
        String getDescription = descTextArea.getText();
        Date deadline = selectDeadline.getDate();
        
        if (getTitle == null || getTitle.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Task title cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } if (deadline == null) {
            JOptionPane.showMessageDialog(this, "Please select a valid deadline date!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Calendar dateCal = Calendar.getInstance();
        dateCal.setTime(selectDeadline.getDate());

        Calendar timeCal = Calendar.getInstance();
        timeCal.setTime((Date) jSpinner1.getValue());

        dateCal.set(Calendar.HOUR_OF_DAY, timeCal.get(Calendar.HOUR_OF_DAY));
        dateCal.set(Calendar.MINUTE, timeCal.get(Calendar.MINUTE));
        dateCal.set(Calendar.SECOND, 0);

        Date finalDateTime = dateCal.getTime();

        
        String originalTitle = taskEntries.getTitleAt(selectedIndex);
        
        boolean success = TaskDatabase.updateTask(originalTitle, getTitle, getDescription, deadline);

        if(success) {
            taskEntries.setTitleAt(selectedIndex, getTitle);

            taskifyApp.removeTaskFromMaps(originalTitle);

            Task updatedTask = new Task(getTitle, getDescription, new java.sql.Timestamp(deadline.getTime()));
            taskifyApp.addTaskToMaps(updatedTask);

            JPanel taskPanel = (JPanel) taskEntries.getComponentAt(selectedIndex);

            for(Component comp : taskPanel.getComponents()) {
                if (comp instanceof JLabel) {
                    JLabel label = (JLabel) comp;
                    if ("titleLabel".equals(comp.getName())) {
                        label.setText(getTitle);
                    } else if ("deadlineLabel".equals(comp.getName())) {
                        String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(deadline);
                        label.setText(formattedDate);
                    }
                } else if (comp instanceof JTextArea && "descriptionArea".equals(comp.getName())) {
                    ((JTextArea) comp).setText(getDescription);
                }
            }
            taskifyApp.refreshCalendarHighlighting();

            taskPanel.revalidate();
            taskPanel.repaint();

            JOptionPane.showMessageDialog(this, "Task updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update task in the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_confirmButtonActionPerformed
    
    public static void main(String args[]) {
        FlatDarkLaf.setup();

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JPanel container;
    private javax.swing.JLabel descLabel;
    private javax.swing.JTextArea descTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JScrollPane scrollPane;
    private com.toedter.calendar.JDateChooser selectDeadline;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
