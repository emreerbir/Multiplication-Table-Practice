/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nypproje;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emre
 */
public class ReportPanel extends javax.swing.JFrame {

    /**
     * Creates new form ReportPanel
     */
    private List<String[]> reportList;
    
    public ReportPanel() {
        reportList = new ArrayList<>();
        initComponents();
        loadReportsFromSer();
        updateTable();
    }

    public void setReportList(List<String[]> reportList) {
        this.reportList = reportList;
    }

    public JTable getReportTable() {
        return reportTable;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        reportTable = new javax.swing.JTable();
        detailButton = new javax.swing.JButton();
        mainPageButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        downloadButton = new javax.swing.JButton();
        mesaj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        reportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rapor ID", "Çocuk Adı", "Alıştırma Kodu", "Puan", "Doğru/Yanlış", "Süre", "Katılım Tarihi"
            }
        ));
        reportTable.setShowGrid(true);
        jScrollPane1.setViewportView(reportTable);

        detailButton.setText("Detay Göster");
        detailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailButtonActionPerformed(evt);
            }
        });

        mainPageButton.setText("KAPAT");
        mainPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainPageButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setText("RAPORLAR");

        downloadButton.setText("İNDİR");
        downloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadButtonActionPerformed(evt);
            }
        });

        mesaj.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(detailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(downloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(397, 397, 397)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 516, Short.MAX_VALUE)
                .addComponent(mainPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(442, 442, 442))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(detailButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mainPageButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(downloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void downloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadButtonActionPerformed
        // TODO add your handling code here:
        mesaj.setText("");
        DefaultTableModel model = (DefaultTableModel) reportTable.getModel();
        int seciliRow = reportTable.getSelectedRow();
        if(seciliRow == -1){
            if(reportTable.getRowCount()==0){
                mesaj.setText("Lütfen rapor ekleyiniz.");
            }else{
                mesaj.setText("Lütfen rapor seciniz.");
            }
        }else{
            saveReportListToCsv(seciliRow);
        }
    }//GEN-LAST:event_downloadButtonActionPerformed

    private void detailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailButtonActionPerformed
        // TODO add your handling code here:
        int seciliRow = reportTable.getSelectedRow();
        
        if(seciliRow == -1){
            if(reportTable.getRowCount()==0){
                mesaj.setText("Lütfen rapor ekleyiniz.");
            }else{
                mesaj.setText("Lütfen rapor seciniz.");
            }
        }else{
            String[] row = reportList.get(seciliRow);
            GraphicReportPanel graphicReportPanel = new GraphicReportPanel(row);
            graphicReportPanel.setVisible(true);
        }
    }//GEN-LAST:event_detailButtonActionPerformed

    private void mainPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainPageButtonActionPerformed
        // TODO add your handling code here:
        MainAdminPanel mainAdminPanel = new MainAdminPanel();
        mainAdminPanel.setVisible(true);
        dispose();
    }//GEN-LAST:event_mainPageButtonActionPerformed
    
    public void saveReportListToCsv(int index){
        StringBuilder csvContent = new StringBuilder();
        String[] row = reportList.get(index);
        for (String data : row) {
            // Veriyi CSV formatına uygun şekilde ekleyin
            csvContent.append("\"").append(data).append("\",");
        }        
        
        try {
            FileWriter writer = new FileWriter("rapor"+index+1+row[1]+".csv");
            writer.write(csvContent.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Hata durumunda gerekli işlemleri yapabilirsiniz
        }

    }
    
    private void loadReportsFromSer(){
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
    }
    
    public void updateTable(){
        DefaultTableModel model = (DefaultTableModel)reportTable.getModel();
        model.setRowCount(0);
        int index = 1;
        int len;
        for (String[] report : reportList) {
            len = report.length - 1;
            double yanlis = Double.parseDouble(report[len - 3]) - Double.parseDouble(report[len - 2]);
            Object[] eklenecek = {index, report[1], report[2], report[len-1], report[len-2]+"/"+yanlis, report[len], report[0]};
            model.addRow(eklenecek);
            index++;
        }
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
            java.util.logging.Logger.getLogger(ReportPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton detailButton;
    private javax.swing.JButton downloadButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainPageButton;
    private javax.swing.JLabel mesaj;
    private javax.swing.JTable reportTable;
    // End of variables declaration//GEN-END:variables
}