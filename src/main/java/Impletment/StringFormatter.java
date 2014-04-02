package Impletment;

import Interface.Formatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by leng on 2/04/2014.
 */
public class StringFormatter implements Formatter {

    @Override
    public String formatData(HashMap<String, ArrayList<String>> dupllicatedFilePaths) {
            StringBuilder formatString= new StringBuilder();

            for(String key:dupllicatedFilePaths.keySet()){
                formatString.append("=====================================================\n");
                ArrayList<String> filePaths=dupllicatedFilePaths.get(key);
                for(int i=0; i<filePaths.size();i++){
                    formatString.append(filePaths.get(i)+"\n");
                }
            }
        return  formatString.toString();
    }
}
