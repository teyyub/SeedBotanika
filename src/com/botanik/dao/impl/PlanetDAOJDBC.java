package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.dao.intf.PlanetDAO;
import com.botanik.model.Base;
import com.botanik.model.Family;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class PlanetDAOJDBC implements PlanetDAO {

    @Override
    public List<Family> families() {
        List<Family> list = new ArrayList();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;

        String SQL_ALL_FAMILY = "select * from family f where f.status='a'";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ALL_FAMILY, values);

            rs = ps.executeQuery();
            while (rs.next()) {

                list.add(
                        new Family(rs.getBigDecimal("id"), rs.getString("name")
                        )
                );

            }
//            base.setId(gen_id);
//            base.setDaoStatus("1");
        } catch (SQLException e) {
//            base.setDaoStatus("0");
            System.err.println("Exception in SQL_ALL_FAMILY " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
        return list;
    }

    @Override
    public void save(Family model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_SAVE_FAMILY = "insert into family(name,create_date,status) values(?,?,'a')";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {model.getName(), new Date()};
            ps = prepareStatement(conn, SQL_SAVE_FAMILY, true, values);
            ps.execute();
            rs = ps.getGeneratedKeys();
            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
//            base.setDaoStatus("1");
        } catch (SQLException e) {
//            base.setDaoStatus("0");
            System.err.println("Exception in SQL_SAVE_FAMILY " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void edit(Family model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_UPDATE_FAMILY = "update family set name =?  where id = ? ";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {model.getName(), model.getId()};
            ps = prepareStatement(conn, SQL_UPDATE_FAMILY, true, values);
            ps.executeUpdate();
//            rs = ps.getGeneratedKeys();
//            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
//            base.setDaoStatus("1");
        } catch (SQLException e) {
//            base.setDaoStatus("0");
            System.err.println("Exception in SQL_DELETE_FAMILY " + e.getMessage());
        } finally {
            close(conn, ps);
        }
    }

    @Override
    public void delete(Number id) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_DELETE_FAMILY = "update family set status ='d'  where id = ? ";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {id};
            ps = prepareStatement(conn, SQL_DELETE_FAMILY, true, values);
            ps.executeUpdate();
//            rs = ps.getGeneratedKeys();
//            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
//            base.setDaoStatus("1");
        } catch (SQLException e) {
//            base.setDaoStatus("0");
            System.err.println("Exception in SQL_DELETE_FAMILY " + e.getMessage());
        } finally {
            close(conn, ps);
        }

    }

    @Override
    public List<Base> genuses() {
        List<Base> list = new ArrayList();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;

        String SQL_ALL_GENUSES = "select * from genus g where g.status='a'";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ALL_GENUSES, values);

            rs = ps.executeQuery();
            while (rs.next()) {

                list.add(new Base(rs.getBigDecimal("id"), rs.getString("name")));

            }
//            base.setId(gen_id);
//            base.setDaoStatus("1");
        } catch (SQLException e) {
//            base.setDaoStatus("0");
            System.err.println("Exception in SQL_ALL_GENUSES " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
        return list;
    }

    @Override
    public void save(Base model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_SAVE_GENUS = "insert into genus(name,create_date,status) values(?,?,'a')";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {model.getName(), new Date()};
            ps = prepareStatement(conn, SQL_SAVE_GENUS, true, values);
            ps.execute();
            rs = ps.getGeneratedKeys();
            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
//            base.setDaoStatus("1");
        } catch (SQLException e) {
//            base.setDaoStatus("0");
            System.err.println("Exception in SQL_SAVE_GENUS " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void edit(Base model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_UPDATE_GENUS = "update genus set name =?  where id = ? ";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {model.getName(), model.getId()};
            ps = prepareStatement(conn, SQL_UPDATE_GENUS, true, values);
            ps.executeUpdate();
//            rs = ps.getGeneratedKeys();
//            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
//            base.setDaoStatus("1");
        } catch (SQLException e) {
//            base.setDaoStatus("0");
            System.err.println("Exception in SQL_UPDATE_GENUS " + e.getMessage());
        } finally {
            close(conn, ps);
        }
    }

    @Override
    public void deleteGenus(Number id) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_DELETE_GENUS = "update genus set status ='d'  where id = ? ";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {id};
            ps = prepareStatement(conn, SQL_DELETE_GENUS, true, values);
            ps.executeUpdate();
//            rs = ps.getGeneratedKeys();
//            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
//            base.setDaoStatus("1");
        } catch (SQLException e) {
//            base.setDaoStatus("0");
            System.err.println("Exception in SQL_DELETE_GENUS " + e.getMessage());
        } finally {
            close(conn, ps);
        }
    }

}
