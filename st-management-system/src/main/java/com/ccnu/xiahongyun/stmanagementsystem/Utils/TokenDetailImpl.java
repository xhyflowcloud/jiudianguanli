
package com.ccnu.xiahongyun.stmanagementsystem.Utils;

import com.ccnu.xiahongyun.stmanagementsystem.Utils.InUtils.TokenDetail;
import com.ccnu.xiahongyun.stmanagementsystem.enums.UserAuthority;

public class TokenDetailImpl implements TokenDetail {

    private final String username;
    /*private final UserAuthority userAuthority;*/

    /*public TokenDetailImpl(String username, UserAuthority userAuthority) {
        this.username = username;
        this.userAuthority = userAuthority;
    }*/

    public TokenDetailImpl(String username) {
        this.username = username;

    }

    @Override
    public String getUsername() {
        return this.username;
    }

   /* @Override
    public String getAuthority() {
        return this.userAuthority.getAuthority();
    }*/
}