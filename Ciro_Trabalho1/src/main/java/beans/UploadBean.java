/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.MetadataException;
import entity.Imagem;
import entity.Tag;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import model.DAO;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Luana
 */
public class UploadBean {

   
    public UploadBean() {
    }
    
    public void upload(FileUploadEvent event) throws FileNotFoundException, IOException, JpegProcessingException, MetadataException {
        UploadedFile uploadedFile = event.getFile();
        
        File arquivo = new File("C:\\Users\\Luana\\Desktop\\Ciro\\Ciro_Trabalho1\\Imagens", uploadedFile.getFileName());
        
        OutputStream out = new FileOutputStream(arquivo);
        out.write(uploadedFile.getContents());
        out.close();
        
        
    }
    
    
}
