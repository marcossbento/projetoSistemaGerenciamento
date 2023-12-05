package model;

import controller.DataAccessObject;
import java.util.ArrayList;
import security.HashSecurity;

public class Funcionario extends DataAccessObject {
    
    // atributos mapeamento Objeto-Relacional
    private int idFuncionario;
    private String nomeFuncionario;
    private String cpf;
    private float salario;
    private Localidade localidade = new Localidade();
    private String cargo;
    private String senha;

    public Funcionario() {
        super("Funcionarios");
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        
        if( idFuncionario != this.idFuncionario ) {
            
            this.idFuncionario = idFuncionario;
            addChange("id_funcionario", this.idFuncionario);
        }
    }
    
    public void setSenha(String senha){
        HashSecurity hash = new HashSecurity();
        senha = hash.execute(senha, this.idFuncionario);
        if( senha.equals( this.senha )) return;
    
        this.senha = senha;
        System.out.println(senha);
        addChange("senha", this.senha);
        
    }
    public String getSenha(){
        return this.senha;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        
        if( !nomeFuncionario.equals( this.nomeFuncionario ) ) {
            
            this.nomeFuncionario = nomeFuncionario;
            addChange("nome_funcionario", this.nomeFuncionario);
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        
        if( !cpf.equals( this.cpf ) ) {
            
            this.cpf = cpf;
            addChange("cpf", this.cpf);
        }
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        
        if( salario != this.salario ) {
            
            this.salario = salario;
            addChange("salario", this.salario);
        }        
    }
    public void setCargo(String cargo){
        if( cargo.equals( this.cargo )) return;
    
        this.cargo = cargo;
        addChange("cargo", this.cargo);
        
    }
    public String getCargo(){
        return this.cargo;
    }
    public Localidade getLocalidade() {
        return localidade;
    }
    
    public void setLocalidade(Localidade localidade) {
        
        if(localidade.equals(this.localidade)) return;
        
        this.localidade = localidade;
        addChange("cidade", localidade.getCidade());
        addChange("bairro", localidade.getBairro());
        addChange("rua", localidade.getRua());
        addChange("numero", localidade.getNumero());
    }

    
        
    @Override
    protected String getWhereClauseForOneEntry() {
        return " id_funcionario = " + this.idFuncionario;
    }

    @Override
    protected void fill(ArrayList<Object> data) {
        this.idFuncionario = (int) data.get(0);
        this.nomeFuncionario = (String) data.get(1);
        this.cpf = (String) data.get(2);
        this.salario = (float) data.get(3);
        this.cargo = (String) data.get(4);
        this.localidade.setAllElements( (String) data.get(8),  (String) data.get(6),  (String) data.get(5),  (String) data.get(7));
        this.senha = (String) data.get(9);
    }   
    
    
}