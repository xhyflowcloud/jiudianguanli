package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.Root;

import java.util.List;

public interface RootService {
    Boolean addRootAdmin(Root root);
    Boolean deleteRootAdmin(Root root);
    List<Root> findAllRootAdmin(Root root);
}
