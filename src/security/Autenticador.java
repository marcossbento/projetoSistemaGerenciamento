package security;

import controller.DataBaseConnection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionario;




public class Autenticador {
    
    public Funcionario autenticar(String senha, int codigo_usuario) throws Exception{
        Funcionario typeUser = null;
        senha = new HashSecurity().execute(senha, codigo_usuario);
        DataBaseConnection dbConnection = DataBaseConnection.getInstance();
        String sql;
        sql = String.format("select senha, id_funcionario from Funcionarios where senha = '%s'  and  id_funcionario = %d",senha, codigo_usuario);
        System.out.println(sql);
        try {
            dbConnection.executeQuery(sql);
            Boolean status = dbConnection.getResultSet().next();
            
            if(!status) throw new Exception("Erro de login");
            else {
              typeUser= new Funcionario();
              typeUser.setIdFuncionario((int) dbConnection.getResultSet().getObject(2));
              typeUser.load();
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Autenticador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return typeUser ;
    }
}
