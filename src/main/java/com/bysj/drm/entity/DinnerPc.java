package com.bysj.drm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (DinnerPc)实体类
 *
 * @author makejava
 * @since 2020-02-20 11:29:01
 */
@Data
public class DinnerPc implements Serializable {
    private static final long serialVersionUID = 786175471005835749L;

    private Integer id;

    private Integer orderid;

    private Integer isok;


}