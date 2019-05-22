package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
 
import com.botanik.dao.intf.SeedMorphologyDAO;
import com.botanik.model.HabitatDataBase;
import com.botanik.model.SeedMorphology;
import com.botanik.model.SeedWeight;
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
 * @author USER
 */
public class SeedMorphologyDAOJDBC implements SeedMorphologyDAO {

//    @Override
//    public void saveForm(Base base) {
//        ResultSet rs = null;
//        PreparedStatement ps = null;
//        Connection conn = null;
//        String SQL_SAVE_FORM = "insert into organize_institute(name ,create_date,status) values(?,?,'a')";
//        try {
//            try {
//                conn = DAOUtil.accessDBConnection();
//            } catch (IOException | ClassNotFoundException ex) {
//                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            Object[] values = {base.getName(), new Date()};
//            ps = prepareStatement(conn, SQL_SAVE_FORM, true, values);
//            ps.execute();
//            rs = ps.getGeneratedKeys();
//            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
//            base.setDaoStatus("1");
//        } catch (SQLException e) {
//            base.setDaoStatus("0");
//            System.err.println("exception in saveForm " + e.getMessage());
//        } finally {
//            close(conn, ps, rs);
//        }
//    }
//
//    @Override
//    public List<Base> organizeInstitute() {
//        ResultSet rs = null;
//        PreparedStatement ps = null;
//        Connection conn = null;
//        Base base = null;
//        List<Base> bases = new ArrayList<>();
//        final String SQL_ORG_INS = "select * from organize_institute";
//        try {
//            try {
//                conn = DAOUtil.accessDBConnection();
//            } catch (IOException | ClassNotFoundException ex) {
//                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
//            }
////            conn.setAutoCommit(true);
//            Object[] values = {};
//            ps = prepareStatement(conn, SQL_ORG_INS, false, values);
//
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
//                bases.add(base);
//            }
//
//        } catch (SQLException e) {
//            System.err.println("exception in organizeInstitute " + e.getMessage());
////            daoUtils.getLogger().error(e);
//        } finally {
//            close(conn, ps, rs);
//        }
//        return bases;
//    }
//
//    @Override
//    public void saveWildCultivited(Base base) {
//        ResultSet rs = null;
//        PreparedStatement ps = null;
//        Connection conn = null;
//        String SQL_SAVE_FORM = "insert into wild_ciltivited(name ,create_date,status) values(?,?,'a')";
//        try {
//            try {
//                conn = DAOUtil.accessDBConnection();
//            } catch (IOException | ClassNotFoundException ex) {
//                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            Object[] values = {base.getName(), new Date()};
//            ps = prepareStatement(conn, SQL_SAVE_FORM, true, values);
//            ps.execute();
//            rs = ps.getGeneratedKeys();
//            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
//            base.setDaoStatus("1");
//        } catch (SQLException e) {
//            base.setDaoStatus("0");
//            System.err.println("exception in saveForm " + e.getMessage());
//        } finally {
//            close(conn, ps, rs);
//        }
//    }
//
//    @Override
//    public List<Base> wildCultivited() {
//        ResultSet rs = null;
//        PreparedStatement ps = null;
//        Connection conn = null;
//        Base base = null;
//        List<Base> bases = new ArrayList<>();
//        final String SQL_ORG_INS = "select * from wild_cultivited";
//        try {
//            try {
//                conn = DAOUtil.accessDBConnection();
//            } catch (IOException | ClassNotFoundException ex) {
//                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
//            }
////            conn.setAutoCommit(true);
//            Object[] values = {};
//            ps = prepareStatement(conn, SQL_ORG_INS, false, values);
//
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
//                bases.add(base);
//            }
//
//        } catch (SQLException e) {
//            System.err.println("exception in authorByName " + e.getMessage());
////            daoUtils.getLogger().error(e);
//        } finally {
//            close(conn, ps, rs);
//        }
//        return bases;
//    }
//
//    @Override
//    public void saveCollectorInstitute(Base base) {
//        ResultSet rs = null;
//        PreparedStatement ps = null;
//        Connection conn = null;
//        String SQL_SAVE_FORM = "insert into collector_institut(name ,create_date,status) values(?,?,'a')";
//        try {
//            try {
//                conn = DAOUtil.accessDBConnection();
//            } catch (IOException | ClassNotFoundException ex) {
//                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            Object[] values = {base.getName(), new Date()};
//            ps = prepareStatement(conn, SQL_SAVE_FORM, true, values);
//            ps.execute();
//            rs = ps.getGeneratedKeys();
//            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
//            base.setDaoStatus("1");
//        } catch (SQLException e) {
//            base.setDaoStatus("0");
//            System.err.println("exception in saveForm " + e.getMessage());
//        } finally {
//            close(conn, ps, rs);
//        }
//    }
//
//    @Override
//    public List<Base> collectorInstitute() {
//        ResultSet rs = null;
//        PreparedStatement ps = null;
//        Connection conn = null;
//        Base base = null;
//        List<Base> bases = new ArrayList<>();
//        final String SQL_ORG_INS = "select * from collector_institut";
//        try {
//            try {
//                conn = DAOUtil.accessDBConnection();
//            } catch (IOException | ClassNotFoundException ex) {
//                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
//            }
////            conn.setAutoCommit(true);
//            Object[] values = {};
//            ps = prepareStatement(conn, SQL_ORG_INS, false, values);
//
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
//                bases.add(base);
//            }
//
//        } catch (SQLException e) {
//            System.err.println("exception in authorByName " + e.getMessage());
////            daoUtils.getLogger().error(e);
//        } finally {
//            close(conn, ps, rs);
//        }
//        return bases;
//    }
//
//    @Override
//    public void saveCollectionData(CollectionDataModel model) {
//        ResultSet rs = null;
//        PreparedStatement ps = null;
//        Connection conn = null;
//        String SQL_SAVE_COLL_DATA = "insert into collection_data(number,org_ins_id,name,wild_cult_id,coll_name_ins_id,acces_number,coll_date ,create_date,status) values(?,?,?,?,?,?,?,?,'a')";
//        try {
//            try {
//                conn = DAOUtil.accessDBConnection();
//            } catch (IOException | ClassNotFoundException ex) {
//                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            Object[] values = {model.getCollectionNumber(),model.getOrganizeInstituteId(),model.getProjectName(),
//                model.getWildCultivitedId(),model.getCollectorInstituteId(),model.getAccessionNumber(),                 
//                model.getDateCollection(),
//                new Date()};
//            ps = prepareStatement(conn, SQL_SAVE_COLL_DATA, true, values);
//            ps.execute();
//            rs = ps.getGeneratedKeys();
//            int gen_id = rs.next() ? rs.getInt(1) : 0;
////            base.setId(gen_id);
////            base.setDaoStatus("1");
//        } catch (SQLException e) {
////            base.setDaoStatus("0");
//            System.err.println("exception in saveCollData " + e.getMessage());
//        } finally {
//            close(conn, ps, rs);
//        }
//    }
//
//    @Override
//    public List<CollectionDataModel> collections() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public void save(SeedMorphology model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_SAVE_SEED_MORPHOLOGY = "insert into seed_morphology(size,type_id,length,width,height,aids,configuration,embrio,create_date,status) "
                + "values(?,?,?,?,?,?,?,?,?,'a')";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {
                model.getSize(),
                model.getTypeId(),
                model.getLength(),
                model.getWidth(),
                model.getHeight(),
                model.getAidId(),
                model.getConfiguration(),
                model.getEmbrioId(),                
                new Date()};

            ps = prepareStatement(conn, SQL_SAVE_SEED_MORPHOLOGY, true,values);
            ps.execute();
            rs = ps.getGeneratedKeys();
            int gen_id = rs.next() ? rs.getInt(1) : 0;
            model.setId(gen_id);
            model.setDaoStatus("1");
        } catch (SQLException e) {
            model.setDaoStatus("0");
            System.err.println("Exception in SQL_SAVE_SEED_MORPHOLOGY " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void update(HabitatDataBase model) {
//        ResultSet rs = null;
//        PreparedStatement ps = null;
//        Connection conn = null;
//        String  SQL_UPDATE_HABITAT_DATA = "update  habitat_data set habitat = ?, landForm = ?, geology = ?, aspect = ?,"
//                + "factor = ? , soil = ?, site = ? , associated = ? , slope = ? , landUse = ? where id = ?";
//        try {
//            try {
//                conn = DAOUtil.accessDBConnection();
//            } catch (IOException | ClassNotFoundException ex) {
//                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            Object[] values = {
//                model.getHabitat(),
//                model.getLandForm(),
//                model.getGeology(),
//                model.getAspect(),
//                model.getFactor(),
//                model.getSoil(),
//                model.getSite(),
//                model.getAssociated(),
//                model.getSlope(),
//                model.getLandUse(),
//                model.getId()
//            };
//            ps = prepareStatement(conn, SQL_UPDATE_HABITAT_DATA, values);
//            ps.execute();
////            rs = ps.getGeneratedKeys();
////            inst gen_id = rs.next() ? rs.getInt(1) : 0;
////            base.setId(gen_id);
//            model.setDaoStatus("1");
//        } catch (SQLException e) {
//            model.setDaoStatus("0");
//            System.err.println("Exception in SQL_UPDATE_HABITAT_DATA " + e.getMessage());
//        } finally {
//            close(conn, ps, rs);
//        }
    }

    @Override
    public void delete(Number id) {
//          ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_UPDATE_HABITAT_DATA = "update habitat_data set status = 'd' where id = ?";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {
                id
            };
            ps = prepareStatement(conn, SQL_UPDATE_HABITAT_DATA, values);
            ps.execute();
//            rs = ps.getGeneratedKeys();
//            inst gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
//            base.setDaoStatus("1");
        } catch (SQLException e) {
//            base.setDaoStatus("0");
            System.err.println("Exception in delete SQL_UPDATE_HABITAT_DATA " + e.getMessage());
        } finally {
            close(conn, ps);
        }
    }

    @Override
    public List<HabitatDataBase> AllHabitatDatas() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        HabitatDataBase model = null;
        List<HabitatDataBase> modelList = new ArrayList();
        final String SQL_ALL_HABITAT_DATA = "select * from habitat_data where status='a'";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ALL_HABITAT_DATA, values);

            rs = ps.executeQuery();
//            while (rs.next()) {
//                model = new HabitatDataBase(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7),
//                        rs.getString(8),
//                        rs.getString(9),
//                        rs.getString(10),
//                        rs.getString(11));
//                modelList.add(model);
//            }

        } catch (SQLException e) {
            System.err.println("exception in SQL_ALL_HABITAT_DATA " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return modelList;
    }

    @Override
    public List<HabitatDataBase> habitatDataBySearchModel(HabitatDataBase model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        LinkedList<Object> paramValues = new LinkedList<>();
        List<HabitatDataBase> modelList = new ArrayList();
        final String SQL_HABITAT_DATA_BY_MODEL = "select * from habitat_data hd ";
        String where_part = " where   1=1 ";
        if (!model.getHabitat().equals("")) {
            where_part = where_part + " and hd.habitat like ? ";
            paramValues.add("%" + model.getHabitat() + "%");

        }
        if (!model.getLandForm().equals("")) {
            where_part = where_part + " and hd.landform  like ?";
            paramValues.add("%" + model.getLandForm() + "%");
        }

        if (!model.getGeology().equals("")) {
            where_part = where_part + " and hd.geology like ?";
            paramValues.add("%" + model.getGeology() + "%");
        }

        if (!model.getAspect().equals("")) {
            where_part = where_part + " and hd.aspect like ?";
            paramValues.add("%" + model.getAspect() + "%");
        }

        if (!model.getFactor().equals("")) {
            where_part = where_part + " and hd.factor like ?";
            paramValues.add("%" + model.getFactor() + "%");
        }
        
        if (!model.getSoil().equals("")) {
            where_part = where_part + " and hd.soil like ?";
            paramValues.add("%" + model.getSoil() + "%");
        }
        
        if (!model.getSiteNotes().equals("")) {
            where_part = where_part + " and sd.note like ?";
            paramValues.add("%" + model.getSiteNotes()+ "%");
        }
        
        if (!model.getAssociated().equals("")) {
            where_part = where_part + " and hd.associated like ?";
            paramValues.add("%" + model.getAssociated() + "%");
        }
        
        if (!model.getSlope().equals("")) {
            where_part = where_part + " and hd.slope like ?";
            paramValues.add("%" + model.getSlope() + "%");
        }
        
        
        if (!model.getLandUse().equals("")) {
            where_part = where_part + " and hd.landuse like ?";
            paramValues.add("%" + model.getLandUse() + "%");
        }
        
            String result = SQL_HABITAT_DATA_BY_MODEL + where_part + " and hd.status='a'";
        Object[] values = new Object[paramValues.size()];
        for (int i = 0; i < paramValues.size(); i++) {
            values[i] = paramValues.get(i);
        }

        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }

            ps = prepareStatement(conn, result, values);

//            rs = ps.executeQuery();
//            while (rs.next()) {
//                model = new HabitatDataBase(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7),
//                        rs.getString(8),
//                        rs.getString(9),
//                        rs.getString(10),
//                        rs.getString(11)
//                );
//                modelList.add(model);
//            }

        } catch (SQLException e) {
            System.err.println("exception in SQL_HABITAT_DATA_BY_MODEL " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return modelList;
    }

    @Override
    public void save(SeedWeight model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_SAVE_SEED_WEIGHT = "insert into seed_weight(weight_1000,weight_100,typeWeightId,fruit_weight,perfruit,create_date,status) "
                + "values(?,?,?,?,?,?,'a')";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {
                model.getWeight_1000(),
                model.getWeight_100(),
                model.getTypeWeightId(),
                model.getFruit_weight(),  
                model.getPerfruit(),
                new Date()};

            ps = prepareStatement(conn, SQL_SAVE_SEED_WEIGHT, true,values);
            ps.execute();
            rs = ps.getGeneratedKeys();
            int gen_id = rs.next() ? rs.getInt(1) : 0;
            model.setId(gen_id);
            model.setDaoStatus("1");
        } catch (SQLException e) {
            model.setDaoStatus("0");
            System.err.println("Exception in SQL_SAVE_SEED_WEIGHT " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void update(SeedWeight model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_UPDATE_SEED_WEIGHT = "update seed_weight set weight_1000= ?, weight_100 =? , typeweightid = ? , fruit_weight = ?, perfruit =? where id =?";            
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {
                model.getWeight_1000(),
                model.getWeight_100(),
                model.getTypeWeightId(),
                model.getFruit_weight(),  
                model.getPerfruit(),
                model.getId()
            };

            ps = prepareStatement(conn, SQL_UPDATE_SEED_WEIGHT,  values);
            ps.execute();
//            rs = ps.getGeneratedKeys();
//            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            model.setId(gen_id);
            model.setDaoStatus("1");
        } catch (SQLException e) {
            model.setDaoStatus("0");
            System.err.println("Exception in SQL_UPDATE_SEED_WEIGHT " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void update(SeedMorphology model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_UPDATE_SEED_MORPHOLOGY = "update seed_morphology set size =?, type_id = ?, length = ?, width =? , height = ?,"
                + "aids =? ,configuration =? , embrio =? where id = ?";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {
                model.getSize(),
                model.getTypeId(),
                model.getLength(),
                model.getWidth(),
                model.getHeight(),
                model.getAidId(),
                model.getConfiguration(),
                model.getEmbrioId(),                
                model.getId()};

            ps = prepareStatement(conn, SQL_UPDATE_SEED_MORPHOLOGY,  values);
            ps.execute();
//            rs = ps.getGeneratedKeys();
//            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            model.setId(gen_id);
            model.setDaoStatus("1");
        } catch (SQLException e) {
            model.setDaoStatus("0");
            System.err.println("Exception in SQL_UPDATE_SEED_MORPHOLOGY " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }
 

}
