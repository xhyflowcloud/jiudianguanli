
package com.ccnu.xiahongyun.stmanagementsystem.Utils;

import com.ccnu.xiahongyun.stmanagementsystem.Utils.InUtils.TokenDetail;

public class TokenDetailImpl implements TokenDetail {

    private final String username;

    public TokenDetailImpl(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}