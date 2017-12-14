package com.shanghai.changning.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
public class SundayAttendInfo implements Serializable{
    private static final long serialVersionUID = -7184384157891138739L;

    @Getter @Setter
    private  Integer infoId;

    @Getter @Setter
    private  Date attendDate;

    @Getter @Setter
    private String createBy;

    @Getter @Setter
    private Date createDate;

    @Getter @Setter
    private String attendUsers;

    @Getter @Setter
    private Integer isDeleted;

    @Getter @Setter
    private String subject;

    @Getter @Setter
    private String content;

    @Getter @Setter
    private String preachPriest;

}