package com.botanik.model;

/**
 *
 * @author USER
 */
public class SeedMorphologyView extends Base {

    private String size;
    private String type;
    private String length;
    private String width;
    private String height;
    private String aid;
    private String configuration;
    private String embrio;
    private boolean isSeedMorphologyNew = true;

    public SeedMorphologyView() {
    }

    public SeedMorphologyView(String size, String type, String length, String width, 
            String height, String aid, String configuration, String embrio) {
        this.size = size;
        this.type = type;
        this.length = length;
        this.width = width;
        this.height = height;
        this.aid = aid;
        this.configuration = configuration;
        this.embrio = embrio;
    }

    public SeedMorphologyView(Number id, String size, String type, String length, String width, 
            String height, String aid, String configuration, String embrio) {
        super(id);
        this.size = size;
        this.type = type;
        this.length = length;
        this.width = width;
        this.height = height;
        this.aid = aid;
        this.configuration = configuration;
        this.embrio= embrio;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public String getLength() {
        return length;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public String getAid() {
        return aid;
    }

    public String getConfiguration() {
        return configuration;
    }

    public String getEmbrio() {
        return embrio;
    }

    public boolean isIsSeedMorphologyNew() {
        return isSeedMorphologyNew;
    }

    public void setIsSeedMorphologyNew(boolean isSeedMorphologyNew) {
        this.isSeedMorphologyNew = isSeedMorphologyNew;
    }

    
    
}
