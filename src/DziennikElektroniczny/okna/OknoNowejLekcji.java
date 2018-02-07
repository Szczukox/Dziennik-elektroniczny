/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.okna;

import DziennikElektroniczny.modele.ComboBoxModel;
import DziennikElektroniczny.modele.LekcjeModel;
import DziennikElektroniczny.modele.ListaLekcjiModel;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author patry
 */
public class OknoNowejLekcji extends javax.swing.JFrame {

    /**
     * Creates new form OknoNowejLekcji
     */
    private javax.swing.JFrame oknoLekcji;
    private final Connection conn;
    private String klasaIPrzedmiot;
    private javax.swing.JComboBox lekcjeComboBox;

    public OknoNowejLekcji(javax.swing.JFrame oknoLekcji, Connection conn, String lekcja, String klasaIPrzedmiot, javax.swing.JComboBox lekcjeComboBox) {
        this.oknoLekcji = oknoLekcji;
        this.conn = conn;
        this.klasaIPrzedmiot = klasaIPrzedmiot;
        this.lekcjeComboBox = lekcjeComboBox;
        initComponents();
        setVisible(true);

        numerLekcjiTextField.setText(lekcja);
        DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        dataTextField.setText(dateFormat.format(timestamp));
    }

    private OknoNowejLekcji() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        oknoNowejLekcjiPanel = new javax.swing.JPanel();
        tytulLabel = new javax.swing.JLabel();
        numerLekcjiLabel = new javax.swing.JLabel();
        tematLabel = new javax.swing.JLabel();
        numerLekcjiTextField = new javax.swing.JTextField();
        dodajButton = new javax.swing.JButton();
        anulujButton = new javax.swing.JButton();
        tematScrollPane = new javax.swing.JScrollPane();
        tematTextArea = new javax.swing.JTextArea();
        dataLabel = new javax.swing.JLabel();
        dataTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dodaj nową lekcję");
        setLocation(new java.awt.Point(800, 350));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tytulLabel.setFont(new java.awt.Font("PT Serif", 1, 18)); // NOI18N
        tytulLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tytulLabel.setText("DODAJ NOWĄ LEKCJĘ");

        numerLekcjiLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        numerLekcjiLabel.setText("Numer lekcji:");

        tematLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tematLabel.setText("Temat:");

        numerLekcjiTextField.setEditable(false);

        dodajButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        dodajButton.setText("DODAJ");
        dodajButton.setPreferredSize(new java.awt.Dimension(100, 30));
        dodajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajButtonActionPerformed(evt);
            }
        });

        anulujButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        anulujButton.setText("ANULUJ");
        anulujButton.setPreferredSize(new java.awt.Dimension(100, 30));
        anulujButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anulujButtonActionPerformed(evt);
            }
        });

        tematTextArea.setColumns(20);
        tematTextArea.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tematTextArea.setLineWrap(true);
        tematTextArea.setRows(3);
        tematTextArea.setWrapStyleWord(true);
        tematScrollPane.setViewportView(tematTextArea);

        dataLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dataLabel.setText("Data:");

        dataTextField.setEditable(false);

        javax.swing.GroupLayout oknoNowejLekcjiPanelLayout = new javax.swing.GroupLayout(oknoNowejLekcjiPanel);
        oknoNowejLekcjiPanel.setLayout(oknoNowejLekcjiPanelLayout);
        oknoNowejLekcjiPanelLayout.setHorizontalGroup(
            oknoNowejLekcjiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoNowejLekcjiPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(oknoNowejLekcjiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tytulLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(oknoNowejLekcjiPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(dodajButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(anulujButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(oknoNowejLekcjiPanelLayout.createSequentialGroup()
                        .addGroup(oknoNowejLekcjiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numerLekcjiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(tematLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(oknoNowejLekcjiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(numerLekcjiTextField)
                            .addComponent(tematScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(dataTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        oknoNowejLekcjiPanelLayout.setVerticalGroup(
            oknoNowejLekcjiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoNowejLekcjiPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tytulLabel)
                .addGap(30, 30, 30)
                .addGroup(oknoNowejLekcjiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numerLekcjiLabel)
                    .addComponent(numerLekcjiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(oknoNowejLekcjiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataLabel)
                    .addComponent(dataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(oknoNowejLekcjiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tematLabel)
                    .addComponent(tematScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(oknoNowejLekcjiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anulujButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dodajButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoNowejLekcjiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoNowejLekcjiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        oknoLekcji.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void anulujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anulujButtonActionPerformed
        oknoLekcji.setEnabled(true);
        dispose();
    }//GEN-LAST:event_anulujButtonActionPerformed

    private void dodajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajButtonActionPerformed
        LekcjeModel lekcjeModel = new LekcjeModel(conn, klasaIPrzedmiot);
        lekcjeModel.dodajLekcje(numerLekcjiTextField.getText(), tematTextArea.getText(), Timestamp.valueOf(dataTextField.getText()));
        ListaLekcjiModel listaLekcjiModel = new ListaLekcjiModel();
        String[] listaLekcji = listaLekcjiModel.listaLekcji(conn, klasaIPrzedmiot);
        ComboBoxModel lekcjeComboBoxModel = new ComboBoxModel(listaLekcji);
        lekcjeComboBox.setModel(lekcjeComboBoxModel);
        oknoLekcji.setEnabled(true);
        dispose();
    }//GEN-LAST:event_dodajButtonActionPerformed

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
            java.util.logging.Logger.getLogger(OknoNowejLekcji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OknoNowejLekcji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OknoNowejLekcji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OknoNowejLekcji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OknoNowejLekcji().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anulujButton;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JTextField dataTextField;
    private javax.swing.JButton dodajButton;
    private javax.swing.JLabel numerLekcjiLabel;
    private javax.swing.JTextField numerLekcjiTextField;
    private javax.swing.JPanel oknoNowejLekcjiPanel;
    private javax.swing.JLabel tematLabel;
    private javax.swing.JScrollPane tematScrollPane;
    private javax.swing.JTextArea tematTextArea;
    private javax.swing.JLabel tytulLabel;
    // End of variables declaration//GEN-END:variables
}
