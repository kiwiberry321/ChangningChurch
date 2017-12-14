package com.shanghai.changning.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
public class FormalAttendUserInfo implements Serializable{
    private static final long serialVersionUID = 2346885730925592158L;

    @Getter @Setter
    private Integer userId;

    @Getter @Setter
    private String userName;

    @Getter @Setter
    private String birthday;

    @Getter @Setter
    private Date createDate;

    @Getter @Setter
    private String createBy;

}