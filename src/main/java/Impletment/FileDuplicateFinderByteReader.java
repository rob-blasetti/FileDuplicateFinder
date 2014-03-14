package Impletment;

import Interface.FileDuplicateFinderByteReaderImp;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * Created by leng on 14/03/2014.
 */
public class FileDuplicateFinderByteReader implements FileDuplicateFinderByteReaderImp {

    private String filePath;

    public FileDuplicateFinderByteReader(String filePath) {
        this.filePath = filePath;

    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public byte[] readFileByte() {
        byte[] result = new byte[]{};
        try {
            InputStream inputStream = new FileInputStream(this.filePath);

            result = IOUtils.toByteArray(inputStream);

        } catch (FileNotFoundException e) {
            result = null;
            e.printStackTrace();
        } catch (IOException e) {
            result = null;
            e.printStackTrace();

        }

        return result;


    }
}
