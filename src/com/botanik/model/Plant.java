package com.botanik.model;

import java.util.Date;

/**
 *
 * @author USER
 */
public class Plant extends Base {

    private Number familyId;
    private Number genusId;
    private Number speciesId;
    private Number speciesAuthorId;
    private Number rankId;
    private Number infraSpeciesId;
    private Number infrauthorId;
    private Number rank2Id;
    private Number identStatusId;
    private Number identInstituteId;    
    private String plantDesc;
    private Number usesId;
    private Number verNameId;
    private Number assesInforId;
    private Number otherKeyId;
    private Number plantFormId;
    private Number infraSpecies2Id;
    private Number infraAuthor2Id;
    private Number identFromId;
    private Date identificationDate;
    private String height;
    private DefaultImage defaultImage;
//    private Number seedId;
    private boolean isPlantNew = true;

    public Plant() {
    }
 

    public Plant(Number id,Number familyId, Number genusId, Number speciesId,
            Number speciesAuthorId, Number rankId,Number infraSpeciesId, Number infrauthorId, Number rank2Id, 
            Number identStatusId, Number identInstituteId, String plantDesc, 
            Number usesId, Number verNameId, Number assesInforId, Number otherKeyId, 
            Number plantFormId, Number infraSpecies2Id, Number infraAuthor2Id, 
            Number identFromId, Date identificationDate, String height) {
        super(id);
        this.familyId = familyId;
        this.genusId = genusId;
        this.speciesId = speciesId;
        this.speciesAuthorId = speciesAuthorId;
        this.rankId = rankId;
        this.infraSpeciesId = infraSpeciesId;
        this.infrauthorId = infrauthorId;
        this.rank2Id = rank2Id;
        this.identStatusId = identStatusId;
        this.identInstituteId = identInstituteId;
        this.plantDesc = plantDesc;
        this.usesId = usesId;
        this.verNameId = verNameId;
        this.assesInforId = assesInforId;
        this.otherKeyId = otherKeyId;
        this.plantFormId = plantFormId;
        this.infraSpecies2Id = infraSpecies2Id;
        this.infraAuthor2Id = infraAuthor2Id;
        this.identFromId = identFromId;
        this.identificationDate = identificationDate;
        this.height = height;
    }

  
    
     public Plant(Number familyId, 
             Number genusId, 
             Number speciesId,
             Number speciesAuthorId, 
             Number rankId, 
             Number infraSpeciesId, 
             Number infrauthorId, 
             Number rank2Id, 
             Number identStatusId, 
             Number identInstituteId, 
             String plantDesc, 
             Number usesId, 
             Number verNameId, 
             Number assesInforId, 
             Number otherKeyId, 
             Number plantFormId, 
             Number infraSpecies2Id, Number infraAuthor2Id, Number identFromId, Date identificationDate, String height) {
        this.familyId = familyId;
        this.genusId = genusId;
        this.speciesId = speciesId;
        this.speciesAuthorId = speciesAuthorId;
        this.rankId = rankId;
        this.infraSpeciesId = infraSpeciesId;
        this.infrauthorId = infrauthorId;
        this.rank2Id = rank2Id;
        this.identStatusId = identStatusId;
        this.identInstituteId = identInstituteId;
        this.plantDesc = plantDesc;
        this.usesId = usesId;
        this.verNameId = verNameId;
        this.assesInforId = assesInforId;
        this.otherKeyId = otherKeyId;
        this.plantFormId = plantFormId;
        this.infraSpecies2Id = infraSpecies2Id;
        this.infraAuthor2Id = infraAuthor2Id;
        this.identFromId = identFromId;
        this.identificationDate = identificationDate;
        this.height = height; 
    }
     
 

    public Number getFamilyId() {
        return familyId;
    }

    public Number getGenusId() {
        return genusId;
    }

    public Number getSpeciesId() {
        return speciesId;
    }

    public Number getSpeciesAuthorId() {
        return speciesAuthorId;
    }

    public Number getRankId() {
        return rankId;
    }

    public Number getInfraSpeciesId() {
        return infraSpeciesId;
    }

    public Number getInfrauthorId() {
        return infrauthorId;
    }

    public Number getRank2Id() {
        return rank2Id;
    }

    public Number getIdentStatusId() {
        return identStatusId;
    }

    public Number getIdentInstituteId() {
        return identInstituteId;
    }

     

    public Number getUsesId() {
        return usesId;
    }

    public Number getVerNameId() {
        return verNameId;
    }

    public Number getAssesInforId() {
        return assesInforId;
    }

    public Number getOtherKeyId() {
        return otherKeyId;
    }

    public Number getPlantFormId() {
        return plantFormId;
    }

    public Number getInfraSpecies2Id() {
        return infraSpecies2Id;
    }

    public Number getInfraAuthor2Id() {
        return infraAuthor2Id;
    }

    public Number getIdentFromId() {
        return identFromId;
    }

    public Date getIdentificationDate() {
        return identificationDate;
    }

    public String getHeight() {
        return height;
    }

//    public Number getSeedId() {
//        return seedId;
//    }

    public String getPlantDesc() {
        return plantDesc;
    }

    public void setPlantDesc(String plantDesc) {
        this.plantDesc = plantDesc;
    }

    public boolean isIsPlantNew() {
        return isPlantNew;
    }

    public void setIsPlantNew(boolean isPlantNew) {
        this.isPlantNew = isPlantNew;
    }

    public DefaultImage getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(DefaultImage defaultImage) {
        this.defaultImage = defaultImage;
    }

    
    
    
}
