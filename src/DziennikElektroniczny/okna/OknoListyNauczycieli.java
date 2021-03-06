/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.okna;

import DziennikElektroniczny.modele.KlasyTableModel;
import DziennikElektroniczny.modele.NauczycieleTableModel;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author patry
 */
public class OknoListyNauczycieli extends javax.swing.JFrame {

    /**
     * Creates new form OknoListyNauczycieli
     */
    private javax.swing.JFrame oknoAplikacji;
    private final Connection conn;
    private NauczycieleTableModel listaNauczycieliModel;

    public OknoListyNauczycieli(javax.swing.JFrame oknoAplikacji, Connection connection) {
        conn = connection;
        this.oknoAplikacji = oknoAplikacji;
        initComponents();
        listaNauczycieliModel = new NauczycieleTableModel(conn);
        listaNauczycieliModel.fireTableDataChanged();
        listaNauczycieliTable.setModel(listaNauczycieliModel);
        listaNauczycieliTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaNauczycieliTable.getTableHeader().setReorderingAllowed(false);
        setVisible(true);
    }

    private OknoListyNauczycieli() {
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

        oknoListyNauczycieliPanel = new javax.swing.JPanel();
        listaNauczycieliLabel = new javax.swing.JLabel();
        wyjdzOknoListyNauczycieliButton = new javax.swing.JButton();
        listaNauczycieliScrollPane = new javax.swing.JScrollPane();
        listaNauczycieliTable = new javax.swing.JTable();
        opcjePanel = new javax.swing.JPanel();
        dodajNauczycielaButton = new javax.swing.JButton();
        usunNauczycielaButton = new javax.swing.JButton();
        edytujNauczycielaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista nauczycieli");
        setLocation(new java.awt.Point(550, 200));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        listaNauczycieliLabel.setFont(new java.awt.Font("PT Serif", 1, 24)); // NOI18N
        listaNauczycieliLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listaNauczycieliLabel.setText("LISTA NAUCZYCIELI");

        wyjdzOknoListyNauczycieliButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wyjdzOknoListyNauczycieliButton.setText("WYJDŹ");
        wyjdzOknoListyNauczycieliButton.setMaximumSize(new java.awt.Dimension(100, 30));
        wyjdzOknoListyNauczycieliButton.setPreferredSize(new java.awt.Dimension(100, 30));
        wyjdzOknoListyNauczycieliButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyjdzOknoListyNauczycieliButtonActionPerformed(evt);
            }
        });

        listaNauczycieliTable.setModel(new javax.swing.table.DefaultTableModel(
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
        listaNauczycieliTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listaNauczycieliTableMousePressed(evt);
            }
        });
        listaNauczycieliScrollPane.setViewportView(listaNauczycieliTable);

        dodajNauczycielaButton.setText("Dodaj");
        dodajNauczycielaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajNauczycielaButtonActionPerformed(evt);
            }
        });

        usunNauczycielaButton.setText("Usuń");
        usunNauczycielaButton.setEnabled(false);
        usunNauczycielaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usunNauczycielaButtonActionPerformed(evt);
            }
        });

        edytujNauczycielaButton.setText("Edytuj");
        edytujNauczycielaButton.setEnabled(false);
        edytujNauczycielaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edytujNauczycielaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout opcjePanelLayout = new javax.swing.GroupLayout(opcjePanel);
        opcjePanel.setLayout(opcjePanelLayout);
        opcjePanelLayout.setHorizontalGroup(
            opcjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dodajNauczycielaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(usunNauczycielaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(edytujNauczycielaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        opcjePanelLayout.setVerticalGroup(
            opcjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcjePanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(dodajNauczycielaButton)
                .addGap(18, 18, 18)
                .addComponent(usunNauczycielaButton)
                .addGap(53, 53, 53)
                .addComponent(edytujNauczycielaButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout oknoListyNauczycieliPanelLayout = new javax.swing.GroupLayout(oknoListyNauczycieliPanel);
        oknoListyNauczycieliPanel.setLayout(oknoListyNauczycieliPanelLayout);
        oknoListyNauczycieliPanelLayout.setHorizontalGroup(
            oknoListyNauczycieliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoListyNauczycieliPanelLayout.createSequentialGroup()
                .addGroup(oknoListyNauczycieliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oknoListyNauczycieliPanelLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(listaNauczycieliLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(oknoListyNauczycieliPanelLayout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(wyjdzOknoListyNauczycieliButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(oknoListyNauczycieliPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(listaNauczycieliScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(opcjePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        oknoListyNauczycieliPanelLayout.setVerticalGroup(
            oknoListyNauczycieliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoListyNauczycieliPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(listaNauczycieliLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(oknoListyNauczycieliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcjePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaNauczycieliScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(wyjdzOknoListyNauczycieliButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoListyNauczycieliPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoListyNauczycieliPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        oknoAplikacji.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void wyjdzOknoListyNauczycieliButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyjdzOknoListyNauczycieliButtonActionPerformed
        oknoAplikacji.setEnabled(true);
        dispose();
    }//GEN-LAST:event_wyjdzOknoListyNauczycieliButtonActionPerformed

    private void dodajNauczycielaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajNauczycielaButtonActionPerformed
        SwingUtilities.invokeLater(() -> {
            OknoNauczyciela oknoNauczyciela = new OknoNauczyciela(this, conn, listaNauczycieliModel, listaNauczycieliTable, edytujNauczycielaButton, usunNauczycielaButton, "Dodaj nowego nauczyciela");
        });
        setEnabled(false);
    }//GEN-LAST:event_dodajNauczycielaButtonActionPerformed

    private void listaNauczycieliTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaNauczycieliTableMousePressed
        if (evt.getButton() == MouseEvent.BUTTON1) {
            edytujNauczycielaButton.setEnabled(true);
            usunNauczycielaButton.setEnabled(true);
        }
    }//GEN-LAST:event_listaNauczycieliTableMousePressed

    private void edytujNauczycielaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edytujNauczycielaButtonActionPerformed
        SwingUtilities.invokeLater(() -> {
            OknoNauczyciela oknoNauczyciela = new OknoNauczyciela(this, conn, listaNauczycieliModel, listaNauczycieliTable, edytujNauczycielaButton, usunNauczycielaButton, "Edytuj wybranego nauczyciela");
        });
        //listaNauczycieliModel = new NauczycieleTableModel(conn);
        //listaNauczycieliModel.fireTableDataChanged();
        //listaNauczycieliTable.setModel(listaNauczycieliModel);
        setEnabled(false);
    }//GEN-LAST:event_edytujNauczycielaButtonActionPerformed

    private void usunNauczycielaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usunNauczycielaButtonActionPerformed
        listaNauczycieliModel.deleteRow(listaNauczycieliTable.getSelectedRow());
        listaNauczycieliModel = new NauczycieleTableModel(conn);
        listaNauczycieliModel.fireTableDataChanged();
        listaNauczycieliTable.setModel(listaNauczycieliModel);
        edytujNauczycielaButton.setEnabled(false);
        usunNauczycielaButton.setEnabled(false);
    }//GEN-LAST:event_usunNauczycielaButtonActionPerformed

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
            java.util.logging.Logger.getLogger(OknoListyNauczycieli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OknoListyNauczycieli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OknoListyNauczycieli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OknoListyNauczycieli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OknoListyNauczycieli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dodajNauczycielaButton;
    private javax.swing.JButton edytujNauczycielaButton;
    private javax.swing.JLabel listaNauczycieliLabel;
    private javax.swing.JScrollPane listaNauczycieliScrollPane;
    private javax.swing.JTable listaNauczycieliTable;
    private javax.swing.JPanel oknoListyNauczycieliPanel;
    private javax.swing.JPanel opcjePanel;
    private javax.swing.JButton usunNauczycielaButton;
    private javax.swing.JButton wyjdzOknoListyNauczycieliButton;
    // End of variables declaration//GEN-END:variables
}
