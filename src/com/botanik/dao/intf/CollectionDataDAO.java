package com.botanik.dao.intf;

import com.botanik.model.Base;
import com.botanik.model.CollectionDataBase;
import java.util.List;

/**
 *
 * @author USER
 */
public interface CollectionDataDAO {

    void save(CollectionDataBase model);

    void update(CollectionDataBase model);
    
    List<CollectionDataBase> collections();

    void delete(Number id);

    void saveOrganization(Base base);

    List<Base> organizeInstitute();

    void saveWildCultivited(Base base);

    List<Base> wildCultivited();

    void saveCollectorInstitute(Base base);

    List<Base> collectorInstitute();
    
    void save(Base model, int combos_id);

}
