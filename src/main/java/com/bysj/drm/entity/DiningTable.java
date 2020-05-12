package com.bysj.drm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (DiningTable)实体类
 *
 * @author makejava
 * @since 2020-02-20 11:29:42
 */
@Data
public class DiningTable implements Serializable {
    private static final long serialVersionUID = 814603678570610626L;
    
    private Integer id;
    
    private String tableNum;
    
    private Integer tablePernum;
    
    private Integer isno;


}