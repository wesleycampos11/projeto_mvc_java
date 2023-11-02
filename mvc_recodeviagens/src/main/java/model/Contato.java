package model;

import java.util.Date;

public class Contato {
    
    private int id;
    private String nome, email, telefone, assunto, comentario;
    private Date dataCadastro;
    private Boolean cadastrado, logado;
    
     
    public int getId() {
        return id;
    }
    

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getNome() {
        return nome;
    }
    

    public void setNome(String nome) {
        this.nome = nome;
    }
    
      
    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    

    
    public String getTelefone() {
        return telefone;
    }
    

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
  
    public String getAssunto() {
        return assunto;
    }
    

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    
    
    public String getComentario() {
        return comentario;
    }
    

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
  
    
    public Date getDataCadastro() {
        return dataCadastro;
    }
    

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    
    

    public Boolean getCadastrado() {
        return cadastrado;
    }
    

    public void setCadastrado(Boolean cadastrado) {
        this.cadastrado = cadastrado;
    }
    

     


    public Boolean getLogado() {
        return logado;
    }
    

    public void setLogado(Boolean logado) {
        this.logado = logado;
    }
    


   
    public void finalizarCompra() {
       
    }
    

    public void cancelarCompra() {
       
    }
    
    
}