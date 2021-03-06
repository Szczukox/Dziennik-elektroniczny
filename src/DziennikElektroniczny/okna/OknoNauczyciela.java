/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.okna;

import DziennikElektroniczny.modele.NauczycieleTableModel;
import com.sun.glass.events.KeyEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author patry
 */
public class OknoNauczyciela extends javax.swing.JFrame {

    /**
     * Creates new form OknoNauczyciela
     */
    private javax.swing.JFrame oknoListyNauczycieli;
    private final Connection conn;
    private NauczycieleTableModel nauczycieleTableModel;
    private javax.swing.JTable nauczycieleTable;
    private javax.swing.JButton edytujButton;
    private javax.swing.JButton usunButton;
    private String tytul;

    public OknoNauczyciela(javax.swing.JFrame oknoListyNauczycieli, Connection connection, NauczycieleTableModel nauczycieleTableModel, javax.swing.JTable nauczycieleTable, javax.swing.JButton edytujButton, javax.swing.JButton usunButton, String tytul) {
        conn = connection;
        this.oknoListyNauczycieli = oknoListyNauczycieli;
        this.nauczycieleTableModel = nauczycieleTableModel;
        this.nauczycieleTable = nauczycieleTable;
        this.edytujButton = edytujButton;
        this.usunButton = usunButton;
        this.tytul = tytul;
        initComponents();
        setTitle(tytul);
        tytulLabel.setText(tytul.toUpperCase());
        setVisible(true);

        if (tytul == "Edytuj wybranego nauczyciela") {
            imieOknoNauczycielaTextField.setText((String) this.nauczycieleTable.getValueAt(this.nauczycieleTable.getSelectedRow(), 1));
            nazwiskoOknoNauczycielaTextField.setText((String) this.nauczycieleTable.getValueAt(this.nauczycieleTable.getSelectedRow(), 2));
            peselOknoNauczycielaTextField.setText((String) this.nauczycieleTable.getValueAt(this.nauczycieleTable.getSelectedRow(), 3));
            dodajButton.setText("ZMIEŃ");
        }
    }

    private OknoNauczyciela() {
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

        oknoNauczycielaPanel = new javax.swing.JPanel();
        tytulLabel = new javax.swing.JLabel();
        dodajButton = new javax.swing.JButton();
        anulujButton = new javax.swing.JButton();
        imieOknoNauczycielaLabel = new javax.swing.JLabel();
        nazwiskoOknoNauczycielaLabel = new javax.swing.JLabel();
        peselOknoNauczycielaLabel = new javax.swing.JLabel();
        imieOknoNauczycielaTextField = new javax.swing.JTextField();
        nazwiskoOknoNauczycielaTextField = new javax.swing.JTextField();
        peselOknoNauczycielaTextField = new javax.swing.JTextField();
        obowiazkoweImieLabel = new javax.swing.JLabel();
        obowiazkoweNazwiskoLabel = new javax.swing.JLabel();
        obowiazkowePeselLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dodaj nowego nauczyciela");
        setLocation(new java.awt.Point(800, 350));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        oknoNauczycielaPanel.setMinimumSize(new java.awt.Dimension(400, 300));

        tytulLabel.setFont(new java.awt.Font("PT Serif", 1, 18)); // NOI18N
        tytulLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tytulLabel.setText("DODAJ NOWEGO NAUCZYCIELA");
        tytulLabel.setPreferredSize(new java.awt.Dimension(300, 25));

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

        imieOknoNauczycielaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        imieOknoNauczycielaLabel.setText("Imię:");

        nazwiskoOknoNauczycielaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nazwiskoOknoNauczycielaLabel.setText("Nazwisko:");

        peselOknoNauczycielaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        peselOknoNauczycielaLabel.setText("PESEL:");

        imieOknoNauczycielaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                imieOknoNauczycielaTextFieldKeyTyped(evt);
            }
        });

        nazwiskoOknoNauczycielaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nazwiskoOknoNauczycielaTextFieldKeyTyped(evt);
            }
        });

        peselOknoNauczycielaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                peselOknoNauczycielaTextFieldKeyTyped(evt);
            }
        });

        obowiazkoweImieLabel.setText("*");

        obowiazkoweNazwiskoLabel.setText("*");

        obowiazkowePeselLabel.setText("*");

        javax.swing.GroupLayout oknoNauczycielaPanelLayout = new javax.swing.GroupLayout(oknoNauczycielaPanel);
        oknoNauczycielaPanel.setLayout(oknoNauczycielaPanelLayout);
        oknoNauczycielaPanelLayout.setHorizontalGroup(
            oknoNauczycielaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoNauczycielaPanelLayout.createSequentialGroup()
                .addGroup(oknoNauczycielaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oknoNauczycielaPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(nazwiskoOknoNauczycielaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(nazwiskoOknoNauczycielaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(obowiazkoweNazwiskoLabel))
                    .addGroup(oknoNauczycielaPanelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(dodajButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(anulujButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(oknoNauczycielaPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(peselOknoNauczycielaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(peselOknoNauczycielaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(obowiazkowePeselLabel))
                    .addGroup(oknoNauczycielaPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(imieOknoNauczycielaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(imieOknoNauczycielaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(obowiazkoweImieLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oknoNauczycielaPanelLayout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(tytulLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        oknoNauczycielaPanelLayout.setVerticalGroup(
            oknoNauczycielaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoNauczycielaPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tytulLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(oknoNauczycielaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oknoNauczycielaPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(imieOknoNauczycielaLabel))
                    .addGroup(oknoNauczycielaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(imieOknoNauczycielaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(obowiazkoweImieLabel)))
                .addGap(18, 18, 18)
                .addGroup(oknoNauczycielaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oknoNauczycielaPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(nazwiskoOknoNauczycielaLabel))
                    .addGroup(oknoNauczycielaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nazwiskoOknoNauczycielaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(obowiazkoweNazwiskoLabel)))
                .addGap(18, 18, 18)
                .addGroup(oknoNauczycielaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oknoNauczycielaPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(peselOknoNauczycielaLabel))
                    .addGroup(oknoNauczycielaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(peselOknoNauczycielaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(obowiazkowePeselLabel)))
                .addGap(63, 63, 63)
                .addGroup(oknoNauczycielaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dodajButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anulujButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoNauczycielaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoNauczycielaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        oknoListyNauczycieli.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void anulujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anulujButtonActionPerformed
        oknoListyNauczycieli.setEnabled(true);
        dispose();
    }//GEN-LAST:event_anulujButtonActionPerformed

    private void dodajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajButtonActionPerformed
        boolean czyWypelniono = true;
        String czegoBrakuje = "Nie wypełniono poprawnie następujących obowiązkowych pól:\n";
        if (imieOknoNauczycielaTextField.getText().isEmpty()) {
            czyWypelniono = false;
            czegoBrakuje += "Imię\n";
        }
        if (nazwiskoOknoNauczycielaTextField.getText().isEmpty()) {
            czyWypelniono = false;
            czegoBrakuje += "Nazwisko\n";
        }
        if (peselOknoNauczycielaTextField.getText().isEmpty() || peselOknoNauczycielaTextField.getText().toString().length() != 11) {
            czyWypelniono = false;
            czegoBrakuje += "PESEL\n";
        }
        if (czyWypelniono) {
            try {
                if (tytul == "Dodaj nowego nauczyciela") {
                    nauczycieleTableModel.insertRow(
                            imieOknoNauczycielaTextField.getText(),
                            nazwiskoOknoNauczycielaTextField.getText(),
                            peselOknoNauczycielaTextField.getText());
                } else if (tytul == "Edytuj wybranego nauczyciela") {
                    nauczycieleTableModel.editRow(
                            imieOknoNauczycielaTextField.getText(),
                            nazwiskoOknoNauczycielaTextField.getText(),
                            peselOknoNauczycielaTextField.getText(),
                            nauczycieleTable.getSelectedRow());
                }
                nauczycieleTableModel = new NauczycieleTableModel(conn);
                nauczycieleTableModel.fireTableDataChanged();
                nauczycieleTable.setModel(nauczycieleTableModel);
                oknoListyNauczycieli.setEnabled(true);
                edytujButton.setEnabled(false);
                usunButton.setEnabled(false);
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(OknoKlasy.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, czegoBrakuje + "Proszę wpisać poprawne dane!", "Nie wypełniono poprawnie obowiązkowych pól", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dodajButtonActionPerformed

    private void imieOknoNauczycielaTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imieOknoNauczycielaTextFieldKeyTyped
        char znak = evt.getKeyChar();
        if (!Character.isLetter(znak)) {
            evt.consume();
        }
    }//GEN-LAST:event_imieOknoNauczycielaTextFieldKeyTyped

    private void nazwiskoOknoNauczycielaTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nazwiskoOknoNauczycielaTextFieldKeyTyped
        char znak = evt.getKeyChar();
        if (!Character.isLetter(znak)) {
            evt.consume();
        }
    }//GEN-LAST:event_nazwiskoOknoNauczycielaTextFieldKeyTyped

    private void peselOknoNauczycielaTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_peselOknoNauczycielaTextFieldKeyTyped
        char znak = evt.getKeyChar();
        if (!Character.isDigit(znak) || znak == KeyEvent.VK_BACKSPACE || znak == KeyEvent.VK_DELETE) {
            evt.consume();
        }
    }//GEN-LAST:event_peselOknoNauczycielaTextFieldKeyTyped

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
            java.util.logging.Logger.getLogger(OknoNauczyciela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OknoNauczyciela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OknoNauczyciela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OknoNauczyciela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OknoNauczyciela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anulujButton;
    private javax.swing.JButton dodajButton;
    private javax.swing.JLabel imieOknoNauczycielaLabel;
    private javax.swing.JTextField imieOknoNauczycielaTextField;
    private javax.swing.JLabel nazwiskoOknoNauczycielaLabel;
    private javax.swing.JTextField nazwiskoOknoNauczycielaTextField;
    private javax.swing.JLabel obowiazkoweImieLabel;
    private javax.swing.JLabel obowiazkoweNazwiskoLabel;
    private javax.swing.JLabel obowiazkowePeselLabel;
    private javax.swing.JPanel oknoNauczycielaPanel;
    private javax.swing.JLabel peselOknoNauczycielaLabel;
    private javax.swing.JTextField peselOknoNauczycielaTextField;
    private javax.swing.JLabel tytulLabel;
    // End of variables declaration//GEN-END:variables
}
