package com.botanik.export.controller;

import com.botanik.export.dao.impl.ExportDAOJDBC;
import com.botanik.export.dao.intf.ExportDAO;
import com.botanik.export.model.CollectionExport;
import com.botanik.export.model.ExportModel;
import com.botanik.export.model.HabitatExport;
import com.botanik.export.model.HerbariumExport;
import com.botanik.export.model.LocationExport;
import com.botanik.export.model.PlantExport;
import com.botanik.export.model.SamplingExport;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.botanik.logger.Logger;

/**
 *
 * @author teyyub , 8:20:49 PM
 */
public class ExportController {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    private long gen_id;
    private Map<String, String> headers = new HashMap();
    private Map<Integer, String> headers1 = new HashMap();

    private ExportDAO dao = new ExportDAOJDBC();
    Map<Integer, Object[]> data = new TreeMap<>();
    Map<String, Object[]> data1 = new TreeMap<>();

    public ExportController() {
        gen_id = genId();
    }

    private void loadData() {
        List<ExportModel> list = dao.getExportModel();

        for (int i = 0; i < list.size(); i++) {
            CollectionExport ce = list.get(i).getCollectionExport();
            PlantExport pe = list.get(i).getPlantExport();
            LocationExport le = list.get(i).getLocationExport();
            HabitatExport he = list.get(i).getHabitatExport();
            SamplingExport se = list.get(i).getSamplingExport();
            HerbariumExport her = list.get(i).getHerbariumExport();

            data1.put(String.valueOf(i), new Object[]{ce.getOrganisation(), ce.getProjectName(), ce.getWildCultivated(), ce.getColNumber(), ce.getAccNumber(), ce.getColDate(), ce.getCollectorName(), ce.getOtherCollName(),
                pe.getFamily(), pe.getGenus(), pe.getSpecies(), pe.getSpecies(), pe.getSpeAuthor(), pe.getRank(), pe.getInfraSpeciSpecies(), pe.getInfraSpeciAthor(), pe.getRank2(),
                pe.getInfraSpeciSpecies2(), pe.getInfraSpeciAthor2(), pe.getIdentStatus(), pe.getIdetFrom(), pe.getIdentName(), pe.getIdentDate(), pe.getPlantDesc(), pe.getPlantForm(),
                pe.getPlantHeight(), pe.getUses(), pe.getVerName(), pe.getOtherInform(),
                le.getCountry(), le.getState(), le.getDistrict(), le.getDescription(), le.getOrientationN(), le.getDegreeN(), le.getMinutesN(), le.getSecondsN(),
                le.getLat_long_method(), le.getUnit(), le.getGridReference(), le.getDatum(), le.getAltitude(), le.getAltMethod(),
                he.getHabitat(), he.getAssSpecies(), he.getFactor(), he.getLandForm(), he.getLandUse(), he.getGeology(), he.getSlope(), he.getAspect(), he.getSoilType(), he.getSiteNotes(),
                se.getSampled(), se.getFound(), se.getArea(), se.getPercentage(), se.getNotes(),
                her.getSpecimen(), her.getNumber(), her.getSentToKew(), her.getLocation()
            });
        }

    }

    private void prepare() {
//        final String dir = System.getProperty("user.dir");
//        Logger logger = Logger.getLogger("Mylog");
        try {
//            FileHandler fh = new FileHandler(dir + "/slog.txt");           
//            logger.addHandler(fh);

            Logger.save("preparing method");
            loadData();
            headerMap();
            subHeaderMap();
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Data");
//
//            //collection data
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$A$2:$H$2"));
//            CellStyle style = workbook.createCellStyle();
//            Row row = createRow((short) 1);
//            Cell cell = createCell(row, (short) 0);
//            cell.setCellValue(headers.get("bir"));
//            style.setAlignment(HorizontalAlignment.CENTER);
//            style.setVerticalAlignment(VerticalAlignment.CENTER);
//            XSSFColor color = new XSSFColor(new java.awt.Color(228, 109, 10));
//            ((XSSFCellStyle) style).setFillForegroundColor(color);
//            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//            row.getCell(0).setCellStyle(style);
//            cell.setCellStyle(style);
//
////        plant and identification
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$I$2:$AC$2"));
//            createCell(row, (short) 8).setCellValue(headers.get("iki"));
//            CellStyle style1 = workbook.createCellStyle();
//            style1.setAlignment(HorizontalAlignment.CENTER);
//            style1.setVerticalAlignment(VerticalAlignment.CENTER);
//            XSSFColor color1 = new XSSFColor(new java.awt.Color(204, 153, 0));
//            ((XSSFCellStyle) style1).setFillForegroundColor(color1);
//            style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//            row.getCell(8).setCellStyle(style1);
//
//            //       location data
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$AD$2:$AU$2"));
//            createCell(row, (short) 29).setCellValue(headers.get("uc"));
//
//            CellStyle style2 = workbook.createCellStyle();
//            style2.setAlignment(HorizontalAlignment.CENTER);
//            style2.setVerticalAlignment(VerticalAlignment.CENTER);
//            XSSFColor color2 = new XSSFColor(new java.awt.Color(83, 142, 213));
//            ((XSSFCellStyle) style2).setFillForegroundColor(color2);
//            style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//            row.getCell(29).setCellStyle(style2);
//
//            //habitat
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$AV$2:$BE$2"));
//            createCell(row, (short) 47).setCellValue(headers.get("dord"));;//row.createCell(46);
//
//            CellStyle style3 = workbook.createCellStyle();
//            style3.setAlignment(HorizontalAlignment.CENTER);
//            style3.setVerticalAlignment(VerticalAlignment.CENTER);
//            XSSFColor color3 = new XSSFColor(new java.awt.Color(79, 98, 40));
//            ((XSSFCellStyle) style3).setFillForegroundColor(color3);
//            style3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//            row.getCell(47).setCellStyle(style3);
//
//            //        //sapling   
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$BF$2:$BJ$2"));
//            createCell(row, (short) 57).setCellValue(headers.get("bes"));;//row.createCell(52);        
//            CellStyle style4 = workbook.createCellStyle();
//            style3.setAlignment(HorizontalAlignment.CENTER);
//            style3.setVerticalAlignment(VerticalAlignment.CENTER);
//            XSSFColor color4 = new XSSFColor(new java.awt.Color(67, 33, 129));
//            ((XSSFCellStyle) style4).setFillForegroundColor(color4);
//            style4.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//            row.getCell(57).setCellStyle(style4);
//
//            //        herbarium
//            sheet.addMergedRegion(CellRangeAddress.valueOf("$BK$2:$BN$2"));
//            createCell(row, (short) 62).setCellValue(headers.get("alti"));;//row.createCell(56);        
//            CellStyle style5 = workbook.createCellStyle();
//            style5.setAlignment(HorizontalAlignment.CENTER);
//            style5.setVerticalAlignment(VerticalAlignment.CENTER);
//            XSSFColor color5 = new XSSFColor(new java.awt.Color(79, 98, 40));
//            ((XSSFCellStyle) style5).setFillForegroundColor(color5);
//            style5.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//            row.getCell(62).setCellStyle(style5);
//
////        sheet.addMergedRegion(CellRangeAddress.valueOf("$BN$2:$BV$2"));
////        createCell(row, (short) 67).setCellValue(headers.get("yeddi"));;//row.createCell(65);              
////        CellStyle style6 = workbook.createCellStyle();
////        style6.setAlignment(HorizontalAlignment.CENTER);
////        style6.setVerticalAlignment(VerticalAlignment.CENTER);
////        XSSFColor color6 = new XSSFColor(new java.awt.Color(79, 98, 40));
////        ((XSSFCellStyle) style6).setFillForegroundColor(color3);
////        style6.setFillPattern(FillPatternType.SOLID_FOREGROUND);
////        row.getCell(67).setCellStyle(style6);
//            Row row2 = createRow((short) 2);
//            Cell cell1 = createCell(row2, (short) 0);
//            CellStyle cs = workbook.createCellStyle();
//            cs.setWrapText(true);
//            Font font = workbook.createFont();
//            font.setFontHeightInPoints((short) 10);
//            cs.setFont(font);
//
//            for (int j = 0; j < headers1.size(); j++) {
////            CellStyle cs = workbook.createCellStyle();
//
//                row2.createCell(j).setCellValue(headers1.get(j));
////            cs.setAlignment(HorizontalAlignment.CENTER);
//                cs.setVerticalAlignment(VerticalAlignment.TOP);
//                row2.getCell(j).setCellStyle(cs);
//            }

//        row.setHeightInPoints((2 * sheet.getDefaultRowHeightInPoints()));
            //adjust column width to fit the content
//        sheet.autoSizeColumn(2);
//        sheet.autoSizeColumn(1);
//        CreationHelper factory = workbook.getCreationHelper();
//        Drawing drawing = sheet.createDrawingPatriarch();
//        ClientAnchor anchor = factory.createClientAnchor();
//        anchor.setCol1(cell.getColumnIndex());
//        anchor.setCol2(cell.getColumnIndex() + 1);
//        anchor.setRow1(row.getRowNum());
//        anchor.setRow2(row.getRowNum() + 1);
//        Comment comment = drawing.createCellComment(anchor);
//        RichTextString str = factory.createRichTextString("Hello, World!");
//        comment.setString(str);
//        comment.setAuthor("Apache POI");
//
//        // Assign the comment to the cell
//        cell.setCellComment(comment);
        } catch (SecurityException ex) {
//            logger.log( ex.getMessage());
        }
    }

    private void makeRowHeight() {
        sheet.getRow(2).setHeightInPoints(40);
//        sheet.getRow(3).setHeightInPoints(20);
    }

    private void mergeCell() {
        for (int i = 0; i < 70; i++) {
            if (i == 2) {
                continue;
            }
            sheet.addMergedRegion(new CellRangeAddress(
                    2, //first row (0-based)
                    3, //last row  (0-based)
                    i, //first column (0-based)
                    i //last column  (0-based)
            ));
        }
    }

    private void writeToExcel() {
        prepare();
        mergeCell();
        Set<String> keyset = data1.keySet();

        int rownum = 4;
        for (String key : keyset) {
            Row row1 = sheet.createRow(rownum++);
            Object[] objArr = data1.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {

                Cell cell11 = row1.createCell(cellnum++);
                if (obj instanceof String) {
                    cell11.setCellValue((String) obj);

                } else if (obj instanceof Integer) {
                    cell11.setCellValue((Integer) obj);
                }
            }
        }
        makeRowHeight();
    }

    public void export() {
        try {
            writeToExcel();
            try (FileOutputStream fileOut = new FileOutputStream(fileName())) {
                workbook.write(fileOut);
                fileOut.close();
                workbook.close();
            }
            try {
                Logger.save(fileName());
                Desktop.getDesktop().open(new File(fileName()));
            } catch (IOException e) {
                Logger.save(e.getMessage());
            }

        } catch (IOException | SecurityException ex) {
            Logger.save(ex.getMessage());
        }
    }

    private void write() throws IOException, FileNotFoundException {

    }

//    private String fileName() {
//        return "c:/test/test1234.xlsx";
//    }
    private long genId() {
        return System.currentTimeMillis();
    }

//    private String fileName() {
//        return "c:/test/" + genId() + ".xlsx";
//    }
    private String fileName() throws IOException {
        final String dir = System.getProperty("user.dir");
        String cur_dir = dir + "/" + gen_id + ".xls";
        System.out.println("cur_dir " + cur_dir);
        Logger.save(cur_dir);
        return cur_dir;
    }

    private Row createRow(short index) {
        return sheet.createRow(index);
    }

    private Cell createCell(Row row, short index) {
        return row.createCell(index);
    }

    public void headerMap() {
        headers.put("bir", "COLLECTION DATA");
        headers.put("iki", "PLANT NAME & IDENTIFICATION DATA");
        headers.put("uc", "LOCATION DATA for WILD COLLECTIONS");
        headers.put("dord", "HABITAT DATA for WILD COLLECTIONS");
        headers.put("bes", "SAMPLING DATA for WILD COLLECTIONS");
        headers.put("alti", "HERBARIUM SPECIMEN DATA");
        headers.put("yeddi", "CULTIVATED COLLECTIONS ONLY");
    }

    public void subHeaderMap() {
        headers1.put(0, "Donor Organisation\n\nOrganisation institute donating the seeds to Kew.");
        headers1.put(1, "Project Name\n\nIf known.");
        headers1.put(2, "If seeds collected from wild or cultivated plants.\nSelect from list.");
        headers1.put(3, "Collection Number *\n\n Unique collecting number.");
        headers1.put(4, "Accession Number\n\nUnique database reference number.");
        headers1.put(5, "Date Collected*\n\ndd/mm/yyyy");
        headers1.put(6, "Main Collector's Name & Institute*\n\nE.g. Jones, A., Kew Gardens");
        headers1.put(7, "Other Collector(s) Names & Institutes");
        headers1.put(8, "Family*");
        headers1.put(9, "Genus*");
        headers1.put(10, "Species*");
        headers1.put(11, "Species Author");
        headers1.put(12, "Rank\nE.g. var.; subsp.");
        headers1.put(13, "Infra-Specific Species");
        headers1.put(14, "Infra-Specific Author");
        headers1.put(15, "Rank 2");
        headers1.put(16, "Infra-Specific Species 2");
        headers1.put(17, "Infra-Specific Author 2");
        headers1.put(18, "Identification Status*\nSelect from list:\n- Collector's identification (unverified)\n- Provisional identification (unverified)\n- Field identification by specialist (verified)- Verified by other institution (verified)");
        headers1.put(19, "Identified From\nSelect from list:\n- living plant material\n- herbarium specimen\n- photograph\n- seed");
        headers1.put(20, "Identifier's Name & Institute");
        headers1.put(21, "Identification Date\n\ndd/mm/yyyy");
        headers1.put(22, "Plant Description*\nShort description of the plant.\n\nE.g. Perennial with white flowers.");
        headers1.put(23, "Plant Form*\n\nSelect from list.");
        headers1.put(24, "Plant Height (m)");
        headers1.put(25, "Uses\nList the main uses and source of information. E.g. Animal Food; Food; Fuel; Materials; Medicine; Poison; etc.");
        headers1.put(26, "Vernacular Name\nCommon name for the plant & language. \n\nE.g. Gesse Odorante (French).");
        headers1.put(27, "Assesment Information");
        headers1.put(28, "Other Key Information\n Record any other important information about the plant. \n"
                + "\n E.g. Threatened (IUCN Red List); Poisonous; Endemic; etc.");
        headers1.put(29, "Country*");
        headers1.put(30, "State/County/Province");
        headers1.put(31, "District/Municipality");
        headers1.put(32, "Description of Location\n\nShort description of collecting site location.\n\n E.g. Jones Nature Reserve, 200m from visitor centre.");
        headers1.put(33, "Orientation* \n\nN for North\nS for South*");
        headers1.put(34, "Degrees/ Northing*");
        headers1.put(35, "Minutes*");
        headers1.put(36, "Seconds*");
        headers1.put(37, "Orientation*\n\nE for East\nW for West");
        headers1.put(38, "Degrees/ Easting*");
        headers1.put(39, "Minutes*");
        headers1.put(40, "Seconds*");
        headers1.put(41, "Lat/Long Method\n\nSelect from list.");
        headers1.put(42, "Lat/Long Units\nSelect from list.\nDD = decimal degrees \n"
                + "DM = degrees & decimal minutes\nDMS = degrees, minutes & seconds\nUTM = if UTM specify zone");
        headers1.put(43, "Grid Reference\n\nIf applicable.");
        headers1.put(44, "GPS Datum\n\nSelect from list or input. E.g. WGS 84");
        headers1.put(45, "Altitude (m)");
        headers1.put(46, "Altitude Method\n\nSelect from list.");
        headers1.put(47, "Habitat*\n\nShort description of main habitat. Select from list or input.\n\nE.g. Woodland.");
        headers1.put(48, "Associated Species\n\nList key species associated with the habitat and collection site.\n\nE.g. Associated with Prunus spp.");
        headers1.put(49, "Factors Affecting Habitat\n\nList any factors, natural or human, that have modified the habitat. E.g. Grazing; Flooding; Roadside; Trampling; etc.");
        headers1.put(50, "Land Form\n\nSelect from list or input. \n\nE.g. Hill; Mountain; River Bank; Valley; etc.");
        headers1.put(51, "Land Use\n\nE.g. Agriculture; Pasture; Recreation; Conservation; etc.");
        headers1.put(52, "Geology\n\nE.g. Basalt; Granite; Limestone; Sandstone; Chalk; etc.");
        headers1.put(53, "Slope (°)\n\nSelect a range from list.");
        headers1.put(54, "Aspect\n\nSelect from list. \nE.g. N for North; SW for South West; etc.");
        headers1.put(55, "Soil Type\n\nSelect from list or input. \nE.g. Clay; Loam; Sand;  Silt; etc.");
        headers1.put(56, "Site Notes\n\nAny other key information about the site, such as soil pH, drainage, etc.");
        headers1.put(57, "Number of Plants Sampled*\n\nNumber of plants seeds collected from.");
        headers1.put(58, "Number of Plants Found*\n\nTotal number of plants of that species at collecting site.");
        headers1.put(59, "Area Sampled* (m2)\n \n Select range from list.");
        headers1.put(60, "Percentage of Plants Producing Seed* (%)");
        headers1.put(61, "Sampling Notes\n \n Any other key information about sampling. \n E.g. Mid season. Collected from plants. Seeds dry.");
        headers1.put(62, "Herbarium Specimen*\n \n Select 'Yes' if herbarium specimen collected.");
        headers1.put(63, "Herbarium Specimen Number\n \n If any.");
        headers1.put(64, "Sent to Kew\n \n Select 'Yes' if a herbarium specimen has been/is being sent to Kew.");
        headers1.put(65, "Location of Herbarium Specimens\n \n List all the locations of the herbarium specimens, both in country and elsewhere.");
//        headers1.put(66, "First Date of Harvest*\n \n Date seeds first collected.");
//        headers1.put(67, "Last Date of Harvest*\n \n If only harvested on one day, input same as first date of harvest.");
//        headers1.put(68, "Collector(s) Name & Institute*\n");
//        headers1.put(69, "Where Regrown*\n \n Country and place where seeds regrown.\n E.g. Agricultural Research Organisation, Israel.");
//        headers1.put(70, "Isolation Techniques Used\n \n If any.");
//        headers1.put(71, "Relation to Wild Population\n \n Select the generation, if known, from list.");
//        headers1.put(72, "Number of Plants Cultivated*\n \n Total number of plants grown.");
//        headers1.put(73, "Number of Plants Harvested*\n \n Number of plants seed collected from.");
//        headers1.put(74, "Habitat/Other Information\n \n Record the habitat and/or any other important information about the collection.");

    }

}
