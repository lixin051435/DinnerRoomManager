package com.bysj.drm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (DinnerNotice)实体类
 *
 * @author makejava
 * @since 2020-02-20 11:29:26
 */
@Data
public class DinnerNotice implements Serializable {
    private static final long serialVersionUID = -36927731855617579L;
    
    private Integer id;
    
    private String menuName;
    
    private Integer orderId;
    
    private Integer menunum;
    
    private String remark;
    
    private Integer menuprice;


}