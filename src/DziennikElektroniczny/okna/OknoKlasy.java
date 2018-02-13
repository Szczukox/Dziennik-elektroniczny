/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.okna;

import DziennikElektroniczny.modele.ComboBoxModel;
import DziennikElektroniczny.modele.KlasyTableModel;
import DziennikElektroniczny.modele.ListaNauczycieliModel;
import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author patry
 */
public class OknoKlasy extends javax.swing.JFrame {

    /**
     * Creates new form OknoKlasy
     */
    private javax.swing.JFrame oknoListyKlas;
    private final Connection conn;
    private KlasyTableModel klasyTableModel;
    private javax.swing.JTable klasyTable;
    private javax.swing.JButton edytujButton;
    private javax.swing.JButton usunButton;
    private javax.swing.ComboBoxModel nauczycieleComboBoxModel;
    private String tytul;

    public OknoKlasy(javax.swing.JFrame oknoListyKlas, Connection connection, KlasyTableModel listaKlasModel, javax.swing.JTable klasyTable, javax.swing.JButton edytujButton, javax.swing.JButton usunButton, String tytul) {
        conn = connection;
        this.oknoListyKlas = oknoListyKlas;
        this.klasyTableModel = listaKlasModel;
        this.klasyTable = klasyTable;
        this.edytujButton = edytujButton;
        this.usunButton = usunButton;
        this.tytul = tytul;

        initComponents();
        ListaNauczycieliModel listaNauczycieliModel = new ListaNauczycieliModel();
        String[] listaNauczycieli = listaNauczycieliModel.listaNauczycieli(conn);
        nauczycieleComboBoxModel = new ComboBoxModel(listaNauczycieli);
        nauczycieleComboBox.setModel(nauczycieleComboBoxModel);
        setTitle(tytul);
        tytulLabel.setText(tytul.toUpperCase());
        setVisible(true);

        if (tytul == "Edytuj wybraną klasę") {
            nazwaOknoKlasyTextField.setText((String) this.klasyTable.getValueAt(this.klasyTable.getSelectedRow(), 1));
            rokPowstaniaOknoKlasyTextField.setText((String) this.klasyTable.getValueAt(this.klasyTable.getSelectedRow(), 2));
            profilOknoKlasyTextField.setText((String) this.klasyTable.getValueAt(this.klasyTable.getSelectedRow(), 3));
            nauczycieleComboBox.setSelectedItem(String.valueOf(this.klasyTable.getValueAt(this.klasyTable.getSelectedRow(), 4)));
            dodajOknoKlasyButton.setText("ZMIEŃ");
        }
    }

    private OknoKlasy() {
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

        oknoKlasyPanel = new javax.swing.JPanel();
        tytulLabel = new javax.swing.JLabel();
        anulujOknoKlasyButton = new javax.swing.JButton();
        dodajOknoKlasyButton = new javax.swing.JButton();
        nazwaOknoKlasyLabel = new javax.swing.JLabel();
        rokPowstaniaOknoKlasyLabel = new javax.swing.JLabel();
        profilOknoKlasyLabel = new javax.swing.JLabel();
        nazwaOknoKlasyTextField = new javax.swing.JTextField();
        rokPowstaniaOknoKlasyTextField = new javax.swing.JTextField();
        profilOknoKlasyTextField = new javax.swing.JTextField();
        obowiazkoweNazwaLabel = new javax.swing.JLabel();
        obowiazkoweRokPowstaniaLabel = new javax.swing.JLabel();
        obowiazkoweProfilLabel = new javax.swing.JLabel();
        wychowawcaLabel = new javax.swing.JLabel();
        nauczycieleComboBox = new javax.swing.JComboBox<>();
        obowiazkoweWychowawcaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dodaj nową klasę");
        setLocation(new java.awt.Point(800, 350));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tytulLabel.setFont(new java.awt.Font("PT Serif", 1, 18)); // NOI18N
        tytulLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tytulLabel.setText("DODAJ NOWĄ KLASĘ");

        anulujOknoKlasyButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        anulujOknoKlasyButton.setText("ANULUJ");
        anulujOknoKlasyButton.setPreferredSize(new java.awt.Dimension(100, 30));
        anulujOknoKlasyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anulujOknoKlasyButtonActionPerformed(evt);
            }
        });

        dodajOknoKlasyButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        dodajOknoKlasyButton.setText("DODAJ");
        dodajOknoKlasyButton.setPreferredSize(new java.awt.Dimension(100, 30));
        dodajOknoKlasyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajOknoKlasyButtonActionPerformed(evt);
            }
        });

        nazwaOknoKlasyLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nazwaOknoKlasyLabel.setText("Nazwa:");

        rokPowstaniaOknoKlasyLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rokPowstaniaOknoKlasyLabel.setText("Rok powstania:");

        profilOknoKlasyLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        profilOknoKlasyLabel.setText("Profil:");

        nazwaOknoKlasyTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nazwaOknoKlasyTextFieldKeyTyped(evt);
            }
        });

        rokPowstaniaOknoKlasyTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rokPowstaniaOknoKlasyTextFieldKeyTyped(evt);
            }
        });

        profilOknoKlasyTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                profilOknoKlasyTextFieldKeyTyped(evt);
            }
        });

        obowiazkoweNazwaLabel.setText("*");

        obowiazkoweRokPowstaniaLabel.setText("*");

        obowiazkoweProfilLabel.setText("*");

        wychowawcaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        wychowawcaLabel.setText("Wychowawca:");

        nauczycieleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        obowiazkoweWychowawcaLabel.setText("*");

        javax.swing.GroupLayout oknoKlasyPanelLayout = new javax.swing.GroupLayout(oknoKlasyPanel);
        oknoKlasyPanel.setLayout(oknoKlasyPanelLayout);
        oknoKlasyPanelLayout.setHorizontalGroup(
            oknoKlasyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoKlasyPanelLayout.createSequentialGroup()
                .addGroup(oknoKlasyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oknoKlasyPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(tytulLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(oknoKlasyPanelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(dodajOknoKlasyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(anulujOknoKlasyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(oknoKlasyPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(oknoKlasyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nazwaOknoKlasyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(profilOknoKlasyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rokPowstaniaOknoKlasyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(wychowawcaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(oknoKlasyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profilOknoKlasyTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(nauczycieleComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nazwaOknoKlasyTextField)
                            .addComponent(rokPowstaniaOknoKlasyTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(oknoKlasyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(obowiazkoweNazwaLabel)
                            .addComponent(obowiazkoweRokPowstaniaLabel)
                            .addComponent(obowiazkoweProfilLabel)
                            .addComponent(obowiazkoweWychowawcaLabel))))
                .addGap(37, 37, 37))
        );
        oknoKlasyPanelLayout.setVerticalGroup(
            oknoKlasyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoKlasyPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tytulLabel)
                .addGap(30, 30, 30)
                .addGroup(oknoKlasyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nazwaOknoKlasyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nazwaOknoKlasyLabel)
                    .addComponent(obowiazkoweNazwaLabel))
                .addGap(18, 18, 18)
                .addGroup(oknoKlasyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rokPowstaniaOknoKlasyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(obowiazkoweRokPowstaniaLabel)
                    .addComponent(rokPowstaniaOknoKlasyLabel))
                .addGap(18, 18, 18)
                .addGroup(oknoKlasyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profilOknoKlasyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profilOknoKlasyLabel)
                    .addComponent(obowiazkoweProfilLabel))
                .addGap(18, 18, 18)
                .addGroup(oknoKlasyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wychowawcaLabel)
                    .addComponent(nauczycieleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(obowiazkoweWychowawcaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(oknoKlasyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dodajOknoKlasyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anulujOknoKlasyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(oknoKlasyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoKlasyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        oknoListyKlas.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void anulujOknoKlasyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anulujOknoKlasyButtonActionPerformed
        oknoListyKlas.setEnabled(true);
        dispose();
    }//GEN-LAST:event_anulujOknoKlasyButtonActionPerformed

    private void dodajOknoKlasyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajOknoKlasyButtonActionPerformed
        boolean czyWypelniono = true;
        String czegoBrakuje = "Nie wypełniono poprawnie następujących obowiązkowych pól:\n";
        if (nazwaOknoKlasyTextField.getText().isEmpty()) {
            czyWypelniono = false;
            czegoBrakuje += "Nazwa\n";
        }
        if (rokPowstaniaOknoKlasyTextField.getText().isEmpty() || rokPowstaniaOknoKlasyTextField.getText().toString().length() != 4) {
            czyWypelniono = false;
            czegoBrakuje += "Rok powstania\n";
        }
        if (profilOknoKlasyTextField.getText().isEmpty()) {
            czyWypelniono = false;
            czegoBrakuje += "Profil\n";
        }
        if (nauczycieleComboBox.getSelectedItem().toString().equals("---WYBIERZ---")) {
            czyWypelniono = false;
            czegoBrakuje += "Wychowawca\n";
        }
        if (czyWypelniono) {
            try {
                String[] idNauczyciela = nauczycieleComboBox.getSelectedItem().toString().split("ID: ");
                if (tytul == "Dodaj nową klasę") {
                    klasyTableModel.insertRow(
                            nazwaOknoKlasyTextField.getText(),
                            rokPowstaniaOknoKlasyTextField.getText(),
                            profilOknoKlasyTextField.getText(),
                            idNauczyciela[1]);
                } else if (tytul == "Edytuj wybraną klasę") {
                    klasyTableModel.editRow(
                            nazwaOknoKlasyTextField.getText(),
                            rokPowstaniaOknoKlasyTextField.getText(),
                            profilOknoKlasyTextField.getText(),
                            idNauczyciela[1],
                            klasyTable.getSelectedRow());
                }
            } catch (SQLException ex) {
                Logger.getLogger(OknoKlasy.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                klasyTableModel = new KlasyTableModel(conn);
                klasyTableModel.fireTableDataChanged();
                klasyTable.setModel(klasyTableModel);
                oknoListyKlas.setEnabled(true);
                edytujButton.setEnabled(false);
                usunButton.setEnabled(false);
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, czegoBrakuje + "Proszę wpisać poprawne dane!", "Nie wypełniono poprawnie obowiązkowych pól", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dodajOknoKlasyButtonActionPerformed

    private void nazwaOknoKlasyTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nazwaOknoKlasyTextFieldKeyTyped
        char znak = evt.getKeyChar();
        if (!Character.isLetter(znak)) {
            evt.consume();
        }
    }//GEN-LAST:event_nazwaOknoKlasyTextFieldKeyTyped

    private void rokPowstaniaOknoKlasyTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rokPowstaniaOknoKlasyTextFieldKeyTyped
        char znak = evt.getKeyChar();
        if (!Character.isDigit(znak) || znak == KeyEvent.VK_BACKSPACE || znak == KeyEvent.VK_DELETE) {
            evt.consume();
        }
    }//GEN-LAST:event_rokPowstaniaOknoKlasyTextFieldKeyTyped

    private void profilOknoKlasyTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_profilOknoKlasyTextFieldKeyTyped
        char znak = evt.getKeyChar();
        if (!Character.isLetter(znak)) {
            evt.consume();
        }
    }//GEN-LAST:event_profilOknoKlasyTextFieldKeyTyped

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
            java.util.logging.Logger.getLogger(OknoKlasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OknoKlasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OknoKlasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OknoKlasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OknoKlasy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anulujOknoKlasyButton;
    private javax.swing.JButton dodajOknoKlasyButton;
    private javax.swing.JComboBox<String> nauczycieleComboBox;
    private javax.swing.JLabel nazwaOknoKlasyLabel;
    private javax.swing.JTextField nazwaOknoKlasyTextField;
    private javax.swing.JLabel obowiazkoweNazwaLabel;
    private javax.swing.JLabel obowiazkoweProfilLabel;
    private javax.swing.JLabel obowiazkoweRokPowstaniaLabel;
    private javax.swing.JLabel obowiazkoweWychowawcaLabel;
    private javax.swing.JPanel oknoKlasyPanel;
    private javax.swing.JLabel profilOknoKlasyLabel;
    private javax.swing.JTextField profilOknoKlasyTextField;
    private javax.swing.JLabel rokPowstaniaOknoKlasyLabel;
    private javax.swing.JTextField rokPowstaniaOknoKlasyTextField;
    private javax.swing.JLabel tytulLabel;
    private javax.swing.JLabel wychowawcaLabel;
    // End of variables declaration//GEN-END:variables
}
