package forms;

import dao.*;
import java.sql.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewAttendance extends javax.swing.JFrame {

    public ViewAttendance() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dateChooserFrom.setDateFormatString("yyyy-MM-dd");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        dateChooserFrom = new com.toedter.calendar.JDateChooser();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblCheckedIn = new javax.swing.JLabel();
        lblCheckedOut = new javax.swing.JLabel();
        btnResetFilter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1101, 501));
        setMinimumSize(new java.awt.Dimension(1101, 501));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel1.setText("Entries");

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(userTable);

        dateChooserFrom.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        dateChooserFrom.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateChooserFromPropertyChange(evt);
            }
        });

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel2.setText("Date");

        jLabel4.setText("Search ID");

        jLabel5.setText("Checked In:");

        jLabel6.setText("Checked Out:");

        lblCheckedIn.setForeground(new java.awt.Color(51, 255, 0));
        lblCheckedIn.setText("----------");

        lblCheckedOut.setForeground(new java.awt.Color(255, 0, 0));
        lblCheckedOut.setText("----------");

        btnResetFilter.setText("Reset");
        btnResetFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(479, 479, 479)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblCheckedIn))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblCheckedOut))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(btnResetFilter)))
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateChooserFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(314, 314, 314)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtSearch))))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChooserFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(56, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblCheckedIn))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblCheckedOut))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnResetFilter)
                        .addGap(129, 129, 129))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetFilterActionPerformed
        // TODO add your handling code here:
        txtSearch.setText("");
        dateChooserFrom.setDate(null);

        loadDataInTable();
    }//GEN-LAST:event_btnResetFilterActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        loadDataInTable();
    }//GEN-LAST:event_formComponentShown

    private void dateChooserFromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateChooserFromPropertyChange
        // TODO add your handling code here:
        loadDataInTable();
    }//GEN-LAST:event_dateChooserFromPropertyChange

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        loadDataInTable();
    }//GEN-LAST:event_txtSearchKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAttendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResetFilter;
    private com.toedter.calendar.JDateChooser dateChooserFrom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCheckedIn;
    private javax.swing.JLabel lblCheckedOut;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables

    private void loadDataInTable() {
        List<String> columns = new ArrayList<>(Arrays.asList("ID", "Date", "Check In", "Check Out"));

        String searchText = txtSearch.getText().toString();

        Date fromDateFromCal = dateChooserFrom.getDate();

        LocalDate fromDate = null;

        if (fromDateFromCal != null) {
            fromDate = fromDateFromCal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

//        Date toDateFromCal = dateChooserTo.getDate();
//
//        LocalDate toDate = null;
//
//        if (toDateFromCal != null) {
//            toDate = toDateFromCal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        }
//
//        Long daysBetween = null;
//        if (fromDate != null && toDate != null) {
//            daysBetween = countWeekDays(fromDate, toDate);
//        }
//        searchText = "0242310005101819";
        String sqlQuery = "SELECT userid, date, checkin, checkout from userattendance ";
//        System.out.println(searchText);
        if (searchText != null) {
//            System.out.println("yo2");
            sqlQuery += "where userid like '%" + searchText + "%'";
            if (fromDate != null) {
                sqlQuery += "and date='" + fromDate + "';";
            }
        } else {
            if (fromDate != null) {
                sqlQuery += "where date='" + fromDate + "';";
            }
        }
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns.toArray());
        userTable.setModel(model);
        
//        System.out.println(sqlQuery);
        
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);
            Long checkedInCount = 0l, checkedOutCount = 0l;
            while(rs.next()){
                List<Object> row = new ArrayList<>();
                row.add(rs.getString("userid"));
                row.add(rs.getString("date"));
                row.add(rs.getString("checkin"));
                row.add(rs.getString("checkout"));

                if(rs.getString("checkout")!=null) checkedOutCount++;
                if(rs.getString("checkin")!=null) checkedInCount++;
                model.addRow(row.toArray());
            }
            lblCheckedIn.setText(checkedInCount.toString());
            lblCheckedOut.setText(checkedOutCount.toString());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong.");
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace(); 
        }

    }

//    private Long countWeekDays(LocalDate start, LocalDate end) {
//        long count = 0;
//        LocalDate date = start;
//        while (date.isBefore(end) || date.equals(end)) {
//            if (!(date.getDayOfWeek() == DayOfWeek.FRIDAY)) {
//                count++;
//            }
//            date.plusDays(1);
//        }
//        return count;
//    }
}
