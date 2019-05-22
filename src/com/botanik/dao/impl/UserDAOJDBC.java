package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.dao.intf.UserDAO;
import com.botanik.model.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author teyyub , Feb 13, 2018 , 4:55:22 PM
 */
public class UserDAOJDBC implements UserDAO {

    @Override
    public User user(String username, String password) {

        final String SQL_CHESK_USER = "select * from user where username = :p0 and password= :p1 and status = 'a'";
        User user = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(false);
            Object[] values = {username, password};
            ps = prepareStatement(conn, SQL_CHESK_USER, values);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getInt("user_type"));
            }

        } catch (SQLException e) {
            System.out.println("exception in user " + e.getMessage());
//            DAOUtil.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }

        return user;

    }

    @Override
    public boolean checkUser(String username ) {
        final String SQL_CHESK_USER = " select * from user where username = ? and status='a' ";
        boolean found = false;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(false);
            Object[] values = {username};
            ps = prepareStatement(conn, SQL_CHESK_USER, values);
            rs = ps.executeQuery();
            if (rs.next()) {
                found = !found;
            }

        } catch (SQLException e) {
            System.out.println("exception in checkUser " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }

        return found;
    }

    @Override
    public void createUser(User user) {
        final String SQL_CREATE_USER = "insert into user(username, password , status, create_date ) values(?,?,?,?) ";

        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(false);
            Object[] values = {user.getUsername(), user.getPassword(), "a", new Date()};
            ps = prepareStatement(conn, SQL_CREATE_USER, values);
            ps.execute();
            user.setDaoStatus("1");

        } catch (SQLException e) {
            System.out.println("exception in user " + e.getMessage());
            user.setDaoStatus("0");
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public List<User> loadUsers() {
        final String SQL_ALL_USERS = " select id , username, status from user where status='a' ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        List<User> users = new ArrayList<>();
        User user;
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }

            Object[] values = {};
            ps = prepareStatement(conn, SQL_ALL_USERS, values);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("status"));
                users.add(user);
            }
            System.out.println("users.size " + users.size());
        } catch (SQLException e) {
            System.out.println("exception in loadUser() " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }

        return users;
    }

    @Override
    public void deleteUser(Number userId) {
        final String SQL_DELETE_USER = "update  user set status ='d'  where id = ? ";

        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(false);
            Object[] values = {userId};
            ps = prepareStatement(conn, SQL_DELETE_USER, values);
            ps.execute();

        } catch (SQLException e) {
            System.out.println("exception in user " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public Collection<User> users(String userName) {
        final String SQL_GET_USER = " select * from user where username = ? ";
        boolean found = false;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] values = {userName};
            ps = prepareStatement(conn, SQL_GET_USER, values);
            rs = ps.executeQuery();
            if (!rs.next()) {
                return new ArrayList<>(0);
            }
             
                    
        } catch (SQLException e) {
            System.out.println("exception in user " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
        return new ArrayList<>();
    }

    @Override
    public void resetPassword(Number id, String password) {
       final String SQL_RESET_PASSWORD = "update  user set password = ?  where id = ? ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(false);
            Object[] values = { password, id };
            ps = prepareStatement(conn, SQL_RESET_PASSWORD, values);
            ps.execute();

        } catch (SQLException e) {
            System.out.println("exception in user " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }
    }

}
