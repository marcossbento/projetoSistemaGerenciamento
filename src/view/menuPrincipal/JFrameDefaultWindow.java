package view.menuPrincipal;

import controller.LogTrack;
import java.awt.GridBagConstraints;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import model.Funcionario;
import service.JButtonDisconnectService;
import view.ConfirmarSaida;
import view.cliente.JPanelConsultaCliente;
import view.entrega.JPanelConsultaEntrega;
import view.fornecedor.JPanelConsultaFornecedor;
import view.funcionario.JPanelConsultaFuncionario;
import view.produto.JPanelConsultaProduto;
import view.venda.JPanelConsultaVenda;






public class JFrameDefaultWindow extends javax.swing.JFrame {
    private Funcionario logado = null;
    public JFrameDefaultWindow() {
        initComponents();
        
      
    }
        public JFrameDefaultWindow(Funcionario logado) {
        initComponents();
        this.logado = logado;
        
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
        jButtonVenda = new javax.swing.JButton();
        jButtonEntrega = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanelTable.setMaximumSize(new java.awt.Dimension(1286, 478));
        jPanelTable.setLayout(new java.awt.GridBagLayout());

        jButtonFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/pngs/funcionario.png"))); // NOI18N
        jButtonFuncionario.setText("Funcionarios");
        jButtonFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFuncionarioActionPerformed(evt);
            }
        });

        jButtonFuncionario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/pngs/fornecedor.png"))); // NOI18N
        jButtonFuncionario1.setText("Fornecedor");
        jButtonFuncionario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFuncionario1ActionPerformed(evt);
            }
        });

        jButtonCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/pngs/cliente.png"))); // NOI18N
        jButtonCliente.setText("Cliente");
        jButtonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClienteActionPerformed(evt);
            }
        });

        jButtonProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/pngs/produto.png"))); // NOI18N
        jButtonProduto.setText("Produto");
        jButtonProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdutoActionPerformed(evt);
            }
        });

        jButtonVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/pngs/venda.png"))); // NOI18N
        jButtonVenda.setText("Venda");
        jButtonVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendaActionPerformed(evt);
            }
        });

        jButtonEntrega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/pngs/entrega.png"))); // NOI18N
        jButtonEntrega.setText("Entrega");
        jButtonEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntregaActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/pngs/estoque.png"))); // NOI18N
        jLabel15.setText("SGEV-MENU");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonFuncionario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jPanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFuncionario)
                .addGap(37, 37, 37)
                .addComponent(jButtonFuncionario1)
                .addGap(36, 36, 36)
                .addComponent(jButtonCliente)
                .addGap(36, 36, 36)
                .addComponent(jButtonProduto)
                .addGap(30, 30, 30)
                .addComponent(jButtonVenda)
                .addGap(28, 28, 28)
                .addComponent(jButtonEntrega)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanelTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFuncionarioActionPerformed
        try {
            changeTable(new JPanelConsultaFuncionario(logado));
        } catch (SQLException ex) {
            LogTrack.getInstance().addException(ex, false, this);
        }
    }//GEN-LAST:event_jButtonFuncionarioActionPerformed

    private void jButtonFuncionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFuncionario1ActionPerformed
        try {
            changeTable(new JPanelConsultaFornecedor(null));
        } catch (SQLException ex) {
            LogTrack.getInstance().addException(ex, false, this);
        }
    }//GEN-LAST:event_jButtonFuncionario1ActionPerformed

    private void jButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClienteActionPerformed
         try {
            changeTable(new JPanelConsultaCliente(null,false));
        } catch (SQLException ex) {
            LogTrack.getInstance().addException(ex, false, this);
        }
    }//GEN-LAST:event_jButtonClienteActionPerformed

    private void jButtonProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdutoActionPerformed
        // TODO add your handling code here:
        try {
            changeTable(new JPanelConsultaProduto(null,false));
        } catch (SQLException ex) {
            LogTrack.getInstance().addException(ex, false, this);
        }
    }//GEN-LAST:event_jButtonProdutoActionPerformed

    private void jButtonVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVendaActionPerformed
        // TODO add your handling code here:
        try {
            changeTable(new JPanelConsultaVenda(null,logado,false));
        } catch (SQLException ex) {
            LogTrack.getInstance().addException(ex, false, this);
        }
    }//GEN-LAST:event_jButtonVendaActionPerformed

    private void jButtonEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntregaActionPerformed
        // TODO add your handling code here:
        try {
            changeTable(new JPanelConsultaEntrega(null,logado,false));
        } catch (SQLException ex) {
            LogTrack.getInstance().addException(ex, false, this);
        }
    }//GEN-LAST:event_jButtonEntregaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new ConfirmarSaida(this);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
  
    }//GEN-LAST:event_formWindowClosed

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
            @Override
            public void run() {
                JFrameDefaultWindow frame = new JFrameDefaultWindow();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
                 
             
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCliente;
    private javax.swing.JButton jButtonEntrega;
    private javax.swing.JButton jButtonFuncionario;
    private javax.swing.JButton jButtonFuncionario1;
    private javax.swing.JButton jButtonProduto;
    private javax.swing.JButton jButtonVenda;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    protected javax.swing.JPanel jPanelTable;
    // End of variables declaration//GEN-END:variables
}
