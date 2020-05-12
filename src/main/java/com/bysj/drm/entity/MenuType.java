package com.bysj.drm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (MenuType)实体类
 *
 * @author makejava
 * @since 2020-02-20 11:27:48
 */
@Data
public class MenuType implements Serializable {
    private static final long serialVersionUID = -38476608987360511L;

    private Integer id;

    private String typeName;


}