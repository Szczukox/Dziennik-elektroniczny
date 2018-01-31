/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.okna;

;
import DziennikElektroniczny.modele.KlasyComboBoxModel;
import DziennikElektroniczny.modele.ListaKlasModel;
import DziennikElektroniczny.modele.ListaNauczycieliModel;
import DziennikElektroniczny.modele.ListaPrzedmiotowModel;
import DziennikElektroniczny.modele.NauczycieleComboBoxModel;
import DziennikElektroniczny.modele.PrzedmiotyComboBoxModel;
import DziennikElektroniczny.modele.PrzydzialyTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author patry
 */


public class OknoPrzydzialu extends javax.swing.JFrame {

    /**
     * Creates new form OknoPrzydzialu
     */
    private javax.swing.JFrame oknoListyKlas;
    private final Connection conn;
    private PrzydzialyTableModel przydzialyTableModel;
    private javax.swing.JTable przydzialyTable;
    private javax.swing.JButton edytujButton;
    private javax.swing.JButton usunButton;
    private javax.swing.ComboBoxModel klasyComboBoxModel;
    private javax.swing.ComboBoxModel przedmiotyComboBoxModel;
    private javax.swing.ComboBoxModel nauczycieleComboBoxModel;
    private String klasa;
    private String przedmiot;
    private String nauczyciel;
    private String tytul;

    public OknoPrzydzialu(javax.swing.JFrame oknoListyKlas, Connection connection, PrzydzialyTableModel listaPrzydzialowModel,
            javax.swing.JTable przydzialyTable, javax.swing.JButton edytujButton, javax.swing.JButton usunButton, String tytul,
            String klasa, String przedmiot, String nauczyciel) {
        conn = connection;
        this.oknoListyKlas = oknoListyKlas;
        this.przydzialyTableModel = listaPrzydzialowModel;
        this.przydzialyTable = przydzialyTable;
        this.edytujButton = edytujButton;
        this.usunButton = usunButton;
        this.klasa = klasa;
        this.przedmiot = przedmiot;
        this.nauczyciel = nauczyciel;
        this.tytul = tytul;

        initComponents();

        ListaKlasModel listaKlasModel = new ListaKlasModel();
        String[] listaKlas = listaKlasModel.listaKlas(conn);
        klasyComboBoxModel = new KlasyComboBoxModel(listaKlas);
        klasyComboBox.setModel(klasyComboBoxModel);

        ListaPrzedmiotowModel listaPrzedmiotowModel = new ListaPrzedmiotowModel();
        String[] listaPrzedmiotow = listaPrzedmiotowModel.listaPrzedmiotow(conn);
        przedmiotyComboBoxModel = new PrzedmiotyComboBoxModel(listaPrzedmiotow);
        przedmiotyComboBox.setModel(przedmiotyComboBoxModel);

        ListaNauczycieliModel listaNauczycieliModel = new ListaNauczycieliModel();
        String[] listaNauczycieli = listaNauczycieliModel.listaNauczycieli(conn);
        nauczycieleComboBoxModel = new NauczycieleComboBoxModel(listaNauczycieli);
        nauczycieleComboBox.setModel(nauczycieleComboBoxModel);

        setTitle(tytul);
        tytulLabel.setText(tytul.toUpperCase());
        setVisible(true);

        if (tytul == "Edytuj wybrany przydział") {
            klasyComboBox.setSelectedItem(String.valueOf(this.przydzialyTable.getValueAt(this.przydzialyTable.getSelectedRow(), 1)));
            przedmiotyComboBox.setSelectedItem(String.valueOf(this.przydzialyTable.getValueAt(this.przydzialyTable.getSelectedRow(), 2)));
            nauczycieleComboBox.setSelectedItem(String.valueOf(this.przydzialyTable.getValueAt(this.przydzialyTable.getSelectedRow(), 3)));
            dodajButton.setText("ZMIEŃ");
        }
    }

    private OknoPrzydzialu() {
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

        oknoPrzydzialuPanel = new javax.swing.JPanel();
        tytulLabel = new javax.swing.JLabel();
        klasaLabel = new javax.swing.JLabel();
        przedmiotLabel = new javax.swing.JLabel();
        nauczycielLabel = new javax.swing.JLabel();
        dodajButton = new javax.swing.JButton();
        anulujButton = new javax.swing.JButton();
        nauczycieleComboBox = new javax.swing.JComboBox<>();
        przedmiotyComboBox = new javax.swing.JComboBox<>();
        klasyComboBox = new javax.swing.JComboBox<>();
        obowiazkoweKlasaLabel = new javax.swing.JLabel();
        obowiazkowePrzedmiotLabel = new javax.swing.JLabel();
        obowiazkoweNauczycielLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dodaj nowy przydział");
        setLocation(new java.awt.Point(800, 350));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tytulLabel.setFont(new java.awt.Font("PT Serif", 1, 18)); // NOI18N
        tytulLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tytulLabel.setText("DODAJ NOWY PRZYDZIAŁ");

        klasaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        klasaLabel.setText("Klasa:");

        przedmiotLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        przedmiotLabel.setText("Przedmiot:");

        nauczycielLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nauczycielLabel.setText("Nauczyciel:");

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

        nauczycieleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        przedmiotyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        klasyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        obowiazkoweKlasaLabel.setText("*");

        obowiazkowePrzedmiotLabel.setText("*");

        obowiazkoweNauczycielLabel.setText("*");

        javax.swing.GroupLayout oknoPrzydzialuPanelLayout = new javax.swing.GroupLayout(oknoPrzydzialuPanel);
        oknoPrzydzialuPanel.setLayout(oknoPrzydzialuPanelLayout);
        oknoPrzydzialuPanelLayout.setHorizontalGroup(
            oknoPrzydzialuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoPrzydzialuPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(oknoPrzydzialuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oknoPrzydzialuPanelLayout.createSequentialGroup()
                        .addComponent(tytulLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oknoPrzydzialuPanelLayout.createSequentialGroup()
                        .addComponent(dodajButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(anulujButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oknoPrzydzialuPanelLayout.createSequentialGroup()
                        .addGroup(oknoPrzydzialuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(klasaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(przedmiotLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nauczycielLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(oknoPrzydzialuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(przedmiotyComboBox, 0, 150, Short.MAX_VALUE)
                            .addComponent(klasyComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nauczycieleComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(oknoPrzydzialuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(obowiazkowePrzedmiotLabel)
                            .addComponent(obowiazkoweNauczycielLabel)
                            .addComponent(obowiazkoweKlasaLabel))
                        .addGap(37, 37, 37))))
        );
        oknoPrzydzialuPanelLayout.setVerticalGroup(
            oknoPrzydzialuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oknoPrzydzialuPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tytulLabel)
                .addGap(30, 30, 30)
                .addGroup(oknoPrzydzialuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(klasyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(klasaLabel)
                    .addComponent(obowiazkoweKlasaLabel))
                .addGap(18, 18, 18)
                .addGroup(oknoPrzydzialuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(przedmiotyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(przedmiotLabel)
                    .addComponent(obowiazkowePrzedmiotLabel))
                .addGap(18, 18, 18)
                .addGroup(oknoPrzydzialuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nauczycieleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(obowiazkoweNauczycielLabel)
                    .addComponent(nauczycielLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(oknoPrzydzialuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dodajButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anulujButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoPrzydzialuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoPrzydzialuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        if (klasyComboBox.getSelectedItem().toString().equals("---WYBIERZ---")) {
            czyWypelniono = false;
            czegoBrakuje += "Klasa\n";
        }
        if (przedmiotyComboBox.getSelectedItem().toString().equals("---WYBIERZ---")) {
            czyWypelniono = false;
            czegoBrakuje += "Przedmiot\n";
        }
        if (nauczycieleComboBox.getSelectedItem().toString().equals("---WYBIERZ---")) {
            czyWypelniono = false;
            czegoBrakuje += "Nauczyciel\n";
        }
        if (czyWypelniono) {
            try {
                if (tytul == "Dodaj nowy przydział") {
                    przydzialyTableModel.insertRow(
                            klasyComboBox.getSelectedItem().toString(),
                            przedmiotyComboBox.getSelectedItem().toString(),
                            nauczycieleComboBox.getSelectedItem().toString());
                } else if (tytul == "Edytuj wybrany przydział") {
                    przydzialyTableModel.editRow(
                            klasyComboBox.getSelectedItem().toString(),
                            przedmiotyComboBox.getSelectedItem().toString(),
                            nauczycieleComboBox.getSelectedItem().toString(),
                            przydzialyTable.getSelectedRow());
                }
            } catch (SQLException ex) {
                Logger.getLogger(OknoKlasy.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                przydzialyTableModel = new PrzydzialyTableModel(conn, klasa, przedmiot, nauczyciel);
                przydzialyTableModel.fireTableDataChanged();
                przydzialyTable.setModel(przydzialyTableModel);
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
            java.util.logging.Logger.getLogger(OknoPrzydzialu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OknoPrzydzialu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OknoPrzydzialu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OknoPrzydzialu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OknoPrzydzialu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anulujButton;
    private javax.swing.JButton dodajButton;
    private javax.swing.JLabel klasaLabel;
    private javax.swing.JComboBox<String> klasyComboBox;
    private javax.swing.JLabel nauczycielLabel;
    private javax.swing.JComboBox<String> nauczycieleComboBox;
    private javax.swing.JLabel obowiazkoweKlasaLabel;
    private javax.swing.JLabel obowiazkoweNauczycielLabel;
    private javax.swing.JLabel obowiazkowePrzedmiotLabel;
    private javax.swing.JPanel oknoPrzydzialuPanel;
    private javax.swing.JLabel przedmiotLabel;
    private javax.swing.JComboBox<String> przedmiotyComboBox;
    private javax.swing.JLabel tytulLabel;
    // End of variables declaration//GEN-END:variables
}