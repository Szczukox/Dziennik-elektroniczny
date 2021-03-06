/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.okna;

import DziennikElektroniczny.modele.ComboBoxModel;
import DziennikElektroniczny.modele.ListaKlasModel;
import DziennikElektroniczny.modele.UczniowieTableModel;
import com.sun.glass.events.KeyEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author patry
 */
public class OknoUcznia extends javax.swing.JFrame {

    /**
     * Creates new form OknoUcznia
     */
    private javax.swing.JFrame oknoListyUczniow;
    private final Connection conn;
    private UczniowieTableModel uczniowieTableModel;
    private javax.swing.JTable uczniowieTable;
    private javax.swing.JButton edytujButton;
    private javax.swing.JButton usunButton;
    private javax.swing.ComboBoxModel klasyComboBoxModel;
    private String tytul;
    private String klasa;

    public OknoUcznia(javax.swing.JFrame oknoListyUczniow, Connection connection, UczniowieTableModel listaUczniowModel, javax.swing.JTable uczniowieTable,
            javax.swing.JButton edytujButton, javax.swing.JButton usunButton, String tytul, String klasa) {
        conn = connection;
        this.oknoListyUczniow = oknoListyUczniow;
        this.uczniowieTableModel = listaUczniowModel;
        this.uczniowieTable = uczniowieTable;
        this.edytujButton = edytujButton;
        this.usunButton = usunButton;
        this.tytul = tytul;
        this.klasa = klasa;
        initComponents();

        ListaKlasModel listaKlasModel = new ListaKlasModel();
        String[] listaKlas = listaKlasModel.listaKlas(conn);
        klasyComboBoxModel = new ComboBoxModel(listaKlas);
        klasyComboBox.setModel(klasyComboBoxModel);

        setTitle(tytul);
        tytulLabel.setText(tytul.toUpperCase());
        setVisible(true);

        if (tytul == "Edytuj wybranego ucznia") {
            imieTextField.setText((String) this.uczniowieTable.getValueAt(this.uczniowieTable.getSelectedRow(), 1));
            nazwiskoTextField.setText((String) this.uczniowieTable.getValueAt(this.uczniowieTable.getSelectedRow(), 2));
            peselTextField.setText((String) this.uczniowieTable.getValueAt(this.uczniowieTable.getSelectedRow(), 3));
            klasyComboBox.setSelectedItem(String.valueOf(this.uczniowieTable.getValueAt(this.uczniowieTable.getSelectedRow(), 4)));
            dodajButton.setText("ZMIEŃ");
        }
    }

    private OknoUcznia() {
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

        oknoUczniaPanel = new javax.swing.JPanel();
        tytulLabel = new javax.swing.JLabel();
        dodajButton = new javax.swing.JButton();
        anulujButton = new javax.swing.JButton();
        imieLabel = new javax.swing.JLabel();
        imieTextField = new javax.swing.JTextField();
        nazwiskoTextField = new javax.swing.JTextField();
        peselTextField = new javax.swing.JTextField();
        klasyComboBox = new javax.swing.JComboBox<>();
        nazwiskoLabel = new javax.swing.JLabel();
        peselLabel = new javax.swing.JLabel();
        klasyLabel = new javax.swing.JLabel();
        obowiazkoweImieLabel = new javax.swing.JLabel();
        obowiazkoweNazwiskoLabel = new javax.swing.JLabel();
        obowiazkowePeselLabel = new javax.swing.JLabel();
        obowiazkoweKlasaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dodaj nowego ucznia");
        setLocation(new java.awt.Point(800, 350));
        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tytulLabel.setFont(new java.awt.Font("PT Serif", 1, 18)); // NOI18N
        tytulLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tytulLabel.setText("DODAJ NOWEGO UCZNIA");

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

        imieLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        imieLabel.setText("Imię:");

        imieTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                imieTextFieldKeyTyped(evt);
            }
        });

        nazwiskoTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nazwiskoTextFieldKeyTyped(evt);
            }
        });

        peselTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                peselTextFieldKeyTyped(evt);
            }
        });

        klasyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        nazwiskoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nazwiskoLabel.setText("Nazwisko:");

        peselLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        peselLabel.setText("PESEL:");

        klasyLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        klasyLabel.setText("Klasa:");

        obowiazkoweImieLabel.setText("*");

        obowiazkoweNazwiskoLabel.setText("*");

        obowiazkowePeselLabel.setText("*");

        obowiazkoweKlasaLabel.setText("*");

        javax.swing.GroupLayout oknoUczniaPanelLayout = new javax.swing.GroupLayout(oknoUczniaPanel);
        oknoUczniaPanel.setLayout(oknoUczniaPanelLayout);
        oknoUczniaPanelLayout.setHorizontalGroup(
            oknoUczniaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoUczniaPanelLayout.createSequentialGroup()
                .addGroup(oknoUczniaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oknoUczniaPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(tytulLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(oknoUczniaPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(imieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(imieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(obowiazkoweImieLabel))
                    .addGroup(oknoUczniaPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(nazwiskoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(nazwiskoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(obowiazkoweNazwiskoLabel))
                    .addGroup(oknoUczniaPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(peselLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(peselTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(obowiazkowePeselLabel))
                    .addGroup(oknoUczniaPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(klasyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(klasyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(obowiazkoweKlasaLabel))
                    .addGroup(oknoUczniaPanelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(dodajButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(anulujButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        oknoUczniaPanelLayout.setVerticalGroup(
            oknoUczniaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoUczniaPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tytulLabel)
                .addGap(30, 30, 30)
                .addGroup(oknoUczniaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oknoUczniaPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(imieLabel))
                    .addGroup(oknoUczniaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(imieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(obowiazkoweImieLabel)))
                .addGap(18, 18, 18)
                .addGroup(oknoUczniaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nazwiskoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(oknoUczniaPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(oknoUczniaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nazwiskoLabel)
                            .addComponent(obowiazkoweNazwiskoLabel))))
                .addGap(18, 18, 18)
                .addGroup(oknoUczniaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(peselTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(oknoUczniaPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(oknoUczniaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(peselLabel)
                            .addComponent(obowiazkowePeselLabel))))
                .addGap(18, 18, 18)
                .addGroup(oknoUczniaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(klasyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(oknoUczniaPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(oknoUczniaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(klasyLabel)
                            .addComponent(obowiazkoweKlasaLabel))))
                .addGap(23, 23, 23)
                .addGroup(oknoUczniaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dodajButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anulujButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoUczniaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoUczniaPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        oknoListyUczniow.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void anulujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anulujButtonActionPerformed
        oknoListyUczniow.setEnabled(true);
        dispose();
    }//GEN-LAST:event_anulujButtonActionPerformed

    private void dodajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajButtonActionPerformed
        boolean czyWypelniono = true;
        String czegoBrakuje = "Nie wypełniono poprawnie następujących obowiązkowych pól:\n";
        if (imieTextField.getText().isEmpty()) {
            czyWypelniono = false;
            czegoBrakuje += "Imię\n";
        }
        if (nazwiskoTextField.getText().isEmpty()) {
            czyWypelniono = false;
            czegoBrakuje += "Nazwisko\n";
        }
        if ((peselTextField.getText().isEmpty()) || (peselTextField.getText().length() != 11)) {
            czyWypelniono = false;
            czegoBrakuje += "PESEL\n";
        }
        if (klasyComboBox.getSelectedItem().toString().equals("---WYBIERZ---")) {
            czyWypelniono = false;
            czegoBrakuje += "Klasa\n";
        }
        if (czyWypelniono) {
            String[] idKlasy = klasyComboBox.getSelectedItem().toString().split("ID: ");
            try {
                if (tytul == "Dodaj nowego ucznia") {
                    uczniowieTableModel.insertRow(
                            imieTextField.getText(),
                            nazwiskoTextField.getText(),
                            peselTextField.getText(),
                            idKlasy[1]);
                } else if (tytul == "Edytuj wybranego ucznia") {
                    uczniowieTableModel.editRow(
                            imieTextField.getText(),
                            nazwiskoTextField.getText(),
                            peselTextField.getText(),
                            idKlasy[1],
                            uczniowieTable.getSelectedRow());
                }
            } catch (SQLException ex) {
                Logger.getLogger(OknoKlasy.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                uczniowieTableModel = new UczniowieTableModel(conn, klasa);
                uczniowieTableModel.fireTableDataChanged();
                uczniowieTable.setModel(uczniowieTableModel);
                oknoListyUczniow.setEnabled(true);
                edytujButton.setEnabled(false);
                usunButton.setEnabled(false);
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, czegoBrakuje + "Proszę wpisać poprawne dane!", "Nie wypełniono poprawnie obowiązkowych pól", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dodajButtonActionPerformed

    private void peselTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_peselTextFieldKeyTyped
        char znak = evt.getKeyChar();
        if (!Character.isDigit(znak) || znak == KeyEvent.VK_BACKSPACE || znak == KeyEvent.VK_DELETE) {
            evt.consume();
        }
    }//GEN-LAST:event_peselTextFieldKeyTyped

    private void imieTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imieTextFieldKeyTyped
        char znak = evt.getKeyChar();
        if (!Character.isLetter(znak)) {
            evt.consume();
        }
    }//GEN-LAST:event_imieTextFieldKeyTyped

    private void nazwiskoTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nazwiskoTextFieldKeyTyped
        char znak = evt.getKeyChar();
        if (!Character.isLetter(znak)) {
            evt.consume();
        }
    }//GEN-LAST:event_nazwiskoTextFieldKeyTyped

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
            java.util.logging.Logger.getLogger(OknoUcznia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OknoUcznia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OknoUcznia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OknoUcznia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OknoUcznia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anulujButton;
    private javax.swing.JButton dodajButton;
    private javax.swing.JLabel imieLabel;
    private javax.swing.JTextField imieTextField;
    private javax.swing.JComboBox<String> klasyComboBox;
    private javax.swing.JLabel klasyLabel;
    private javax.swing.JLabel nazwiskoLabel;
    private javax.swing.JTextField nazwiskoTextField;
    private javax.swing.JLabel obowiazkoweImieLabel;
    private javax.swing.JLabel obowiazkoweKlasaLabel;
    private javax.swing.JLabel obowiazkoweNazwiskoLabel;
    private javax.swing.JLabel obowiazkowePeselLabel;
    private javax.swing.JPanel oknoUczniaPanel;
    private javax.swing.JLabel peselLabel;
    private javax.swing.JTextField peselTextField;
    private javax.swing.JLabel tytulLabel;
    // End of variables declaration//GEN-END:variables
}
