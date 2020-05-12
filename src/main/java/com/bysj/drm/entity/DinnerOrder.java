package com.bysj.drm.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (DinnerOrder)实体类
 *
 * @author makejava
 * @since 2020-02-20 11:29:15
 */
@Data
public class DinnerOrder implements Serializable {
    private static final long serialVersionUID = 447210234399493799L;
    
    private Integer id;
    
    private String tableId;
    
    private Date ordertime;
    
    private String usercode;
    
    private Integer personnum;
    
    private Integer ispay;
    
    private Integer price;
    
    private Integer isfull;


}