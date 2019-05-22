package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.dao.intf.CombosDAO;
import com.botanik.model.Base;
import com.botanik.model.Combo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class CombosDAOJDBC implements CombosDAO {

    @Override
    public List<Base> families() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from organize_institute";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ORG_INS, false, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in organizeInstitute " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public List<Base> genuses() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from organize_institute";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ORG_INS, false, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in organizeInstitute " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public List<Base> speciesAuthors() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from organize_institute";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ORG_INS, false, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in organizeInstitute " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public List<Base> ranks() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from organize_institute";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ORG_INS, false, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in organizeInstitute " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public List<Base> infraSpecies() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from organize_institute";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ORG_INS, false, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in organizeInstitute " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public List<Base> infraAuthors() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from organize_institute";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ORG_INS, false, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in organizeInstitute " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public List<Base> identStatus() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from organize_institute";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ORG_INS, false, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in organizeInstitute " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public List<Base> identInstitutes() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from organize_institute";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ORG_INS, false, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in organizeInstitute " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public List<Base> plantDescriptions() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from organize_institute";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ORG_INS, false, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in organizeInstitute " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public List<Base> useses() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from organize_institute";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ORG_INS, false, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in organizeInstitute " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public List<Base> vernacularNames() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from organize_institute";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ORG_INS, false, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in organizeInstitute " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public List<Base> assesmentInformations() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from organize_institute";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ORG_INS, false, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in organizeInstitute " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public List<Base> otherKeyInfor() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from organize_institute";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ORG_INS, false, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in organizeInstitute " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public List<Base> plantForms() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from organize_institute";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ORG_INS, false, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in organizeInstitute " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public List<Base> identifiedFrom() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from organize_institute";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ORG_INS, false, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in organizeInstitute " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public List<Base> combosByIds(int num) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_GET_BASE = "select * from combos where combo_id =? and status ='a' order by 1 asc ";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {num};
            ps = prepareStatement(conn, SQL_GET_BASE, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in combosByIds " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public Number getId() {
        final String sql_max_id = "SELECT max(id)+1 FROM  seed";//" SELECT IIF(max(id)+1>0, max(id)+1, 1 ) AS max_id FROM  seed";
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Number gen_id = null;

        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, sql_max_id, false, values);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    gen_id = 1;
                } else {
                    gen_id = rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            System.err.println("exception in getId " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return gen_id;
    }

    @Override
    public List<Base> familyByName(String name) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_GET_BASE = "select * from combos where description like ?  and  combo_id =1 and status ='a' order by 1 asc ";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {name};
            ps = prepareStatement(conn, SQL_GET_BASE, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in familyByName " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public void deleteFamilyById(Number id) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        final String SQL_GET_BASE = "update combos  set status ='d' where id =? and  combo_id =1  ";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {id};
            ps = prepareStatement(conn, SQL_GET_BASE, values);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("exception in deleteFamilyById " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }

    }

    @Override
    public void updateFamily(Base model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        final String SQL_GET_BASE = "update combos  set description=? where id = ? and  combo_id =1 ";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {model.getId(),model.getName()};
            ps = prepareStatement(conn, SQL_GET_BASE, values);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("exception in updateFamily " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void deleteCombosById(Number id, int combos_id) {
         ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        final String SQL_DELETE_BASE = "update combos  set status ='d' where id =? and  combo_id = ?  ";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {id, combos_id};
            ps = prepareStatement(conn, SQL_DELETE_BASE, values);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("exception in deleteCombosById " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void updateCombosById(Base model, int combos_id) {
       ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        final String SQL_UPDATE_BASE = "update combos  set description=? where id = ? and  combo_id = ? ";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {model.getName(),model.getId(),combos_id};
            ps = prepareStatement(conn, SQL_UPDATE_BASE, values);

            ps.executeUpdate();
            model.setDaoStatus("1");
        } catch (SQLException e) {
            model.setDaoStatus("0");
            System.err.println("exception in updateCombosById " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public List<Base> loadByCombo(Combo model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base =null;
        List<Base> bases = new ArrayList<>();
        final String SQL_GET_BASE = "select * from combos where description like ?  and  combo_id =? and status ='a' order by 1 asc ";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CombosDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {"%"+model.getName()+"%", model.getComboId()};
            ps = prepareStatement(conn, SQL_GET_BASE, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                base = new Base(rs.getInt(1), rs.getString(2), rs.getString(3));
                bases.add(base);
            }

        } catch (SQLException e) {
            System.err.println("exception in loadByCombo " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

}
