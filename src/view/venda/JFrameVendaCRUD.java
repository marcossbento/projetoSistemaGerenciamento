package view.venda;

import view.*;
import com.toedter.calendar.JCalendar;
import controller.LogTrack;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import model.Funcionario;


import model.*;
import view.cliente.JPanelConsultaCliente;




public class JFrameVendaCRUD extends javax.swing.JFrame {
    
    private Venda data;
    private Funcionario funcionario;
    private Cliente cliente;
    private Produto produto;
  
    private boolean disconnectOnClose;

    
    public JFrameVendaCRUD( Venda data, boolean disconnectOnClose ) throws Exception {
        initComponents();
        
        if( data == null ) {
            this.data  = new Venda();
        } else {
                        
            this.data = data;
            
            if( this.data.getFuncionario()!= null ) {         
                
                this.funcionario = new Funcionario();
                this.funcionario.setIdFuncionario(this.data.getFuncionario().getIdFuncionario());
                this.funcionario.load();
                
            }
            
            if( this.data.getCliente()!= null ) {
                
                this.cliente = new Cliente();
                this.cliente.setIdCliente(this.data.getCliente().getIdCliente());
                this.cliente.load();
                
            }
            
            if( this.data.getProduto() != null ) {
                
                this.produto = new Produto();
                this.produto.setIdProduto(this.data.getProduto().getIdProduto());
                this.produto.load();
                
            }
            
            dataUp();
            jTextFieldIdVenda.setEnabled(false);
            
        }
        
        this.disconnectOnClose = disconnectOnClose;
    }
    
    
    
    private void dataDown() throws Exception {
        data.setIdVenda(Integer.parseInt(jTextFieldIdVenda.getText()));
        data.setDataCompra(jDateChooser.getDate());
        
        data.setFuncionario(funcionario );
        
        data.setCliente(cliente );
        
        data.setProduto(produto ); 
    }
    
    
    
    private void dataUp() {
        jTextFieldIdVenda.setText(String.valueOf(data.getIdVenda()));
        jDateChooser.setDate(data.getDataCompra());
        
        if( data.getFuncionario().getNomeFuncionario()!= null ) {
            jTextFieldFuncionario.setText( data.getFuncionario().getNomeFuncionario());
        }
        
        if( data.getCliente().getNomeCliente()!= null ) {
            jTextFieldCliente.setText( data.getCliente().getNomeCliente());
        }
        
        if( data.getProduto().getNomeProduto()!= null ) {
            jTextFieldProduto.setText( data.getProduto().getNomeProduto());
        }
        
    }
    
    
    
    
    private void exclude() throws Exception{
        dataDown();
        
        try {
            this.data.delete();
            this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
        } catch (SQLException ex) {
            Logger.getLogger(JFrameVendaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    private void save(){
        try {
            checkInput();
            dataDown();
        
            data.save();
            this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    

  
    private void checkInput() throws Exception {
        if( jTextFieldIdVenda.getText().isEmpty() ) throw new Exception("Informe ID.");
          
        else if(!jTextFieldIdVenda.getText().matches("\\d+")) throw new Exception("O campo ID deve ser um número.");
             
        if(jTextFieldFuncionario.getText().isEmpty() )  throw new Exception("Informe um funcionário responsável!");
        
        if(jTextFieldCliente.getText().isEmpty() )  throw new Exception("Informe o cliente comprador!");
        
        if(jTextFieldProduto.getText().isEmpty() )  throw new Exception("Informe o produto comprado!");
        
    

    }
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldIdVenda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jButtonSelecionarCliente = new javax.swing.JButton();
        jButtonApagarCliente = new javax.swing.JButton();
        jLabelTipoUsuario = new javax.swing.JLabel();
        jTextFieldFuncionario = new javax.swing.JTextField();
        jButtonSelecionarFuncionario = new javax.swing.JButton();
        jButtonApagarFuncionario = new javax.swing.JButton();
        jLabelEspecialidade = new javax.swing.JLabel();
        jTextFieldCliente = new javax.swing.JTextField();
        jButtonSelecionarProduto = new javax.swing.JButton();
        jButtonApagarProduto = new javax.swing.JButton();
        jLabelEspecialidade1 = new javax.swing.JLabel();
        jTextFieldProduto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextFieldIdVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdVendaActionPerformed(evt);
            }
        });

        jLabel1.setText("id Venda");

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
        jLabel15.setText("Informações da Venda:");

        jLabel3.setText("Data Max. Troca");

        jButtonSelecionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarClienteActionPerformed(evt);
            }
        });

        jButtonApagarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarClienteActionPerformed(evt);
            }
        });

        jLabelTipoUsuario.setText("Funcionario");

        jTextFieldFuncionario.setEditable(false);

        jButtonSelecionarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarFuncionarioActionPerformed(evt);
            }
        });

        jButtonApagarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarFuncionarioActionPerformed(evt);
            }
        });

        jLabelEspecialidade.setText("Cliente");

        jTextFieldCliente.setEditable(false);

        jButtonSelecionarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarProdutoActionPerformed(evt);
            }
        });

        jButtonApagarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarProdutoActionPerformed(evt);
            }
        });

        jLabelEspecialidade1.setText("Produto");

        jTextFieldProduto.setEditable(false);
        jTextFieldProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel15)
                .addContainerGap(491, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTipoUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSelecionarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonApagarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabelEspecialidade1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonSelecionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonApagarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelEspecialidade)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonSelecionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonApagarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSelecionarFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonApagarFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelTipoUsuario)
                                .addComponent(jTextFieldFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSelecionarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonApagarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelEspecialidade)
                                .addComponent(jTextFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSelecionarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonApagarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelEspecialidade1)
                                .addComponent(jTextFieldProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
            Logger.getLogger(JFrameVendaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonSalvarKeyPressed
        save();
    }//GEN-LAST:event_jButtonSalvarKeyPressed

    private void jButtonExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonExcluirKeyPressed
        try {
            exclude();
        } catch (Exception ex) {
            Logger.getLogger(JFrameVendaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonExcluirKeyPressed

    private void jTextFieldIdVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdVendaActionPerformed

    private void jButtonSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarClienteActionPerformed
        // TODO add your handling code here:

        try {

            if( cliente == null ) {
                cliente = new Cliente();
            }

            JPanelConsultaCliente jPanelConsultaCliente;
            jPanelConsultaCliente = new JPanelConsultaCliente(cliente);

            jPanelConsultaCliente.add( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if( cliente.getNomeCliente()!= null ) {
                        jTextFieldCliente.setText( cliente.getNomeCliente());
                    }
                }
            } );

            jFrameConsulta.setVisible(true);
        } catch( Exception ex ) {
            LogTrack.getInstance().addException(ex, true, this);
            cliente = null;
        }

    }//GEN-LAST:event_jButtonSelecionarClienteActionPerformed

    private void jButtonApagarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarClienteActionPerformed
        // TODO add your handling code here:
        especialidade = null;
        jTextFieldCliente.setText( null );
    }//GEN-LAST:event_jButtonApagarClienteActionPerformed

    private void jButtonSelecionarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarFuncionarioActionPerformed
        // TODO add your handling code here:

        try {

            if( tipoUsuario == null ) {
                tipoUsuario = new TipoUsuario();
            }

            JFrameConsultaTipoUsuario jFrameConsulta;
            jFrameConsulta = new JFrameConsultaTipoUsuario( true, false, tipoUsuario );

            jFrameConsulta.addWindowListener( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if( tipoUsuario.getNome() != null ) {
                        jTextFieldFuncionario.setText( tipoUsuario.getNome() );
                    }
                }
            } );

            jFrameConsulta.setVisible(true);
        } catch( Exception ex ) {
            ex.printStackTrace();
            tipoUsuario = null;
        }
    }//GEN-LAST:event_jButtonSelecionarFuncionarioActionPerformed

    private void jButtonApagarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarFuncionarioActionPerformed
        // TODO add your handling code here:
        funcionario = null;
        jTextFieldFuncionario.setText( null );
    }//GEN-LAST:event_jButtonApagarFuncionarioActionPerformed

    private void jButtonSelecionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSelecionarProdutoActionPerformed

    private void jButtonApagarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonApagarProdutoActionPerformed

    private void jTextFieldProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProdutoActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApagarCliente;
    private javax.swing.JButton jButtonApagarFuncionario;
    private javax.swing.JButton jButtonApagarProduto;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSelecionarCliente;
    private javax.swing.JButton jButtonSelecionarFuncionario;
    private javax.swing.JButton jButtonSelecionarProduto;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelEspecialidade;
    private javax.swing.JLabel jLabelEspecialidade1;
    private javax.swing.JLabel jLabelTipoUsuario;
    private javax.swing.JTextField jTextFieldCliente;
    private javax.swing.JTextField jTextFieldFuncionario;
    private javax.swing.JTextField jTextFieldIdVenda;
    private javax.swing.JTextField jTextFieldProduto;
    // End of variables declaration//GEN-END:variables


}
