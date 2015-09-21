package action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

public class UserService {
    private static final String CURRENT_USER = "CURRENT_USER";
    
    public static String encryptPasswd(String passwd) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] passBytes = passwd.getBytes();
        md.reset();
        byte[] digested = md.digest(passBytes);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<digested.length;i++)
            sb.append(Integer.toHexString(0xff & digested[i]));
        return sb.toString();
    }
    
   

}
