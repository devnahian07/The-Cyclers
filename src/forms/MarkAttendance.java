package forms;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import dao.ConnectionProvider; // Ensure this is correct or implemented in your project
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.Timer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import utility.BDUtility;

public class MarkAttendance extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private ExecutorService executor = Executors.newSingleThreadExecutor(this);
    private volatile boolean running = true;
//    ImageIcon imgg;

    public MarkAttendance() {
        initComponents();

//        JLabel thumb = new JLabel();
//        imgg = new ImageIcon("yooo.gif");
//        thumb.setIcon(imgg);
        
        initWebcam();
        
        
        
        Timer timer = new Timer(1, e -> updateTime());
        timer.start();
    }

    public void updateTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm:ss aa");
        lblTime1.setText(simpleDateFormat.format(new Date()));
        lblTime2.setText(simpleDateFormat2.format(new Date()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        webCamPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTime1 = new javax.swing.JLabel();
        lblCheckInCheckOut = new javax.swing.JLabel();
        lblTime2 = new javax.swing.JLabel();
        btnViewAttendance = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel1.setText("The Cyclers");

        webCamPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel2.setText("Date:");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel3.setText("Time:");

        lblTime1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        lblTime1.setText("Time");

        lblCheckInCheckOut.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        lblTime2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        lblTime2.setText("Time");

        btnViewAttendance.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnViewAttendance.setText("Admin");
        btnViewAttendance.setFocusPainted(false);
        btnViewAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAttendanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(579, 579, 579)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(webCamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCheckInCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTime2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(123, 123, 123))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnViewAttendance)
                .addGap(274, 274, 274))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnViewAttendance)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblTime1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblTime2))
                        .addGap(296, 296, 296)
                        .addComponent(lblCheckInCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(webCamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAttendanceActionPerformed
        // TODO add your handling code here:
        BDUtility.openForm(ViewAttendance.class.getSimpleName(), new ViewAttendance());
        
    }//GEN-LAST:event_btnViewAttendanceActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarkAttendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnViewAttendance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCheckInCheckOut;
    private javax.swing.JLabel lblTime1;
    private javax.swing.JLabel lblTime2;
    private javax.swing.JPanel webCamPanel;
    // End of variables declaration//GEN-END:variables

//    Map<String, String> resultMap = new HashMap<String, String>();
    
    String id;

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }

            try {
                Result result = null;
                BufferedImage image = null;

                if (webcam.isOpen()) {
                    if ((image = webcam.getImage()) == null) {
                        continue;
                    }
                }

                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                try {
                    result = new MultiFormatReader().decode(bitmap);
                } catch (NotFoundException ex) {

                }

                if (result != null) {
//                    String jsonString = result.getText();
                    id = result.getText();
                    checkInCheckOut();
//                    System.out.println(id);
//                    System.out.println(jsonString);
//                    Gson gson = new Gson();
//                    java.lang.reflect.Type type = new TypeToken<Map<String, String>>() {
//                    }.getType();
//
//                    resultMap = gson.fromJson(jsonString, type);
                }

            } catch (Exception ex) {

            }
        } while (running);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    private void stopWebCam() {
        if (webcam != null && webcam.isOpen()) {
            webcam.close();
        }
    }

    private void initWebcam() {
        webcam = Webcam.getDefault();
//        webcam = Webcam.getWebcamByName("Droidcam /dev/video2");
//        webcam = Webcam.getWebcamByName("video1");
        if (webcam != null) {
            Dimension[] resolutions = webcam.getViewSizes();
            Dimension maxResolution = resolutions[resolutions.length - 1];

            if (webcam.isOpen()) {
                webcam.close();
            }

            webcam.setViewSize(maxResolution);
            webcam.open();

            panel = new WebcamPanel(webcam);
            panel.setPreferredSize(maxResolution);
//            panel.setFPSDisplayed(true);

            webCamPanel.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 689, 518));
            executor.execute(this);
            executor.shutdown();
        } else {
            System.out.println("Issue with webcam.");
        }
    }

    private void checkInCheckOut() throws HeadlessException, SQLException {
        String popUpHeader = null;
        String popUpMessage = null;
        Color color = null;
        
        System.out.println(id);
        
        Connection con = (Connection) ConnectionProvider.getCon();
        Statement st = (Statement) con.createStatement();

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Connection connection = ConnectionProvider.getCon();
//        ResultSet rs = st.executeQuery("select * from userattendance where userid=" + id + ";");
        ResultSet rs = st.executeQuery("select * from userattendance where date='"+currentDate.format(dateFormatter)+"' and userid="+id+";");
        if (rs.next()) {
            System.out.println("yo");
            String checkOutDateTime = rs.getString(4);
            
            if(checkOutDateTime != null){
                popUpMessage = "Already Checked Out!";
                popUpHeader = "Invalid Checkout";
                showPopUpForCertainDuration(popUpMessage, popUpHeader, JOptionPane.ERROR_MESSAGE);
                return ;
            }

            String checkInDateTime = rs.getString(3);
            LocalDateTime checkInLocalDateTime = LocalDateTime.parse(checkInDateTime, dateTimeFormatter);
            Duration duration = Duration.between(checkInLocalDateTime, currentDateTime);

            long hours = duration.toHours();
            long minutes = duration.minusHours(hours).toMinutes();
//            long seconds = duration.minusHours(hours).minusMinutes(minutes).getSeconds();
            
            int f = 0;
            
            if (minutes >= 2) {
                f = 1;
            }

            String updateQuery = "update userattendance set checkout=? where date=? and userid = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, currentDateTime.format(dateTimeFormatter));
            preparedStatement.setString(2, currentDate.format(dateFormatter));
            preparedStatement.setString(3, id);

            preparedStatement.executeUpdate();
            popUpHeader = "Checkout";
            String late = "";
            if(f == 1) late = ". Due to late check out additional fee were deducted.";
            popUpMessage = id + " checked out at " + currentDateTime.format(dateTimeFormatter) + late;
            color = Color.RED;
        } else{
            String insertQuery = "INSERT INTO userattendance (userid,date,checkin) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, currentDate.format(dateFormatter));
            preparedStatement.setString(3, currentDateTime.format(dateTimeFormatter));
            
            preparedStatement.executeUpdate();
            
            popUpHeader = "CheckIn";
            popUpMessage = id + " checked in at " + currentDateTime.format(dateTimeFormatter);
            color = Color.GREEN;
        }
        
        lblCheckInCheckOut.setHorizontalAlignment(JLabel.CENTER);
        lblCheckInCheckOut.setText(popUpHeader);
        lblCheckInCheckOut.setForeground(color);
        lblCheckInCheckOut.setBackground(Color.DARK_GRAY);
        lblCheckInCheckOut.setOpaque(true);
        
        showPopUpForCertainDuration(popUpMessage, popUpHeader, JOptionPane.INFORMATION_MESSAGE);
    }

    private void showPopUpForCertainDuration(String popUpMessage, String popUpHeader, Integer iconId) throws HeadlessException{
        final JOptionPane optionPane = new JOptionPane(popUpMessage, iconId);
        final JDialog dialog = optionPane.createDialog(popUpHeader);
        
        Timer timer = new Timer(5000, (ActionEvent e) -> {
            dialog.dispose();
            clearUserDetails();
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
    }
    
    private void clearUserDetails() {
        lblCheckInCheckOut.setText("");
        lblCheckInCheckOut.setBackground(null);
        lblCheckInCheckOut.setForeground(null);
        lblCheckInCheckOut.setOpaque(false);
    }
}
