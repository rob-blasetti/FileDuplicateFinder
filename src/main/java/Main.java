import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 12/03/2014
 * Time: 3:16 PM
 * To change this template use File | Settings | File Templates.
 */

public class Main {
    private static String filePath = "/Users/user/Desktop/GitProjects/FileDuplicateFinder/src/main/resources/someArrays";
    private static String filePath2 = "/Users/user/Desktop/GitProjects/FileDuplicateFinder/src/main/resources/someArrays2";

    public static void main(String[] args) {
        FileDuplicateFinderReader fileDuplicateFinderReader = new FileDuplicateFinderReader(filePath);

        List<String> arrayList1 = fileDuplicateFinderReader.readFile();
        fileDuplicateFinderReader.setFilePath(filePath2);
        List<String> arrayList2 = fileDuplicateFinderReader.readFile();


        CompareContents compareContents = new CompareContents(arrayList1, arrayList2);
        if (compareContents.compare()) {
            System.out.println("Same");

        } else {
            System.out.println("Not Same");
        }
    }

}
