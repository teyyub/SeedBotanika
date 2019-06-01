package com.botanik.model;

import java.math.BigDecimal;

/**
 *
 * @author teyyub , Jan 7, 2018 , 1:19:20 PM
 */
public class GenusModel extends Genus {
 
    private String author_name;
    private String family_name;

    public GenusModel() {
    }

    public GenusModel(
            BigDecimal genus_id,
            Integer author_id,
            String author_name,
            Number family_id,
            String family_name,
            Number taxon_id,
            String ref_no,
            String addition,
            String remarks,
            boolean hybrid,
            boolean accepted,
            String full_name
    ) {

        super(genus_id, author_id, family_id, taxon_id, ref_no, addition, remarks, hybrid, accepted, full_name);
        this.author_name = author_name;
        this.family_name = family_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getFamily_name() {
        return family_name;
    }

}
