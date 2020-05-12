package com.bysj.drm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (MemberType)实体类
 *
 * @author makejava
 * @since 2020-02-20 11:28:23
 */
@Data
public class MemberType implements Serializable {
    private static final long serialVersionUID = 761477814070936121L;
    
    private Integer id;
    
    private String typeName;

}