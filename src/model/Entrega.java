package model;

import controller.DataAccessObject;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

// mapeamento com a tabela especialidades
public class Entrega extends DataAccessObject {

    private int idEntrega;
    private String nomeDistribuidora;
    private Date previsaoEntrega;
    
    private Venda venda;
    
    
    public Entrega() {
        super("Entregas");
    }    

    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        // verificar se o estado do objeto precisar alterar/modificar
        if( this.idEntrega !=  idEntrega ) {
            this.idEntrega = idEntrega;
            // informar que um campo da tabela foi alterado
            addChange("id_entrega", 
                    this.idEntrega);
        }
    }

    public String getNomeDistribuidora() {
        return nomeDistribuidora;
    }

    public void setNomeDistribuidora(String nomeDistribuidora) {
        if( !nomeDistribuidora.equals( this.nomeDistribuidora ) ) {
            this.nomeDistribuidora = nomeDistribuidora;
             addChange("nome_distribuidora", 
                    this.nomeDistribuidora);
        }
    }
    
    

    public Date getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public void setPrevisaoEntrega(Date previsaoEntrega) {
        if(previsaoEntrega.equals(this.previsaoEntrega))return;
        this.previsaoEntrega = previsaoEntrega;
        addChange("previsao_entrega", new SimpleDateFormat("yyyy/MM/dd").format(previsaoEntrega).replaceAll("\\p{Punct}", "-") );
    }
    
    public Venda getVenda() {
        return venda;
    }
    
    public void setVenda(Venda venda) throws Exception {
        
        if( this.venda  == null ) {
            
            if( venda != null ) {
                
                this.venda = new Venda();
                this.venda.setIdVenda(venda.getIdVenda());
                this.venda.load();
                addChange( "id_vendas", this.venda.getIdVenda());
                
            }
            
        } else {
            
            if( venda == null ) {
                
                this.venda = null;
                addChange( "id_vendas", null );
                
            } else {
                
                if( !this.venda.equals( venda ) ) {
                    
                    this.venda.setIdVenda(venda.getIdVenda());
                    this.venda.load();
                    addChange( "id_vendas", this.venda.getIdVenda());
                    
                }
                
            }
        }
        
    }
    
    @Override
    protected String getWhereClauseForOneEntry() {
        // utilizar somente chaves primárias
        return " id_entrega = " + this.idEntrega;
    }

    @Override
    protected void fill(ArrayList<Object> data) {
        // ordem do preenchimento segue a ordem definida na criação da tabela
        this.idEntrega = (int) data.get(0);
        this.nomeDistribuidora = (String) data.get(1);
        this.previsaoEntrega = (Date) data.get(2);
        
        this.venda = new Venda();
        this.venda.setIdVenda((int)data.get(3));
        try {
            this.venda.load();
        } catch (SQLException ex) {
            Logger.getLogger(Entrega.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}