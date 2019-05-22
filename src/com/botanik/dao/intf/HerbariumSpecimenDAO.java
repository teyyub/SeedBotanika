package com.botanik.dao.intf;

import com.botanik.model.HerbariumSpecimenBase;

/**
 *
 * @author teyyub , Feb 5, 2018 , 6:08:35 PM
 */
public interface HerbariumSpecimenDAO {

    void save(HerbariumSpecimenBase base);

    void update(HerbariumSpecimenBase base);
    
    void delete(Number id);
        
   
}
