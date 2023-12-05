package view;



import model.Funcionario;

import security.Autenticador;
import view.principal.JFrameDefaultWindow;

public class Login extends javax.swing.JFrame {
    private Funcionario logado;
    
    public Login() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCodigoUsuario = new javax.swing.JLabel();
        jTextFieldCodigoUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonEntrar = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");

        jLabelCodigoUsuario.setText("codigo usuario");

        jLabel1.setText("senha");

        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelCodigoUsuario)
                .addGap(27, 27, 27)
                .addComponent(jTextFieldCodigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEntrar)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigoUsuario)
                    .addComponent(jTextFieldCodigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(jButtonEntrar)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        try {
            logado = new Autenticador().autenticar(jPasswordField.getText(),Integer.parseInt(jTextFieldCodigoUsuario.getText()));
            this.dispose();
            JFrameDefaultWindow frame =  new JFrameDefaultWindow(logado);
            frame.setTitle("Funcionario: " + logado.getNomeFuncionario());
            frame.setVisible(true);
        } catch (Exception ex) {
            ErroLogin errorFrame =  new ErroLogin();
            errorFrame.setLocationRelativeTo(null);
            errorFrame.setVisible(true);
        }
    }//GEN-LAST:event_jButtonEntrarActionPerformed
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Login frame =  new Login();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCodigoUsuario;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldCodigoUsuario;
    // End of variables declaration//GEN-END:variables
}
