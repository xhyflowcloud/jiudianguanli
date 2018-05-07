package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.Admin;
import com.ccnu.xiahongyun.stmanagementsystem.model.Register;

public interface RegisterService {

    Admin SelectAdminByUsername(String username);
}
