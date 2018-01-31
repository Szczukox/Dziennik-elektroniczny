/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.okna;

import DziennikElektroniczny.modele.PrzedmiotyTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author patry
 */
public class OknoPrzedmiotu extends javax.swing.JFrame {

    private javax.swing.JFrame oknoListyKlas;
    private final Connection conn;
    private PrzedmiotyTableModel przedmiotyTableModel;
    private javax.swing.JTable przedmiotyTable;
    private javax.swing.JButton edytujButton;
    private javax.swing.JButton usunButton;
    private String tytul;

    /**
     * Creates new form OknoPrzedmiotu
     */
    public OknoPrzedmiotu(javax.swing.JFrame oknoListyKlas, Connection connection, PrzedmiotyTableModel listaPrzedmiotowModel, javax.swing.JTable przedmiotyTable, javax.swing.JButton edytujButton, javax.swing.JButton usunButton, String tytul) {
        conn = connection;
        this.oknoListyKlas = oknoListyKlas;
        this.przedmiotyTableModel = listaPrzedmiotowModel;
        this.przedmiotyTable = przedmiotyTable;
        this.edytujButton = edytujButton;
        this.usunButton = usunButton;
        this.tytul = tytul;
        initComponents();
        setTitle(tytul);
        tytulLabel.setText(tytul.toUpperCase());
        setVisible(true);

        if (tytul == "Edytuj wybrany przedmiot") {
            nazwaTextField.setText((String) this.przedmiotyTable.getValueAt(this.przedmiotyTable.getSelectedRow(), 0));
            dodajButton.setText("ZMIEŃ");
        }
    }

    private OknoPrzedmiotu() {
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

        oknoPrzedmiotuPanel = new javax.swing.JPanel();
        tytulLabel = new javax.swing.JLabel();
        nazwaLabel = new javax.swing.JLabel();
        nazwaTextField = new javax.swing.JTextField();
        obowiazkoweNazwaLabel = new javax.swing.JLabel();
        dodajButton = new javax.swing.JButton();
        anulujButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dodaj nowy przedmiot");
        setLocation(new java.awt.Point(800, 350));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tytulLabel.setFont(new java.awt.Font("PT Serif", 1, 18)); // NOI18N
        tytulLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tytulLabel.setText("DODAJ NOWY PRZEDMIOT");

        nazwaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nazwaLabel.setText("Nazwa:");

        obowiazkoweNazwaLabel.setText("*");

        dodajButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        dodajButton.setText("DODAJ");
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

        javax.swing.GroupLayout oknoPrzedmiotuPanelLayout = new javax.swing.GroupLayout(oknoPrzedmiotuPanel);
        oknoPrzedmiotuPanel.setLayout(oknoPrzedmiotuPanelLayout);
        oknoPrzedmiotuPanelLayout.setHorizontalGroup(
            oknoPrzedmiotuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oknoPrzedmiotuPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(tytulLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oknoPrzedmiotuPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(nazwaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nazwaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(obowiazkoweNazwaLabel)
                .addGap(37, 37, 37))
            .addGroup(oknoPrzedmiotuPanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(dodajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(anulujButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        oknoPrzedmiotuPanelLayout.setVerticalGroup(
            oknoPrzedmiotuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoPrzedmiotuPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tytulLabel)
                .addGap(30, 30, 30)
                .addGroup(oknoPrzedmiotuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nazwaLabel)
                    .addComponent(nazwaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(obowiazkoweNazwaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addGroup(oknoPrzedmiotuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dodajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anulujButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoPrzedmiotuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoPrzedmiotuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        oknoListyKlas.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void anulujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anulujButtonActionPerformed
        oknoListyKlas.setEnabled(true);
        dispose();
    }//GEN-LAST:event_anulujButtonActionPerformed

    private void dodajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajButtonActionPerformed
        boolean czyWypelniono = true;
        String czegoBrakuje = "Nie wypełniono następujących obowiązkowych pól:\n";
        if (nazwaTextField.getText().isEmpty()) {
            czyWypelniono = false;
            czegoBrakuje += "Nazwa\n";
        }
        if (czyWypelniono) {
            try {
                if (tytul == "Dodaj nowy przedmiot") {
                    przedmiotyTableModel.insertRow(nazwaTextField.getText());
                } else if (tytul == "Edytuj wybrany przedmiot") {
                    przedmiotyTableModel.editRow(nazwaTextField.getText(), przedmiotyTable.getSelectedRow());
                }
            } catch (SQLException ex) {
                Logger.getLogger(OknoKlasy.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                przedmiotyTableModel = new PrzedmiotyTableModel(conn);
                przedmiotyTableModel.fireTableDataChanged();
                przedmiotyTable.setModel(przedmiotyTableModel);
                oknoListyKlas.setEnabled(true);
                edytujButton.setEnabled(false);
                usunButton.setEnabled(false);
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, czegoBrakuje + "Proszę je uzupełnić", "Nie wypełniono obowiązkowych pól", JOptionPane.ERROR_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(OknoPrzedmiotu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OknoPrzedmiotu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OknoPrzedmiotu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OknoPrzedmiotu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OknoPrzedmiotu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anulujButton;
    private javax.swing.JButton dodajButton;
    private javax.swing.JLabel nazwaLabel;
    private javax.swing.JTextField nazwaTextField;
    private javax.swing.JLabel obowiazkoweNazwaLabel;
    private javax.swing.JPanel oknoPrzedmiotuPanel;
    private javax.swing.JLabel tytulLabel;
    // End of variables declaration//GEN-END:variables
}
