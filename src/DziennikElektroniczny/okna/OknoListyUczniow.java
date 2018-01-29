/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DziennikElektroniczny.okna;

import DziennikElektroniczny.modele.KlasyComboBoxModel;
import DziennikElektroniczny.modele.ListaKlasModel;
import java.sql.Connection;
import javax.swing.SwingUtilities;

/**
 *
 * @author patry
 */
public class OknoListyUczniow extends javax.swing.JFrame {

    /**
     * Creates new form OknoListyUczniow
     */
    private javax.swing.JFrame oknoAplikacji;
    private final Connection conn;
    private KlasyComboBoxModel klasyComboBoxModel;

    public OknoListyUczniow(javax.swing.JFrame oknoListyKlas, Connection connection) {
        conn = connection;
        this.oknoAplikacji = oknoListyKlas;
        initComponents();
        ListaKlasModel listaKlasModel = new ListaKlasModel();
        String[] listaKlas =  listaKlasModel.listaKlas(conn);
        klasyComboBoxModel = new KlasyComboBoxModel(listaKlas);
        klasyComboBox.setModel(klasyComboBoxModel);
        setVisible(true);
    }

    private OknoListyUczniow() {
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

        oknoListyUczniowPanel = new javax.swing.JPanel();
        listaUczniowLabel = new javax.swing.JLabel();
        listaUczniowScrollPane = new javax.swing.JScrollPane();
        listaUczniowTable = new javax.swing.JTable();
        wyjdzOknoListyUczniowButton = new javax.swing.JButton();
        opcjePanel = new javax.swing.JPanel();
        dodajUczniaButton = new javax.swing.JButton();
        usunUczniaButton = new javax.swing.JButton();
        edytujUczniaButton = new javax.swing.JButton();
        klasaLabel = new javax.swing.JLabel();
        klasyComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista uczniów");
        setLocation(new java.awt.Point(550, 200));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        listaUczniowLabel.setFont(new java.awt.Font("PT Serif", 1, 24)); // NOI18N
        listaUczniowLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listaUczniowLabel.setText("LISTA UCZNIÓW");

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
        listaUczniowScrollPane.setViewportView(listaUczniowTable);

        wyjdzOknoListyUczniowButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wyjdzOknoListyUczniowButton.setText("WYJDŹ");
        wyjdzOknoListyUczniowButton.setPreferredSize(new java.awt.Dimension(100, 30));
        wyjdzOknoListyUczniowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyjdzOknoListyUczniowButtonActionPerformed(evt);
            }
        });

        dodajUczniaButton.setText("Dodaj");
        dodajUczniaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajUczniaButtonActionPerformed(evt);
            }
        });

        usunUczniaButton.setText("Usuń");
        usunUczniaButton.setEnabled(false);

        edytujUczniaButton.setText("Edytuj");
        edytujUczniaButton.setEnabled(false);

        javax.swing.GroupLayout opcjePanelLayout = new javax.swing.GroupLayout(opcjePanel);
        opcjePanel.setLayout(opcjePanelLayout);
        opcjePanelLayout.setHorizontalGroup(
            opcjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dodajUczniaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(usunUczniaButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(edytujUczniaButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        opcjePanelLayout.setVerticalGroup(
            opcjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcjePanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(dodajUczniaButton)
                .addGap(27, 27, 27)
                .addComponent(usunUczniaButton)
                .addGap(30, 30, 30)
                .addComponent(edytujUczniaButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        klasaLabel.setText("Klasa:");

        klasyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout oknoListyUczniowPanelLayout = new javax.swing.GroupLayout(oknoListyUczniowPanel);
        oknoListyUczniowPanel.setLayout(oknoListyUczniowPanelLayout);
        oknoListyUczniowPanelLayout.setHorizontalGroup(
            oknoListyUczniowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoListyUczniowPanelLayout.createSequentialGroup()
                .addGroup(oknoListyUczniowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oknoListyUczniowPanelLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(listaUczniowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(oknoListyUczniowPanelLayout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(wyjdzOknoListyUczniowButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(oknoListyUczniowPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(oknoListyUczniowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oknoListyUczniowPanelLayout.createSequentialGroup()
                        .addComponent(klasaLabel)
                        .addGap(27, 27, 27)
                        .addComponent(klasyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(oknoListyUczniowPanelLayout.createSequentialGroup()
                        .addComponent(listaUczniowScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(opcjePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        oknoListyUczniowPanelLayout.setVerticalGroup(
            oknoListyUczniowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oknoListyUczniowPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(listaUczniowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(oknoListyUczniowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(klasaLabel)
                    .addComponent(klasyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(oknoListyUczniowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opcjePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaUczniowScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(wyjdzOknoListyUczniowButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoListyUczniowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oknoListyUczniowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        oknoAplikacji.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void wyjdzOknoListyUczniowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyjdzOknoListyUczniowButtonActionPerformed
        oknoAplikacji.setEnabled(true);
        dispose();
    }//GEN-LAST:event_wyjdzOknoListyUczniowButtonActionPerformed

    private void dodajUczniaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajUczniaButtonActionPerformed
        SwingUtilities.invokeLater(() -> {
            OknoUcznia oknoUcznia = new OknoUcznia(this, conn);
        });
        setEnabled(false);
    }//GEN-LAST:event_dodajUczniaButtonActionPerformed

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
            java.util.logging.Logger.getLogger(OknoListyUczniow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OknoListyUczniow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OknoListyUczniow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OknoListyUczniow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OknoListyUczniow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dodajUczniaButton;
    private javax.swing.JButton edytujUczniaButton;
    private javax.swing.JLabel klasaLabel;
    private javax.swing.JComboBox<String> klasyComboBox;
    private javax.swing.JLabel listaUczniowLabel;
    private javax.swing.JScrollPane listaUczniowScrollPane;
    private javax.swing.JTable listaUczniowTable;
    private javax.swing.JPanel oknoListyUczniowPanel;
    private javax.swing.JPanel opcjePanel;
    private javax.swing.JButton usunUczniaButton;
    private javax.swing.JButton wyjdzOknoListyUczniowButton;
    // End of variables declaration//GEN-END:variables
}
