 

package com.botanik.excel.report;
 
import java.util.Date;


/**
 *
 * @author teyyub , 11:19:16 PM
 */
public class ReportPlant {
    private String family;
    private String genus;
    private String species;
    private String speciesAuthor;
    private String rank;
    private String infraSpecSpecies;
    private String infraSpecAuthor;
    private String rank2;
    private String infraSpecSpecies2;
    private String infraSpecAuthor2;
    private String identStatus;
    private String identFrom;
    private String identName;
    private Date identDate;
    private String plantDesc;
    private String plantForm;
    private String plantHeight;
    private String uses;
    private String vernacularName;
    private String assessmentInformation;
    private String otherKey;

    public ReportPlant(String family, String genus, String species, String speciesAuthor, String rank, String infraSpecSpecies, String infraSpecAuthor, String rank2, String infraSpecSpecies2, String infraSpecAuthor2, String identStatus, String identFrom, String identName, Date identDate, String plantDesc, String plantForm, String plantHeight, String uses, String vernacularName, String assessmentInformation, String otherKey) {
        this.family = family;
        this.genus = genus;
        this.species = species;
        this.speciesAuthor = speciesAuthor;
        this.rank = rank;
        this.infraSpecSpecies = infraSpecSpecies;
        this.infraSpecAuthor = infraSpecAuthor;
        this.rank2 = rank2;
        this.infraSpecSpecies2 = infraSpecSpecies2;
        this.infraSpecAuthor2 = infraSpecAuthor2;
        this.identStatus = identStatus;
        this.identFrom = identFrom;
        this.identName = identName;
        this.identDate = identDate;
        this.plantDesc = plantDesc;
        this.plantForm = plantForm;
        this.plantHeight = plantHeight;
        this.uses = uses;
        this.vernacularName = vernacularName;
        this.assessmentInformation = assessmentInformation;
        this.otherKey = otherKey;
    }

    ReportPlant() {
        
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

    public String getSpeciesAuthor() {
        return speciesAuthor;
    }

    public String getRank() {
        return rank;
    }

    public String getInfraSpecSpecies() {
        return infraSpecSpecies;
    }

    public String getInfraSpecAuthor() {
        return infraSpecAuthor;
    }

    public String getRank2() {
        return rank2;
    }

    public String getInfraSpecSpecies2() {
        return infraSpecSpecies2;
    }

    public String getInfraSpecAuthor2() {
        return infraSpecAuthor2;
    }

    public String getIdentStatus() {
        return identStatus;
    }

    public String getIdentFrom() {
        return identFrom;
    }

    public String getIdentName() {
        return identName;
    }

    public Date getIdentDate() {
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

    public String getVernacularName() {
        return vernacularName;
    }

    public String getAssessmentInformation() {
        return assessmentInformation;
    }

    public String getOtherKey() {
        return otherKey;
    }
    
}
