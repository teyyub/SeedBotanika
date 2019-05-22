package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.dao.intf.SamplingDataDAO;
import com.botanik.model.SamplingDataBase;
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
public class SamplingDAOJDBC implements SamplingDataDAO {

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
    public void save(SamplingDataBase model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_SAVE_SamplingData = "insert into samplingdata(numbersample,numberfood,area,percentage,note,create_date,status) values(?,?,?,?,?,?,'a')";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {
                model.getNumberSample(),
                model.getNumberFood(),
                model.getPercentage(),
                model.getArea(),
                model.getNote(),
                new Date()};
            ps = prepareStatement(conn, SQL_SAVE_SamplingData, true, values);
            ps.execute();
            rs = ps.getGeneratedKeys();
            int gen_id = rs.next() ? rs.getInt(1) : 0;
            model.setId(gen_id);
            model.setDaoStatus("1");
        } catch (SQLException e) {
            model.setDaoStatus("0");
            System.err.println("Exception in SQL_SAVE_SamplingData " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void update(SamplingDataBase model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_UPDATE_SamplingData = "update samplingdata set numbersample = ?, numberfood =? , area =?, percentage=? , note =?  where id = ?";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {
                model.getNumberSample(),
                model.getNumberFood(),
                model.getPercentage(),
                model.getArea(),
                model.getNote(),
                model.getId()
            };
            ps = prepareStatement(conn, SQL_UPDATE_SamplingData, values);
            ps.execute();
//            rs = ps.getGeneratedKeys();
//            inst gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
            model.setDaoStatus("1");
        } catch (SQLException e) {
            model.setDaoStatus("0");
            System.err.println("Exception in SQL_SAVE_SamplingData " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void delete(Number id) {
//          ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_UPDATE_SamplingData = "update samplingdata set status = 'd' where id = ?";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {
                id
            };
            ps = prepareStatement(conn, SQL_UPDATE_SamplingData, values);
            ps.execute();
//            rs = ps.getGeneratedKeys();
//            inst gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
//            base.setDaoStatus("1");
        } catch (SQLException e) {
//            base.setDaoStatus("0");
            System.err.println("Exception in delete SamplingData " + e.getMessage());
        } finally {
            close(conn, ps);
        }
    }

    @Override
    public List<SamplingDataBase> AllSamplingDatas() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        SamplingDataBase model = null;
        List<SamplingDataBase> modelList = new ArrayList();
        final String SQL_ALL_SAMPLING_DATA = "select * from samplingdata where status='a'";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ALL_SAMPLING_DATA, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                model = new SamplingDataBase(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
                modelList.add(model);
            }

        } catch (SQLException e) {
            System.err.println("exception in SQL_ALL_SAMPLING_DATA " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return modelList;
    }

    @Override
    public List<SamplingDataBase> samplingDataBySearchModel(SamplingDataBase model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        LinkedList<Object> paramValues = new LinkedList<>();
        List<SamplingDataBase> modelList = new ArrayList();
        final String SQL_SAMPLING_DATA_BY_MODEL = "select * from samplingdata sd ";
        String where_part = " where   1=1 ";
        if (!model.getNumberSample().equals("")) {
            where_part = where_part + " and sd.numberSample like ? ";
            paramValues.add("%" + model.getNumberSample() + "%");

        }
        if (!model.getNumberFood().equals("")) {
            where_part = where_part + " and sd.numberFood  like ?";
            paramValues.add("%"+model.getNumberFood()+"%");
        }

        if (!model.getArea().equals("")) {
            where_part = where_part + " and sd.area like ?";
            paramValues.add("%"+model.getArea()+"%");
        }

        if (!model.getPercentage().equals("")) {
            where_part = where_part + " and sd.percentage liek ?";
            paramValues.add("%"+model.getPercentage()+"%");
        }

        if (!model.getNote().equals("")) {
            where_part = where_part + " and sd.note like ?";
            paramValues.add("%"+model.getNote()+"%");
        }

        String result = SQL_SAMPLING_DATA_BY_MODEL + where_part +" and sd.status='a'";
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

            rs = ps.executeQuery();
            while (rs.next()) {
                model = new SamplingDataBase(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
                        modelList.add(model);
            }

        } catch (SQLException e) {
            System.err.println("exception in SQL_SAMPLING_DATA_BY_MODEL " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return modelList;
    }

}
