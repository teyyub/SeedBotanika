package com.botanik.controller;

import com.botanik.dao.impl.SeedDAOJDBC;
import com.botanik.dao.intf.SeedDAO;
import com.botanik.model.CollectionDataBase;
import com.botanik.model.DefaultExcel;
import com.botanik.model.DefaultSeed;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author teyyub , 9:12:51 PM
 */
public class TestExcel {

    private SeedDAO dao = new SeedDAOJDBC();
    private DefaultExcel excel;
    DefaultSeed seed;
    CollectionDataBase cd ;

    @Before
    public void setUp() {
        excel = new DefaultExcel("Data");
          seed = dao.defaultSeedById(24);
          cd = seed.getCollection();
    }

    @Test
    public void testExport() throws IOException {
        List<String> headerNames = new ArrayList();
        headerNames.add("Organisation/institute");
        headerNames.add("Project Name");
        headerNames.add("Wild or Cultivated*");
        headerNames.add("Collection Number*");
        headerNames.add("Accession Number");
        headerNames.add("Date Collected*");
        headerNames.add("Main Collector's Name & Institute*");
        headerNames.add("Family*");
        headerNames.add("Genus*");
        headerNames.add("Species*");
        headerNames.add("Species Author");
        headerNames.add("Rank");
        headerNames.add("Infra-Specific Species");
        headerNames.add("Infra-Specific Author");
        headerNames.add("Rank 2");
        headerNames.add("Infra-Specific Species 2");
        headerNames.add("Infra-Specific Author 2");
        headerNames.add("Identification Status*");
        headerNames.add("Identified From");
        headerNames.add("Identifier's Name & Institute");
        headerNames.add("Identification Date");
        headerNames.add("Plant Description*");
        headerNames.add("Plant Form*");
        headerNames.add("Plant Height (m)");
        headerNames.add("Uses");
        headerNames.add("Vernacular Name");
        headerNames.add("Assessment Information");        
        headerNames.add("Other Key Information");
        headerNames.add("Country*");
        headerNames.add("State/County/Province");
        headerNames.add("District/Municipality");
        headerNames.add("Description of Location");
        headerNames.add("Latitude*");
        headerNames.add("Longitude*");
        headerNames.add("Lat/Long Method");
        headerNames.add("Lat/Long Units");
        headerNames.add("Grid Reference");
        headerNames.add("GPS Datum");
        headerNames.add("Altitude (m)");
        headerNames.add("Altitude Method");
        headerNames.add("Habitat*");
        headerNames.add("Associated Species");
        headerNames.add("Factors Affecting Habitat");
        headerNames.add("Land Form");
        headerNames.add("Land Use");
        headerNames.add("Geology");
        headerNames.add("Slope (°)");
        headerNames.add("Aspect");
        headerNames.add("Soil Type");
        headerNames.add("Site Notes");
        headerNames.add("Number of Plants Sampled*");
        headerNames.add("Number of Plants Found*");
        headerNames.add("Area Sampled* (m2)");
        headerNames.add("Percentage of Plants Producing Seed* (%)");
        headerNames.add("Sampling Notes");
        headerNames.add("Herbarium Specimen*");
        headerNames.add("Herbarium Specimen Number");
        headerNames.add("Sent to Kew");
        headerNames.add("Location of Herbarium Specimens");
        
        
        
        
        
        
        
        
        
        
        
        excel.ready();
        excel.addRow(1);
        for (int i = 0; i < headerNames.size(); i++) {
            excel.addToCell(i, headerNames.get(i));            
        }
        
        excel.addRow(5);
        
         
        
        
//        excel.merge();
//        excel.createStyle();
        excel.write();
    }
    
    public void writeCollection(){
         
    }

}
