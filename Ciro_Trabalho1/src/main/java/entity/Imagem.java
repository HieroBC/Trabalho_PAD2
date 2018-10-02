/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import model.AbstractEntity;

/**
 *
 * @author Luana
 */

@Entity
@Dependent
public class Imagem extends AbstractEntity {

   @Column(length = 30)
   private String nome;
   @Column(length = 200)
   private String descricao;
   @Column(length = 50)
   private String local;
   @Column(length = 20)
   private String data;
   @Column (length = 50)
   private String autor;
   @Column (length = 20)
   private String dimensoes;
   @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
   private List<Tag> tags = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    
   
    public void addTag(Tag tag) {
     tags.add(tag);
     
     tag.getImagens().add(this);

    }

    public void removeTag(Tag tag) {
     tags.remove(tag);

     tag.getImagens().remove(this);
    } 

    
}
