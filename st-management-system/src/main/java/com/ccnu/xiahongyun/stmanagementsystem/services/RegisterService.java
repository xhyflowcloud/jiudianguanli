package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.Admin;

public interface RegisterService {

    Admin SelectAdminByUsername(String username);
}
