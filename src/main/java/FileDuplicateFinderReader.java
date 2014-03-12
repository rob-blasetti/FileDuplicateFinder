import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 12/03/2014
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileDuplicateFinderReader {
    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    public FileDuplicateFinderReader(String filePath){
        this.filePath=filePath;

    }

    public List<String> readFile(){

        List<String>  fileContentList = new ArrayList<String>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filePath));
            String line;
            while((line = bufferedReader.readLine())!=null) {
                 fileContentList.add(line);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        catch (IOException e){
            e.printStackTrace();

        }

        return fileContentList;
    }
}
