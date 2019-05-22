package com.botanik.dao.intf;

import com.botanik.model.DefaultSeed;
import com.botanik.model.SamplingDataView;
import com.botanik.model.SeedModel;
import com.botanik.model.SeedMorphologyView;
import com.botanik.model.SeedView;
import com.botanik.model.SeedWeightView;
import java.util.List;

/**
 *
 * @author teyyub , Feb 4, 2018 , 2:54:06 PM
 */
public interface SeedDAO {

    List<SeedModel> seedByModel(SeedModel model);

    SeedModel seedById(Number id);

    SeedWeightView seedWeightById(Number id);

    SeedMorphologyView seedMorphologyById(Number id);

    SamplingDataView seedSamplingData(Number id);
            
    DefaultSeed defaultSeedById(Number id);

    SeedView SeedById(Number id);

    void save(SeedModel model);

    void update(SeedModel model);

    void save(DefaultSeed model);

    void update(DefaultSeed model);
}
