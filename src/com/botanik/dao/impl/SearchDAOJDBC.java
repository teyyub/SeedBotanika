package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.dao.intf.SearchDAO;
import com.botanik.model.Search;
import com.botanik.model.SearchModel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author teyyub , Feb 4, 2018 , 2:56:25 PM
 */
public class SearchDAOJDBC implements SearchDAO {

    @Override
    public List<Search> search(SearchModel model) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        LinkedList<Object> paramValues = new LinkedList<>();
        List<Search> modelList = new ArrayList();
        Search smodel;
        final String SQL_SEARCH_MODEL_DATA_BY_MODEL = "SELECT sd.id, pl.description,cd.col_number, cc.description,h.habitat, cd.col_date, \n" +
"              cd.col_name,her.number as herbarium, ld.country_id,cld.description as country, plf.description as family, gen.description as genus, spec.description as species, reg.description as region from ((((((((((seed sd left  join \n" +
"                              plant pl on sd.plant_id = pl.id ) \n" +
"                                left join collection_data cd on cd.id = sd.collection_id) \n" +
"                           left join habitat_data h on sd.habitat_id = h.id)  \n" +
"                             left join combos cc on h.habitat = cc.id) \n" +
"                           left join herbariumspecimen her on her.id = sd.herbarium_id)\n" +
"                          left join location_data ld on sd.location_id = ld.id) \n" +
"                        left join combos cld on cld.id = ld.country_id) \n" +
"                         left join combos plf on plf.id = pl.familyid )\n" +
"                         left join combos gen on pl.genusid = gen.id)\n" +
"                         left join combos spec on pl.speciesid = spec.id )\n" +
"                         left join combos reg on reg.id = ld.state_id \n" ;
 
  
        String where_part = " where   1=1 ";
        if (!model.getSeedId().equals(-1)) {
            where_part = where_part + " and sd.id = ? ";
            paramValues.add(model.getSeedId());

        }
        if (!model.getCollectionNumber().equals("")) {
            where_part = where_part + " and cd.col_number = ?";
            paramValues.add(model.getCollectionNumber());
        }

        if (!model.getAccesssionNumber().equals("")) {
            where_part = where_part + " and cd.access_number= ?";
            paramValues.add(model.getAccesssionNumber());
        }
        //banked number nedir
//        if (!model.getDescOfLocation().equals("")) {
//            where_part = where_part + " and sd.percentage like ?";
//            paramValues.add("%" + model.getDescOfLocation() + "%");
//        }
//
        if (!model.getFamily().equals("")) {
            where_part = where_part + " and plf.description like ?";
            paramValues.add("%" + model.getFamily() + "%");
        }

        if (!model.getGenus().equals("")) {
            where_part = where_part + " and lcase(gen.description) like ?";
            paramValues.add("%" + model.getGenus().toLowerCase() + "%");
        }

        if (!model.getSpecies().equals("")) {
            where_part = where_part + " and lcase(spec.description) like ?";
            paramValues.add("%" + model.getSpecies().toLowerCase() + "%");
        }
        if(model.getCollectedDate()!=null){
            where_part = where_part + " and cd.col_date = ?";           
            paramValues.add(DAOUtil.formatDate(model.getCollectedDate()));
        
        }

//        if(model.getColDate()!=null){
//            where_part = where_part + " and cd.col_date = ?";           
//            paramValues.add(model.getColDate());
//        
//        }    
            
        if (!model.getRegion().equals("")) {
            where_part = where_part + " and lcase(reg.description) like ?";
            paramValues.add("%" + model.getRegion().toLowerCase() + "%");
        }

        String result = SQL_SEARCH_MODEL_DATA_BY_MODEL + where_part;
        Object[] values = new Object[paramValues.size()];
        for (int i = 0; i < paramValues.size(); i++) {
            values[i] = paramValues.get(i);
        }

        try {

            conn = DAOUtil.accessDBConnection();

            ps = prepareStatement(conn, result, values);

            rs = ps.executeQuery();
            while (rs.next()) {
                smodel = new Search();
                smodel.setSeedId(rs.getInt(1));
                smodel.setPlant(rs.getString("description"));
                smodel.setCollectedDate(rs.getDate("col_date"));
                smodel.setHabitat(rs.getString("description"));
                smodel.setHerbarium(rs.getString("herbarium"));
                smodel.setCollection(rs.getString("col_name"));
                smodel.setRegion(rs.getString("country"));
                modelList.add(smodel);
            }

        } catch (SQLException e) {
            System.err.println("exception in SQL_SEARCH_MODEL_DATA_BY_MODEL " + e.toString());
//            daoUtils.getLogger().error(e);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(SeedDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, ps, rs);
        }
        return modelList;
    }

}
