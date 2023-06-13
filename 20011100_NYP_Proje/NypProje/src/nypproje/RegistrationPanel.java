/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nypproje;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emre
 */
public class RegistrationPanel extends javax.swing.JFrame {

    /**
     * Creates new form RegistrationPanel
     */
    public HashMap<String, String> credentialsMap;
    
    public RegistrationPanel() {
        initComponents();
        initializeCredentialsMap();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cocukAdiField = new javax.swing.JTextField();
        sifreField = new javax.swing.JTextField();
        kaydetButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cocukTable = new javax.swing.JTable();
        mainPageButton = new javax.swing.JButton();

        jButton3.setText("ANASAYFA");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Çocuk Adı:");

        jLabel2.setText("Şifre:");

        kaydetButton.setText("KAYDET");
        kaydetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaydetButtonActionPerformed(evt);
            }
        });

        cocukTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Çocuk Adı", "Şifre"
            }
        ));
        cocukTable.setShowGrid(true);
        jScrollPane1.setViewportView(cocukTable);

        mainPageButton.setText("KAPAT");
        mainPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainPageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mainPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(sifreField))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cocukAdiField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(kaydetButton)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cocukAdiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sifreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(kaydetButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kaydetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaydetButtonActionPerformed
        // TODO add your handling code here:
        String cocukAdi = cocukAdiField.getText();
        String sifre = sifreField.getText();
        credentialsMap.put(cocukAdi, sifre);
        
        cocukAdiField.setText("");
        sifreField.setText("");
        
        JOptionPane.showMessageDialog(this, "Çocuk kaydedildi!");
        
        // Alıştırmaları SER dosyasına kaydet
        try {
            saveToSer(credentialsMap);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "SER dosyasına kaydedilirken bir hata oluştu!", "Hata", JOptionPane.ERROR_MESSAGE);
        }

        // Alıştırmaları güncelle
        updateTable();
    }//GEN-LAST:event_kaydetButtonActionPerformed

    private void mainPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainPageButtonActionPerformed
        // TODO add your handling code here:
        MainAdminPanel mainAdminPanel = new MainAdminPanel();
        mainAdminPanel.setVisible(true);
        dispose();
    }//GEN-LAST:event_mainPageButtonActionPerformed

    public void initializeCredentialsMap() {
        credentialsMap = new HashMap<>();
        try {
            File file = new File("child.ser");
        
            // Ser dosyası mevcut değilse boş bir dosya oluştur
            if (!file.exists()) {
                file.createNewFile();
                updateTable();
                return;
            }
            
            FileInputStream fileIn = new FileInputStream("child.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            credentialsMap = (HashMap<String, String>) objectIn.readObject();

            objectIn.close();
            fileIn.close();
            updateTable();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            //credentialsMap = new HashMap<>(); // Okuma başarısız olursa boş bir harita oluşturulur
        }
    }
    
    public void saveToSer(HashMap<String, String> credentialsMap) throws IOException{
        try {
            FileOutputStream fileOut = new FileOutputStream("child.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(credentialsMap);

            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void updateTable(){
        DefaultTableModel model = (DefaultTableModel) cocukTable.getModel();
        model.setRowCount(0);
        int index = 1;
        for (Map.Entry<String, String> entry : credentialsMap.entrySet()) {
            String cocukAdi = entry.getKey();
            String sifre = entry.getValue();
            Object[] eklenecek = {index, cocukAdi, sifre};
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
            java.util.logging.Logger.getLogger(RegistrationPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cocukAdiField;
    public javax.swing.JTable cocukTable;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kaydetButton;
    private javax.swing.JButton mainPageButton;
    private javax.swing.JTextField sifreField;
    // End of variables declaration//GEN-END:variables
}