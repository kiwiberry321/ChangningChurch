package com.shanghai.changning.mapper;

import com.shanghai.changning.vo.FormalAttendUserInfo;

import java.util.List;

public interface FormalAttendUserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(FormalAttendUserInfo record);

    int insertSelective(FormalAttendUserInfo record);

    FormalAttendUserInfo selectByPrimaryKey(Integer userId);

    List<FormalAttendUserInfo> selectByCondition(FormalAttendUserInfo record);

    int updateByPrimaryKeySelective(FormalAttendUserInfo record);

    int updateByPrimaryKey(FormalAttendUserInfo record);
}