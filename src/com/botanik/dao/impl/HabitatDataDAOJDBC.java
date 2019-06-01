package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.dao.intf.HabitatDataDAO;
import com.botanik.model.HabitatDataBase;
import java.io.IOException;
import java.math.BigDecimal;
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
public class HabitatDataDAOJDBC implements HabitatDataDAO {
  
    @Override
    public void save(HabitatDataBase model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_SAVE_HABITAT_DATA = "insert into habitat_data(habitat,landForm,geology,aspect,factor,soil,associated,slope,landUse,site_notes,create_date,status) values(?,?,?,?,?,?,?,?,?,?,?,'a')";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(HabitatDataDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {
                model.getHabitat().intValue(),
                model.getLandForm().intValue(),
                model.getGeology(),
                model.getAspect().intValue(),
                model.getFactor().intValue(),
                model.getSoil().intValue(),                
                model.getAssociated(),
                model.getSlope().intValue(),
                model.getLandUse().intValue(),
                model.getSiteNotes(),
                new Date()};

            ps = prepareStatement(conn, SQL_SAVE_HABITAT_DATA, true,values);
            ps.execute();
            rs = ps.getGeneratedKeys();
            int gen_id = rs.next() ? rs.getInt(1) : 0;
            model.setId(BigDecimal.valueOf(gen_id));
            model.setDaoStatus("1");
        } catch (SQLException e) {
            model.setDaoStatus("0");
            System.err.println("Exception in SQL_SAVE_HABITAT_DATA " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void update(HabitatDataBase model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String  SQL_UPDATE_HABITAT_DATA = "update  habitat_data set habitat = ?, landForm = ?, geology = ?, aspect = ?,"
                + "factor = ? , soil = ?, associated = ? , slope = ? , landUse = ?, site_notes = ?  where id = ?";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(HabitatDataDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {
                model.getHabitat().intValue(),
                model.getLandForm().intValue(),
                model.getGeology(),
                model.getAspect().intValue(),
                model.getFactor().intValue(),
                model.getSoil().intValue(),                
                model.getAssociated(),
                model.getSlope().intValue(),
                model.getLandUse().intValue(),
                model.getSiteNotes(),
                model.getId()
            };
            ps = prepareStatement(conn, SQL_UPDATE_HABITAT_DATA, values);
            ps.execute();
//            rs = ps.getGeneratedKeys();
//            inst gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
            model.setDaoStatus("1");
        } catch (SQLException e) {
            model.setDaoStatus("0");
            System.err.println("Exception in SQL_UPDATE_HABITAT_DATA " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
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
                Logger.getLogger(HabitatDataDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(HabitatDataDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ALL_HABITAT_DATA, values);

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
                Logger.getLogger(HabitatDataDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
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

}
