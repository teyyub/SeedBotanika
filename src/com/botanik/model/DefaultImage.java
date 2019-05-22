package com.botanik.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author teyyub , Mar 23, 2018 , 9:38:28 AM
 */
public class DefaultImage {

    private String localFolder = "IMAGES/";    
    private Number imageId;
    private Number plantId;
    private String imageUrl;
    private String imageName;
    private String local_imge_url; 
    private File file;
    private Path source;
    private Path target;
    private String daoStatus;

    public DefaultImage(Number plantId, String imageUrl, String imageName) {
        this.plantId = plantId;
        this.imageUrl = imageUrl;
        this.imageName = imageName;
    }
    
    public DefaultImage(Number id, Number plantId, String imageUrl, String imageName) {
        this.imageId = id;
        this.plantId = plantId;
        this.imageUrl = imageUrl;
        this.imageName = imageName;
    }
    public DefaultImage(File sourceFile) {
        this.file = sourceFile;
    }

    public Number getPlantId() {
        return plantId;
    }

    public void setPlantId(Number plantId) {
        this.plantId = plantId;
    }

    private void makeFileReady() {
        if (file != null) {
            Long gen_id = System.currentTimeMillis();
            this.imageName = file.getName();
            String ext = FilenameUtils.getExtension(file.getName());
            this.imageUrl = gen_id + "." + ext;
            local_imge_url = localFolder + gen_id+"."+ext;
            this.source = this.file.toPath();

//            this.target = Paths.get(imageUrl);
            target = Paths.get(local_imge_url);
        }

    }

    public Number getImageId() {
        return imageId;
    }

    public void setImageId(Number imageId) {
        this.imageId = imageId;
    }

    public void imageUrl() {
        Long gen_id = System.currentTimeMillis();
        this.imageUrl = localFolder + gen_id + file.getName();
    }

    public void genId() {
        Long gen_id = System.currentTimeMillis();
    }

    public String getLocal_imge_url() {
        return local_imge_url;
    }

    public void saveFile() throws IOException {
//        makeFileReady();
        Files.copy(source, target, REPLACE_EXISTING);
    }

    public File readFile() {
//        if((imageUrl!=null) &&(imageName!=null))
//        File file1 = new File(imageUrl + imageName);
        if((imageUrl!=null))
        return new File(imageUrl);
       return null;
    }
    
     public File readLocalFile() {
        if((imageUrl!=null) &&(imageName!=null))
//        File file1 = new File(imageUrl + imageName);
        return new File(""+imageUrl + imageName);
       return null;
    }
    
    public File file() {
        makeFileReady();
        return file;
    }

    

    public String getImageUrl() {
        return imageUrl;
    }

    public String getImageName() {
        return imageName;
    }

    public String getDaoStatus() {
        return daoStatus;
    }

    public void setDaoStatus(String daoStatus) {
        this.daoStatus = daoStatus;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public String getLocalFolder() {
        return localFolder;
    }

    public void setLocalFolder(String localFolder) {
        this.localFolder = localFolder;
    }

}
