package HashingMD5;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by leng on 19/03/2014.
 */
public class HashingMD5 {

    private FileInputStream file;


    public FileInputStream getFile() {
        return file;
    }

    public void setFile(FileInputStream file) {
        this.file = file;
    }

    public String generateHashCode() {
        String hash;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] dataBytes = new byte[1024];

            int nread = 0;
            while ((nread = file.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, nread);
            }
            ;
            byte[] mdbytes = md.digest();

            //convert the byte to hex format method 2
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < mdbytes.length; i++) {
                String hex = Integer.toHexString(0xff & mdbytes[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            hash = hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
        return hash;

    }
}
