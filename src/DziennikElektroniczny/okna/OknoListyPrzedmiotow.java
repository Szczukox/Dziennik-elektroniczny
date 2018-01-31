/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.okna;

import DziennikElektroniczny.modele.PrzedmiotyTableModel;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author patry
 */
public class OknoListyPrzedmiotow extends javax.swing.JFrame {

    private javax.swing.JFrame oknoAplikacji;
    private final Connection conn;
    private PrzedmiotyTableModel listaPrzedmiotowModel;

    /**
     * Creates new form OknoListyPrzedmiotow
     */
    public OknoListyPrzedmiotow(javax.swing.JFrame oknoAplikacji, Connection connection) {
        conn = connection;
        this.oknoAplikacji = oknoAplikacji;
        initComponents();
        listaPrzedmiotowModel = new PrzedmiotyTableModel(conn);
        listaPrzedmiotowModel.fireTableDataChanged();
        listaPrzedmiotowTable.setModel(listaPrzedmiotowModel);
        listaPrzedmiotowTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setVisible(true);
    }

    private OknoListyPrzedmiotow() {
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

        oknoListyPrzedmiotowPanel = new javax.swing.JPanel();
        listaPrzedmiotowScrollPane = new javax.swing.JScrollPane();
        listaPrzedmiotowTable = new javax.swing.JTable();
        opcjePanel = new javax.swing.JPanel();
        dodajButton = new javax.swing.JButton();
        usunButton = new javax.swing.JButton();
        edytujButton = new javax.swing.JButton();
        listaPrzedmiotowLabel = new javax.swing.JLabel();
        wyjdzOknoListyPrzedmiotowButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista przedmiotów");
        setLocation(new java.awt.Point(550, 200));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        listaPrzedmiotowTable.setModel(new javax.swing.table.DefaultTableModel(
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
        listaPrzedmiotowTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listaPrzedmiotowTableMousePressed(evt);
            }
        });
        listaPrzedmiotowScrollPane.setViewportView(listaPrzedmiotowTable);

        dodajButton.setText("DODAJ");
        dodajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajButtonActionPerformed(evt);
            }
        });

        usunButton.setText("USUŃ");
        usunButton.setEnabled(false);
        usunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usunButtonActionPerformed(evt);
            }
        });

        edytujButton.setText("EDYTUJ");
        edytujButton.setEnabled(false);
        edytujButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edytujButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout opcjePanelLayout = new javax.swing.GroupLayout(opcjePanel);
        opcjePanel.setLayout(opcjePanelLayout);
        opcjePanelLayout.setHorizontalGroup(
            opcjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dodajButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(usunButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(edytujButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        opcjePanelLayout.setVerticalGroup(
            opcjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcjePanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(dodajButton)
                .addGap(31, 31, 31)
                .addComponent(usunButton)
                .addGap(43, 43, 43)
                .addComponent(edytujButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listaPrzedmiotowLabel.setFont(new java.awt.Font("PT Serif", 1, 24)); // NOI18N
        listaPrzedmiotowLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listaPrzedmiotowLabel.setText("LISTA PRZEDMIOTÓW");
        listaPrzedmiotowLabel.setPreferredSize(new java.awt.Dimension(400, 30));

        wyjdzOknoListyPrzedmiotowButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wyjdzOknoListyPrzedmiotowButton.setText("WYJDŹ");
        wyjdzOknoListyPrzedmiotowButton.setPreferredSize(new java.awt.Dimension(100, 30));
        wyjdzOknoListyPrzedmiotowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyjdzOknoListyPrzedmiotowButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout oknoListyPrzedmiotowPanelLayout = new javax.swing.GroupLayout(oknoListyPrzedmiotowPanel);
        oknoListyPrzedmiotowPanel.setLayout(oknoListyPrzedmiotowPanelLayout);
        oknoListyPrzedmiotowPanelLayout.setHorizontalGroup(
            oknoListyPrzedmiotowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoListyPrzedmiotowPanelLayout.createSequentialGroup()
                .addGroup(oknoListyPrzedmiotowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oknoListyPrzedmiotowPanelLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(listaPrzedmiotowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(oknoListyPrzedmiotowPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(listaPrzedmiotowScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(opcjePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(oknoListyPrzedmiotowPanelLayout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(wyjdzOknoListyPrzedmiotowButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        oknoListyPrzedmiotowPanelLayout.setVerticalGroup(
            oknoListyPrzedmiotowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoListyPrzedmiotowPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(listaPrzedmiotowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(oknoListyPrzedmiotowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opcjePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaPrzedmiotowScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(wyjdzOknoListyPrzedmiotowButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoListyPrzedmiotowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoListyPrzedmiotowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        oknoAplikacji.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void wyjdzOknoListyPrzedmiotowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyjdzOknoListyPrzedmiotowButtonActionPerformed
        oknoAplikacji.setEnabled(true);
        dispose();
    }//GEN-LAST:event_wyjdzOknoListyPrzedmiotowButtonActionPerformed

    private void dodajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajButtonActionPerformed
        SwingUtilities.invokeLater(() -> {
            OknoPrzedmiotu oknoPrzedmiotu = new OknoPrzedmiotu(this, conn, listaPrzedmiotowModel, listaPrzedmiotowTable, edytujButton, usunButton, "Dodaj nowy przedmiot");
        });
        setEnabled(false);
    }//GEN-LAST:event_dodajButtonActionPerformed

    private void listaPrzedmiotowTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaPrzedmiotowTableMousePressed
        if (evt.getButton() == MouseEvent.BUTTON1) {
            edytujButton.setEnabled(true);
            usunButton.setEnabled(true);
        }
    }//GEN-LAST:event_listaPrzedmiotowTableMousePressed

    private void edytujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edytujButtonActionPerformed
        SwingUtilities.invokeLater(() -> {
            OknoPrzedmiotu oknoPrzedmiotu = new OknoPrzedmiotu(this, conn, listaPrzedmiotowModel, listaPrzedmiotowTable, edytujButton, usunButton, "Edytuj wybrany przedmiot");
        });
        setEnabled(false);
    }//GEN-LAST:event_edytujButtonActionPerformed

    private void usunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usunButtonActionPerformed
        listaPrzedmiotowModel.deleteRow(listaPrzedmiotowTable.getSelectedRow());
        listaPrzedmiotowModel = new PrzedmiotyTableModel(conn);
        listaPrzedmiotowModel.fireTableDataChanged();
        listaPrzedmiotowTable.setModel(listaPrzedmiotowModel);
        edytujButton.setEnabled(false);
        usunButton.setEnabled(false);
    }//GEN-LAST:event_usunButtonActionPerformed

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
            java.util.logging.Logger.getLogger(OknoListyPrzedmiotow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OknoListyPrzedmiotow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OknoListyPrzedmiotow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OknoListyPrzedmiotow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OknoListyPrzedmiotow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dodajButton;
    private javax.swing.JButton edytujButton;
    private javax.swing.JLabel listaPrzedmiotowLabel;
    private javax.swing.JScrollPane listaPrzedmiotowScrollPane;
    private javax.swing.JTable listaPrzedmiotowTable;
    private javax.swing.JPanel oknoListyPrzedmiotowPanel;
    private javax.swing.JPanel opcjePanel;
    private javax.swing.JButton usunButton;
    private javax.swing.JButton wyjdzOknoListyPrzedmiotowButton;
    // End of variables declaration//GEN-END:variables
}