package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.dao.intf.HerbariumSpecimenDAO;
 
import com.botanik.model.HerbariumSpecimenBase;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class HerbariumSpecimenDAOJDBC implements HerbariumSpecimenDAO {

    @Override
    public void save(HerbariumSpecimenBase base) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_SAVE_HERBARIUM_SPECIMEN = "insert into herbariumspecimen(number ,location,dublicated,isSpecimen,voucher,create_date,status) values(?,?,?,?,?,?,'a')";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {base.getNumber(), base.getLocationId(),base.getDublicatedId(), base.getHerbarium() , base.getVoucher(),new Date()};
            ps = prepareStatement(conn, SQL_SAVE_HERBARIUM_SPECIMEN, true, values);
            ps.execute();
            rs = ps.getGeneratedKeys();
            int gen_id = rs.next() ? rs.getInt(1) : 0;
            base.setId(gen_id);
            base.setDaoStatus("1");
        } catch (SQLException e) {
            base.setDaoStatus("0");
            System.err.println("Exception in SQL_SAVE_HERBARIUM_SPECIMEN " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }
 

  
    @Override
    public void update(HerbariumSpecimenBase base) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_UPDATE_HERBARIUM_SPECIMEN = "update herbariumspecimen set number =? ,location =? , isSpecimen =? , dublicated =? , voucher =? where id = ? ";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {base.getNumber(), base.getLocationId(), base.getHerbarium(), base.getDublicatedId(),base.getVoucher(), base.getId()};
            ps = prepareStatement(conn, SQL_UPDATE_HERBARIUM_SPECIMEN,   values);
            ps.executeUpdate();
//            rs = ps.getGeneratedKeys();
//            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
            base.setDaoStatus("1");
        } catch (SQLException e) {
            base.setDaoStatus("0");
            System.err.println("Exception in SQL_UPDATE_HERBARIUM_SPECIMEN " + e.getMessage());
        } finally {
            close(conn, ps);
        }
    }

   
     
    @Override
    public void delete(Number id) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_DELETE_HERBARIUM_SPECIMEN = "update herbariumspecimen set status ='d'  where id = ? ";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {id};
            ps = prepareStatement(conn, SQL_DELETE_HERBARIUM_SPECIMEN, true, values);
            ps.executeUpdate();
//            rs = ps.getGeneratedKeys();
//            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
//            base.setDaoStatus("1");
        } catch (SQLException e) {
//            base.setDaoStatus("0");
            System.err.println("Exception in SQL_DELETE_HERBARIUM_SPECIMEN " + e.getMessage());
        } finally {
            close(conn, ps);
        }
    }

}
