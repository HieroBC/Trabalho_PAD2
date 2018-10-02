/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.iptc.IptcDirectory;
import static com.drew.metadata.iptc.IptcDirectory.TAG_CAPTION;
import com.drew.metadata.jpeg.JpegDirectory;
import entity.Imagem;
import entity.Tag;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.DAO;

/**
 *
 * @author Luana
 */
public class ImagemBean {

    private Imagem imagem = new Imagem();
    private List<Imagem> imagens = new ArrayList<>();
    
    public ImagemBean() {
        
    }
    public void Metadados() throws JpegProcessingException, IOException, MetadataException{
        
        File Arquivo = new File("C:\\Users\\Luana\\Desktop\\Ciro\\Ciro_Trabalho1\\Imagens\\DZ17_16378.jpg");
        //List<String> tags = new ArrayList<>();
        Imagem img = new Imagem();
        Metadata metadata = JpegMetadataReader.readMetadata(Arquivo);        
        ExifDirectoryBase directory1 = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
        IptcDirectory directory2 = metadata.getFirstDirectoryOfType(IptcDirectory.class);
        JpegDirectory directory3 = metadata.getFirstDirectoryOfType(JpegDirectory.class);
        
        //Adiciona as Tags
        
        List<String> Keywords = new ArrayList<>();
        Keywords.addAll(directory2.getKeywords());
        
        System.out.println(Keywords.size());
        for(int i = 0; i < Keywords.size(); i++){
            Tag tagAux = new Tag();
            tagAux.setNome(Keywords.get(i));
            img.addTag(tagAux);
            
        }
        for(int i = 0; i<img.getTags().size(); i++){
            System.out.println(img.getTags().get(i).getNome());
        }
        
        // Adiciona a variavel Nome
        img.setNome(Arquivo.getName());
        System.out.println("Nome: " + Arquivo.getName());
        // 
        String DescricaoAux = directory2.getDescription(TAG_CAPTION);
            
        String[] palavras = DescricaoAux.split(":\\s");
        // Adiciona Descricao
        img.setDescricao((String) palavras[1].subSequence(0,palavras[1].length()-6));
        System.out.println("Descricao: " + img.getDescricao());
        // Adiciona Local
        img.setLocal((String) palavras[2].subSequence(0,palavras[2].length()-5));
        System.out.println("Local: " + img.getLocal());
        // Adiciona Data
        img.setData((String) palavras[3].subSequence(0, palavras[3].length()-6));
        System.out.println("Data: " + img.getData());
        // Adiciona Autor
        img.setAutor(palavras[4]);
        System.out.println("Autor: " + img.getAutor());
        
        //Adiciona Dimensoes
        img.setDimensoes(directory3.getImageHeight() + "x" + directory3.getImageWidth());
        System.out.println("Dimensoes: " + img.getDimensoes());
        
       ImagemBean imagembean = new ImagemBean();
       imagembean.setImagem(img);
       imagembean.gravar();
        //this.setImagem(img);
        //this.gravar();
    }
    
   
     public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
        
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }
    
    public String consultar(){
        DAO dao = new DAO(Imagem.class);
        imagens = dao.listarGenerico("Imagem.cnsultarPorAutor", "%" + imagem.getAutor() + "%");
        return null;
    }
    
    public String gravar(){
        DAO dao = new DAO(Imagem.class);
        dao.adicionar (imagem);
        imagem  = new Imagem();
        return null;
    }
    public String atualizar(){
        DAO dao = new DAO(Imagem.class);
        dao.alterar(imagem);
        imagem = new Imagem();
        return "/paginaQualquer";
    }
    
     public String excluir(Imagem i) {
        DAO dao = new DAO(Imagem.class);
        imagens.remove(i);
        dao.excluir(i.getId());
        return null;
    }
}
