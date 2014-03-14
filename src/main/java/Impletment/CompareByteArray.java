package Impletment;

import Interface.CompareFileImp;

import java.util.Arrays;

/**
 * Created by leng on 14/03/2014.
 */
public class CompareByteArray implements CompareFileImp {
    private byte[] byte1;
    private byte[] byte2;


    public CompareByteArray(byte[] b1, byte[] b2) {
        byte1 = b1;
        byte2 = b2;

    }


    @Override
    public boolean areContentSame() {
        if (Arrays.equals(byte1, byte2)) {
            return true;
        }

        return false;
    }


}
