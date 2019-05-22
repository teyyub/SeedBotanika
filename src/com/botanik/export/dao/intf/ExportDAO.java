package com.botanik.export.dao.intf;

import com.botanik.export.model.ExportListModel;
import com.botanik.export.model.ExportModel;
import java.util.List;

/**
 *
 * @author teyyub , 7:43:34 PM
 */
public interface ExportDAO {

    List<ExportModel> getExportModel();

    ExportListModel getExportListModel();
}
