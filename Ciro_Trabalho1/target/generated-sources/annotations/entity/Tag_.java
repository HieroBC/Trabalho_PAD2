package entity;

import entity.Imagem;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.AbstractEntity_;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-01T20:56:14")
@StaticMetamodel(Tag.class)
public class Tag_ extends AbstractEntity_ {

    public static volatile ListAttribute<Tag, Imagem> imagens;
    public static volatile SingularAttribute<Tag, String> nome;

}