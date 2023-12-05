package model;


public class Localidade  {
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    
    
    
    
  
    public Localidade setAllElements(String cidade, String bairro, String rua, String numero){
        setCidade(cidade);
        setBairro(bairro);
        setRua(rua);
        setNumero(numero);
        return this;
    }
    
    
    
    
    

    
    
    public String getCidade(){
        return this.cidade;
    }
    
    public void setCidade(String cidade){
        if(cidade != null)  cidade = cidade.toLowerCase();
        
        this.cidade = cidade;
    }
    
    
    
    public String getBairro(){
        return this.bairro;
    }
    
    public void setBairro(String bairro){
       if(bairro != null)  bairro = bairro.toLowerCase();
        
        this.bairro = bairro;
    }
    
    
    
    public String getRua(){
        return this.rua;
    }
    
    public void setRua(String rua){
        if(rua != null)  rua = rua.toLowerCase();
       
        this.rua = rua;
    }

    
    
    public String getNumero(){
        return this.numero;
    }
    
    public void setNumero(String numero){
        if(numero != null)  numero = numero.toLowerCase();
        
        this.numero = numero;
    }
    
    
    
   
    

    
    @Override
    public boolean equals(Object obj) {
        Localidade nova = (Localidade) obj;
        return this.toString().equals(nova.toString());
    }

    @Override
    public String toString() {
        return  this.cidade + " " + this.bairro + " " + this.rua + " " + this.numero;
    }
    
    
}

