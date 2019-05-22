 
package com.botanik.dao.intf;

import com.botanik.model.LocationDataBase;
import java.util.List;

/**
 *
 * @author USER
 */
public interface LocationDataDAO {
    
    void  save(LocationDataBase model);
    void  update(LocationDataBase model);          
    void delete(Number id); 
    List<LocationDataBase> AllLocationDatas();
    List<LocationDataBase> locationDataBySearchModel(LocationDataBase model);
}
