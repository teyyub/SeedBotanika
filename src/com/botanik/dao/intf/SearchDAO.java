package com.botanik.dao.intf;

import com.botanik.model.Search;
import com.botanik.model.SearchModel;
import java.util.List;

/**
 *
 * @author teyyub , Feb 4, 2018 , 2:54:06 PM
 */
public interface SearchDAO {

//   List<SeedModel> search(SearchModel model);
   
   List<Search> search(SearchModel model);
    
}
