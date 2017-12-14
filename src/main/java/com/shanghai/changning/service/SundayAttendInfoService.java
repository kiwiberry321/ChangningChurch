package com.shanghai.changning.service;

import com.shanghai.changning.vo.SundayAttendInfo;

import java.util.List;

public interface SundayAttendInfoService {

    int insert(SundayAttendInfo record);
    SundayAttendInfo selectByPrimaryKey(Integer infoId);
    List<SundayAttendInfo> selectByCondition(SundayAttendInfo record);
    int updateByPrimaryKey(SundayAttendInfo record);

}
