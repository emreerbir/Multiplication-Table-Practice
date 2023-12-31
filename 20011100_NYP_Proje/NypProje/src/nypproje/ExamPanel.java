/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nypproje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author emre
 */
public class ExamPanel extends javax.swing.JFrame {

    /**
     * Creates new form ExamPanel
     */
    private int a;
    private int b;
    private double n;
    private int index;
    private Timer timer;
    private int secondsPassed;
    private int secondsPassedForQ;
    private List<int[]> exerciseList;
    private List<String[]> reportList;
    private List<String> report;
    LocalDateTime bugun;
    private String kullaniciAdi;
    private double dogruCevap;
    private double puan;
    
    public ExamPanel(int a, int b, int n, String kullaniciAdi, int seciliRow) {
        index=1;
        this.dogruCevap=0;
        this.a=a;
        this.b=b;
        this.n=n;
        this.kullaniciAdi=kullaniciAdi;
        this.puan=0;
        bugun = LocalDateTime.now();
        report = new ArrayList<>();
        reportList = new ArrayList<>();
        report.add(bugun.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        report.add(kullaniciAdi);
        report.add(String.valueOf(seciliRow));
        
        initComponents();
        updateValues();
        initializeTimer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        soruField = new javax.swing.JLabel();
        aField = new javax.swing.JLabel();
        bField = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        cevapField = new javax.swing.JTextField();
        timerLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        soruField.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        soruField.setText("Soru 1");

        aField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        aField.setText("a");

        bField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        bField.setText("b");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("x");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("=");

        nextButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nextButton.setText("İLERLE");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        cevapField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cevapField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cevapFieldActionPerformed(evt);
            }
        });

        timerLabel.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        timerLabel.setText("TİMER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(nextButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(aField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(soruField)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cevapField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(85, Short.MAX_VALUE))
            .addComponent(timerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soruField)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aField)
                    .addComponent(jLabel4)
                    .addComponent(bField)
                    .addComponent(jLabel5)
                    .addComponent(cevapField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(nextButton)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        if(nextButton.getText().equals("ÇIKIŞ")){
            ChildPanel childPanel = new ChildPanel(kullaniciAdi);
            childPanel.setVisible(true);
            dispose();
        }
        else if(nextButton.getText().equals("BİTİR")){
            updateReport();
            puan = dogruCevap/n*100;
            report.add(String.valueOf(n));
            report.add(String.valueOf(dogruCevap));
            report.add(String.valueOf(puan));
            report.add(String.valueOf(secondsPassed));
            saveReportToSer();
            saveReportListToCsv();
            nextButton.setText("ÇIKIŞ");
            timer.stop();
            String[] reportArray = report.toArray(String[]::new);
            GraphicReportPanel graphicReportPanel = new GraphicReportPanel(reportArray);
            graphicReportPanel.setVisible(true);
            //setVisible(false);
        }else{
            updateReport();
            updateValues();
        }
        //updateValues();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void cevapFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cevapFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cevapFieldActionPerformed
    
    private void updateValues(){
        Random random = new Random();
        if(index==n){
            nextButton.setText("BİTİR");
        }
        cevapField.setText("");
        aField.setText(String.valueOf(random.nextInt(a-1)+1));
        bField.setText(String.valueOf(random.nextInt(b-1)+1));
        soruField.setText("Soru "+String.valueOf(index));
        index++;
    }
    
    private void updateReport(){
        report.add(aField.getText()+"x"+bField.getText());
        report.add(cevapField.getText());
        int a1 = Integer.parseInt(aField.getText());
        int b1 = Integer.parseInt(bField.getText());
        int c1 = Integer.parseInt(cevapField.getText());
        int c2 = a1*b1;
        if(c1==c2){
            report.add("Dogru");
            dogruCevap++;
        }else{
            report.add("Yanlis");
        }
        report.add(String.valueOf(secondsPassedForQ));
        secondsPassedForQ=0;
    }
    
    private void saveReportListToCsv(){
        StringBuilder csvContent = new StringBuilder();

        for (String[] row : reportList) {
            for (String data : row) {
                // Veriyi CSV formatına uygun şekilde ekleyin
                csvContent.append("\"").append(data).append("\",");
            }
            csvContent.append("\n");
        }
        
        try {
            FileWriter writer = new FileWriter("reportList.csv");
            writer.write(csvContent.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Hata durumunda gerekli işlemleri yapabilirsiniz
        }

    }
    
    private void saveReportToSer(){
        
        try {
            FileInputStream fileIn = new FileInputStream("reports.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            // reports.ser dosyasından verileri oku ve reportList'e at
            reportList = (List<String[]>) objectIn.readObject();

            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // Hata durumunda gerekli işlemleri yapabilirsiniz
        }
        
        // reportList'e yeni veriyi ekle
        reportList.add(report.toArray(new String[0])); // report List<String> olarak tanımlı olduğu için List<String[]>'e dönüştürmemiz gerekiyor

           
        try {
            FileOutputStream fileOut = new FileOutputStream("reports.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            // reportList'i ObjectOutputStream'e yaz
            objectOut.writeObject(reportList);

            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Hata durumunda gerekli işlemleri yapabilirsiniz
        }

        
    }
    
    private void initializeTimer() {
        secondsPassed = 0;
        secondsPassedForQ = 0;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsPassed++;
                secondsPassedForQ++;
                updateTimerLabel();
            }
        });
        timer.start();
    }
    
    private void updateTimerLabel() {
        int minutes = secondsPassed / 60;
        int seconds = secondsPassed % 60;
        String timerText = String.format("%02d:%02d", minutes, seconds);
        timerLabel.setText(timerText);
    }
    
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
            java.util.logging.Logger.getLogger(ExamPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamPanel(0,0,0,"emre",0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aField;
    private javax.swing.JLabel bField;
    private javax.swing.JTextField cevapField;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel soruField;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}
