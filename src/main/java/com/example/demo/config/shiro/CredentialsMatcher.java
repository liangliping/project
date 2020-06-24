package com.example.demo.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Description: CredentialsMatcher <br>
 *
 * @author Liang lp
 * Date: 2020/4/30 14:17 <br>
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;
        //所需加密的参数  即  用户输入的密码
        String source = String.valueOf(utoken.getPassword());
        //[盐] 一般为用户名 或 随机数
        String salt = utoken.getUsername();
        //加密次数
        int hashIterations = 1;
        SimpleHash sh = new SimpleHash("md5", source, salt, hashIterations);
        String stash = sh.toHex();
        //打印最终结果
        System.out.println("正确密码为：" + stash);
        //获得数据库中的密码
        String dbPassword = (String) getCredentials(info);
        //进行密码的比对
        return this.equals(stash, dbPassword);
    }
}
