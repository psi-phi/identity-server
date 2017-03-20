package com.psiphiglobal;

import org.apache.commons.codec.binary.Base64;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Test
{
    public static void main(String[] args) throws Exception
    {
        String pkStr = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKWU3SFMIuxiEG4HJ04goxOM6Y1xp6RJTET2SRuRYX4d6xgr2enohzIfmfNCU5TS3AdV1nYGa7up/yuFnkmgiGlwmldjzk3RJkOnLcq+cX0OalfWaD4W8SESNMD2LGeuTlfrJG6neV7/rHS07MPpNxrgOYYIjTAXL4eCg4ODzY4tAgMBAAECgYAQ8gorZTJRxLtvtzWzji2CS7J/Mjl427N9f0L+GkPC92be42X6xTxIyekkdw48tdOkwIkhLQkLfJtLpfIMEOzEy2bQv6447Z31pGJFuLjXq+ISFKYdzOGeKMaFw5WYHooEt4HC1MaIYnAMFiMmBIOcFCyfd3S7IstHWgA6SBO3QQJBAN69pOPMdPm2Wu6+vUrMDYB20VKbPwfqqeJbtPXqFLyBqW/hdvyR3o2H0waiIMxZ5MFI2yehEl3K22zaduEeqd0CQQC+Tkhe/ff+X7cp86+h4rhkPghqOE+E6eAZQ45h64nw6piqucZe7xdeFn0vJDHqiIeevdcJhtS5kXomFtAWcziRAkAFfgei1lfMEIMNgAaK4Z0znbprnwhe2Zp2ymwb5Dm+rDPRXm3grHggZUj+0OCeKVlKqtE8mOwrA+WFOZ3UzzzBAkBH8QIM3weMIxT0CApCMZoxUv4NYaI2Bc/Q3SgLPmaUK6txBu/F3a7Aw9GpK46vMdPLH8sV7+GlESjTE1aw1ffxAkEAhESDpHka2rFFpPIIhOnXnxNMM36LnEhcqy3ln4v3Fz6P/vv0uBtrp7+EYYuPbajb7j2l5L9be9IKswFyEWfjjQ==";
        byte[] pkData = Base64.decodeBase64(pkStr);
        PrivateKey pk = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(pkData));

        String pubKStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCllN0hTCLsYhBuBydOIKMTjOmNcaekSUxE9kkbkWF+HesYK9np6IcyH5nzQlOU0twHVdZ2Bmu7qf8rhZ5JoIhpcJpXY85N0SZDpy3KvnF9DmpX1mg+FvEhEjTA9ixnrk5X6yRup3le/6x0tOzD6Tca4DmGCI0wFy+HgoODg82OLQIDAQAB";
        byte[] pubKData = Base64.decodeBase64(pubKStr);
        PublicKey pubK = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(pubKData));

        String msg = "JlpVRrIHizTRcJv5QQaBTrpSg2OBlV1RdKGwjmBjB70";
        byte[] msgBytes = Base64.decodeBase64(msg);

        String sign = "fNQgTq31JpKEakxSY4Qt7MvQ0SscqBKe4HjWXIWNDt6tccZiz/gPdkcszPsFDLRdglVmRA33VdEKSHOIL8Z8Ow8X+s/2mmeHjxSZQcwpyDk6bJIVCmDY/8ZVWoWy+VNU8EZEYtqfqUWEprRZsT4yxFa6G/DY/d36G5a37Nc/X8A=";
        byte[] s = Base64.decodeBase64(sign);

//        Signature signature = Signature.getInstance("SHA256withRSA");
//        signature.initVerify(pubK);
//        signature.update(msgBytes);
//        System.out.println(signature.verify(s));

        Signature signature1 = Signature.getInstance("SHA256withRSA");
        signature1.initSign(pk);
        signature1.update(msg.getBytes());
        byte[] s1 = signature1.sign();
        System.out.println(Base64.encodeBase64String(s1));
        System.out.println(Base64.encodeBase64String(s));
    }
}
