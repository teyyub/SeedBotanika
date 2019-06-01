package com.botanik.model;

import java.math.BigDecimal;

/**
 *
 * @author USER
 */
public class SeedMorphology extends Base {

    private String size;
    private BigDecimal typeId;
    private String length;
    private String width;
    private String height;
    private BigDecimal aidId;
    private String configuration;
    private BigDecimal embrioId;
    private boolean isSeedMorphologyNew = true;

    public SeedMorphology() {
    }

    public SeedMorphology(String size, BigDecimal typeId, String length, String width, String height, BigDecimal aidId, String configuration, BigDecimal embrioId) {
        this.size = size;
        this.typeId = typeId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.aidId = aidId;
        this.configuration = configuration;
        this.embrioId = embrioId;
    }

    public SeedMorphology(BigDecimal id, String size, BigDecimal typeId, String length, String width, String height, BigDecimal aidId,
            String configuration, BigDecimal embrioId) {
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

    public BigDecimal getTypeId() {
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

    public BigDecimal getAidId() {
        return aidId;
    }

    public String getConfiguration() {
        return configuration;
    }

    public BigDecimal getEmbrioId() {
        return embrioId;
    }

    public boolean isIsSeedMorphologyNew() {
        return isSeedMorphologyNew;
    }

    public void setIsSeedMorphologyNew(boolean isSeedMorphologyNew) {
        this.isSeedMorphologyNew = isSeedMorphologyNew;
    }

}
