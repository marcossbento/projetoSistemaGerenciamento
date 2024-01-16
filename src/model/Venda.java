package model;

import controller.DataAccessObject;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

// mapeamento com a tabela especialidades
public class Venda extends DataAccessObject {

    private int idVenda;
    private Date dataCompra;
    
    //private float preco;
    private Funcionario funcionario;
    private Cliente cliente;
    private Produto produto;
    
    
    public Venda() {
        super("Vendas");
    }    

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        // verificar se o estado do objeto precisar alterar/modificar
        if( this.idVenda !=  idVenda ) {
            this.idVenda = idVenda;
            // informar que um campo da tabela foi alterado
            addChange("id_vendas", 
                    this.idVenda);
        }
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        if(dataCompra.equals(this.dataCompra))return;
        this.dataCompra = dataCompra;
        addChange("data_compra", new SimpleDateFormat("yyyy/MM/dd").format(dataCompra).replaceAll("\\p{Punct}", "-") );
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) throws Exception {
        
        if( this.funcionario  == null ) {
            
            if( funcionario != null ) {
                
                this.funcionario = funcionario;
                addChange( "id_funcionario", this.funcionario.getIdFuncionario());
            }
            
        } else {
            if( !this.funcionario.equals( funcionario ) ) {
                this.funcionario = funcionario;
                addChange( "id_funcionario", this.funcionario.getIdFuncionario());
                }
                
            }
        }
  
    
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) throws Exception {
        
        if( this.cliente  == null ) {
            
            if( cliente != null ) {
                
                this.cliente = new Cliente();
                this.cliente.setIdCliente(cliente.getIdCliente());
                this.cliente.load();
                addChange( "id_cliente", this.cliente.getIdCliente());
                
            }
            
        } else {
            
            if( cliente == null ) {
                
                this.cliente = null;
                addChange( "id_cliente", null );
                
            } else {
                
                if( !this.cliente.equals( cliente ) ) {
                    
                    this.cliente.setIdCliente(cliente.getIdCliente());
                    this.cliente.load();
                    addChange( "id_cliente", this.cliente.getIdCliente());
                    
                }
                
            }
        }
        
    }
    
    public Produto getProduto() {
        return produto;
    }
    
    public void setProduto(Produto produto) throws Exception {
        
        if( this.produto  == null ) {
            
            if( produto != null ) {
                
                this.produto = produto;
                addChange( "id_produto", this.produto.getIdProduto());
                
            }
            
        } 
           else {
                if( !this.produto.equals( produto ) ) {
                    this.produto = produto;
                    addChange( "id_produto", this.produto.getIdProduto());
                }
                
            }
        }
        
    
    
    

    @Override
    protected String getWhereClauseForOneEntry() {
        // utilizar somente chaves primárias
        return " id_vendas = " + this.idVenda;
    }

    @Override
    protected void fill(ArrayList<Object> data) {
        try {
            // ordem do preenchimento segue a ordem definida na criação da tabela
            this.idVenda = (int) data.get(0);
            this.dataCompra = (Date) data.get(1);
            
            this.funcionario = new Funcionario();
            this.funcionario.setIdFuncionario((int)data.get(2));
            this.funcionario.load();
            
            this.cliente = new Cliente();
            this.cliente.setIdCliente((int) data.get(3));
            this.cliente.load();
            
            this.produto = new Produto();
            this.produto.setIdProduto((int)data.get(4));
            this.produto.load();
        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    @Override
    public boolean equals(Object obj) {
        Venda comparada = (Venda) obj;
                
        return this.getIdVenda() == comparada.getIdVenda();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.idVenda;
        return hash;
    }
    

}