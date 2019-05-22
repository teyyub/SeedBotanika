package com.project.file.intf;

import com.botanik.model.DefaultImage;

/**
 *
 * @author teyyub , Mar 25, 2018 , 9:34:18 AM
 */
public interface FileOperation {

    void saveFile(DefaultImage image);
    void updateFile(DefaultImage image);
}
