package view.entrega;

import view.entrega.*;
import Service.GetSelectedObjectService;
import controller.LogTrack;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import model.Funcionario;


import model.*;
import view.cliente.JPanelConsultaCliente;
import view.produto.JPanelConsultaProduto;
import view.venda.JPanelConsultaVenda;




public class JFrameEntregaCRUD extends javax.swing.JFrame {
    
    private Entrega data;
    private Venda venda;
    private Funcionario logado;

    public JFrameEntregaCRUD(Entrega data,Funcionario logado) {
        initComponents();
        this.logado = logado;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        try{
            if( data == null ) {
                this.data  = new Entrega();
            } else {
                this.data = data;
                dataUp();
        }
        }catch (Exception ex) {
            LogTrack.getInstance().addException(ex, false, this);
        }
    }
    
    
    
    private void dataDown() throws Exception {
        data.setIdEntrega(Integer.parseInt(jTextFieldIdEntrega.getText()));
        data.setNomeDistribuidora(jTextFieldNomeDistribuidora.getText());
        data.setPrevisaoEntrega(jDateChooser.getDate());
        
        
    }
    
    
    
    private void dataUp() {
        jTextFieldIdEntrega.setText(String.valueOf(data.getIdEntrega()));
        jTextFieldNomeDistribuidora.setText(data.getNomeDistribuidora());
        jDateChooser.setDate(data.getPrevisaoEntrega());
        
        if( data.getVenda() != null ) {
            jTextFieldVenda.setText(String.valueOf(data.getVenda().getIdVenda()));
        }
        
    }
    
    
    
    
    private void exclude() throws Exception{
        dataDown();
        
        try {
            this.data.delete();
            this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
        } catch (SQLException ex) {
            LogTrack.getInstance().addException(ex, false, this);
        }
    }
    
    
    
    
    private void save(){
        try {
            checkInput();
            dataDown();
        
            data.save();
            this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
        } catch (Exception ex) {
            LogTrack.getInstance().addException(ex, true, this);;
        }
    }

    

  
    private void checkInput() throws Exception {
        if( jTextFieldIdEntrega.getText().isEmpty() ) throw new Exception("Informe ID da Entrega.");
          
        else if(!jTextFieldIdEntrega.getText().matches("\\d+")) throw new Exception("O campo ID Entrega deve ser um número.");
        
        if(jTextFieldVenda.getText().isEmpty() )  throw new Exception("Informe a venda atrelada!");
        
        if(jTextFieldNomeDistribuidora.getText().isEmpty() )  throw new Exception("Informe a distribuidora!");
    }
    
    private void setVenda(GetSelectedObjectService panel) throws Exception{
        Venda venda = (Venda) panel.getSelected();
        if(venda == null) return;
        
        data.setVenda(venda);
        jTextFieldVenda.setText(String.valueOf(venda.getIdVenda()));
    }
    
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextFieldIdEntrega = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonSelecionarVenda = new javax.swing.JButton();
        jLabelEspecialidade1 = new javax.swing.JLabel();
        jTextFieldVenda = new javax.swing.JTextField();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jTextFieldNomeDistribuidora = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entrega");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextFieldIdEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdEntregaActionPerformed(evt);
            }
        });

        jLabel1.setText("id Entrega");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jButtonSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonSalvarKeyPressed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        jButtonExcluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonExcluirKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel15.setText("Informações da Entrega:");

        jLabel3.setText("Previsão Entrega");

        jButtonSelecionarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/pngs/search-icon.png"))); // NOI18N
        jButtonSelecionarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarVendaActionPerformed(evt);
            }
        });

        jLabelEspecialidade1.setText("IdVenda");

        jTextFieldVenda.setEditable(false);
        jTextFieldVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVendaActionPerformed(evt);
            }
        });

        jTextFieldNomeDistribuidora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeDistribuidoraActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome Distribuidora");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelEspecialidade1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSelecionarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldIdEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldNomeDistribuidora, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSalvar)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel15)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldNomeDistribuidora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSelecionarVenda)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelEspecialidade1)
                                .addComponent(jTextFieldVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldIdEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonSalvar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        save();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        try {
            exclude();
        } catch (Exception ex) {
           LogTrack.getInstance().addException(ex, false, this);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonSalvarKeyPressed
        save();
    }//GEN-LAST:event_jButtonSalvarKeyPressed

    private void jButtonExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonExcluirKeyPressed
        try {
            exclude();
        } catch (Exception ex) {
            Logger.getLogger(JFrameEntregaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonExcluirKeyPressed

    private void jTextFieldIdEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdEntregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdEntregaActionPerformed

    private void jButtonSelecionarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarVendaActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
            frame.setVisible(true);
            try {
                JPanelConsultaVenda panel = new JPanelConsultaVenda(null,logado,true);
                frame.add(panel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                
                panel.jButtonSelecionar.addActionListener((ActionEvent e) -> {
                    try {
                        setVenda(panel);
                        frame.dispose();
                    } catch (Exception ex) {
                        LogTrack.getInstance().addException(ex, false, this);
                    }
                });
                
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        try {
                            setVenda(panel);
                        } catch (Exception ex) {
                            LogTrack.getInstance().addException(ex, false, frame);
                        }
                    }
                });
            } catch (SQLException ex) {
                LogTrack.getInstance().addException(ex, true, this);
            }
    }//GEN-LAST:event_jButtonSelecionarVendaActionPerformed

    private void jTextFieldVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVendaActionPerformed

    private void jTextFieldNomeDistribuidoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeDistribuidoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeDistribuidoraActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    public javax.swing.JButton jButtonSelecionarVenda;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelEspecialidade1;
    private javax.swing.JTextField jTextFieldIdEntrega;
    private javax.swing.JTextField jTextFieldNomeDistribuidora;
    private javax.swing.JTextField jTextFieldVenda;
    // End of variables declaration//GEN-END:variables


}
