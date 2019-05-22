 
package com.botanik.dao.intf;

import com.botanik.model.HabitatDataBase;
import com.botanik.model.SeedMorphology;
import com.botanik.model.SeedWeight;
import java.util.List;

/**
 *
 * @author USER
 */
public interface SeedMorphologyDAO {
    
    void  save(SeedMorphology model);
    void  update(SeedMorphology model);
    void save(SeedWeight model);
    void update(SeedWeight model);
    void  update(HabitatDataBase model);          
    void delete(Number id); 
    List<HabitatDataBase> AllHabitatDatas();
    List<HabitatDataBase> habitatDataBySearchModel(HabitatDataBase model);
}
