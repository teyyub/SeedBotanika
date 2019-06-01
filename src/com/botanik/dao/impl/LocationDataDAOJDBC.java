package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.dao.intf.LocationDataDAO;
import com.botanik.model.LocationDataBase;
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
public class LocationDataDAOJDBC implements LocationDataDAO {

    @Override
    public void save(LocationDataBase model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_SAVE_LOCATION_DATA = "insert into location_data(country_id,state_id, latitude,lat_long_method,grid,altitude,description,"
                + "longtitude,lat_long_unit,gps,altitude_method,create_date,status) values(?,?,?,?,?,?,?,?,?,?,?,?,'a')";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {
                model.getCountryId(),
                model.getStateId(),                
                model.getLatitude(),
                model.getLatMethod(),
                model.getGrid(),
                model.getAltitude(),
                model.getDescription(),
                model.getLongtitude(),
                model.getLatUnits(),
                model.getGps(),
                model.getAltitudeMethod(),
                new Date()};
            ps = prepareStatement(conn, SQL_SAVE_LOCATION_DATA, true, values);
            ps.execute();
            rs = ps.getGeneratedKeys();
            int gen_id = rs.next() ? rs.getInt(1) : 0;
            model.setId(BigDecimal.valueOf(gen_id));
            model.setDaoStatus("1");
        } catch (SQLException e) {
            model.setDaoStatus("0");
            System.err.println("Exception in SQL_SAVE_LOCATION_DATA " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void update(LocationDataBase model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_UPDATE_LOCATION_DATA = " update location_data set country_id = ?, state_id = ? ,   latitude =?,"
                + "lat_long_method = ?, grid =? , altitude =? , description =?,"
                + "longtitude =? , lat_long_unit =? , gps =? , altitude_method =? where id =?";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {
                model.getCountryId(),
                model.getStateId(),                
                model.getLatitude(),
                model.getLatMethod(),
                model.getGrid(),
                model.getAltitude(),
                model.getDescription(),
                model.getLongtitude(),
                model.getLatUnits(),
                model.getGps(),
                model.getAltitudeMethod(),
                model.getId()
            };
            ps = prepareStatement(conn, SQL_UPDATE_LOCATION_DATA, values);
            ps.execute();
//            rs = ps.getGeneratedKeys();
//            inst gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
            model.setDaoStatus("1");
        } catch (SQLException e) {
            model.setDaoStatus("0");
            System.err.println("Exception in SQL_UPDATE_LOCATION_DATA " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void delete(Number id) {
//          ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_UPDATE_LOCATION_DATA = "update location_data set status = 'd' where id = ?";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {
                id
            };
            ps = prepareStatement(conn, SQL_UPDATE_LOCATION_DATA, values);
            ps.execute();
//            rs = ps.getGeneratedKeys();
//            inst gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
//            base.setDaoStatus("1");
        } catch (SQLException e) {
//            base.setDaoStatus("0");
            System.err.println("Exception in delete Location_Data " + e.getMessage());
        } finally {
            close(conn, ps);
        }
    }

    @Override
    public List<LocationDataBase> AllLocationDatas() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        LocationDataBase model = null;
        List<LocationDataBase> modelList = new ArrayList();
        final String SQL_ALL_LOCATION_DATA = "select * from location_data where status='a'";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ALL_LOCATION_DATA, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                model = new LocationDataBase(
                        rs.getBigDecimal("id"),
                        rs.getBigDecimal("country_id"),
                        rs.getBigDecimal("state_id"),                        
                        rs.getString("latitude"),
                        rs.getString("lat_long_Method"),
                        rs.getString("grid"),
                        rs.getString("altitude"),
                        rs.getString("description"),
                        rs.getString("longtitude"),
                        rs.getString("lat_long_Unit"),
                        rs.getString("gps"),
                        rs.getString("altitude_Method")
                );
                modelList.add(model);
            }

        } catch (SQLException e) {
            System.err.println("exception in SQL_ALL_LOCATION_DATA " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return modelList;
    }

    @Override
    public List<LocationDataBase> locationDataBySearchModel(LocationDataBase model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        LinkedList<Object> paramValues = new LinkedList<>();
        List<LocationDataBase> modelList = new ArrayList();
        final String SQL_LOCATION_DATA_BY_MODEL = "select * from location_data ld";
        String where_part = " where   1=1 ";
        if(!model.getCountryId().equals(-1)){
            where_part = where_part + " and ld.country_id = ? ";
            paramValues.add(model.getCountryId()); 
        }
        if(!model.getStateId().equals(-1)){
            where_part = where_part + " and ld.state_Id = ? ";
            paramValues.add(model.getStateId());
        }
//        if (!model.getDistrict().equals("")) {
//            where_part = where_part + " and ld.district like ? ";
//            paramValues.add("%" + model.getDistrict() + "%");
//
//        }
        if (!model.getLatitude().equals("")) {
            where_part = where_part + " and ld.latitude  like ?";
            paramValues.add("%" + model.getLatitude() + "%");
        }

        if (!model.getLatMethod().equals("")) {
            where_part = where_part + " and ld.area like ?";
            paramValues.add("%" + model.getLatMethod() + "%");
        }

        if (!model.getGrid().equals("")) {
            where_part = where_part + " and ld.latMethod liek ?";
            paramValues.add("%" + model.getGrid() + "%");
        }

        if (!model.getAltitude().equals("")) {
            where_part = where_part + " and ld.altitude like ?";
            paramValues.add("%" + model.getAltitude() + "%");
        }

        if (!model.getDescription().equals("")) {
            where_part = where_part + " and ld.description like ?";
            paramValues.add("%" + model.getDescription() + "%");
        }
        if (!model.getLongtitude().equals("")) {
            where_part = where_part + " and ld.longtitude like ?";
            paramValues.add("%" + model.getLongtitude() + "%");
        }

        if (!model.getLatUnits().equals("")) {
            where_part = where_part + " and ld.latUnits like ?";
            paramValues.add("%" + model.getLatUnits() + "%");
        }
        if (!model.getGps().equals("")) {
            where_part = where_part + " and ld.gps like ?";
            paramValues.add("%" + model.getGps() + "%");
        }

        if (!model.getAltitudeMethod().equals("")) {
            where_part = where_part + " and ld.altitudeMethod like ?";
            paramValues.add("%" + model.getAltitudeMethod() + "%");
        }

        String result = SQL_LOCATION_DATA_BY_MODEL + where_part + " and ld.status='a'";
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
                model = new LocationDataBase(
                        rs.getBigDecimal("id"),
                        rs.getBigDecimal("country_id"),
                        rs.getBigDecimal("state_id"),                       
                        rs.getString("latitude"),
                        rs.getString("lat_long_Method"),
                        rs.getString("grid"),
                        rs.getString("altitude"),
                        rs.getString("description"),
                        rs.getString("longtitude"),
                        rs.getString("lat_long_Unit"),
                        rs.getString("gps"),
                        rs.getString("altitude_Method")
                );
                modelList.add(model);
            }

        } catch (SQLException e) {
            System.err.println("exception in SQL_LOCATION_DATA_BY_MODEL " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return modelList;
    }

}
