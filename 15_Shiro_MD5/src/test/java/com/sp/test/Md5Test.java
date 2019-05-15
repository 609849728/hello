package com.sp.test;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

public class Md5Test {

    public static void main(String[] args) {
        String password = "789";  //原始密码

        String salt = new SecureRandomNumberGenerator().nextBytes().toString();  //盐

        int times = 2;  //计算次数
        String algorithmName = "md5";

        String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();  //运算后的密文

        System.out.printf("原始密码是 %s , 盐是： %s, 运算次数是： %d, 运算出来的密文是：%s ",password,salt,times,encodedPassword);
    }

}
