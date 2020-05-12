package com.bysj.drm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Users)实体类
 *
 * @author makejava
 * @since 2020-02-20 11:26:27
 */
@Data
public class Users implements Serializable {
    private static final long serialVersionUID = 828347927926450778L;
    
    private Integer id;
    
    private String uLoginname;
    
    private String uPwd;
    
    private String uName;
    
    private String uSex;
    
    private String uPhone;
    
    private String uIdcard;
    
    private String uAddress;
    
    private Integer uRole;




}