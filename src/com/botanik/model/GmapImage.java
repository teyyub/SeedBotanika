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
public class GmapImage {

    private final String localFolder = "IMAGES/MAP/";
    private Number imageId;
    private Number specimenId;
    private String imageUrl;
    private String imageName;
    private File file;
    private Path source;
    private Path target;
    private String daoStatus;

    public GmapImage(Number specimenId, String imageUrl, String imageName) {
        this.specimenId = specimenId;
        this.imageUrl = imageUrl;
        this.imageName = imageName;
    }

    public GmapImage(File sourceFile) {
        this.file = sourceFile;
    }

    private void checkFile() {
        if (file != null) {
            Long gen_id = System.currentTimeMillis();
            this.imageName = file.getName();
            String ext = FilenameUtils.getExtension(file.getName());
            this.imageUrl = localFolder + gen_id + "." + ext;
            this.source = this.file.toPath();

//            this.target = Paths.get(imageUrl);
            target = Paths.get(imageUrl);
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

    public void saveFile() throws IOException {
        checkFile();
        Files.copy(source, target, REPLACE_EXISTING);
    }

    public File readFile() {
        if (imageUrl == null && imageName == null) {
            return new File("src/image/no_image.jpg");
        }
        return new File(imageUrl + imageName);
    }

    public File file() {
        checkFile();
        return file;
    }

    public Number getSpecimenId() {
        return specimenId;
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

}
