 
package com.botanik.dao.intf;

import com.botanik.model.Base;
import com.botanik.model.Family;
import java.util.List;

/**
 *
 * @author USER
 */
public interface PlanetDAO {
    List<Family> families();
    void save(Family model);
    void edit(Family model);
    void delete(Number id); 
    
    
    List<Base> genuses();
    void save(Base model);
    void edit(Base model);
    void deleteGenus(Number id); 
}
