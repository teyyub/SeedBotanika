 

package com.botanik.export.model;

/**
 *
 * @author teyyub , 8:51:54 AM
 */
public class PlantExport {
    private String family;
    private String genus;
    private String species;
    private String speAuthor;
    private String rank;
    private String infraSpeciAthor;
    private String infraSpeciSpecies;
    private String rank2;
    private String infraSpeciAthor2;
    private String infraSpeciSpecies2;
    private String identStatus;
    private String idetFrom;
    private String identName;
    private String identDate;
    private String plantDesc;
    private String plantForm;
    private String plantHeight;
    private String uses;
    private String verName;
    private String assInformation;
    private String otherInform;

    public PlantExport(String family, String genus, String species, String speAuthor, String rank, String infraSpeciAthor, String infraSpeciSpecies, 
            String rank2, String infraSpeciAthor2, String infraSpeciSpecies2, String identStatus, String idetFrom, String identName, 
            String identDate, String plantDesc, String plantForm, String plantHeight, String uses, String verName, String asInf,String otherInform) {
        this.family = family;
        this.genus = genus;
        this.species = species;
        this.speAuthor = speAuthor;
        this.rank = rank;
        this.infraSpeciAthor = infraSpeciAthor;
        this.infraSpeciSpecies = infraSpeciSpecies;
        this.rank2 = rank2;
        this.infraSpeciAthor2 = infraSpeciAthor2;
        this.infraSpeciSpecies2 = infraSpeciSpecies2;
        this.identStatus = identStatus;
        this.idetFrom = idetFrom;
        this.identName = identName;
        this.identDate = identDate;
        this.plantDesc = plantDesc;
        this.plantForm = plantForm;
        this.plantHeight = plantHeight;
        this.uses = uses;
        this.verName = verName;
        this.assInformation = asInf;
        this.otherInform = otherInform;
    }

    public String getFamily() {
        return family;
    }

    public String getGenus() {
        return genus;
    }

    public String getSpecies() {
        return species;
    }

    public String getSpeAuthor() {
        return speAuthor;
    }

    public String getRank() {
        return rank;
    }

    public String getInfraSpeciAthor() {
        return infraSpeciAthor;
    }

    public String getInfraSpeciSpecies() {
        return infraSpeciSpecies;
    }

    public String getRank2() {
        return rank2;
    }

    public String getInfraSpeciAthor2() {
        return infraSpeciAthor2;
    }

    public String getInfraSpeciSpecies2() {
        return infraSpeciSpecies2;
    }

    public String getIdentStatus() {
        return identStatus;
    }

    public String getIdetFrom() {
        return idetFrom;
    }

    public String getIdentName() {
        return identName;
    }

    public String getIdentDate() {
        return identDate;
    }

    public String getPlantDesc() {
        return plantDesc;
    }

    public String getPlantForm() {
        return plantForm;
    }

    public String getPlantHeight() {
        return plantHeight;
    }

    public String getUses() {
        return uses;
    }

    public String getVerName() {
        return verName;
    }

    public String getAssInformation() {
        return assInformation;
    }

    
    
    public String getOtherInform() {
        return otherInform;
    }

    @Override
    public String toString() {
        return  family + " " + genus + " " + species + " " + speAuthor + " " + rank + " " + infraSpeciAthor 
                + " " + infraSpeciSpecies + " " + rank2 + " " + infraSpeciAthor2 + " " + infraSpeciSpecies2 
                + " " + identStatus + " " + idetFrom + " " + identName + " " + identDate + " " + plantDesc 
                + " " + plantForm + " " + plantHeight + " " + uses + " " + verName + " " + assInformation + " " + otherInform ;
    }

  
    
    
}   
