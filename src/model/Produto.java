package model;

import controller.DataAccessObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// mapeamento com a tabela especialidades
public class Produto extends DataAccessObject {

    private int idProduto;
    private String nomeProduto;
    private float preco;
    private int dataMaxTroca;
    
    
    public Produto() {
        super("Produtos");
    }    

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        // verificar se o estado do objeto precisar alterar/modificar
        if( this.idProduto !=  idProduto ) {
            this.idProduto = idProduto;
            // informar que um campo da tabela foi alterado
            addChange("id_produto", 
                    this.idProduto);
        }
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        if( !nomeProduto.equals( this.nomeProduto ) ) {
            this.nomeProduto = nomeProduto;
             addChange("nome_produto", 
                    this.nomeProduto);
        }
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if( this.preco !=  preco ) {
            this.preco = preco;
            // informar que um campo da tabela foi alterado
            addChange("preco", 
                    this.preco);
        }
    }

    public int getDataMaxTroca() {
        return dataMaxTroca;
    }

    public void setDataMaxTroca(int dataMaxTroca) {
        if( this.dataMaxTroca !=  dataMaxTroca ) {
            this.dataMaxTroca = dataMaxTroca;
            // informar que um campo da tabela foi alterado
            addChange("data_max_troca", 
                    this.dataMaxTroca);
        }
    }
    
    

    @Override
    protected String getWhereClauseForOneEntry() {
        // utilizar somente chaves primárias
        return " id_produto = " + this.idProduto;
    }

    @Override
    protected void fill(ArrayList<Object> data) {
        // ordem do preenchimento segue a ordem definida na criação da tabela
        this.idProduto = (int) data.get(0);
        this.nomeProduto = (String) data.get(1);
        this.preco = (float) data.get(2);
        this.dataMaxTroca = (int) data.get(3);
    }

}