package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.RegisterMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.RootMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Register;
import com.ccnu.xiahongyun.stmanagementsystem.model.Root;
import com.ccnu.xiahongyun.stmanagementsystem.services.RootService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RootServiceImpl implements RootService{

    private final RootMapper rootMapper;
    private final RegisterMapper registerMapper;

    @Autowired
    public RootServiceImpl(RootMapper rootMapper, RegisterMapper registerMapper) {
        this.rootMapper = rootMapper;
        this.registerMapper = registerMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Boolean addRootAdmin(Root root) {
        Boolean isSuccess;
        try{
            Root root1 = rootMapper.findRootByEmail(root.getEmail());
            Register register = registerMapper.findRegisterByEmail(root.getEmail());
            if(root1 == null || register == null){
                return false;
            }else{
                root.setAuth(11);
                root.setEnable(true);
                rootMapper.insertRoot(root);
            }
            isSuccess = true;
        }catch (Exception e){
            isSuccess = false;
        }
        return isSuccess;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Boolean deleteRootAdmin(Root root) {
        Boolean isSuccess;
        try{
            rootMapper.deleteRoot(root.getId());
            isSuccess = true;
        }catch (Exception e){
            isSuccess = false;
        }
        return isSuccess;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public List<Root> findAllRootAdmin(Root root) {
        List<Root> roots;
        try{
            if(root.getEmail() == null || !StringUtils.isNotEmpty(root.getEmail())) {
                roots = rootMapper.findAllRoot();
            }
            else{
                roots = new ArrayList<>();
                roots.add(rootMapper.findRootByEmail(root.getEmail()));
            }
        }catch (Exception e){
            roots = new ArrayList<>();
        }
        return roots;
    }
}
