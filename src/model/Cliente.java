package model;

import controller.DataAccessObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Cliente extends DataAccessObject {

    // atributos mapeamento Objeto-Relacional
    private int idCliente;
    private String nomeCliente;
    private String cpf;
    private Date dataNascimento;
    private Localidade localidade = new Localidade();

    public Cliente() {
        super("Clientes");
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {

        if (idCliente != this.idCliente) {

            this.idCliente = idCliente;
            addChange("id_cliente", this.idCliente);
        }
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {

        if (!nomeCliente.equals(this.nomeCliente)) {

            this.nomeCliente = nomeCliente;
            addChange("nome_cliente", this.nomeCliente);
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {

        if (!cpf.equals(this.cpf)) {

            this.cpf = cpf;
            addChange("cpf", this.cpf);
        }
    }
    
     
    public Date getDataNascimento() {
        return dataNascimento;
    }

   
    public void setDataNascimento(Date dataNascimento) {
        if(dataNascimento.equals(this.dataNascimento))return;
        this.dataNascimento = dataNascimento;
        addChange("data_nascimento", new SimpleDateFormat("yyyy/MM/dd").format(dataNascimento).replaceAll("\\p{Punct}", "-") );
    }


    public void setLocalidade(Localidade localidade) {

        if (localidade.equals(this.localidade)) {
            return;
        }

        this.localidade = localidade;
        addChange("cidade", localidade.getCidade());
        addChange("bairro", localidade.getBairro());
        addChange("rua", localidade.getRua());
        addChange("numero", localidade.getNumero());
    }

    public Localidade getLocalidade() {
        return this.localidade;
    }

    @Override
    protected String getWhereClauseForOneEntry() {
        return " id_cliente = " + this.idCliente;
    }

    @Override
    protected void fill(ArrayList<Object> data) {
        this.idCliente = (int) data.get(0);
        this.cpf = (String) data.get(1);
        this.setDataNascimento((Date)data.get(2));
        this.nomeCliente = (String) data.get(3);
        this.localidade.setAllElements((String) data.get(7), (String) data.get(5), (String) data.get(4), (String) data.get(6));
    }

   
}
