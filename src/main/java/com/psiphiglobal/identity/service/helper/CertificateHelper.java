package com.psiphiglobal.identity.service.helper;

import com.google.protobuf.ByteString;
import com.psiphiglobal.identity.proto.Common;
import com.psiphiglobal.identity.proto.Organization;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.xbill.DNS.*;

import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CertificateHelper
{
    public static Common.PublicKey parsePublicKey(String algo, String base64EncodedX508PublicKey)
    {
        Common.PublicKey.Algorithm algorithm = null;
        try
        {
            algorithm = Common.PublicKey.Algorithm.valueOf(algo.toUpperCase());
        }
        catch (Exception e)
        {
            return null;
        }

        try
        {
            byte[] x509PublicKey = Base64.decodeBase64(base64EncodedX508PublicKey);
            switch (algorithm)
            {
                case RSA:
                    KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(x509PublicKey));
                    break;

                case ECDSA:
                    KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(x509PublicKey));
                    break;

                default:
                    return null;
            }

            return Common.PublicKey.newBuilder()
                    .setAlgorithm(algorithm)
                    .setData(ByteString.copyFrom(x509PublicKey))
                    .build();
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public static String getCertId(Organization.CertificateData certData)
    {
        byte[] rawCertData = certData.toByteArray();
        byte[] certHash = DigestUtils.sha256(rawCertData);
        return Base64.encodeBase64URLSafeString(certHash);
    }

    public static boolean dnsValidate(String domainName, String certId)
    {
        try
        {
            List<String> certRecords = getCertRecords(domainName);
            if (certRecords == null)
                throw new NullPointerException();

            return certRecords.contains(certId);
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static Common.Signature processSignature(Organization.CertificateData certData, String base64EncodedSignature)
    {
        try
        {
            Common.PublicKey publicKey = certData.getPublicKey();
            byte[] message = Base64.decodeBase64(getCertId(certData));
            byte[] signature = Base64.decodeBase64(base64EncodedSignature);

            Signature sig = null;
            switch (publicKey.getAlgorithm())
            {
                case RSA:
                    sig = Signature.getInstance("SHA256withRSA");
                    sig.initVerify(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKey.getData().toByteArray())));
                    sig.update(message);
                    if (sig.verify(signature))
                        return Common.Signature.newBuilder()
                                .setData(ByteString.copyFrom(signature))
                                .build();
                    else
                        return null;

                case ECDSA:
                    sig = Signature.getInstance("SHA256withECDSA");
                    sig.initVerify(KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(publicKey.getData().toByteArray())));
                    sig.update(message);
                    if (sig.verify(signature))
                        return Common.Signature.newBuilder()
                                .setData(ByteString.copyFrom(signature))
                                .build();
                    else
                        return null;

                default:
                    return null;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    private static List<String> getCertRecords(String domainName)
    {
        try
        {
            List<String> certRecords = new ArrayList<>();

            String recordName = "identity_certs." + domainName;

            final Lookup lookup = new Lookup(recordName, Type.TXT);
            lookup.setResolver(new SimpleResolver());
            lookup.setCache(null);

            final Record[] records = lookup.run();
            if (lookup.getResult() == Lookup.SUCCESSFUL)
            {
                final StringBuilder builder = new StringBuilder();
                for (Record record : records)
                {
                    final TXTRecord txt = (TXTRecord) record;
                    builder.delete(0, builder.length());
                    for (String s : (List<String>) txt.getStrings())
                    {
                        builder.append(s);
                    }
                    final String txtStr = builder.toString();
                    String[] tokens = txtStr.split(" ");
                    certRecords.addAll(Arrays.asList(tokens));
                }
            }

            return certRecords;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
