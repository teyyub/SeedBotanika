 
package com.botanik.model;

import java.util.Date;

/**
 *
 * @author USER
 */
public class PlantData {
    private Number id;
    private Number familyId;
    private Number genuesId;
    private Number speciesAuthorId;
    private Number rankId;
    private Number rank2Id;
    private Number infraSpecificSpeciesId;
    private Number infraSpecificSpecies2Id;
    private Number infraSpecificAuthorId;
    private Number infraSpecificAuthor2Id;
    private Number identificationStatusId;
    private Number usesId;
    private Number vernacularNameId;
    private Number assessmentNameId;
    private Number identifiedFormId;
    private Number identifierNameId;
    private Date identificationDate;
    private Number plantFormId;
    private Number otherKeyInfirmationId;
    private Number PlantDescriptionId;
    private Double plantHeight;

    public PlantData(Number id, Number familyId, Number genuesId, Number speciesAuthorId, Number rankId, Number rank2Id, Number infraSpecificSpeciesId, Number infraSpecificSpecies2Id, Number infraSpecificAuthorId, Number infraSpecificAuthor2Id, Number identificationStatusId, Number usesId, Number vernacularNameId, Number assessmentNameId, Number identifiedFormId, Number identifierNameId, Date identificationDate, Number plantFormId, Number otherKeyInfirmationId, Number PlantDescriptionId, Double plantHeight) {
        this.id = id;
        this.familyId = familyId;
        this.genuesId = genuesId;
        this.speciesAuthorId = speciesAuthorId;
        this.rankId = rankId;
        this.rank2Id = rank2Id;
        this.infraSpecificSpeciesId = infraSpecificSpeciesId;
        this.infraSpecificSpecies2Id = infraSpecificSpecies2Id;
        this.infraSpecificAuthorId = infraSpecificAuthorId;
        this.infraSpecificAuthor2Id = infraSpecificAuthor2Id;
        this.identificationStatusId = identificationStatusId;
        this.usesId = usesId;
        this.vernacularNameId = vernacularNameId;
        this.assessmentNameId = assessmentNameId;
        this.identifiedFormId = identifiedFormId;
        this.identifierNameId = identifierNameId;
        this.identificationDate = identificationDate;
        this.plantFormId = plantFormId;
        this.otherKeyInfirmationId = otherKeyInfirmationId;
        this.PlantDescriptionId = PlantDescriptionId;
        this.plantHeight = plantHeight;
    }

    public Number getId() {
        return id;
    }

    public Number getFamilyId() {
        return familyId;
    }

    public Number getGenuesId() {
        return genuesId;
    }

    public Number getSpeciesAuthorId() {
        return speciesAuthorId;
    }

    public Number getRankId() {
        return rankId;
    }

    public Number getRank2Id() {
        return rank2Id;
    }

    public Number getInfraSpecificSpeciesId() {
        return infraSpecificSpeciesId;
    }

    public Number getInfraSpecificSpecies2Id() {
        return infraSpecificSpecies2Id;
    }

    public Number getInfraSpecificAuthorId() {
        return infraSpecificAuthorId;
    }

    public Number getInfraSpecificAuthor2Id() {
        return infraSpecificAuthor2Id;
    }

    public Number getIdentificationStatusId() {
        return identificationStatusId;
    }

    public Number getUsesId() {
        return usesId;
    }

    public Number getVernacularNameId() {
        return vernacularNameId;
    }

    public Number getAssessmentNameId() {
        return assessmentNameId;
    }

    public Number getIdentifiedFormId() {
        return identifiedFormId;
    }

    public Number getIdentifierNameId() {
        return identifierNameId;
    }

    public Date getIdentificationDate() {
        return identificationDate;
    }

    public Number getPlantFormId() {
        return plantFormId;
    }

    public Number getOtherKeyInfirmationId() {
        return otherKeyInfirmationId;
    }

    public Number getPlantDescriptionId() {
        return PlantDescriptionId;
    }

    public Double getPlantHeight() {
        return plantHeight;
    }
    
    
    
    
}
