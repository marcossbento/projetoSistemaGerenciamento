package view.cliente;


import Service.GetSelectedObjectService;
import controller.DataAccessObject;
import controller.LogTrack;
import controller.ResultSetTableModel;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Cliente;
import service.FilterTableService;



public class JPanelConsultaCliente extends javax.swing.JPanel implements GetSelectedObjectService{
  
    private Cliente data;
    private final String query = "SELECT * from Clientes ";
    private ResultSetTableModel result;
   private final TableRowSorter<TableModel> filter;
   
    public JPanelConsultaCliente(Cliente data,Boolean select) throws SQLException {
        initComponents();
        
        if(select == true) jButtonSelecionar.setEnabled(true);
        this.data = data;
        
        
        result = new ResultSetTableModel(query);
        jTableCliente.setModel(result);
        
        filter = new TableRowSorter<TableModel>(result);
        jTableCliente.setRowSorter(filter);
    }
    
    
    private void addCliente(){
        JFrameClienteCRUD crud = new JFrameClienteCRUD(null);
       
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
    
    
    
    private void changeCliente(){
       int row = jTableCliente.getSelectedRow();
        
        if(row == -1) return;
        data = new Cliente();
        data.setIdCliente((int) result.getValueAt(row, 0));
        
        try {
            data.load();
            
            JFrameClienteCRUD crud = new JFrameClienteCRUD(data);
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
        jButtonFiltrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneFiltrar = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
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

        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jTextPaneFiltrar);

        jTableCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableCliente.setOpaque(false);
        jTableCliente.setRowHeight(30);
        jScrollPane3.setViewportView(jTableCliente);

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
                .addComponent(jButtonFiltrar)
                .addGap(18, 18, 18)
                .addComponent(jButtonSelecionar)
                .addGap(27, 27, 27)
                .addComponent(jButtonAlterar)
                .addGap(61, 61, 61)
                .addComponent(jButtonAdicionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonFiltrar)
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        addCliente();
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        changeCliente();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonAlterarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonAlterarKeyPressed
        changeCliente();
    }//GEN-LAST:event_jButtonAlterarKeyPressed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        new FilterTableService().filtrar(filter, jTextPaneFiltrar);
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSelecionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonFiltrar;
    public javax.swing.JButton jButtonSelecionar;
    private javax.swing.JLabel jLabelFiltro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JTextPane jTextPaneFiltrar;
    // End of variables declaration//GEN-END:variables

    @Override
    public DataAccessObject getSelected() {
        Cliente cliente = new Cliente();
        int row = jTableCliente.getSelectedRow();
        if(row == -1) return null;
        
        cliente.setIdCliente((int) result.getValueAt(row, 0));
       
        try {
            cliente.load();
        } catch (SQLException ex) {
           LogTrack.getInstance().addException(ex);
        }
        return cliente;
    }

}
