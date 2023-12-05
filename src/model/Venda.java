package model;

import controller.DataAccessObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// mapeamento com a tabela especialidades
public class Venda extends DataAccessObject {

    private int idVenda;
    private Date dataCompra;
    
    //private float preco;
    private Funcionario funcionario;
    private Cliente cliente;
    private Produto produto;
    
    
    public Venda() {
        super("vendas");
    }    

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        // verificar se o estado do objeto precisar alterar/modificar
        if( this.idVenda !=  idVenda ) {
            this.idVenda = idVenda;
            // informar que um campo da tabela foi alterado
            addChange("id_venda", 
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
                
                this.funcionario = new Funcionario();
                this.funcionario.setIdFuncionario(funcionario.getIdFuncionario());
                this.funcionario.load();
                addChange( "id_funcionario", this.funcionario.getIdFuncionario());
                
            }
            
        } else {
            
            if( funcionario == null ) {
                
                this.funcionario = null;
                addChange( "id_funcionario", null );
                
            } else {
                
                if( !this.funcionario.equals( funcionario ) ) {
                    
                    this.funcionario.setIdFuncionario(funcionario.getIdFuncionario());
                    this.funcionario.load();
                    addChange( "id_funcionario", this.funcionario.getIdFuncionario());
                    
                }
                
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
                
                this.produto = new Produto();
                this.produto.setIdProduto(produto.getIdProduto());
                this.produto.load();
                addChange( "id_produto", this.produto.getIdProduto());
                
            }
            
        } else {
            
            if( produto == null ) {
                
                this.produto = null;
                addChange( "id_produto", null );
                
            } else {
                
                if( !this.produto.equals( produto ) ) {
                    
                    this.produto.setIdProduto(produto.getIdProduto());
                    this.produto.load();
                    addChange( "id_produto", this.produto.getIdProduto());
                    
                }
                
            }
        }
        
    }
    
    

    @Override
    protected String getWhereClauseForOneEntry() {
        // utilizar somente chaves primárias
        return " id_venda = " + this.idVenda;
    }

    @Override
    protected void fill(ArrayList<Object> data) {
        // ordem do preenchimento segue a ordem definida na criação da tabela
        this.idVenda = (int) data.get(0);
        this.dataCompra = (Date) data.get(1);
        this.funcionario = (Funcionario) data.get(2);
        this.cliente = (Cliente) data.get(3);
        this.produto = (Produto) data.get(4);

    }

}