 package view.fornecedor;

import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Fornecedor;





public class JFrameFornecedorCRUD extends javax.swing.JFrame {
    
    private Fornecedor data;
  


    
    public JFrameFornecedorCRUD(Fornecedor data) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    
        this.data = data;
       
        
        if(data == null) this.data = new Fornecedor();
        else {
            this.data = data;
            dataUp();
        }
        
    }
    
    
    
    private void dataDown() {
      data.setIdFornecedor(Integer.parseInt(jTextFieldFornecedor.getText()));
      data.setCnpj(jTextFieldCnpj.getText());
      data.setEmail(jTextFieldEmail.getText());
      data.setNomeFornecedor(jTextFieldNome.getText());
      data.setTelefone(jTextFieldTelefone.getText());
      data.setProdutos(jTextPaneProdutos.getText());
    }
    
    
    
    private void dataUp() {
        jTextFieldFornecedor.setText(String.valueOf(data.getIdFornecedor()));
        jTextFieldNome.setText(data.getNomeFornecedor());
        jTextFieldTelefone.setText(data.getTelefone());
        jTextFieldCnpj.setText(data.getCnpj());
        jTextFieldEmail.setText(data.getEmail());
        jTextPaneProdutos.setText(data.getProdutos());
    }
    
    
    
    private void exclude(){
        dataDown();
        
        try {
            this.data.delete();
            this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
        } catch (SQLException ex) {
            Logger.getLogger(JFrameFornecedorCRUD.class.getName()).log(Level.SEVERE, null, ex);
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
        if( jTextFieldFornecedor.getText().isEmpty() ) throw new Exception("Informe ID.");
          
        else if(!jTextFieldFornecedor.getText().matches("\\d+")) throw new Exception("O campo ID deve ser um número.");
             
        if(jTextFieldNome.getText().isEmpty() )  throw new Exception("Informe um NOME.");    
        
    

    }
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldFornecedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCnpj = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneProdutos = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("ID  Fornecedor");

        jLabel2.setText("nome");

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

        jLabel3.setText("CNPJ");

        jLabel5.setText("telefone");

        jLabel6.setText("Email");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel15.setText("Fornecedor");

        jSeparator2.setMinimumSize(new java.awt.Dimension(35, 10));

        jScrollPane1.setViewportView(jTextPaneProdutos);

        jLabel7.setText("Produtos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(162, 162, 162)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                            .addComponent(jTextFieldTelefone)
                                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel15)
                        .addGap(254, 254, 254)))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonExcluir)
                .addGap(18, 18, 18)
                .addComponent(jButtonSalvar)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonExcluir)
                            .addComponent(jButtonSalvar))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addContainerGap(35, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        save();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        exclude();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonSalvarKeyPressed
        save();
    }//GEN-LAST:event_jButtonSalvarKeyPressed

    private void jButtonExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonExcluirKeyPressed
        exclude();
    }//GEN-LAST:event_jButtonExcluirKeyPressed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldCnpj;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFornecedor;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldTelefone;
    private javax.swing.JTextPane jTextPaneProdutos;
    // End of variables declaration//GEN-END:variables


}
