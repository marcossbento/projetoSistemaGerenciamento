package view.principal;

import java.awt.GridBagConstraints;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import model.Funcionario;
import service.JButtonDisconnectService;
import view.cliente.JPanelConsultaCliente;
import view.fornecedor.JPanelConsultaFornecedor;
import view.funcionario.JPanelConsultaFuncionario;
import view.produto.JPanelConsultaProduto;






public class JFrameDefaultWindow extends javax.swing.JFrame {

    public JFrameDefaultWindow() {
        initComponents();
        
      
    }
        public JFrameDefaultWindow(Funcionario logado) {
        initComponents();
        
    }
    
    public void changeTable(JPanel panel){
        this.jPanelTable.removeAll();
        this.jPanelTable.repaint();
        this.jPanelTable.validate();
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        this.jPanelTable.add(new JButtonDisconnectService(jPanelTable),c);
        
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 1; 
        this.jPanelTable.add(panel,c);
        
       
        this.jPanelTable.repaint();
        this.jPanelTable.validate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanelTable = new javax.swing.JPanel();
        jButtonFuncionario = new javax.swing.JButton();
        jButtonFuncionario1 = new javax.swing.JButton();
        jButtonCliente = new javax.swing.JButton();
        jButtonProduto = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanelTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelTable.setMaximumSize(new java.awt.Dimension(1286, 478));
        jPanelTable.setLayout(new java.awt.GridBagLayout());

        jButtonFuncionario.setText("Funcionarios");
        jButtonFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFuncionarioActionPerformed(evt);
            }
        });

        jButtonFuncionario1.setText("Fornecedor");
        jButtonFuncionario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFuncionario1ActionPerformed(evt);
            }
        });

        jButtonCliente.setText("Cliente");
        jButtonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClienteActionPerformed(evt);
            }
        });

        jButtonProduto.setText("Produto");
        jButtonProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonFuncionario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jPanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jButtonFuncionario)
                .addGap(37, 37, 37)
                .addComponent(jButtonFuncionario1)
                .addGap(36, 36, 36)
                .addComponent(jButtonCliente)
                .addGap(36, 36, 36)
                .addComponent(jButtonProduto)
                .addContainerGap(233, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFuncionarioActionPerformed
        try {
            changeTable(new JPanelConsultaFuncionario(null));
        } catch (SQLException ex) {
            Logger.getLogger(JFrameDefaultWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonFuncionarioActionPerformed

    private void jButtonFuncionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFuncionario1ActionPerformed
        try {
            changeTable(new JPanelConsultaFornecedor(null));
        } catch (SQLException ex) {
            Logger.getLogger(JFrameDefaultWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonFuncionario1ActionPerformed

    private void jButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClienteActionPerformed
         try {
            changeTable(new JPanelConsultaCliente(null));
        } catch (SQLException ex) {
            Logger.getLogger(JFrameDefaultWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonClienteActionPerformed

    private void jButtonProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdutoActionPerformed
        // TODO add your handling code here:
        try {
            changeTable(new JPanelConsultaProduto(null));
        } catch (SQLException ex) {
            Logger.getLogger(JFrameDefaultWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonProdutoActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameDefaultWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameDefaultWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameDefaultWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameDefaultWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrameDefaultWindow frame = new JFrameDefaultWindow();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
                 
             
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCliente;
    private javax.swing.JButton jButtonFuncionario;
    private javax.swing.JButton jButtonFuncionario1;
    private javax.swing.JButton jButtonProduto;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    protected javax.swing.JPanel jPanelTable;
    // End of variables declaration//GEN-END:variables
}
