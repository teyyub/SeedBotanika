package com.botanik.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author teyyub Mar 13, 2016 12:55:10 PM
 */
public final class DAOUtil {

    public static Connection accessDBConnection() throws SQLException, IOException, ClassNotFoundException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        return DriverManager.getConnection("jdbc:ucanaccess://seed.accdb");
//        return DriverManager.getConnection("jdbc:ucanaccess://seed.accdb");
//        return DriverManager.getConnection("jdbc:ucanaccess://botanik_yeni.accdb");
    }

    public static PreparedStatement prepareStatement(Connection connection, String sql, boolean returnGeneratedKeys, Object... values)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql,
                returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
        setValues(statement, values);
        return statement;
    }

    public static PreparedStatement prepareStatement(Connection connection, String sql, Object... values)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        setValues(statement, values);
        return statement;
    }

    public static PreparedStatement prepareStatement(Connection connection, String sql, LinkedList<Object> values) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
//        setValues(statement, values);

        int length = values.size();
        for (int i = 0; i < length; i++) {
            statement.setObject(i, values.get(i));
        }

        return statement;
    }

    public static CallableStatement callableStatement(Connection connection, String sql, boolean returnCursor, Object... values)
            throws SQLException {
        CallableStatement statement = connection.prepareCall(sql);
        if (returnCursor) {
            statement.registerOutParameter(1, Types.INTEGER);
            setValues(returnCursor, statement, values);
        } else {
            setValues(statement, values);
        }
        return statement;
    }

    public static CallableStatement callableStatement(Connection connection, String sql, boolean returnCursor, int type, Object... values)
            throws SQLException {
        CallableStatement statement = connection.prepareCall(sql);
        if (returnCursor) {
            statement.registerOutParameter(1, type);
            setValues(returnCursor, statement, values);
        } else {
            setValues(statement, values);
        }
        return statement;
    }

    public static void setValues(CallableStatement statement, Object... values)
            throws SQLException {
        int length = values.length;
        for (int i = 0; i < length; i++) {
            statement.setObject(i + 1, values[i]);
        }
    }

    public static void setValues(boolean returnValue, CallableStatement statement, Object... values)
            throws SQLException {
        for (int i = 0; i < values.length; i++) {
            statement.setObject(i + 2, values[i]);
        }
    }

    public static void setValues(PreparedStatement statement, Object... values)
            throws SQLException {
        for (int i = 0; i < values.length; i++) {
            statement.setObject(i + 1, values[i]);
        }
    }

    public static Timestamp toSqlTimestamp(java.util.Date date) {
        return (date != null) ? new Timestamp(date.getTime()) : null;
    }

    public static Date toSqlDate(java.util.Date date) {
        return (date != null) ? new Date(date.getTime()) : null;
    }

    public static  Date  formatDate(java.util.Date date)  {
        
//        Date date = Date.valueOf(localdate);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        String dateString = format.format(date);
        java.util.Date dateReturn = null;
        try {
            dateReturn = ( java.util.Date) format.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(DAOUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toSqlDate(dateReturn);
//        return new Date(date.getTime());
    }

    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
//                Logger.getLogger(this.getClass().getName()).info(ex);
            }
        }
    }

    public static void close(CallableStatement cst) {
        if (cst != null) {
            try {
                cst.close();
            } catch (SQLException ex) {
//                Logger.getLogger(this.getClass().getName()).info(ex);
            }
        }
    }

    public static void close(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
//                Logger.getLogger(this.getClass().getName()).info(ex);
            }
        }
    }

    public static void close(PreparedStatement pst) {
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException ex) {
//                Logger.getLogger(this.getClass().getName()).info(ex);
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
//                Logger.getLogger(this.getClass().getName()).info(ex);
            }
        }
    }

    public static void close(Connection cn, CallableStatement cs, PreparedStatement ps) {
        close(cn);
        close(cs);
        close(ps);
    }

    public static void close(Connection cn, CallableStatement cs, ResultSet rs) {
        close(cn);
        close(cs);
        close(rs);
    }

    public static void close(Connection cn, Statement s, ResultSet rs) {
        close(cn);
        close(s);
        close(rs);
    }

    public static void close(Connection cn, PreparedStatement ps, ResultSet rs) {
        close(cn);
        close(ps);
        close(rs);
    }

    public static void close(Connection cn, CallableStatement cs) {
        close(cn);
        close(cs);
    }

    public static void close(Connection cn, Statement s) {
        close(cn);
        close(s);
    }

    public static void close(Connection cn, PreparedStatement ps) {
        close(cn);
        close(ps);
    }
}
