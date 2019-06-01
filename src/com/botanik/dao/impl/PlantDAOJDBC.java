package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.dao.intf.PlantDAO;
import com.botanik.model.Genus;
import com.botanik.model.Plant;
 
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author teyyub , Feb 4, 2018 , 2:56:25 PM
 */
public class PlantDAOJDBC implements PlantDAO {

    

    private Genus mapGenus(ResultSet rs) throws SQLException {
        Genus g = new Genus();
        g.setId(rs.getBigDecimal(1));
        g.setName(rs.getString(2));

        g.setFull_name(rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
        return g;
    }

    public void saveGenus(Genus genus) {

        PreparedStatement ps = null;
        Connection conn = null;
        final String SAVE_GENUS = "insert into genus(name ,author_id,family_id,taxon_id,ref_no,addition,hybrid,accepted,remarks,create_date,status) "
                + "values(?,?,?,?,?,?,?,?,?,?,'a')";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {genus.getName(), genus.getAuthor_id(), genus.getFamily_id(), genus.getTaxon_id(), genus.getRef_no(),
                genus.getAddition(), genus.isHybrid(), genus.isAccepted(), genus.getRemarks(), new Date()};
            ps = prepareStatement(conn, SAVE_GENUS, values);

            ps.executeUpdate();
            genus.setDaoStatus("1");
//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            genus.setDaoStatus("0");
            System.err.println("exception in saveGenus " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps);
        }
    }
 
    
    @Override
    public void save(Plant plant) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        final String SAVE_PLANT = "insert into plant(familyid ,genusid,speciesId,speciesAuthorId, rankId,infraSpeciesId,infraAuthorId,rank2Id,identifationStatusId ,"
                + "identifierInstituteId,description,usesId,vernacularNameId,assesInforId,otherKeyId,plantFromId,infraSpecies2Id,infraAuthor2Id,"
                + "identifiedFromId,identificationDate,height,create_date,status) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'a')";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {plant.getFamilyId().intValue(),
                plant.getGenusId().intValue(),
                plant.getSpeciesId().intValue(),
                plant.getSpeciesAuthorId().intValue(),
                plant.getRankId().intValue(),
                plant.getInfraSpeciesId().intValue(),
                plant.getInfrauthorId().intValue(),
                plant.getRank2Id().intValue(),
                plant.getIdentStatusId().intValue(),
                plant.getIdentInstituteId().intValue(),
                plant.getPlantDesc(),
                plant.getUsesId().intValue(),
                plant.getVerNameId().intValue(),
                plant.getAssesInforId().intValue(),
                plant.getOtherKeyId().intValue(),
                plant.getPlantFormId().intValue(),
                plant.getInfraSpecies2Id().intValue(),
                plant.getInfraAuthor2Id().intValue(),
                plant.getIdentFromId().intValue(),
                plant.getIdentificationDate(),
                plant.getHeight(),               
                new Date()};
            ps = prepareStatement(conn, SAVE_PLANT, true, values);
            ps.execute();
            rs = ps.getGeneratedKeys();
            int gen_id = rs.next() ? rs.getInt(1) : 0;
            plant.setId(BigDecimal.valueOf(gen_id));
            plant.setDaoStatus("1"); 
        } catch (SQLException e) {
            plant.setDaoStatus("0");
            System.err.println("exception in SAVE_PLANT " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps,rs);
        }
    }

    @Override
    public void update(Plant plant) {
//         ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        final String UPDATE_PLANT = "update plant  set familyid =?, genusid = ?, speciesId= ?, speciesAuthorId =? , rankId = ? ,infraSpeciesId =? ,"
                + "infraAuthorId = ? , rank2Id = ? , identifationStatusId =?  ,"
                + "identifierInstituteId = ? ,description = ? ,usesId = ? , vernacularNameId = ? ,"
                + "assesInforId = ? , otherKeyId =? , plantFromId = ? , infraSpecies2Id = ? , infraAuthor2Id = ? ,"
                + "identifiedFromId = ?, identificationDate =? , height =? where id= ?";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {plant.getFamilyId(),
                plant.getGenusId(),
                plant.getSpeciesId(),
                plant.getSpeciesAuthorId(),
                plant.getRankId(),
                plant.getInfraSpeciesId(),
                plant.getInfrauthorId(),
                plant.getRank2Id(),
                plant.getIdentStatusId(),
                plant.getIdentInstituteId(),
                plant.getPlantDesc(),
                plant.getUsesId(),
                plant.getVerNameId(),
                plant.getAssesInforId(),
                plant.getOtherKeyId(),
                plant.getPlantFormId(),
                plant.getInfraSpecies2Id(),
                plant.getInfraAuthor2Id(),
                plant.getIdentFromId(),
                plant.getIdentificationDate(),
                plant.getHeight(),
                plant.getId()};
            ps = prepareStatement(conn, UPDATE_PLANT,  values);
            ps.execute();
            plant.setDaoStatus("1"); 
        } catch (SQLException e) {
            plant.setDaoStatus("0");
            System.err.println("exception in UPDATE_PLANT " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps);
        }
    }

}
