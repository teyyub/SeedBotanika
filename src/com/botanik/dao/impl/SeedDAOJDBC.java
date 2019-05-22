package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.dao.intf.SeedDAO;
import com.botanik.model.CollectionDataBase;
import com.botanik.model.DefaultImage;
import com.botanik.model.DefaultSeed;
import com.botanik.model.HabitatDataBase;
import com.botanik.model.HerbariumSpecimenBase;
import com.botanik.model.LocationDataBase;
import com.botanik.model.Plant;
import com.botanik.model.PlantView;
import com.botanik.model.SamplingDataBase;
import com.botanik.model.SamplingDataView;
import com.botanik.model.SeedModel;
import com.botanik.model.SeedMorphology;
import com.botanik.model.SeedMorphologyView;
import com.botanik.model.SeedView;
import com.botanik.model.SeedWeight;
import com.botanik.model.SeedWeightView;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author teyyub , Feb 4, 2018 , 2:56:25 PM
 */
public class SeedDAOJDBC implements SeedDAO {

    @Override
    public List<SeedModel> seedByModel(SeedModel model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        LinkedList<Object> paramValues = new LinkedList<>();
        List<SeedModel> modelList = new ArrayList();
        final String SQL_SEED_MODEL_DATA_BY_MODEL = //"select * from plant pl where pl.description =?" ;
                
                " SELECT pl.seedid, pl.description,cd.number, h.habitat from ((seed sd left  join  " +
                                                        " plant pl on sd.plant_id = pl.id )  " +
                                                        " left join collection_data cd on cd.id = sd.collection_id)  " +
                                                        " left join habitat_data h on sd.habitat_id = h.id where pl.[description] like ?  ";
//        String where_part = " where   1=1 ";
//        if (!model.getSeedId().equals(-1)) {
//            where_part = where_part + " and sd.numberSample like ? ";
//            paramValues.add("%" + model.getSeedId() + "%");
//
//        }
//        if (!model.getPlantDescription().equals("")) {
//            where_part = where_part + " and pl.description  like ?";
//            paramValues.add(model.getPlantDescription());
//        }

//        if (!model.getCollectionNumber().equals("-1")) {
//            where_part = where_part + " and sd.area like ?";
//            paramValues.add("%" + model.getCollectionNumber() + "%");
//        }

//        if (!model.getDescOfLocation().equals("")) {
//            where_part = where_part + " and sd.percentage like ?";
//            paramValues.add("%" + model.getDescOfLocation() + "%");
//        }
//
//        if (!model.getNumberOfPlantSample().equals("")) {
//            where_part = where_part + " and sd.note like ?";
//            paramValues.add("%" + model.getNumberOfPlantSample() + "%");
//        }

//        if (!model.getHerbariumNumber().equals("-1")) {
//            where_part = where_part + " and sd.note like ?";
//            paramValues.add("%" + model.getHerbariumNumber() + "%");
//        }

//        if (!model.getHabitat().equals("")) {
//            where_part = where_part + " and h.habitat like ?";
//            paramValues.add("%" + model.getHabitat() + "%");
//        }
      String t ="test"; 
        String result = SQL_SEED_MODEL_DATA_BY_MODEL ;// + where_part;// + " and sd.status=a ";
        Object[] values ={t};// new Object[paramValues.size()];
//        for (int i = 0; i < paramValues.size(); i++) {
//            values[i] = paramValues.get(i);
//        }

        try {

            conn = DAOUtil.accessDBConnection();

            ps = prepareStatement(conn, result, values);

            rs =ps.executeQuery();
            while (rs.next()) {
//                model = new SeedModel(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getString(5),
//                        rs.getString(6));
//                modelList.add(model);
            }

        } catch (SQLException e) {
            System.err.println("exception in SQL_SEED_MODEL_DATA_BY_MODEL " +e.toString()  );
//            daoUtils.getLogger().error(e);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(SeedDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, ps, rs);
        }
        return modelList;
    }

    @Override
    public void save(SeedModel model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        final String SAVE_SEED = "insert into seed(plant_id ,collection_id,location_id, sampling_id,herbarium_id,habitat_id,seed_mor_id,seed_weight_id,create_date,status) "
                + "values(?,?,?,?,?,?,?,?,?,'a')";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {model.getPlantId(), model.getCollectionId(), model.getLocationId(), model.getSamplingId(), 
                model.getHerbariumId(), model.getHabitatId(),model.getMorphologyId(),model.getSeedWeightId(), new Date()};
            ps = prepareStatement(conn, SAVE_SEED, true, values);
            ps.execute();
            rs = ps.getGeneratedKeys();
            int gen_id = rs.next() ? rs.getInt(1) : 0;
            model.setId(gen_id);
            model.setDaoStatus("1");
        } catch (SQLException e) {
            model.setDaoStatus("0");
            System.err.println("exception in SAVE_SEED " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void update(SeedModel model) {
        PreparedStatement ps = null;
        Connection conn = null;
        final String UPDATE_SEED = "update seed  set plant_id =?, collection_id =? , location_id=? , sampling_id =? , herbarium_id = ?, habitat_id =? ,"
                + "seed_mor_id =? , seed_weight_id =?  where id= ?";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {model.getPlantId(),model.getCollectionId(),model.getLocationId(),
                model.getSamplingId(),model.getHerbariumId(),model.getHabitatId(),model.getMorphologyId(),model.getSeedWeightId(),
                model.getId()};
            ps = prepareStatement(conn, UPDATE_SEED, values);
            ps.execute();
            model.setDaoStatus("1");
        } catch (SQLException e) {
            model.setDaoStatus("0");
            System.err.println("exception in UPDATE_SEED " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps);
        }
    }

    @Override
    public SeedModel seedById(Number id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        SeedModel model = null;
        final String SEED_BY_ID = "select sw.id, sw.weight_1000,sw.weight_100,sw.fruit_weight,cw.id as type_id from (seed sd left join  seed_weight sw on sw.id = sd.seed_weight_id )\n" +
                                   "left join combos cw on cw.id = sw.typeWeightId where sd.id =?";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {id};
            ps = prepareStatement(conn, SEED_BY_ID, values);
            rs = ps.executeQuery();
            if (rs.next()){
                model = new SeedModel();
                SeedWeight sw = new SeedWeight(rs.getInt("id"),rs.getString("weight_1000"), rs.getString("weight_100"), rs.getInt("type_id"), rs.getString("fruit_weight"),
                        rs.getString("perfruit"));
                model.setSeedWeightId(id);
            }
//            model.setDaoStatus("1");
        } catch (SQLException e) {
//            model.setDaoStatus("0");
            System.err.println("exception in SEED_BY_ID " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps,rs);
        }
       return model;
    }

    @Override
    public DefaultSeed defaultSeedById(Number id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        DefaultSeed model = null;
        final String SEED_BY_ID =               "   select sw.id, sw.weight_1000,sw.weight_100,sw.fruit_weight,cw.id as type_id, sw.perfruit ,\n" +
                                                " sm.id as mor_id ,sm.size,sm.length,sm.width,sm.height,sm.configuration, sm.type_id as mor_type_id, sm.aids,sm.embrio,\n" +
                                                " hs.id as her_id, hs.number, hs.location, hs.isSpecimen, hs.dublicated,hs.voucher,\n" +
                                                " sdt.id as sam_id, sdt.numberSample, sdt.numberFood, sdt.area, sdt.percentage, sdt.note,\n" +
                                                " hd.id as hab_id, hd.habitat, hd.landform, hd.geology, hd.aspect ,hd.factor, hd.soil, hd.site_notes, hd.associated, hd.slope,hd.landuse ,\n" +
                                                " ld.id as loc_id, ld.country_id, ld.district, ld.latitude, ld.lat_long_method, ld.grid, ld.altitude, ld.state_id, ld.description, ld.longtitude, ld.lat_long_unit , ld.gps, ld.altitude_method  ,\n" +
                                                " cd.id as col_id, cd.col_number, cd.col_name ,  cd.access_number,  cd.col_date, cd.org_ins_id, cd.wild_cult_id, cd.col_name_ins_id,\n" +
                                                " pl.id as plant_id, pl.familyid, pl.genusid, pl.speciesAuthorid, pl.rankid, pl.infraspeciesId, pl.infraAuthorId, pl.rank2Id, pl.identifationStatusId,pl.identifierInstituteId, pl.description as plant_desc ,\n" +
                                                " pl.usesId, pl.vernacularNameId ,pl.otherKeyId,pl.plantFromId, pl.infraSpecies2Id, pl.infraAuthor2Id , pl.identifiedFromId , pl.identificationDate, pl.height as plant_height, pl.assesInforId, pl.speciesid,\n" +
                                                " img.id as image_id, img.plant_id, img.image_url, img.image_name "+
                                                " from (((((((((seed sd left join  seed_weight sw on sw.id = sd.seed_weight_id ) \n" +
                                                " left join combos cw on cw.id = sw.typeWeightId )\n" +
                                                " left join seed_morphology sm on sm.id = sd.seed_mor_id)\n" +
                                                " left join herbariumSpecimen hs on hs.id = sd.herbarium_id )\n" +
                                                " left join samplingdata sdt on sdt.id =sd.sampling_id )\n" +
                                                " left join habitat_data hd on hd.id = sd.habitat_id )\n" +
                                                " left join location_data ld on ld.id = sd.location_id)\n" +
                                                " left join collection_data cd on cd.id = sd.collection_id)\n" +
                                                " left join plant pl on sd.plant_id = pl.id)\n" +
                                                " left join image img on pl.id = img.plant_id  and img.status='a' "+    
                                                " where sd.id =?";
 

        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {id};
            System.out.println("id = "+id);
            ps = prepareStatement(conn, SEED_BY_ID, values);
            rs = ps.executeQuery();
            if (rs.next()){
                model = new DefaultSeed();
                SeedWeight sw = new SeedWeight(rs.getInt("id"),rs.getString("weight_1000"), rs.getString("weight_100"), rs.getInt("type_id"), rs.getString("fruit_weight"),
                        rs.getString("perfruit"));
                SeedMorphology sm = new SeedMorphology(rs.getInt("mor_id"), rs.getString("size"), rs.getInt("mor_type_id"), rs.getString("length"), 
                        rs.getString("width"), rs.getString("height"), rs.getInt("aids"), rs.getString("configuration"), rs.getInt("embrio"));
                HerbariumSpecimenBase hs = new HerbariumSpecimenBase(rs.getInt("her_id"), rs.getString("number"),  rs.getInt("location"), rs.getInt("dublicated"),
                        rs.getBoolean("isSpecimen"), rs.getString("voucher"));
                SamplingDataBase sd = new SamplingDataBase(rs.getInt("sam_id"), rs.getString("numbersample"), rs.getString("numberFood"), 
                        rs.getString("area"), rs.getString("percentage"), rs.getString("note"));
                 
                HabitatDataBase hd = new HabitatDataBase(rs.getInt("hab_id"),rs.getInt("habitat"), rs.getInt("landform"),  rs.getString("geology"), 
                        rs.getInt("aspect"), rs.getInt("factor"), rs.getInt("soil"), rs.getString("associated"), rs.getInt("slope"), rs.getInt("landuse"),rs.getString("site_notes"));
               
                LocationDataBase ld = new LocationDataBase(rs.getInt("loc_id"), rs.getInt("country_id"), rs.getInt("state_id"),rs.getString("latitude"),
                        rs.getString("lat_long_method"), rs.getString("grid"), rs.getString("altitude"), rs.getString("description"), rs.getString("longtitude"), 
                        rs.getString("lat_long_unit"), rs.getString("gps"), rs.getString("altitude_method"));
              
                CollectionDataBase cd = new CollectionDataBase(rs.getInt("col_id"), rs.getString("col_number"), rs.getString("col_name"), rs.getString("access_number"), 
                        rs.getDate("col_date"), rs.getInt("org_ins_id"), rs.getInt("wild_cult_id"), rs.getInt("col_name_ins_id"));
                
                Plant pl = new Plant(rs.getInt("plant_id"), rs.getInt("familyId"), rs.getInt("genusId"), rs.getInt("speciesId"), rs.getInt("speciesAuthorId"), rs.getInt("rankId"), 
                        rs.getInt("infraSpeciesId"), rs.getInt("infraAuthorId"), rs.getInt("rank2Id"), rs.getInt("identifationStatusId"), rs.getInt("identifierInstituteId"), 
                        rs.getString("plant_desc"), rs.getInt("usesId"), rs.getInt("vernacularNameId"), 
                        rs.getInt("assesInforId"), rs.getInt("otherKeyId"), rs.getInt("plantFromId"), rs.getInt("infraSpecies2Id"),
                        rs.getInt("infraAuthor2Id"), rs.getInt("identifiedFromId"), rs.getDate("identificationDate"),rs.getString("plant_height"));
                
                DefaultImage defaultImage = new DefaultImage(rs.getInt("image_id"), rs.getInt("plant_id"), rs.getString("image_url"), rs.getString("image_name"));
                pl.setDefaultImage(defaultImage);
                model.setSeedWeight(sw);
                model.setMorphology(sm);
                model.setHerbarium(hs);
                model.setSampling(sd);
                model.setHabitat(hd);
                model.setLocation(ld);
                model.setCollection(cd);
                model.setPlant(pl);
                model.setId(id);
            }
//            model.setDaoStatus("1");
        } catch (SQLException e) {
//            model.setDaoStatus("0");
            System.err.println("exception in SEED_BY_ID " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps,rs);
        }
       return model;
    }

    @Override
    public void save(DefaultSeed model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        final String SAVE_SEED = "insert into seed(plant_id ,collection_id,location_id, sampling_id,herbarium_id,habitat_id,seed_mor_id,seed_weight_id,create_date,status) "
                + "values(?,?,?,?,?,?,?,?,?,'a')";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {model.getPlant().getId(), model.getCollection().getId(), model.getLocation().getId(), model.getSampling().getId(), 
                model.getHerbarium().getId(), model.getHabitat().getId(),model.getMorphology().getId(),model.getSeedWeight().getId(), new Date()};
            ps = prepareStatement(conn, SAVE_SEED, true, values);
            ps.execute();
            rs = ps.getGeneratedKeys();
            int gen_id = rs.next() ? rs.getInt(1) : 0;
            model.setId(gen_id);
//            model.setDaoStatus("1");
        } catch (SQLException e) {
//            model.setDaoStatus("0");
            System.err.println("exception in SAVE_SEED " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void update(DefaultSeed model) {
        PreparedStatement ps = null;
        Connection conn = null;
        final String UPDATE_SEED = "update seed  set plant_id =?, collection_id =? , location_id=? , sampling_id =? , herbarium_id = ?, habitat_id =? ,"
                + "seed_mor_id =? , seed_weight_id =?  where id= ?";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {model.getPlant().getId(),model.getCollection().getId(),model.getLocation().getId(),
                model.getSampling().getId(),model.getHerbarium().getId(),model.getHabitat().getId(),model.getMorphology().getId(),model.getSeedWeight().getId(),
                model.getId()};
            ps = prepareStatement(conn, UPDATE_SEED, values);
            ps.execute();
//            model.setDaoStatus("1");
        } catch (SQLException e) {
//            model.setDaoStatus("0");
            System.err.println("exception in UPDATE_SEED " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps);
        }
    }

    @Override
    public SeedView SeedById(Number id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        SeedView model = null;
        PlantView pl = null;
        SamplingDataView sdv =null;
        SeedMorphologyView smv = null;
        SeedWeightView swv = null;
        final String SEED_VIEW_BY_ID =  " select   clcombo.description as orgins ,cp.description as family,plver.description as famAze , "
                + " cp.description as taxon,cp.description as taxaze,wlcombo.description as wild , cld.col_date , cld.col_name,\n" +
                                        "loccombo.description as country , discombo.description as district, ld.description as location , ld.latitude,ld.altitude, pl.description as plantDesc,\n" +
                                        "hcombo.description as habitat,  lfcombo.description as landform , fcombo.description as factor , hd.associated,\n" +
                                        "her.number, hc.description as herloc ,plform.description as plantfrom , hs.description as soiltype ,pl.id as plant_id, pi.id as image_id,pi.image_url, pi.image_name from\n" +
                                        " (((((((((((((((((seed sd left join  plant pl on sd.plant_id = pl.id)\n" +
                                        "left join combos cp on pl.familyid = cp.id  )\n" +
                                        "left join collection_data cld on cld.id = sd.collection_id)\n" +
                                        "left join combos clcombo on clcombo.id = cld.org_ins_id)\n" +
                                        "left join combos wlcombo on wlcombo.id = cld.wild_cult_id)\n" +
                                        "left join location_data ld on sd.location_id = ld.id)\n" +
                                        "left join combos loccombo on loccombo.id = ld.country_id )\n" +
                                        "left join combos discombo on discombo.id = ld.state_id )\n" +
                                        "left join habitat_data hd on hd.id = sd.habitat_id)\n" +
                                        "left join combos hcombo on hcombo.id = hd.habitat )\n" +
                                        "left join combos lfcombo on lfcombo.id = hd.landform)\n" +
                                        "left join combos fcombo on fcombo.id = hd.factor)\n" +
                                        "left join herbariumspecimen her on her.id = sd.herbarium_id)\n" +
                                        "left join combos hc on hc.id = her.location )\n" +
                                        "left join combos plform on plform.id = pl.plantfromid)\n" +
                                        "left join combos plver on plver.id = pl.vernacularnameid)\n" +
                                        "left join image pi on pi.plant_id = pl.id)\n" +
                                        "left join combos hs on hs.id = hd.soil \n"+
                                        "where sd.id=?  and cp.status='a' ";
 

        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {id};
            System.out.println("id = "+id);
            ps = prepareStatement(conn, SEED_VIEW_BY_ID, values);
            rs = ps.executeQuery();
            if (rs.next()){
                model = new SeedView();
//                SeedWeight sw = new SeedWeight(rs.getInt("id"),rs.getString("weight_1000"), rs.getString("weight_100"), rs.getInt("type_id"), rs.getString("fruit_weight"),
//                        rs.getString("perfruit"));
//                SeedMorphology sm = new SeedMorphology(rs.getInt("mor_id"), rs.getString("size"), rs.getInt("mor_type_id"), rs.getString("length"), 
//                        rs.getString("width"), rs.getString("height"), rs.getInt("aids"), rs.getString("configuration"), rs.getInt("embrio"));
//                HerbariumSpecimenBase hs = new HerbariumSpecimenBase(rs.getInt("her_id"), rs.getString("number"),  rs.getInt("location"), rs.getInt("dublicated"),
//                        rs.getBoolean("isSpecimen"), rs.getString("voucher"));
//                SamplingDataBase sd = new SamplingDataBase(rs.getInt("sam_id"), rs.getString("numbersample"), rs.getString("numberFood"), 
//                        rs.getString("area"), rs.getString("percentage"), rs.getString("note"));
//                 
//                HabitatDataBase hd = new HabitatDataBase(rs.getInt("hab_id"),rs.getInt("habitat"), rs.getInt("landform"),  rs.getString("geology"), 
//                        rs.getInt("aspect"), rs.getInt("factor"), rs.getInt("soil"), rs.getString("associated"), rs.getInt("slope"), rs.getInt("landuse"),rs.getString("site_notes"));
//               
//                LocationDataBase ld = new LocationDataBase(rs.getInt("loc_id"), rs.getInt("country_id"), rs.getInt("state_id"),rs.getString("latitude"),
//                        rs.getString("lat_long_method"), rs.getString("grid"), rs.getString("altitude"), rs.getString("description"), rs.getString("longtitude"), 
//                        rs.getString("lat_long_unit"), rs.getString("gps"), rs.getString("altitude_method"));
//              
//                CollectionDataBase cd = new CollectionDataBase(rs.getInt("col_id"), rs.getString("col_number"), rs.getString("col_name"), rs.getString("access_number"), 
//                        rs.getDate("col_date"), rs.getInt("org_ins_id"), rs.getInt("wild_cult_id"), rs.getInt("col_name_ins_id"));
//                
//                
                
                DefaultImage defaultImage = new DefaultImage(rs.getInt("image_id"), rs.getInt("plant_id"), rs.getString("image_url"), rs.getString("image_name"));
                pl = new PlantView(
                        rs.getInt("plant_id"), 
                        rs.getString("orgIns"),
                        rs.getString("family"), 
                        rs.getString("famAze"), 
                        rs.getString("taxon"), 
                        rs.getString("taxAze"), 
                        rs.getString("wild"), 
                        rs.getDate("col_date"),
                        rs.getString("col_name"), 
                        rs.getString("country"), 
                        rs.getString("district"), 
                        rs.getString("location"), 
                        rs.getString("latitude"), 
                        rs.getString("altitude"), 
                        rs.getString("habitat"), 
                        rs.getString("factor"), 
                        rs.getString("soilType"), 
                        rs.getString("associated"), 
                        rs.getString("plantfrom"), 
                        rs.getString("plantDesc"),
                        rs.getString("herloc"),
                        rs.getString("number"),
                        defaultImage ); 
               
            }
             sdv = seedSamplingData(id);
             swv = seedWeightById(id);
             smv = seedMorphologyById(id);
             model = new SeedView(id,pl,sdv,swv,smv);
             
//            model.setDaoStatus("1");
        } catch (SQLException e) {
//            model.setDaoStatus("0");
            System.err.println("exception in SEED_BY_ID " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps,rs);
        }
       return model;
    }

    @Override
    public SeedWeightView seedWeightById(Number id) {
          PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        SeedWeightView model = null;
        final String WEIGHT_BY_ID =     "select sw.id , sw.weight_1000, sw.weight_100, sw.fruit_weight, sw.perfruit, tw.description as typeWeight  from \n" +
                                        "(seed sd  left join seed_weight  sw on sd.seed_weight_id = sw.id)\n" +
                                        "left join combos tw on tw.id = sw.typeWeightId  \n" +
                                        "where sd.id = ?";
 

        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {id};
            System.out.println("id = "+id);
            ps = prepareStatement(conn, WEIGHT_BY_ID, values);
            rs = ps.executeQuery();
            if (rs.next()){
//                model = new SeedWeightView();
                model = new SeedWeightView(rs.getInt("id"),rs.getString("weight_1000"), rs.getString("weight_100"),
                        rs.getString("typeWeight"), rs.getString("fruit_weight"),
                        rs.getString("perfruit"));
               
//                model = new SeedView(id,pl);
            }
//            model.setDaoStatus("1");
        } catch (SQLException e) {
//            model.setDaoStatus("0");
            System.err.println("exception in seedWeightById " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps,rs);
        }
       return model;
    }

    @Override
    public SeedMorphologyView seedMorphologyById(Number id) {
         PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        SeedMorphologyView model = null;
        final String MORPHOLOGY_VIEW_BY_ID = "select sm.id as mor_id,  sm.size, sm.length, sm.width,sm.height, sm.configuration,"
                + "                              mft.description as type, maid.description as aids,me.description as embrio  from \n" +
                                                "(((seed sd  left join seed_morphology  sm on sd.seed_mor_id = sm.id)\n" +
                                                "left join combos mft on mft.id = sm.type_id)\n" +
                                                "left join combos maid on maid.id = sm.aids )\n" +
                                                "left join combos me on me.id = sm.embrio\n" +
                                                "where sd.id = ?";  


        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {id};
            System.out.println("id = "+id);
            ps = prepareStatement(conn, MORPHOLOGY_VIEW_BY_ID, values);
            rs = ps.executeQuery();
            if (rs.next()){
 
                 model = new SeedMorphologyView(rs.getInt("mor_id"), rs.getString("size"), rs.getString("type"), rs.getString("length"), 
                        rs.getString("width"), rs.getString("height"), rs.getString("aids"), rs.getString("configuration"), rs.getString("embrio"));
       
            }
//            model.setDaoStatus("1");
        } catch (SQLException e) {
//            model.setDaoStatus("0");
            System.err.println("exception in seedMorphologyById " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps,rs);
        }
       return model;
    }

    @Override
    public SamplingDataView seedSamplingData(Number id) {
         PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        SamplingDataView model = null;
        final String SAMPLING_VIEW_BY_ID =  " select samd.id as sam_id, samd.numberSample, samd.numberFood, samd.area  from seed sd \n" +
                                            " left join samplingdata  samd  on sd.sampling_id = samd.id where sd.id = ?";
 

        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {id};
            System.out.println("id = "+id);
            ps = prepareStatement(conn, SAMPLING_VIEW_BY_ID, values);
            rs = ps.executeQuery();
            if (rs.next()){ 
                model = new SamplingDataView(rs.getInt("sam_id"), rs.getString("numbersample"), rs.getString("numberFood"), 
                        rs.getString("area") );                   
                 
            }
//            model.setDaoStatus("1");
        } catch (SQLException e) {
//            model.setDaoStatus("0");
            System.err.println("exception in seedSamplingData " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps,rs);
        }
       return model;
    }

}
