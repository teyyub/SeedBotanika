package com.botanik.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author USER
 */
public class Plant extends Base {

    private BigDecimal familyId;
    private BigDecimal genusId;
    private BigDecimal speciesId;
    private BigDecimal speciesAuthorId;
    private BigDecimal rankId;
    private BigDecimal infraSpeciesId;
    private BigDecimal infrauthorId;
    private BigDecimal rank2Id;
    private BigDecimal identStatusId;
    private BigDecimal identInstituteId;    
    private String plantDesc;
    private BigDecimal usesId;
    private BigDecimal verNameId;
    private BigDecimal assesInforId;
    private BigDecimal otherKeyId;
    private BigDecimal plantFormId;
    private BigDecimal infraSpecies2Id;
    private BigDecimal infraAuthor2Id;
    private BigDecimal identFromId;
    private Date identificationDate;
    private String height;
    private DefaultImage defaultImage;
//    private Number seedId;
    private boolean isPlantNew = true;

    public Plant() {
    }
 

    public Plant(BigDecimal id,BigDecimal familyId, BigDecimal genusId, BigDecimal speciesId,
            BigDecimal speciesAuthorId, BigDecimal rankId,BigDecimal infraSpeciesId, BigDecimal infrauthorId, BigDecimal rank2Id, 
            BigDecimal identStatusId, BigDecimal identInstituteId, String plantDesc, 
            BigDecimal usesId, BigDecimal verNameId, BigDecimal assesInforId, BigDecimal otherKeyId, 
            BigDecimal plantFormId, BigDecimal infraSpecies2Id, BigDecimal infraAuthor2Id, 
            BigDecimal identFromId, Date identificationDate, String height) {
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

  
    
     public Plant(BigDecimal familyId, 
             BigDecimal genusId, 
             BigDecimal speciesId,
             BigDecimal speciesAuthorId, 
             BigDecimal rankId, 
             BigDecimal infraSpeciesId, 
             BigDecimal infrauthorId, 
             BigDecimal rank2Id, 
             BigDecimal identStatusId, 
             BigDecimal identInstituteId, 
             String plantDesc, 
             BigDecimal usesId, 
             BigDecimal verNameId, 
             BigDecimal assesInforId, 
             BigDecimal otherKeyId, 
             BigDecimal plantFormId, 
             BigDecimal infraSpecies2Id, 
             BigDecimal infraAuthor2Id, 
             BigDecimal identFromId, Date identificationDate, String height) {
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
     
 

    public BigDecimal getFamilyId() {
        return familyId;
    }

    public BigDecimal getGenusId() {
        return genusId;
    }

    public BigDecimal getSpeciesId() {
        return speciesId;
    }

    public BigDecimal getSpeciesAuthorId() {
        return speciesAuthorId;
    }

    public BigDecimal getRankId() {
        return rankId;
    }

    public BigDecimal getInfraSpeciesId() {
        return infraSpeciesId;
    }

    public BigDecimal getInfrauthorId() {
        return infrauthorId;
    }

    public BigDecimal getRank2Id() {
        return rank2Id;
    }

    public BigDecimal getIdentStatusId() {
        return identStatusId;
    }

    public BigDecimal getIdentInstituteId() {
        return identInstituteId;
    }

     

    public BigDecimal getUsesId() {
        return usesId;
    }

    public BigDecimal getVerNameId() {
        return verNameId;
    }

    public BigDecimal getAssesInforId() {
        return assesInforId;
    }

    public BigDecimal getOtherKeyId() {
        return otherKeyId;
    }

    public BigDecimal getPlantFormId() {
        return plantFormId;
    }

    public BigDecimal getInfraSpecies2Id() {
        return infraSpecies2Id;
    }

    public BigDecimal getInfraAuthor2Id() {
        return infraAuthor2Id;
    }

    public BigDecimal getIdentFromId() {
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
