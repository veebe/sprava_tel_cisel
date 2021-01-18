/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoznam_tel_cisel;

import com.mysql.jdbc.Connection;
import java.awt.Component;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bluna
 */
public class zoznam extends javax.swing.JFrame {

    boolean stav = true;
    String a , b, c;
    String id;
    Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/tel_cisla";
    String user = "root";
    String password = "";
    /**
     * Creates new form zoznam
     */
    public zoznam() {
        initComponents();
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jButton1.setVisible(false);
        VypisDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public void VypisDB()
     {
          try{
            conn = (Connection) DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM zoznam";
            PreparedStatement dotaz = conn.prepareStatement(sql);
            ResultSet vysledky = dotaz.executeQuery();
            
            DefaultTableModel Tabulka = (DefaultTableModel)jTable2.getModel();
            Tabulka.setRowCount(0);
            
            ResultSetMetaData StData = (ResultSetMetaData) vysledky.getMetaData();
            int j = StData.getColumnCount();
            
            while(vysledky.next()){
            Vector Riadok = new Vector();
            
                    for(int i = 0 ; i < j ; i++){
                    Riadok.add(vysledky.getString("Id"));
                    Riadok.add(vysledky.getString("Meno"));
                    Riadok.add(vysledky.getString("Priezvisko"));
                    Riadok.add(vysledky.getString("Cislo"));
                    }
                    Tabulka.addRow(Riadok);
            }
        }
        catch (Exception ex) {
            System.out.println("niečo zle");
            JOptionPane.showMessageDialog(null, ex);
        } 
    }
    
        public void VypisDBHladanie()
     {   
        try{
            conn = (Connection) DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM zoznam WHERE Meno LIKE '" + jTextField4.getText() + "%'";
            PreparedStatement dotaz = conn.prepareStatement(sql);
            ResultSet vysledky = dotaz.executeQuery();
            
            DefaultTableModel Tabulka = (DefaultTableModel)jTable2.getModel();
            Tabulka.setRowCount(0);
            
            ResultSetMetaData StData = (ResultSetMetaData) vysledky.getMetaData();
            int j = StData.getColumnCount();
            
            while(vysledky.next()){
            Vector Riadok = new Vector();
            
                    for(int i = 0 ; i < j ; i++){
                    Riadok.add(vysledky.getString("Id"));
                    Riadok.add(vysledky.getString("Meno"));
                    Riadok.add(vysledky.getString("Priezvisko"));
                    Riadok.add(vysledky.getString("Cislo"));
                    }
                    Tabulka.addRow(Riadok);
            }
        }
        catch (Exception ex) {
            System.out.println("niečo zle");
            JOptionPane.showMessageDialog(null, ex);
        } 

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton5.setText("Späť");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField1.setText("Meno");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setText("edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField2.setText("Priezvisko");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setText("Cislo");

        jButton1.setText("Zrusit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Meno", "Priezvisko", "Cislo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jLabel1.setText("Hľadanie");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(198, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(309, 309, 309))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
        zoznam_jframe scena = new zoznam_jframe();
        scena.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    //jTable2.setEditingRow(WIDTH);
    jTable2.setEnabled(false);
        if(stav){
        
        Object[] options = {"Vzmazat",
                    "Upravit",
                    "Zrusit",};
        Component frame = null;
    int n = JOptionPane.showOptionDialog(frame,
        "Chcete urpaviť, alebo vzmazať tento záznam",
        "Upraviť / Vymazať",
        JOptionPane.YES_NO_CANCEL_OPTION,

        JOptionPane.YES_OPTION,
        null,
        options,
        options[2]);
    if(n == JOptionPane.YES_NO_CANCEL_OPTION){
        stav = false;
            a = jTextField1.getText();
            b = jTextField2.getText();
            c = jTextField3.getText();
            jTextField1.setEditable(true);
            jTextField2.setEditable(true);
            jTextField3.setEditable(true);
            jButton1.setVisible(true);
            jButton2.setText("Ulozit");
            System.out.println("edit");
    }
    else if(n == JOptionPane.YES_OPTION){
        stav = true;
        System.out.println("delete");
        try{
            conn = (Connection) DriverManager.getConnection(url, user, password);
            String sql = "DELETE FROM zoznam WHERE id = " + id;
            PreparedStatement dotaz = conn.prepareStatement(sql);
            dotaz.executeUpdate();
            VypisDB();
        }
        catch (Exception ex) {
            System.out.println("niečo zle");
            JOptionPane.showMessageDialog(null, ex);
        } 

         
    }
    }
    else {
        if(jTextField1.getText().isEmpty() && (jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty()))
        {System.out.println("prazdne");}
        else {
            /*CisloClass tel_cislo = new CisloClass();
            tel_cislo.setMeno(jTextField1.getText());
            tel_cislo.setPriezvisko(jTextField2.getText());
            tel_cislo.setCislo(jTextField3.getText());*/
            //tel_cislo.ZapisDoDB();
            try{
            conn = (Connection) DriverManager.getConnection(url, user, password);
            String sql = "UPDATE zoznam SET Meno = ?, Priezvisko = ?, Cislo = ? WHERE Id  = " + id;
            PreparedStatement dotaz = conn.prepareStatement(sql);
            dotaz.setString(1, jTextField1.getText());
            dotaz.setString(2, jTextField2.getText());
            dotaz.setString(3, jTextField3.getText());
            dotaz.executeUpdate();
            VypisDB();
        }
        catch (Exception ex) {
            System.out.println("niečo zle");
            JOptionPane.showMessageDialog(null, ex);
        } 
            System.out.println("Ulozene");
        }
        jButton2.setText("Edit");
        jButton1.setVisible(false);
        stav = true;
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton2.setText("Edit");
        jTextField1.setText(a);
        jTextField2.setText(b);
        jTextField3.setText(c);
        jButton1.setVisible(false);
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        stav = true;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
         DefaultTableModel RecordTable = (DefaultTableModel)jTable2.getModel();

       int SelectedRows = jTable2.getSelectedRow();
       id = RecordTable.getValueAt(SelectedRows,0).toString();
       jTextField1.setText(RecordTable.getValueAt(SelectedRows,1).toString());
       jTextField2.setText(RecordTable.getValueAt(SelectedRows,2).toString());
       jTextField3.setText(RecordTable.getValueAt(SelectedRows,3).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        VypisDBHladanie();
    }//GEN-LAST:event_jTextField4KeyReleased

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
            java.util.logging.Logger.getLogger(zoznam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(zoznam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(zoznam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(zoznam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new zoznam().setVisible(true);
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
