 
package com.botanik.dao.intf;

import com.botanik.model.SamplingDataBase;
import java.util.List;

/**
 *
 * @author USER
 */
public interface SamplingDataDAO {
    
    void  save(SamplingDataBase model);
    void  update(SamplingDataBase model);          
    void delete(Number id); 
    List<SamplingDataBase> AllSamplingDatas();
    List<SamplingDataBase> samplingDataBySearchModel(SamplingDataBase model);
}
