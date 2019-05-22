package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.model.DefaultImage;
import com.project.file.intf.FileOperation;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author teyyub , Mar 25, 2018 , 9:35:46 AM
 */
public class FileOperationDAOJDBC implements FileOperation {

    @Override
    public void saveFile(DefaultImage image) {
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("Exception connection to accessDBConnection()");
            }
            
            Object[] values = {image.getPlantId(), image.getLocal_imge_url(), image.getImageName(), new Date(), "a"};

            String SQL_SAVE_IMAGE = "insert into image(plant_id ,image_url , image_name, create_date, status)"
                    + " values(?,?,?,?,?) ";

            ps = prepareStatement(conn, SQL_SAVE_IMAGE, values);
            ps.execute();
            image.setDaoStatus("1");

        } catch (SQLException e) {
            System.err.println("Exception in FileOperationDAOJDBC " +e.getMessage());
            image.setDaoStatus("0");
        } finally {
            close(conn, ps);
        }
    }

    @Override
    public void updateFile(DefaultImage image) {
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("Exception connection to accessDBConnection()");
            }
            
            Object[] values1={image.getImageId()};
            String SQL_UPDATE_IMAGE = "update image set status = 'd'  where id = ?";
            ps = prepareStatement(conn, SQL_UPDATE_IMAGE, values1);
            ps.execute();
            
            
            Object[] values = {image.getPlantId(), image.getLocal_imge_url(), image.getImageName(), new Date(), "a"};
                
            String SQL_SAVE_IMAGE = "insert into image(plant_id ,image_url , image_name, create_date, status)"
                    + " values(?,?,?,?,?) ";

            ps = prepareStatement(conn, SQL_SAVE_IMAGE, values);
            ps.execute();
            image.setDaoStatus("1");

        } catch (SQLException e) {
            System.err.println("Exception in FileOperationDAOJDBC " +e.getMessage());
            image.setDaoStatus("0");
        } finally {
            close(conn, ps);
        }
    }

}
