/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import model.AbstractEntity;

/**
 *
 * @author Luana
 */
@Entity
public class Tag extends AbstractEntity {

    @Column(length = 50)
    private String nome;
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="tags")
    private List<Imagem> imagens = new ArrayList<>(); 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }

    

   
    
}
