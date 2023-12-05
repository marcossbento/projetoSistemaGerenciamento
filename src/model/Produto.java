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
    private Date dataMaxTroca;
    
    
    public Produto() {
        super("produtos");
    }    

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        // verificar se o estado do objeto precisar alterar/modificar
        if( this.idProduto !=  idProduto ) {
            this.idProduto = idProduto;
            // informar que um campo da tabela foi alterado
            addChange("codigo_produto", 
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

    public Date getDataMaxTroca() {
        return dataMaxTroca;
    }

    public void setDataMaxTroca(Date dataMaxTroca) {
        if(dataMaxTroca.equals(this.dataMaxTroca))return;
        this.dataMaxTroca = dataMaxTroca;
        addChange("data_max_troca", new SimpleDateFormat("yyyy/MM/dd").format(dataMaxTroca).replaceAll("\\p{Punct}", "-") );
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
        this.dataMaxTroca = (Date) data.get(3);
    }

}