package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.dao.intf.ReportSeedDAO;
import com.botanik.excel.report.ReportCollection;
import com.botanik.excel.report.ReportHabitat;
import com.botanik.excel.report.ReportLocation;
import com.botanik.excel.report.ReportPlant;
import com.botanik.excel.report.ReportSample;
import com.botanik.excel.report.ReportSeed;
import com.botanik.model.CollectionDataBase;
import com.botanik.model.DefaultSeed;
import com.botanik.model.HabitatDataBase;
import com.botanik.model.HerbariumSpecimenBase;
import com.botanik.model.LocationDataBase;
import com.botanik.model.Plant;
import com.botanik.model.SamplingDataBase;
import com.botanik.model.SeedMorphology;
import com.botanik.model.SeedWeight;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author teyyub , 12:23:40 AM
 */
public class ReportSeedDAOJDBC implements ReportSeedDAO {

    @Override
    public ReportSeed rerportSeedById(Number id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        ReportSeed model = null;
        final String REPORT_SEED_BY_ID = "   select sw.id, sw.weight_1000,sw.weight_100,sw.fruit_weight,cw.id as type_id, sw.perfruit ,\n"
                + " sm.id as mor_id ,sm.size,sm.length,sm.width,sm.height,sm.configuration, sm.type_id as mor_type_id, sm.aids,sm.embrio,\n"
                + " hs.id as her_id, hs.number, hs.location, hs.isSpecimen, hs.dublicated,hs.voucher,\n"
                + " sdt.id as sam_id, sdt.numberSample, sdt.numberFood, sdt.area, sdt.percentage, sdt.note,\n"
                + " hd.id as hab_id, hd.habitat, hd.landform, hd.geology, hd.aspect ,hd.factor, hd.soil, hd.site_notes, hd.associated, hd.slope,hd.landuse ,\n"
                + " ld.id as loc_id, ld.country_id, ld.district, ld.latitude, ld.lat_long_method, ld.grid, ld.altitude, ld.state_id, ld.description, ld.longtitude, ld.lat_long_unit , ld.gps, ld.altitude_method  ,\n"
                + " cd.id as col_id, cd.col_number, cd.col_name ,  cd.access_number,  cd.col_date, cd.org_ins_id, cd.wild_cult_id, cd.col_name_ins_id,\n"
                + " pl.id as plant_id, pl.familyid, pl.genusid, pl.speciesAuthorid, pl.rankid, pl.infraspeciesId, pl.infraAuthorId, pl.rank2Id, pl.identifationStatusId,pl.identifierInstituteId, pl.description as plant_desc ,\n"
                + " pl.usesId, pl.vernacularNameId ,pl.otherKeyId,pl.plantFromId, pl.infraSpecies2Id, pl.infraAuthor2Id , pl.identifiedFromId , pl.identificationDate, pl.height as plant_height, pl.assesInforId, pl.speciesid\n"
                + " from ((((((((seed sd left join  seed_weight sw on sw.id = sd.seed_weight_id ) \n"
                + " left join combos cw on cw.id = sw.typeWeightId )\n"
                + " left join seed_morphology sm on sm.id = sd.seed_mor_id)\n"
                + " left join herbariumSpecimen hs on hs.id = sd.herbarium_id )\n"
                + " left join samplingdata sdt on sdt.id =sd.sampling_id )\n"
                + " left join habitat_data hd on hd.id = sd.habitat_id )\n"
                + " left join location_data ld on ld.id = sd.location_id)\n"
                + " left join collection_data cd on cd.id = sd.collection_id)\n"
                + " left join plant pl on sd.plant_id = pl.id\n"
                + " where sd.id =?";

        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {id};
            System.out.println("id = " + id);
            ps = prepareStatement(conn, REPORT_SEED_BY_ID, values);
            rs = ps.executeQuery();
            if (rs.next()) {
                model = new ReportSeed();
//                SeedWeight sw = new SeedWeight(rs.getInt("id"), rs.getString("weight_1000"), rs.getString("weight_100"), rs.getInt("type_id"), rs.getString("fruit_weight"),
//                        rs.getString("perfruit"));
//                SeedMorphology sm = new SeedMorphology(rs.getInt("mor_id"), rs.getString("size"), rs.getInt("mor_type_id"), rs.getString("length"),
//                        rs.getString("width"), rs.getString("height"), rs.getInt("aids"), rs.getString("configuration"), rs.getInt("embrio"));
//                HerbariumSpecimenBase hs = new HerbariumSpecimenBase(rs.getInt("her_id"), rs.getString("number"), rs.getInt("location"), rs.getInt("dublicated"),
//                        rs.getBoolean("isSpecimen"), rs.getString("voucher"));
//                
                ReportSample sd = new ReportSample(rs.getString("sample"), rs.getString("foud"),
                        rs.getString("area"), rs.getString("percentage"), rs.getString("note"));

                ReportHabitat hd = new ReportHabitat(rs.getString("habitat"), rs.getString("species"), rs.getString("factor"), rs.getString("landform"),rs.getString("landUse"),
                        rs.getString("geology"),rs.getString("slope"),   rs.getString("aspect"), rs.getString("soilType"), rs.getString("site_notes"));

                ReportLocation ld = new ReportLocation(rs.getString("country"), rs.getString("state"),rs.getString("descOfLocation"), 
                        rs.getString("orientationN"),rs.getString("degreesN"),rs.getString("minuteN"),rs.getString("secondsN"),rs.getString("orientationE"),rs.getString("degreeesE"),
                        rs.getString("minuteE"),rs.getString("secondsE"),rs.getString("latUnit"),rs.getString("gridReference"),rs.getString("gpsDatum"), rs.getString("altitude"),                      
                        rs.getString("altitude_method"));

                ReportCollection cd = new ReportCollection(rs.getString("organisation"), rs.getString("project_name"), rs.getString("wild"),
                        rs.getString("collection_number"), rs.getString("accession_number"), rs.getDate("col_date"), rs.getString("main_collector"));

                ReportPlant pl = new ReportPlant(rs.getString("family"), rs.getString("genus"), rs.getString("species"),
                        rs.getString("speciesAuthor"), rs.getString("rank"),
                        rs.getString("infraSpecSpecies"), rs.getString("infraSpecAuthor"), rs.getString("rank2Id"),
                        rs.getString("infraSpecies2"), rs.getString("infraAuthor2"), rs.getString("identifationStatus"),
                        rs.getString("identifiedFrom"), rs.getString("identName"), rs.getDate("identificationDate"),
                        rs.getString("plant_desc"), rs.getString("plantFrom"),
                        rs.getString("plant_height"), rs.getString("uses"), rs.getString("vernacularName"), rs.getString("assesInfor"), rs.getString("otherKey"));
                model.setSampling(sd);
                model.setHabitat(hd);
                model.setLocation(ld);
                model.setCollection(cd);
                model.setPlant(pl);

            }
//            model.setDaoStatus("1");
        } catch (SQLException e) {
//            model.setDaoStatus("0");
            System.err.println("exception in REPORT_SEED_BY_ID " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return model;
    }

}
