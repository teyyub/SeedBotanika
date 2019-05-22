package com.botanik.model;

import com.botanik.dao.impl.CombosDAOJDBC;
import com.botanik.dao.intf.CombosDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author USER
 */
public class DefaultCombo {

    private ComboBox defaultCombo;
    private int comboId;
    private String origin;
    private String selected;
    private Map<Number, String> comboMap;

    CombosDAO baseDao = new CombosDAOJDBC();

    public DefaultCombo() {
    }

    public DefaultCombo(ComboBox combo) {
        defaultCombo = combo;
    }

    public DefaultCombo(ComboBox defaultCombo, String origin) {
        this.defaultCombo = defaultCombo;
        this.origin = origin;
    }

    public DefaultCombo(ComboBox defaultCombo, int comboId) {
        this.defaultCombo = defaultCombo;
        this.comboId = comboId;
    }

    public void escape() {
        defaultCombo.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                defaultCombo.getSelectionModel().clearSelection();
            }
        });
    }

    public Number selectedId() {
        if (defaultCombo.getSelectionModel().getSelectedItem() != null) {
            String filter = defaultCombo.getSelectionModel().getSelectedItem().toString();

            List<Base> lists = defaultCombo.getItems();

            for (Base b : lists) {
                if (b.getName().equals(filter)) {
                    return b.getId();

                }
            }
        }
        return -1;

//        if (defaultCombo.getSelectionModel().getSelectedIndex() == -1) {
//            return -1;
//        }
//        return ((Base) defaultCombo.getSelectionModel().getSelectedItem()).getId();
    }

    
    public void loadComboById() {
        defaultCombo.setItems(
                FXCollections.observableArrayList(
                        baseDao.combosByIds(comboId)
                )
        );
    }

    private void loadComboMap() {
        List a = baseDao.combosByIds(comboId);
        comboMap = new HashMap();
        for (int i = 0; i < a.size(); i++) {
            Base b = (Base) a.get(i);
            comboMap.put(b.getId(), b.getName());
        }
    }

    public String comboTextById(Number id) {
        loadComboMap();
        if (!comboMap.containsKey(id)) {
            return "";
        }
        return comboMap.get(id);
    }

    public void select() {
        defaultCombo.getSelectionModel().select(origin);
    }

    public boolean isInputValid() {
        String errorMessage = "";
        if (defaultCombo.getSelectionModel().getSelectedItem() == null) {
            errorMessage += "Enter Data!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            new DefaultAlert(errorMessage).warning();
            return false;
        }
    }
}
