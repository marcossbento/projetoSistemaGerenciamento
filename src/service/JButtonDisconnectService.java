package service;

import controller.DataBaseConnection;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;


public class JButtonDisconnectService extends JButton{
    DataBaseConnection db;
    
    public JButtonDisconnectService(JPanel jpanelTable){
        this.setText("X");
        this.addActionListener((ActionEvent e) -> {
                
        try {
            jpanelTable.removeAll();
            jpanelTable.validate();
            jpanelTable.repaint();
            db = DataBaseConnection.getInstance();
            db.disconnect();
            } catch (SQLException ex) {
                Logger.getLogger(JButtonDisconnectService.class.getName()).log(Level.SEVERE, null, ex);
            }         
        });
    }
}
