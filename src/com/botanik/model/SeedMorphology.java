package com.botanik.model;

/**
 *
 * @author USER
 */
public class SeedMorphology extends Base {

    private String size;
    private Number typeId;
    private String length;
    private String width;
    private String height;
    private Number aidId;
    private String configuration;
    private Number embrioId;
    private boolean isSeedMorphologyNew = true;

    public SeedMorphology() {
    }

    public SeedMorphology(String size, Number typeId, String length, String width, String height, Number aidId, String configuration, Number embrioId) {
        this.size = size;
        this.typeId = typeId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.aidId = aidId;
        this.configuration = configuration;
        this.embrioId = embrioId;
    }

    public SeedMorphology(Number id, String size, Number typeId, String length, String width, String height, Number aidId, String configuration, Number embrioId) {
        super(id);
        this.size = size;
        this.typeId = typeId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.aidId = aidId;
        this.configuration = configuration;
        this.embrioId = embrioId;
    }

    public String getSize() {
        return size;
    }

    public Number getTypeId() {
        return typeId;
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

    public Number getAidId() {
        return aidId;
    }

    public String getConfiguration() {
        return configuration;
    }

    public Number getEmbrioId() {
        return embrioId;
    }

    public boolean isIsSeedMorphologyNew() {
        return isSeedMorphologyNew;
    }

    public void setIsSeedMorphologyNew(boolean isSeedMorphologyNew) {
        this.isSeedMorphologyNew = isSeedMorphologyNew;
    }

    
    
}
