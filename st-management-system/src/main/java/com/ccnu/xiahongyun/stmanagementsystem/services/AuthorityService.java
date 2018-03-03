package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.Root;

public interface AuthorityService {

    Root getRootByEmail(String email);
}
