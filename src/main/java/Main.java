import HashingMD5.HashingMD5;
import Impletment.CompareContents;
import Impletment.FileDuplicateFinderContentReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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
//        FileDuplicateFinderContentReader fileDuplicateFinderReader = new FileDuplicateFinderContentReader(filePath);
//
//
//        List<String> arrayList1 = fileDuplicateFinderReader.readFileContent();
//        fileDuplicateFinderReader.setFilePath(filePath2);
//        List<String> arrayList2 = fileDuplicateFinderReader.readFileContent();
//
//
//        CompareContents compareContents = new CompareContents(arrayList1, arrayList2);
//        if (compareContents.areContentSame()) {
//            System.out.println("Same");
//
//        } else {
//            System.out.println("Not Same");
//        }

        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine().trim();

        File file = new File(path);
        HashingMD5 hashingMD5 = hashingMD5 = new HashingMD5();
        HashMap<String, List<String>> hash = new HashMap<String, List<String>>();


        findDuplicatedFile(hash, file, hashingMD5);

        for (String key : hash.keySet()) {
            if (hash.get(key).size() > 1) {
                List<String> fileList = hash.get(key);
                for (String fileName : fileList) {
                    System.out.println(fileName);
                }
            }

        }

    }

    public static void findDuplicatedFile(HashMap<String, List<String>> hashMap, File file, HashingMD5 hashingMD5) {

        File files[] = file.listFiles();
        for (File f : files) {

            if (f.isDirectory()) {
                findDuplicatedFile(hashMap, file, hashingMD5);
            } else {
                try {
                    hashingMD5.setFile(new FileInputStream(f));
                    String key = hashingMD5.generateHashCode();
                    if (hashMap.containsKey(key)) {
                        hashMap.get(key).add(f.getAbsolutePath());
                    } else {
                        List<String> list = new ArrayList<String>();
                        list.add(f.getAbsolutePath());
                        hashMap.put(key, list);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }

        }


    }
}
