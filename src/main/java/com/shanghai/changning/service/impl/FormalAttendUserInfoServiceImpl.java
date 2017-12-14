package com.shanghai.changning.service.impl;

import com.shanghai.changning.service.FormalAttendUserInfoService;
import com.shanghai.changning.vo.FormalAttendUserInfo;
import com.shanghai.changning.mapper.FormalAttendUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("formalAttendUserInfoService")
public class FormalAttendUserInfoServiceImpl implements FormalAttendUserInfoService {

    @Autowired
    private FormalAttendUserInfoMapper formalAttendUserInfoMapper;

    @Override
    public int insert(FormalAttendUserInfo record) {
        int result;
        try {
            result = formalAttendUserInfoMapper.insert(record);
        }catch (Exception e){
            result = formalAttendUserInfoMapper.insertSelective(record);
        }
        return result;
    }

    @Override
    public FormalAttendUserInfo selectByPrimaryKey(Integer userId) {
        FormalAttendUserInfo formalAttendUserInfo = new FormalAttendUserInfo();
        try {
            formalAttendUserInfo = formalAttendUserInfoMapper.selectByPrimaryKey(userId);
        }catch (Exception e){
        }
        return formalAttendUserInfo;
    }

    @Override
    public List<FormalAttendUserInfo> selectByCondition(FormalAttendUserInfo record) {
        List<FormalAttendUserInfo> formalAttendUserInfoList = new ArrayList<FormalAttendUserInfo>();
        try {
            formalAttendUserInfoList = formalAttendUserInfoMapper.selectByCondition(record);
        }catch (Exception e){
        }
        return formalAttendUserInfoList;
    }

    @Override
    public int updateByPrimaryKey(FormalAttendUserInfo record) {
        int result;
        try {
            result = formalAttendUserInfoMapper.updateByPrimaryKey(record);
        }catch (Exception e){
            result = formalAttendUserInfoMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }
}
