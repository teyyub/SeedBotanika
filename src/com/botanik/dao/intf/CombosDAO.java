package com.botanik.dao.intf;

import com.botanik.model.Base;
import com.botanik.model.Combo;
import java.util.List;

/**
 *
 * @author USER
 */
public interface CombosDAO {

    List<Base> combosByIds(int num);
    
    void deleteCombosById(Number id, int combos_id);
    
    void updateCombosById(Base model, int combos_id);
    
    List<Base> families();
    
//    List<Base> familyByName(String name);
    
    List<Base> loadByCombo(Combo model);
    
    void deleteFamilyById(Number id);
    
    void updateFamily(Base model);

    List<Base> genuses();

    List<Base> speciesAuthors();

    List<Base> ranks();
    
    List<Base> infraSpecies();
    
    List<Base> infraAuthors();
    
    List<Base> identStatus();
    
    List<Base> identInstitutes();
    
    List<Base> plantDescriptions();
    
    List<Base> useses();
    
    List<Base> vernacularNames();
    
    List<Base> assesmentInformations();
    
    List<Base> otherKeyInfor();
    
    List<Base> plantForms();
    
    List<Base> identifiedFrom();
    
    Number getId();
    
}
