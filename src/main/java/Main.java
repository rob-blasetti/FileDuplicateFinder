import Impletment.CompareContents;
import Impletment.FileDuplicateFinderContentReader;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 12/03/2014
 * Time: 3:16 PM
 * To change this template use File | Settings | File Templates.
 */

public class Main {

    private static String workingDir = System.getProperty("user.dir");
    private static String filePath = workingDir + "/src/main/resources/someArrays";
    private static String filePath2 = workingDir + "/src/main/resources/someArrays2";

    public static void main(String[] args) {
        FileDuplicateFinderContentReader fileDuplicateFinderReader = new FileDuplicateFinderContentReader(filePath);


        List<String> arrayList1 = fileDuplicateFinderReader.readFileContent();
        fileDuplicateFinderReader.setFilePath(filePath2);
        List<String> arrayList2 = fileDuplicateFinderReader.readFileContent();


        CompareContents compareContents = new CompareContents(arrayList1, arrayList2);
        if (compareContents.areContentSame()) {
            System.out.println("Same");

        } else {
            System.out.println("Not Same");
        }
    }

}
