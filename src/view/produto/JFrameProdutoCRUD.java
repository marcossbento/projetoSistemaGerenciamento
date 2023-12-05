package view.produto;

import com.toedter.calendar.JCalendar;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Produto;




public class JFrameProdutoCRUD extends javax.swing.JFrame {
    
    private Produto data;
  


    
    public JFrameProdutoCRUD(Produto data) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    
        this.data = data;
       
        
        if(data == null) this.data = new Produto();
        else {
            this.data = data;
            dataUp();
        }
        
    }
    
    
    
    private void dataDown() {
        data.setIdProduto(Integer.parseInt(jTextFieldIdProduto.getText()));
        data.setPreco(Float.parseFloat(jTextFieldPreco.getText()));
        data.setNomeProduto(jTextFieldNome.getText());
        
    }
    
    
    
    private void dataUp() {
        jTextFieldIdProduto.setText(String.valueOf(data.getIdProduto()));
        jTextFieldNome.setText(data.getNomeProduto());
        jTextFieldPreco.setText(String.valueOf(data.getPreco()));
        jDateChooser.setDate(data.getDataMaxTroca());
    }
    
    
    
    
    private void exclude(){
        dataDown();
        
        try {
            this.data.delete();
            this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
        } catch (SQLException ex) {
            Logger.getLogger(JFrameProdutoCRUD.class.getName()).log(Level.SEVERE, null, ex);
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
        if( jTextFieldIdProduto.getText().isEmpty() ) throw new Exception("Informe ID.");
          
        else if(!jTextFieldIdProduto.getText().matches("\\d+")) throw new Exception("O campo ID deve ser um número.");
             
        if(jTextFieldNome.getText().isEmpty() )  throw new Exception("Informe um NOME.");    
        
    

    }
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldIdProduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextFieldIdProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdProdutoActionPerformed(evt);
            }
        });

        jLabel1.setText("id Produto");

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

        jLabel5.setText("Preço");

        jTextFieldPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecoActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel15.setText("Informações do Produto:");

        jSeparator2.setMinimumSize(new java.awt.Dimension(35, 10));

        jLabel3.setText("Data Max. Troca");

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
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(38, 38, 38)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldIdProduto))
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(jTextFieldPreco)))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel15)))
                .addContainerGap(43, Short.MAX_VALUE))
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
                    .addComponent(jTextFieldIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonSalvar))
                .addContainerGap(15, Short.MAX_VALUE))
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

    private void jTextFieldIdProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdProdutoActionPerformed

    private void jTextFieldPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrecoActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldIdProduto;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPreco;
    // End of variables declaration//GEN-END:variables


}
