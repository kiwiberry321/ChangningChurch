package com.shanghai.changning.service;

import com.shanghai.changning.vo.FormalAttendUserInfo;

import java.util.List;

public interface FormalAttendUserInfoService {

    int insert(FormalAttendUserInfo record);
    FormalAttendUserInfo selectByPrimaryKey(Integer userId);
    List<FormalAttendUserInfo> selectByCondition(FormalAttendUserInfo record);
    int updateByPrimaryKey(FormalAttendUserInfo record);
}
