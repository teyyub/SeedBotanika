package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;

import com.botanik.dao.intf.CollectionDataDAO;
import com.botanik.model.Base;
import com.botanik.model.CollectionDataBase;

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
public class CollectionDataDAOJDBC implements CollectionDataDAO {

    @Override
    public void saveOrganization(Base base) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_SAVE_FORM = "insert into organize_institute(name ,create_date,status) values(?,?,'a')";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CollectionDataDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {base.getName(), new Date()};
            ps = prepareStatement(conn, SQL_SAVE_FORM, values);
            ps.execute();
//            rs = ps.getGeneratedKeys();
//            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
            base.setDaoStatus("1");
        } catch (SQLException e) {
            base.setDaoStatus("0");
            System.err.println("exception in saveForm " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public List<Base> organizeInstitute() {
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
                Logger.getLogger(CollectionDataDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
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
    public void saveWildCultivited(Base base) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_SAVE_WILD = "insert into wild_cultivited(name ,create_date,status) values(?,?,'a')";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CollectionDataDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {base.getName(), new Date()};
            ps = prepareStatement(conn, SQL_SAVE_WILD, values);
            ps.execute();
//            rs = ps.getGeneratedKeys();
//            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
            base.setDaoStatus("1");
        } catch (SQLException e) {
            base.setDaoStatus("0");
            System.err.println("exception in saveWildCultivited " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public List<Base> wildCultivited() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from wild_cultivited";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CollectionDataDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
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
            System.err.println("exception in authorByName " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public void saveCollectorInstitute(Base base) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_SAVE_COLLECTOR = "insert into collector_institut(name ,create_date,status) values(?,?,'a')";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CollectionDataDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {base.getName(), new Date()};
            ps = prepareStatement(conn, SQL_SAVE_COLLECTOR, values);
            ps.execute();
//            rs = ps.getGeneratedKeys();
//            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
            base.setDaoStatus("1");
        } catch (SQLException e) {
            base.setDaoStatus("0");
            System.err.println("exception in saveCollectorInstitute " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public List<Base> collectorInstitute() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Base base = null;
        List<Base> bases = new ArrayList<>();
        final String SQL_ORG_INS = "select * from collector_institut";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CollectionDataDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
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
            System.err.println("exception in authorByName " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return bases;
    }

    @Override
    public void save(CollectionDataBase model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
//        String SQL_SAVE_COLL_DATA = "insert into collection_data(org_ins_id,name,wild_cult_id,coll_name_ins_id,acces_number) values(?,?,?,?,?)";
        String SQL_SAVE_COLL_DATA = "insert into collection_data(col_number,col_name,access_number,col_date,org_ins_id,wild_cult_id,col_name_ins_id,create_date,status) values(?,?,?,?,?,?,?,?,'a')";

        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CollectionDataDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {
                model.getCollectionNumber(),
                model.getProjectName(),
                model.getAccessionNumber(),                
                model.getDateCollection(),
                model.getOrganizeInstituteId(),
                model.getWildCultivitedId(),
                model.getCollectorInstituteId(),
                new Date()
                    
            };
            ps = prepareStatement(conn, SQL_SAVE_COLL_DATA, true, values);
            ps.execute();
            rs = ps.getGeneratedKeys();
            int gen_id = rs.next() ? rs.getInt(1) : 0;
            model.setId(gen_id);
            model.setDaoStatus("1");
        } catch (SQLException e) {
            model.setDaoStatus("0");
            System.err.println("exception in saveCollData " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public List<CollectionDataBase> collections() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        CollectionDataBase model = null;
        List<CollectionDataBase> list = new ArrayList<>();
        final String SQL_ALL_COLLECTIONS = " SELECT cd.id, cd.number ,cd.name, cd.acces_number , oi.id as org_id,  oi.name as organization, "
                + "wc.id as wild_id , wc.name as wild  ,ci.id as coll_id, ci.name as collector  from ((collection_data cd \n"
                + "left join  organize_institute oi  on cd.org_ins_id = oi.id)\n"
                + "left join wild_cultivited wc on wc.id = cd.wild_cult_id)\n"
                + "left join collector_institut ci on ci.id = cd.coll_name_ins_id";
        try {
            try {
                conn = DAOUtil.accessDBConnection();

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CollectionDataDAOJDBC.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {};
            ps = prepareStatement(conn, SQL_ALL_COLLECTIONS, values);

//            rs = ps.executeQuery();
//            while (rs.next()) {
//                model = new CollectionDataBase(
//                        rs.getInt("id"),
//                        rs.getString("number"),
//                        rs.getString("name"),
//                        rs.getString("acces_number"),
//                        new Date(),
//                        rs.getInt("org_id"),
//                        rs.getString("organization"),
//                        rs.getInt("wild_id"),
//                        rs.getString("wild"),
//                        rs.getInt("coll_id"),
//                        rs.getString("collector"));
//                list.add(model);
//            }
//            
        } catch (SQLException e) {
            System.err.println("exception in SQL_ALL_COLLECTIONS " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return list;
    }

    @Override
    public void delete(Number id) {
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_UPDATE_COLLECTION_DATA = "update collection_data set status = 'd' where id = ?";
        try {
            try {
                conn = DAOUtil.accessDBConnection();

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CollectionDataDAOJDBC.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {
                id
            };
            ps = prepareStatement(conn, SQL_UPDATE_COLLECTION_DATA, values);
            ps.execute();
//            rs = ps.getGeneratedKeys();
//            inst gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
//            base.setDaoStatus("1");
        } catch (SQLException e) {
//            base.setDaoStatus("0");
            System.err.println("Exception in delete collection_data " + e.getMessage());
        } finally {
            close(conn, ps);
        }
    }

    @Override
    public void update(CollectionDataBase model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;        
        String SQL_UPDATE_COLL_DATA = "update collection_data set col_number =? , org_ins_id =? , col_name = ?, wild_cult_id = ?, col_name_ins_id = ?,"
                + "access_number = ?, col_date =?  where id =? ";
        try {
            try {
                conn = DAOUtil.accessDBConnection();

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CollectionDataDAOJDBC.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {model.getCollectionNumber(), model.getOrganizeInstituteId(), model.getProjectName(),
                model.getWildCultivitedId(), model.getCollectorInstituteId(), model.getAccessionNumber(),
                model.getDateCollection(),
                model.getId()};
            ps = prepareStatement(conn, SQL_UPDATE_COLL_DATA, values);
            ps.execute();
            rs = ps.getGeneratedKeys();
//            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            base.setId(gen_id);
            model.setDaoStatus("1");
        } catch (SQLException e) {
            model.setDaoStatus("0");
            System.err.println("exception in SQL_UPDATE_COLL_DATA " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void save(Base model, int combos_id) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_SAVE_MODEL = "insert into combos(description,combo_id,create_date,status) values(?,?,?,'a')";
        try {
            try {
                conn = DAOUtil.accessDBConnection();

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(CollectionDataDAOJDBC.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {model.getName(), combos_id, new Date()};
            ps = prepareStatement(conn, SQL_SAVE_MODEL, true, values);
            ps.execute();
            rs = ps.getGeneratedKeys();
            int gen_id = rs.next() ? rs.getInt(1) : 0;
            model.setId(gen_id);
            model.setDaoStatus("1");
        } catch (SQLException e) {
            model.setDaoStatus("0");
            System.err.println("exception in save " + e.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

}
