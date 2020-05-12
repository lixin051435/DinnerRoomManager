package com.bysj.drm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Menu)实体类
 *
 * @author makejava
 * @since 2020-02-20 11:28:03
 */

@Data
public class Menu implements Serializable {
    private static final long serialVersionUID = 778538314717351609L;

    private Integer id;

    private Integer typeId;

    private String mName;

    private Integer mPrice;

    private String imagePath;

    private String remark;


}