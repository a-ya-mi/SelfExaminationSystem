import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class FileManipulator {
    private static FileManipulator instance;

    private FileManipulator() {
    }

    public static FileManipulator getInstance() {
        if (instance == null) {
            instance = new FileManipulator();
        }
        return instance;
    }

    public ArrayList<String> readFileToStringList (String fileName) {
        ArrayList<String> returnList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null) {
                returnList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Cannot to read from file " + fileName);
        }

        return returnList;
    }
}
