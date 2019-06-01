package com.botanik.export.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.export.dao.intf.ExportDAO;
import com.botanik.export.model.CollectionExport;
import com.botanik.export.model.ExportListModel;
import com.botanik.export.model.ExportModel;
import com.botanik.export.model.HabitatExport;
import com.botanik.export.model.HerbariumExport;
import com.botanik.export.model.LocationExport;
import com.botanik.export.model.PlantExport;
import com.botanik.export.model.SamplingExport;
import com.botanik.logger.Logger;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author teyyub , 7:49:57 PM
 */
public class ExportDAOJDBC implements ExportDAO {
    
    private List<CollectionExport> getCollection() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Object[] values = {};
        List<CollectionExport> list = new ArrayList();
        String SQL_COLLECTION = "select  cl_c.description as organisation, cd.col_name ,   cl_wild.description as wildCultivated,cd.col_number, "
                + "cd.access_number,  cd.col_date, cl_inst.description as collectorName  "
                + "from (((seed sd  left join collection_data cd on cd.id = sd.collection_id) "
                + "left join combos cl_c on cl_c.id =  cd.org_ins_id ) "
                + "left join combos cl_wild on cl_wild.id = cd.wild_cult_id) "
                + "left join combos cl_inst on cl_inst.id =cd.col_name_ins_id";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("Exception connection to accessDBConnection()");
            }
            
            ps = prepareStatement(conn, SQL_COLLECTION, values);
            rs = ps.executeQuery();
            while (rs.next()) {
                CollectionExport ce = new CollectionExport(rs.getString("organisation"),
                        rs.getString("col_name"), rs.getString("wildCultivated"),
                        rs.getString("col_number"), rs.getString("access_number"),
                        rs.getDate("col_date"), rs.getString("collectorName"),
                        null);
//                rs.getString("otherCollName")
                list.add(ce);
                
            }
        } catch (SQLException ex) {
            System.out.println("Exception in getCollection" + ex);
        }
        
        return list;
    }
    
    private List<PlantExport> getPlant() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<PlantExport> list = new ArrayList();
        Object[] values = {};
        String SQL_PLANT = "select    pl_f.description as family,pl_g.description as genus,  pl_sa.description as speAuthor, "
                + "pl_rn.description as rank , pl_is.description as infraSpeciSpecies , \n"
                + " pl_ia.description as infraSpeciAthor , \n"
                + " pl_rn2.description as rank2,\n"
                + " pl_sa2.description as infraSpeciAthor2 ,\n"
                + "pl_is2.description as infraSpeciSpecies2,\n"
                + " pl_ide_sta.description as identStatus,\n"
                + "pl_ide_fr.description as idetFrom ,\n"
                + "pl_ide_ins.description as identName ,\n"
                + "pl.identificationDate as identDate, \n"
                + " pl.description as plantdesc ,\n"
                + "pl_from.description as plantForm,\n"
                + "pl.height as plantheight, \n"
                + " pl_uses.description as uses,\n"
                + "pl_ver.description as vername,\n"
                + "pl_ass.description  as assInf\n"
                + " from ((((((((((((((((((seed sd left join  plant pl on sd.plant_id = pl.id)\n"
                + "left join combos pl_f on pl_f.id =  pl.familyid)\n"
                + "left join combos pl_g on pl_g.id = pl.genusid )\n"
                + "left join combos pl_sa on pl_sa.id =  pl.speciesAuthorid)\n"
                + "left join combos pl_rn on pl_rn.id = pl.rankid)\n"
                + "left join  combos pl_is  on pl_is.id =pl.infraspeciesId)\n"
                + "left join combos pl_ia  on pl_ia.id =pl.infraAuthorId)\n"
                + "left join combos pl_rn2 on pl_rn2.id =pl.rank2Id )\n"
                + "left join combos pl_ids on pl_ids.id =  pl.identifationStatusId)\n"
                + "left join combos pl_sa2 on pl_sa2.id = pl.infraAuthor2id)\n"
                + "left join combos pl_is2 on pl_is2.id =pl.infraspecies2id)\n"
                + "left join combos pl_ide_sta on pl_ide_sta.id =pl.identifationStatusId)\n"
                + "left join combos pl_ide_fr on pl_ide_fr.id =pl.identifiedFromId)\n"
                + "left join combos pl_ide_ins on pl_ide_ins.id = pl.identifierInstituteId)\n"
                + "left join combos pl_from on pl_from.id = pl.plantFromId)\n"
                + "left join combos pl_uses on pl_uses.id = pl.usesid)\n"
                + "left join combos  pl_ver on pl_ver.id = pl.vernacularNameId)\n"
                + "left join combos pl_ass on pl_ass.id = pl.assesInforId)";
        
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("Exception connection to accessDBConnection()");
            }
            ps = prepareStatement(conn, SQL_PLANT, values);
            rs = ps.executeQuery();
            while (rs.next()) {
                PlantExport pe = new PlantExport(rs.getString("family"),
                        rs.getString("genus"),
                        null, //rs.getString("species")
                        rs.getString("speAuthor"),
                        rs.getString("rank"),
                        rs.getString("infraSpeciAthor"),
                        rs.getString("infraSpeciSpecies"),
                        rs.getString("rank2"),
                        rs.getString("infraSpeciAthor2"),
                        rs.getString("infraSpeciSpecies2"),
                        rs.getString("identStatus"),
                        rs.getString("idetFrom"),
                        rs.getString("identName"),
                        rs.getString("identDate"),
                        rs.getString("plantDesc"),
                        rs.getString("plantForm"),
                        rs.getString("plantHeight"),
                        rs.getString("uses"),
                        rs.getString("verName"),
                        rs.getString("assInf"),
                        null // rs.getString("otherInform")
                );
                list.add(pe);
            }
        } catch (SQLException ex) {
            System.out.println("Exception in getPlant " + ex);
        }
        
        return list;
    }
    
    private List<LocationExport> getLocation() {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        List<LocationExport> list = new ArrayList();
        Object[] values = {};
        
        String SQL_LOCATION = "select   c.description as country, s.description as state,ld.district, "
                + "ld.latitude, ld.lat_long_method , ld.grid, ld.altitude,ld.description , ld.longtitude, ld.lat_long_unit, ld.gps, ld.altitude_method\n"
                + " from  ((seed sd left join location_data ld on sd.location_id = ld.id )\n"
                + "left join combos c on c.id  = ld.country_id)\n"
                + "left join combos s on s.id = ld.state_id ";
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("Exception connection to accessDBConnection()");
            }
            ps = prepareStatement(conn, SQL_LOCATION, values);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                LocationExport le = new LocationExport(rs.getString("country"),
                        rs.getString("state"), rs.getString("district"), rs.getString("description"),
                        null, null, null, null, null, null, null, null, rs.getString("lat_long_method"),
                        null, //rs.getString("unit") 
                        rs.getString("grid"),
                        null, //rs.getString("datum") 
                        rs.getString("altitude"), rs.getString("altitude_Method"));
                list.add(le);
//                LocationExport le = new LocationExport(rs.getString("country"),
//                        rs.getString("state"), rs.getString("district"), rs.getString("description"),
//                        rs.getString("orientationN"), rs.getString("degreeN"), rs.getString("minutesN"), rs.getString("secondsN"), rs.getString("orientationE"),
//                        rs.getString("degreeE"), rs.getString("minutesE"), rs.getString("secondsE"), rs.getString("method"),
//                        rs.getString("unit"), rs.getString("gridReference"), rs.getString("datum"), rs.getString("altitude"), rs.getString("altMethod"));
            }
        } catch (SQLException ex) {
            System.out.println("Exception in getLocation " + ex);
        }
        
        return list;
    }
    
    private List<HabitatExport> getHabitat() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<HabitatExport> list = new ArrayList();
        Object[] values = {};
        String SQL_HABITAT = "select  h.description as habitat, hd.associated , f.description as factor, "
                + "l.description as landform , lu.description as landuse,hd.geology, s.description as slope,"
                + " a.description as aspect , st.description as soiltype,hd.site_Notes\n"
                + " from  (((((((seed sd left join habitat_data hd on sd.habitat_id = hd.id )\n"
                + "left join combos h on  h.id = hd.habitat)\n"
                + "left  join combos f on f.id =hd.factor)\n"
                + "left join combos l on l.id = hd.landform)\n"
                + "left join combos lu on lu.id = hd.landuse)\n"
                + "left join combos s on s.id = hd.slope)\n"
                + "left join combos a on a.id = hd.aspect)\n"
                + "left join combos st on st.id = hd.soil ";
        
        try {
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("Exception connection to accessDBConnection()");
            }
            ps = prepareStatement(conn, SQL_HABITAT, values);
            rs = ps.executeQuery();
            while (rs.next()) {
                HabitatExport he = new HabitatExport(rs.getString("habitat"),
                        rs.getString("associated"), rs.getString("factor"), rs.getString("landForm"), rs.getString("landUse"),
                        rs.getString("geology"), rs.getString("slope"), rs.getString("aspect"), rs.getString("soilType"), rs.getString("site_Notes"));
                list.add(he);
            }
        } catch (SQLException ex) {
            System.out.println("exception in getHabitat " + ex);
        }
        
        return list;
    }
    
    private List<SamplingExport> getSampling() {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<SamplingExport> list = new ArrayList();
        
        Object[] values = {};
        
        String SQL_SAMPLE = "select samd.numbersample, samd.numberfood, samd.area, samd.percentage, samd.note\n"
                + " from  seed sd left join samplingdata samd on sd.sampling_id = samd.id ";
        
        try {
            
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("Exception connection to accessDBConnection()");
            }
            ps = prepareStatement(conn, SQL_SAMPLE, values);
            rs = ps.executeQuery();
            while (rs.next()) {
                SamplingExport se = new SamplingExport(rs.getString("numbersample"), rs.getString("numberfood"), rs.getString("area"),
                        rs.getString("percentage"), rs.getString("note"));
                list.add(se);
            }
        } catch (SQLException ex) {
            System.out.println("Exception in getSampling " + ex);
        }
        
        return list;
    }
    
    private List<HerbariumExport> getHerbarium() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        List<HerbariumExport> list = new ArrayList();
        Object[] values = {};
        String SQL_HERBARIUM = " select  hs.number, hs_loc.description as location , iif(hs.isSpecimen,'Yes','No') as specimen, iif(hs.isKew,'Yes', 'No') as sentToKew\n"
                + " from  (seed sd left join herbariumspecimen hs on sd.herbarium_id = hs.id )\n"
                + "left join combos hs_loc on hs_loc.id  = hs.location";
        try {
            
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("Exception connection to accessDBConnection()");
            }
            ps = prepareStatement(conn, SQL_HERBARIUM, values);
            rs = ps.executeQuery();
            while (rs.next()) {
                HerbariumExport he = new HerbariumExport(rs.getString("specimen"), rs.getString("number"), rs.getString("sentToKew"),
                        rs.getString("location"));
                list.add(he);
            }
        } catch (SQLException ex) {
            System.out.println("exception in getHerbarium " + ex);
        }
        
        return list;
    }
    
    @Override
    public List<ExportModel> getExportModel() {
        Logger.save("called getExportModel in dao");
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<ExportModel> model = new ArrayList();
        Object[] values = {};
        String SQL_TEXT = " select  *  from  (((((select   sd.id, cl_c.description as organisation, cd.col_name ,   cl_wild.description as wildCultivated,cd.col_number, \n"
                + "  cd.access_number,  cd.col_date, cl_inst.description as collectorName  \n"
                + "  from (((seed sd  left join collection_data cd on cd.id = sd.collection_id) \n"
                + "  left join combos cl_c on cl_c.id =  cd.org_ins_id ) \n"
                + "  left join combos cl_wild on cl_wild.id = cd.wild_cult_id) \n"
                + "  left join combos cl_inst on cl_inst.id =cd.col_name_ins_id ) query1\n"
                + "  left join  ( select  sd.id,  pl_f.description as family,pl_g.description as genus,  pl_sa.description as speAuthor, \n"
                + "  pl_rn.description as rank , pl_is.description as infraSpeciSpecies , \n"
                + "  pl_ia.description as infraSpeciAthor , \n"
                + "  pl_rn2.description as rank2,\n"
                + "  pl_sa2.description as infraSpeciAthor2 ,\n"
                + "  pl_is2.description as infraSpeciSpecies2,\n"
                + "  pl_ide_sta.description as identStatus,\n"
                + "  pl_ide_fr.description as idetFrom ,\n"
                + "  pl_ide_ins.description as identName ,\n"
                + "  pl.identificationDate as identDate, \n"
                + "  pl.description as plantdesc ,\n"
                + "  pl_from.description as plantForm,\n"
                + "  pl.height as plantheight, \n"
                + "  pl_uses.description as uses,\n"
                + "  pl_ver.description as vername,\n"
                + "  pl_ass.description  as assInf\n"
                + "  from (((((((((((((((((seed sd left join  plant pl on sd.plant_id = pl.id)\n"
                + "  left join combos pl_f on pl_f.id =  pl.familyid)\n"
                + "  left join combos pl_g on pl_g.id = pl.genusid )\n"
                + "  left join combos pl_sa on pl_sa.id =  pl.speciesAuthorid)\n"
                + "  left join combos pl_rn on pl_rn.id = pl.rankid)\n"
                + "  left join  combos pl_is  on pl_is.id =pl.infraspeciesId)\n"
                + "  left join combos pl_ia  on pl_ia.id =pl.infraAuthorId)\n"
                + "  left join combos pl_rn2 on pl_rn2.id =pl.rank2Id )\n"
                + "  left join combos pl_ids on pl_ids.id =  pl.identifationStatusId)\n"
                + "  left join combos pl_sa2 on pl_sa2.id = pl.infraAuthor2id)\n"
                + "  left join combos pl_is2 on pl_is2.id =pl.infraspecies2id)\n"
                + "  left join combos pl_ide_sta on pl_ide_sta.id =pl.identifationStatusId)\n"
                + "  left join combos pl_ide_fr on pl_ide_fr.id =pl.identifiedFromId)\n"
                + "  left join combos pl_ide_ins on pl_ide_ins.id = pl.identifierInstituteId)\n"
                + "  left join combos pl_from on pl_from.id = pl.plantFromId)\n"
                + "  left join combos pl_uses on pl_uses.id = pl.usesid)\n"
                + "  left join combos  pl_ver on pl_ver.id = pl.vernacularNameId)\n"
                + "  left join combos pl_ass on pl_ass.id = pl.assesInforId ) query2 on query1.id = query2.id)\n"
                + "  left join (select  sd.id,  c.description as country, s.description as state,ld.district, \n"
                + "  ld.latitude, ld.lat_long_method , ld.grid, ld.altitude,ld.description , ld.longtitude, ld.lat_long_unit, ld.gps, ld.altitude_method\n"
                + "  from  ((seed sd left join location_data ld on sd.location_id = ld.id )\n"
                + "  left join combos c on c.id  = ld.country_id)\n"
                + "  left join combos s on s.id = ld.state_id ) query3 \n"
                + "  on query1.id = query3.id )\n"
                + "  left join (select  sd.id,  h.description as habitat, hd.associated , f.description as factor, \n"
                + "  l.description as landform , lu.description as landuse,hd.geology, s.description as slope,\n"
                + "  a.description as aspect , st.description as soiltype,hd.site_Notes\n"
                + "  from  (((((((seed sd left join habitat_data hd on sd.habitat_id = hd.id )\n"
                + "  left join combos h on  h.id = hd.habitat)\n"
                + "  left  join combos f on f.id =hd.factor)\n"
                + "  left join combos l on l.id = hd.landform)\n"
                + "  left join combos lu on lu.id = hd.landuse)\n"
                + "  left join combos s on s.id = hd.slope)\n"
                + "  left join combos a on a.id = hd.aspect)\n"
                + "  left join combos st on st.id = hd.soil  ) query4 on query1.id = query4.id )\n"
                + "  left join (select  sd.id, samd.numbersample, samd.numberfood, samd.area, samd.percentage, samd.note \n"
                + "  from  seed sd left join samplingdata samd on sd.sampling_id = samd.id) query5 on query1.id = query5.id)\n"
                + "  left join (select  sd.id , hs.number, hs_loc.description as location , iif(hs.isSpecimen,'Yes','No') as specimen, iif(hs.isKew,'Yes', 'No') as sentToKew \n"
                + "  from  (seed sd left join herbariumspecimen hs on sd.herbarium_id = hs.id ) \n"
                + "  left join combos hs_loc on hs_loc.id  = hs.location) query6 on query1.id = query6.id";
        
        try {
            
            try {
                conn = DAOUtil.accessDBConnection();
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("Exception connection to accessDBConnection()");
                Logger.save("Exception connection to accessDBConnection()");
            }
            ps = prepareStatement(conn, SQL_TEXT, values);
            rs = ps.executeQuery();
            while (rs.next()) {
                CollectionExport ce = new CollectionExport(rs.getString("organisation"),
                        rs.getString("col_name"), rs.getString("wildCultivated"),
                        rs.getString("col_number"), rs.getString("access_number"),
                        rs.getDate("col_date"), rs.getString("collectorName"),
                        null);
                PlantExport pe = new PlantExport(rs.getString("family"),
                        rs.getString("genus"),
                        null, //rs.getString("species")
                        rs.getString("speAuthor"),
                        rs.getString("rank"),
                        rs.getString("infraSpeciAthor"),
                        rs.getString("infraSpeciSpecies"),
                        rs.getString("rank2"),
                        rs.getString("infraSpeciAthor2"),
                        rs.getString("infraSpeciSpecies2"),
                        rs.getString("identStatus"),
                        rs.getString("idetFrom"),
                        rs.getString("identName"),
                        rs.getString("identDate"),
                        rs.getString("plantDesc"),
                        rs.getString("plantForm"),
                        rs.getString("plantHeight"),
                        rs.getString("uses"),
                        rs.getString("verName"),
                        rs.getString("assInf"),
                        null // rs.getString("otherInform")
                );
                LocationExport le = new LocationExport(rs.getString("country"),
                        rs.getString("state"), rs.getString("district"), rs.getString("description"),
                        null, null, null, null, null, null, null, null, rs.getString("lat_long_method"),
                        null, //rs.getString("unit") 
                        rs.getString("grid"),
                        null, //rs.getString("datum") 
                        rs.getString("altitude"), rs.getString("altitude_Method"));
                HabitatExport he = new HabitatExport(rs.getString("habitat"),
                        rs.getString("associated"), rs.getString("factor"), rs.getString("landForm"), rs.getString("landUse"),
                        rs.getString("geology"), rs.getString("slope"), rs.getString("aspect"), rs.getString("soilType"), rs.getString("site_Notes"));
                
                SamplingExport se = new SamplingExport(rs.getString("numbersample"), rs.getString("numberfood"), rs.getString("area"),
                        rs.getString("percentage"), rs.getString("note"));
                
                HerbariumExport hre = new HerbariumExport(rs.getString("specimen"), rs.getString("number"), rs.getString("sentToKew"),
                        rs.getString("location"));
                
                ExportModel em = new ExportModel(ce, pe, le, he, se, hre);
                model.add(em);
            }
        } catch (SQLException ex) {
            System.out.println("exception in getExportModel " + ex);
            Logger.save("exception in getExportModel " + ex.getMessage());
        }
        
        return model;
    }
    
    @Override
    public ExportListModel getExportListModel() {
        ExportListModel exportModel = new ExportListModel(getCollection(), getPlant(), getLocation(), getHabitat(), getSampling(), getHerbarium());
        return exportModel;
    }
    
}
