package duplicateFinder;

public class Main {

    public static void main(String[] args) throws Exception {
        String pathToScan = args[0];
        String action = "print";
        ScreenOutput outputter = new ScreenOutput();

        if (args.length > 1 && args[1].equals("-d"))
            action = "delete";

        FileClassifierBySize fileClassifierBySize = new FileClassifierBySize(new PathScanner(), new FileSizeReader());
        FileContentComparer fileContentComparer = new FileContentComparer(new FileStreamOpenerImplement());

        DuplicateFinderProcessor duplicateFinderProcessor = null;
        if ("print".equals(action)) {

            duplicateFinderProcessor = new DuplicateFinderPrintProcessor(outputter);
        } else {
            FileDeleter fileDeleter = new FileDeleter();
            duplicateFinderProcessor = new DuplicateFinderDeleteProcessor(fileDeleter, outputter);
        }

        DuplicateFinder duplicateFinder = new DuplicateFinder(duplicateFinderProcessor, fileClassifierBySize, fileContentComparer);
        duplicateFinder.scan(pathToScan);

    }

}
