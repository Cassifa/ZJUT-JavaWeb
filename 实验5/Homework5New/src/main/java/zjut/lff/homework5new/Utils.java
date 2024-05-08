package zjut.lff.homework5new;

import org.bouncycastle.jcajce.provider.digest.SM3;
import org.bouncycastle.util.encoders.Hex;

import java.security.MessageDigest;

/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 18:50 2024/5/8
 * @ Description：工具类
 */
public class Utils {
    public static String passwordEncode(String password) {
        MessageDigest digest = new SM3.Digest();
        byte[] hashBytes = digest.digest(password.getBytes());
        return Hex.toHexString(hashBytes).toUpperCase();
    }
}
