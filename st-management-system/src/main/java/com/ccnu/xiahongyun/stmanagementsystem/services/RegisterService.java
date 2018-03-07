package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.Register;

public interface RegisterService {

    void addRegister(Register register);
    Register findRegisterById(String email);
    Boolean checkRoles(String email);
    Register queryIdenty(String email);
}
