package view.funcionario;


import controller.LogTrack;
import controller.ResultSetTableModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Funcionario;

import service.FilterTableService;



public class JPanelConsultaFuncionario extends javax.swing.JPanel {
  
    private Funcionario data ;
    private final String query = "SELECT * from Funcionarios";
    private ResultSetTableModel result;
    private final TableRowSorter<TableModel> filter;
   
    public JPanelConsultaFuncionario(Funcionario data) throws SQLException {
        initComponents();
        this.data = data;
        if(!data.getCargo().toUpperCase().equals("GERENTE"))  {
            jButtonAdicionar.setEnabled(false);
            jButtonAlterar.setEnabled(false);
        }
        
        
     
        jButtonSelecionar.setEnabled(false);
        
        
        result = new ResultSetTableModel(query);
        jTableFuncionario.setModel(result);
        
        filter = new TableRowSorter<TableModel>(result);
        jTableFuncionario.setRowSorter(filter);
    }
    
    
    
    
    
    
    private void add(){
        JFrameFuncionarioCRUD crud = new JFrameFuncionarioCRUD(null);
       
        crud.addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosed(java.awt.event.WindowEvent evt){
                try {
                    result.setQuery(query);
                } catch (SQLException ex) {
                    LogTrack.getInstance().addException(ex, false, crud);
                }
            }
        });
    }
    
    
    
    private void change(){
         int row = jTableFuncionario.getSelectedRow();
        
       
        
        try {
             if(row == -1) return;
             data = new Funcionario();
            data.setIdFuncionario((int) result.getValueAt(row, 0));
            data.load();
            
            JFrameFuncionarioCRUD crud = new JFrameFuncionarioCRUD(data);
            jButtonAlterar.setEnabled(false);
            
            crud.addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosed(java.awt.event.WindowEvent evt){
                try {
                    result.setQuery(query);
                    jButtonAlterar.setEnabled(true);
                } catch (SQLException ex) {
                    LogTrack.getInstance().addException(ex, false, crud);
                }
            }
        });
    
        } catch (SQLException ex) {
            LogTrack.getInstance().addException(ex);
        }
    }  

   
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonSelecionar = new javax.swing.JButton();
        jButtonFiltrar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneFiltrar = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableFuncionario = new javax.swing.JTable();
        jLabelFiltro = new javax.swing.JLabel();

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });
        jButtonAlterar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAlterarKeyPressed(evt);
            }
        });

        jButtonSelecionar.setText("Selecionar");
        jButtonSelecionar.setEnabled(false);
        jButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarActionPerformed(evt);
            }
        });

        jButtonFiltrar1.setText("Filtrar");
        jButtonFiltrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrar1ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jTextPaneFiltrar);

        jTableFuncionario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTableFuncionario.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableFuncionario.setOpaque(false);
        jTableFuncionario.setRowHeight(30);
        jScrollPane3.setViewportView(jTableFuncionario);

        jLabelFiltro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelFiltro.setForeground(new java.awt.Color(102, 102, 102));
        jLabelFiltro.setText("Filtro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabelFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButtonFiltrar1)
                .addGap(18, 18, 18)
                .addComponent(jButtonSelecionar)
                .addGap(27, 27, 27)
                .addComponent(jButtonAlterar)
                .addGap(61, 61, 61)
                .addComponent(jButtonAdicionar)
                .addContainerGap(137, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonFiltrar1)
                        .addComponent(jButtonSelecionar)
                        .addComponent(jButtonAdicionar)
                        .addComponent(jButtonAlterar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelFiltro)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        add();
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        change();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonAlterarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonAlterarKeyPressed
        change();
    }//GEN-LAST:event_jButtonAlterarKeyPressed

    private void jButtonFiltrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrar1ActionPerformed
        new FilterTableService().filtrar(filter, jTextPaneFiltrar);
    }//GEN-LAST:event_jButtonFiltrar1ActionPerformed

    private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSelecionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonFiltrar1;
    private javax.swing.JButton jButtonSelecionar;
    private javax.swing.JLabel jLabelFiltro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableFuncionario;
    private javax.swing.JTextPane jTextPaneFiltrar;
    // End of variables declaration//GEN-END:variables
}
