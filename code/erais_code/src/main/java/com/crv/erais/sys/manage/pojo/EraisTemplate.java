package com.crv.erais.sys.manage.pojo;

import com.crv.erais.model.BaseEntity;
import lombok.Data;

@Data
public class EraisTemplate  extends BaseEntity {
    private String id;

    private String name;

    private String classs;

    private String decr;

    private String example;

    private String status;

    private String monadlevel;

    private String projectclass;

    private String text;

   }