/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.okna;

import DziennikElektroniczny.modele.OcenyTableModel;
import java.sql.*;

/**
 *
 * @author patry
 */
public class OknoPoprawyOceny extends javax.swing.JFrame {

    /**
     * Creates new form OknoPoprawyOceny
     */
    private javax.swing.JFrame oknoSzczegolow;
    private Connection conn;
    private String idUcznia;
    private OcenyTableModel ocenyTableModel;
    private javax.swing.JTable ocenyTable;
    private String przedmiot;
    private javax.swing.JButton poprawOceneButton;

    public OknoPoprawyOceny(javax.swing.JFrame oknoSzczegolow, Connection conn, String uczen, String numerLekcji, String typ, String stopien, String waga,
            OcenyTableModel ocenyTableModel, javax.swing.JTable ocenyTable, String przedmiot, javax.swing.JButton poprawOceneButton, String idUcznia) {
        this.oknoSzczegolow = oknoSzczegolow;
        this.conn = conn;
        this.idUcznia = idUcznia;
        this.ocenyTableModel = ocenyTableModel;
        this.ocenyTable = ocenyTable;
        this.przedmiot = przedmiot;
        this.poprawOceneButton = poprawOceneButton;
        initComponents();
        setVisible(true);

        uczenTextField.setText(uczen);
        lekcjaTextField.setText(numerLekcji);
        typTextField.setText(typ);

        stopienComboBox.removeAllItems();
        stopienComboBox.addItem("1");
        stopienComboBox.addItem("2");
        stopienComboBox.addItem("3");
        stopienComboBox.addItem("4");
        stopienComboBox.addItem("5");
        stopienComboBox.addItem("6");
        stopienComboBox.setSelectedItem(stopien);

        wagaComboBox.removeAllItems();
        wagaComboBox.addItem("1");
        wagaComboBox.addItem("2");
        wagaComboBox.addItem("3");
        wagaComboBox.setSelectedItem(waga);
    }

    private OknoPoprawyOceny() {
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

        oknoPoprawyOcenyPanel = new javax.swing.JPanel();
        tytulLabel = new javax.swing.JLabel();
        uczenLabel = new javax.swing.JLabel();
        lekcjaLabel = new javax.swing.JLabel();
        stopienLabel = new javax.swing.JLabel();
        wagaLabel = new javax.swing.JLabel();
        typLabel = new javax.swing.JLabel();
        uczenTextField = new javax.swing.JTextField();
        lekcjaTextField = new javax.swing.JTextField();
        stopienComboBox = new javax.swing.JComboBox<>();
        wagaComboBox = new javax.swing.JComboBox<>();
        typTextField = new javax.swing.JTextField();
        poprawButton = new javax.swing.JButton();
        anulujButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Popraw ocenę");
        setLocation(new java.awt.Point(800, 350));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tytulLabel.setFont(new java.awt.Font("PT Serif", 1, 18)); // NOI18N
        tytulLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tytulLabel.setText("POPRAW OCENĘ");

        uczenLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        uczenLabel.setText("Uczeń:");

        lekcjaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lekcjaLabel.setText("Lekcja:");

        stopienLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        stopienLabel.setText("Stopień:");

        wagaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        wagaLabel.setText("Waga:");

        typLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        typLabel.setText("Typ:");

        uczenTextField.setEditable(false);

        lekcjaTextField.setEditable(false);

        stopienComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        wagaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        poprawButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        poprawButton.setText("POPRAW");
        poprawButton.setPreferredSize(new java.awt.Dimension(100, 30));
        poprawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poprawButtonActionPerformed(evt);
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

        javax.swing.GroupLayout oknoPoprawyOcenyPanelLayout = new javax.swing.GroupLayout(oknoPoprawyOcenyPanel);
        oknoPoprawyOcenyPanel.setLayout(oknoPoprawyOcenyPanelLayout);
        oknoPoprawyOcenyPanelLayout.setHorizontalGroup(
            oknoPoprawyOcenyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoPoprawyOcenyPanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(poprawButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(anulujButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oknoPoprawyOcenyPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(oknoPoprawyOcenyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tytulLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(oknoPoprawyOcenyPanelLayout.createSequentialGroup()
                        .addGroup(oknoPoprawyOcenyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(oknoPoprawyOcenyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(wagaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(typLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(stopienLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(oknoPoprawyOcenyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wagaComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stopienComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(typTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oknoPoprawyOcenyPanelLayout.createSequentialGroup()
                        .addGroup(oknoPoprawyOcenyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(uczenLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lekcjaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(oknoPoprawyOcenyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(uczenTextField)
                            .addComponent(lekcjaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                .addGap(50, 50, 50))
        );
        oknoPoprawyOcenyPanelLayout.setVerticalGroup(
            oknoPoprawyOcenyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoPoprawyOcenyPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(tytulLabel)
                .addGap(18, 18, 18)
                .addGroup(oknoPoprawyOcenyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uczenLabel)
                    .addComponent(uczenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(oknoPoprawyOcenyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lekcjaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lekcjaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(oknoPoprawyOcenyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stopienLabel)
                    .addComponent(stopienComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(oknoPoprawyOcenyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wagaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wagaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(oknoPoprawyOcenyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(oknoPoprawyOcenyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(poprawButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anulujButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoPoprawyOcenyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoPoprawyOcenyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        oknoSzczegolow.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void anulujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anulujButtonActionPerformed
        oknoSzczegolow.setEnabled(true);
        dispose();
    }//GEN-LAST:event_anulujButtonActionPerformed

    private void poprawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poprawButtonActionPerformed
        ocenyTableModel.poprawOcene(stopienComboBox.getSelectedItem().toString(), typTextField.getText(), wagaComboBox.getSelectedItem().toString(),
                ocenyTable.getSelectedRow());
        OcenyTableModel ocenyTableModel = new OcenyTableModel(conn, idUcznia, przedmiot, "nauczyciel");
        ocenyTableModel.fireTableDataChanged();
        ocenyTable.setModel(ocenyTableModel);
        oknoSzczegolow.setEnabled(true);
        poprawOceneButton.setEnabled(false);
        dispose();
    }//GEN-LAST:event_poprawButtonActionPerformed

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
            java.util.logging.Logger.getLogger(OknoPoprawyOceny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OknoPoprawyOceny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OknoPoprawyOceny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OknoPoprawyOceny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OknoPoprawyOceny().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anulujButton;
    private javax.swing.JLabel lekcjaLabel;
    private javax.swing.JTextField lekcjaTextField;
    private javax.swing.JPanel oknoPoprawyOcenyPanel;
    private javax.swing.JButton poprawButton;
    private javax.swing.JComboBox<String> stopienComboBox;
    private javax.swing.JLabel stopienLabel;
    private javax.swing.JLabel typLabel;
    private javax.swing.JTextField typTextField;
    private javax.swing.JLabel tytulLabel;
    private javax.swing.JLabel uczenLabel;
    private javax.swing.JTextField uczenTextField;
    private javax.swing.JComboBox<String> wagaComboBox;
    private javax.swing.JLabel wagaLabel;
    // End of variables declaration//GEN-END:variables
}