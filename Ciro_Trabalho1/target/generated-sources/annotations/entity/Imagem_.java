package entity;

import entity.Tag;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.AbstractEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-01T20:56:14")
@StaticMetamodel(Imagem.class)
public class Imagem_ extends AbstractEntity_ {

    public static volatile SingularAttribute<Imagem, String> dimensoes;
    public static volatile SingularAttribute<Imagem, String> data;
    public static volatile SingularAttribute<Imagem, String> nome;
    public static volatile SingularAttribute<Imagem, String> local;
    public static volatile SingularAttribute<Imagem, String> autor;
    public static volatile SingularAttribute<Imagem, String> descricao;
    public static volatile ListAttribute<Imagem, Tag> tags;

}