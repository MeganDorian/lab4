import tree.Tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    private final static String fileName = "dataBase.txt";
    
    public static void main(String[] args) {
        Main app = new Main();
        try (BufferedReader reader = new BufferedReader(new FileReader(app.getFileFromResource(), StandardCharsets.UTF_8))) {
            Tree tree = new Tree("Stress level");
    
            String line = reader.readLine();
            while (line != null) {
                var list = getList(line);
                tree.add(list);
                line = reader.readLine();
            }
    
            Algorithm algorithm = new Algorithm(tree);
            var answer = algorithm.doAlgorithm();
            if (answer != null) {
                System.out.println(answer);
            } else {
                System.err.println("Ответ не был найден");
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    
    private static Queue<String> getList(String line) {
        String[] params = line.split(", ");
        Queue<String> values = new ConcurrentLinkedQueue<>();
        Collections.addAll(values, params);
        
        return values;
    }
    
    private File getFileFromResource() throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }
    }
}
