 
package com.botanik.dao.intf;

import com.botanik.model.HabitatDataBase;
import com.botanik.model.SamplingDataBase;
import java.util.List;

/**
 *
 * @author USER
 */
public interface HabitatDataDAO {
    
    void  save(HabitatDataBase model);
    void  update(HabitatDataBase model);          
    void delete(Number id); 
    List<HabitatDataBase> AllHabitatDatas();
    List<HabitatDataBase> habitatDataBySearchModel(HabitatDataBase model);
}
