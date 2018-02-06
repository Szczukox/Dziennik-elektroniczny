/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.okna;

import DziennikElektroniczny.modele.ListaPrzydzialowDlaNauczycieliModel;
import DziennikElektroniczny.modele.ComboBoxModel;
import DziennikElektroniczny.modele.ListaLekcjiModel;
import DziennikElektroniczny.modele.UczniowieDlaNauczycieliTableModel;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author patry
 */
public class OknoLekcji extends javax.swing.JFrame {

    /**
     * Creates new form OknoLekcji
     */
    private javax.swing.JFrame oknoAplikacji;
    private Connection conn;
    private String nauczyciel;
    private ComboBoxModel przedmiotyComboBoxModel;
    private ComboBoxModel lekcjeComboBoxModel;
    private UczniowieDlaNauczycieliTableModel listaUczniowDlaNauczycieliModel;

    public OknoLekcji(javax.swing.JFrame oknoAplikacji, Connection conn, String nauczyciel) {
        this.oknoAplikacji = oknoAplikacji;
        this.conn = conn;
        this.nauczyciel = nauczyciel;
        initComponents();
        setVisible(true);

        ListaPrzydzialowDlaNauczycieliModel listaPrzydzialowDlaNauczycieliModel = new ListaPrzydzialowDlaNauczycieliModel();
        String[] listaPrzedmiotow = listaPrzydzialowDlaNauczycieliModel.listaPrzydzialow(conn, nauczyciel);
        przedmiotyComboBoxModel = new ComboBoxModel(listaPrzedmiotow);
        klasyIPrzedmiotyComboBox.setModel(przedmiotyComboBoxModel);

        String[] wybierz = new String[1];
        wybierz[0] = "---WYBIERZ---";
        lekcjeComboBoxModel = new ComboBoxModel(wybierz);
        lekcjeComboBox.setModel(lekcjeComboBoxModel);

        listaUczniowDlaNauczycieliModel = new UczniowieDlaNauczycieliTableModel(conn, klasyIPrzedmiotyComboBox.getSelectedItem().toString());
        listaUczniowDlaNauczycieliModel.fireTableDataChanged();
        listaUczniowTable.setModel(listaUczniowDlaNauczycieliModel);
        listaUczniowTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaUczniowTable.getTableHeader().setReorderingAllowed(false);
    }

    private OknoLekcji() {
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

        listaTwoichUczniowLabel = new javax.swing.JLabel();
        listaUczniowScrollPane = new javax.swing.JScrollPane();
        listaUczniowTable = new javax.swing.JTable();
        opcjePanel = new javax.swing.JPanel();
        szczegolyButton = new javax.swing.JButton();
        nowaLekcjaButton = new javax.swing.JButton();
        wstawOceneButton = new javax.swing.JButton();
        edytujLekcjeButton = new javax.swing.JButton();
        poprawOceneButton = new javax.swing.JButton();
        wyjdzButton = new javax.swing.JButton();
        klasaIPrzedmiotLabel = new javax.swing.JLabel();
        klasyIPrzedmiotyComboBox = new javax.swing.JComboBox<>();
        lekcjaLabel = new javax.swing.JLabel();
        lekcjeComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista uczniów");
        setLocation(new java.awt.Point(550, 200));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        listaTwoichUczniowLabel.setFont(new java.awt.Font("PT Serif", 1, 24)); // NOI18N
        listaTwoichUczniowLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listaTwoichUczniowLabel.setText("LISTA TWOICH UCZNIÓW");
        listaTwoichUczniowLabel.setPreferredSize(new java.awt.Dimension(400, 30));

        listaUczniowTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        listaUczniowTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listaUczniowTableMousePressed(evt);
            }
        });
        listaUczniowScrollPane.setViewportView(listaUczniowTable);

        szczegolyButton.setText("Szczegóły");
        szczegolyButton.setEnabled(false);

        nowaLekcjaButton.setText("Nowa lekcja");
        nowaLekcjaButton.setEnabled(false);
        nowaLekcjaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nowaLekcjaButtonActionPerformed(evt);
            }
        });

        wstawOceneButton.setText("Wstaw ocenę");
        wstawOceneButton.setEnabled(false);
        wstawOceneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wstawOceneButtonActionPerformed(evt);
            }
        });

        edytujLekcjeButton.setText("Edytuj lekcję");
        edytujLekcjeButton.setEnabled(false);

        poprawOceneButton.setText("Popraw ocenę");
        poprawOceneButton.setEnabled(false);

        javax.swing.GroupLayout opcjePanelLayout = new javax.swing.GroupLayout(opcjePanel);
        opcjePanel.setLayout(opcjePanelLayout);
        opcjePanelLayout.setHorizontalGroup(
            opcjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(szczegolyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nowaLekcjaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(wstawOceneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(edytujLekcjeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(poprawOceneButton, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        opcjePanelLayout.setVerticalGroup(
            opcjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcjePanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(szczegolyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nowaLekcjaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edytujLekcjeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wstawOceneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(poprawOceneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        wyjdzButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wyjdzButton.setText("WYJDŹ");
        wyjdzButton.setPreferredSize(new java.awt.Dimension(100, 30));
        wyjdzButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyjdzButtonActionPerformed(evt);
            }
        });

        klasaIPrzedmiotLabel.setText("Klasa | Przedmiot:");

        klasyIPrzedmiotyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        klasyIPrzedmiotyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klasyIPrzedmiotyComboBoxActionPerformed(evt);
            }
        });

        lekcjaLabel.setText("Lekcja:");

        lekcjeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        lekcjeComboBox.setEnabled(false);
        lekcjeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lekcjeComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(wyjdzButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(listaTwoichUczniowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(listaUczniowScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(opcjePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(klasaIPrzedmiotLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(lekcjaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(klasyIPrzedmiotyComboBox, 0, 150, Short.MAX_VALUE)
                            .addComponent(lekcjeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(listaTwoichUczniowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(klasyIPrzedmiotyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(klasaIPrzedmiotLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lekcjeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lekcjaLabel))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opcjePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaUczniowScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(wyjdzButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        oknoAplikacji.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void wyjdzButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyjdzButtonActionPerformed
        oknoAplikacji.setEnabled(true);
        dispose();
    }//GEN-LAST:event_wyjdzButtonActionPerformed

    private void listaUczniowTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaUczniowTableMousePressed
        if (evt.getButton() == MouseEvent.BUTTON1) {
            szczegolyButton.setEnabled(true);
            if (lekcjeComboBox.getSelectedItem().toString() != "---WYBIERZ---") {
                wstawOceneButton.setEnabled(true);
                poprawOceneButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_listaUczniowTableMousePressed

    private void klasyIPrzedmiotyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klasyIPrzedmiotyComboBoxActionPerformed
        listaUczniowDlaNauczycieliModel = new UczniowieDlaNauczycieliTableModel(conn, klasyIPrzedmiotyComboBox.getSelectedItem().toString());
        listaUczniowDlaNauczycieliModel.fireTableDataChanged();
        listaUczniowTable.setModel(listaUczniowDlaNauczycieliModel);
        lekcjeComboBox.setSelectedItem("---WYBIERZ---");
        szczegolyButton.setEnabled(false);
        wstawOceneButton.setEnabled(false);
        poprawOceneButton.setEnabled(false);
        edytujLekcjeButton.setEnabled(false);
        if (klasyIPrzedmiotyComboBox.getSelectedItem().toString().equals("---WYBIERZ---")) {
            lekcjeComboBox.setEnabled(false);
            nowaLekcjaButton.setEnabled(false);
        } else {
            ListaLekcjiModel listaLekcjiModel = new ListaLekcjiModel();
            String[] listaLekcji = listaLekcjiModel.listaLekcji(conn, klasyIPrzedmiotyComboBox.getSelectedItem().toString());
            lekcjeComboBoxModel = new ComboBoxModel(listaLekcji);
            lekcjeComboBox.setModel(lekcjeComboBoxModel);
            lekcjeComboBox.setEnabled(true);
            nowaLekcjaButton.setEnabled(true);
        }
    }//GEN-LAST:event_klasyIPrzedmiotyComboBoxActionPerformed

    private void lekcjeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lekcjeComboBoxActionPerformed
        listaUczniowDlaNauczycieliModel = new UczniowieDlaNauczycieliTableModel(conn, klasyIPrzedmiotyComboBox.getSelectedItem().toString());
        listaUczniowDlaNauczycieliModel.fireTableDataChanged();
        listaUczniowTable.setModel(listaUczniowDlaNauczycieliModel);
        szczegolyButton.setEnabled(false);
        wstawOceneButton.setEnabled(false);
        poprawOceneButton.setEnabled(false);
        if (lekcjeComboBox.getSelectedItem().toString().equals("---WYBIERZ---")) {
            edytujLekcjeButton.setEnabled(false);
        } else {
            edytujLekcjeButton.setEnabled(true);
        }
    }//GEN-LAST:event_lekcjeComboBoxActionPerformed

    private void wstawOceneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wstawOceneButtonActionPerformed
        SwingUtilities.invokeLater(() -> {
            OknoOceny oknoOceny = new OknoOceny(this, conn, listaUczniowDlaNauczycieliModel, listaUczniowTable, (String) lekcjeComboBox.getSelectedItem(),
            (String) klasyIPrzedmiotyComboBox.getSelectedItem());
        });
        setEnabled(false);
    }//GEN-LAST:event_wstawOceneButtonActionPerformed

    private void nowaLekcjaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nowaLekcjaButtonActionPerformed
        SwingUtilities.invokeLater(() -> {
            OknoNowejLekcji oknoNowejLekcji = new OknoNowejLekcji(this, conn);
        });
        setEnabled(false);
    }//GEN-LAST:event_nowaLekcjaButtonActionPerformed

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
            java.util.logging.Logger.getLogger(OknoLekcji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OknoLekcji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OknoLekcji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OknoLekcji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OknoLekcji().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton edytujLekcjeButton;
    private javax.swing.JLabel klasaIPrzedmiotLabel;
    private javax.swing.JComboBox<String> klasyIPrzedmiotyComboBox;
    private javax.swing.JLabel lekcjaLabel;
    private javax.swing.JComboBox<String> lekcjeComboBox;
    private javax.swing.JLabel listaTwoichUczniowLabel;
    private javax.swing.JScrollPane listaUczniowScrollPane;
    private javax.swing.JTable listaUczniowTable;
    private javax.swing.JButton nowaLekcjaButton;
    private javax.swing.JPanel opcjePanel;
    private javax.swing.JButton poprawOceneButton;
    private javax.swing.JButton szczegolyButton;
    private javax.swing.JButton wstawOceneButton;
    private javax.swing.JButton wyjdzButton;
    // End of variables declaration//GEN-END:variables
}
