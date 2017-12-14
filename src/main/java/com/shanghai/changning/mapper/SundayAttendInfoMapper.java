package com.shanghai.changning.mapper;

import com.shanghai.changning.vo.SundayAttendInfo;

import java.util.List;

public interface SundayAttendInfoMapper {
    int deleteByPrimaryKey(Integer infoId);

    int insert(SundayAttendInfo record);

    int insertSelective(SundayAttendInfo record);

    SundayAttendInfo selectByPrimaryKey(Integer infoId);

    List<SundayAttendInfo> selectByCondition(SundayAttendInfo record);

    int updateByPrimaryKeySelective(SundayAttendInfo record);

    int updateByPrimaryKey(SundayAttendInfo record);
}