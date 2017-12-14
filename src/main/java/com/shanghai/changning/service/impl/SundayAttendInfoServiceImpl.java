package com.shanghai.changning.service.impl;

import com.shanghai.changning.mapper.SundayAttendInfoMapper;
import com.shanghai.changning.service.SundayAttendInfoService;
import com.shanghai.changning.vo.SundayAttendInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sundayAttendInfoService")
public class SundayAttendInfoServiceImpl implements SundayAttendInfoService {

    @Autowired
    private SundayAttendInfoMapper sundayAttendInfoMapper;

    @Override
    public int insert(SundayAttendInfo record) {
        int result;
        try {
            result = sundayAttendInfoMapper.insert(record);
        }catch (Exception e){
            result = sundayAttendInfoMapper.insertSelective(record);
        }
        return result;
    }

    @Override
    public SundayAttendInfo selectByPrimaryKey(Integer infoId) {
        return sundayAttendInfoMapper.selectByPrimaryKey(infoId);
    }

    @Override
    public List<SundayAttendInfo> selectByCondition(SundayAttendInfo record) {
        return sundayAttendInfoMapper.selectByCondition(record);
    }

    @Override
    public int updateByPrimaryKey(SundayAttendInfo record) {
        return sundayAttendInfoMapper.updateByPrimaryKey(record);
    }
}
