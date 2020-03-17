package DocumentManagementSystem;

import java.awt.*;
import java.io.*;

public class CatalogUtil {

    public static void save(Catalog catalog) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws IOException{
            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(path))) {
                return new Catalog("name", path);
            }
    }

    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
        //… browse or open, depending of the location type
    }

}
