 
package com.botanik.model;

/**
 *
 * @author USER
 */
public class SeedWeightView extends Base{    
    private String  weight_1000;
    private String weight_100;
    private String type_weight;
    private String typeWeight;
    private String fruit_weight;
    private String perfruit;
 
    public SeedWeightView(String weight_1000, String weight_100, String type_weight, String fruit_weight, String perfruit) {
        this.weight_1000 = weight_1000;
        this.weight_100 = weight_100;
        this.typeWeight = type_weight;
        this.fruit_weight = fruit_weight;
        this.perfruit = perfruit;
    }
    
 
    public SeedWeightView(Number id,String weight_1000, String weight_100, String type_weight, String fruit_weight,String perfruit) {
        super(id);
        this.weight_1000 = weight_1000;
        this.weight_100 = weight_100;
        this.typeWeight = type_weight;
        this.fruit_weight = fruit_weight;
        this.perfruit = perfruit;
    }
    
    public SeedWeightView() {
    }

    public String getWeight_1000() {
        return weight_1000;
    }

    public String getWeight_100() {
        return weight_100;
    }

    public String getType_weight() {
        return type_weight;
    }

    public String getTypeWeight() {
        return typeWeight;
    }

    public String getFruit_weight() {
        return fruit_weight;
    }

    public String getPerfruit() {
        return perfruit;
    }

     
    
    
}
