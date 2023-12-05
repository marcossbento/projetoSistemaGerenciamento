package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class Fornecedor extends DataAccessObject {
    // ordem das colunas da tabela usuarios
    private int idFornecedor;
    private String nomeFornecedor;
    private String cnpj;
    private String telefone;
    private String email;
    private String produtos;
    

    public Fornecedor() {
        super("Fornecedor");
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getProdutos() {
        return produtos;
    }
    

    public void setIdFornecedor(int idFornecedor) {
        if( idFornecedor != this.idFornecedor ) {
            this.idFornecedor = idFornecedor;
            addChange("id_fornecedor", this.idFornecedor);
        }
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        if( !nomeFornecedor.equals( this.nomeFornecedor ) ) {
            this.nomeFornecedor = nomeFornecedor;
            addChange("nome_fornecedor", this.nomeFornecedor);
        }
    }

    public void setCnpj(String cnpj) {
        if( !cnpj.equals( this.cnpj ) ) {
            this.cnpj = cnpj;
            addChange("cnpj", this.cnpj);
        }
    }

    public void setTelefone(String telefone) {
        if( !telefone.equals( this.telefone ) ) {
            this.telefone = telefone;
            addChange("telefone", this.telefone);
        }
    }

    public void setEmail(String email) {
        if( !email.equals( this.email ) ) {
            this.email = email;
            addChange("email", this.email);
        }
    }

    public void setProdutos(String produtos) {
        if( !produtos.equals( this.produtos ) ) {
            this.produtos = produtos;
            addChange("produtos", this.produtos);
        }
    }
    

    @Override
    protected String getWhereClauseForOneEntry() {
        return " id_fornecedor = " + idFornecedor;
    }

    @Override
    protected void fill(ArrayList<Object> data) {
        // ordem das colunas da tabela usuarios
        idFornecedor = (int) data.get(0);
        nomeFornecedor = (String) data.get(1);
        cnpj = (String) data.get(2);
        telefone = (String) data.get(3);
        email = (String) data.get(4);
        produtos = (String) data.get(5);
    }
        
}