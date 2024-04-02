package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public record Person(int id, String name) {

    public void createDirectory() throws IOException {
        String path = "C:\\documents\\" + id;

        File dir = new File(path);
        if(!dir.exists()){
            Files.createDirectory(Paths.get(path));
        }

        path = path + "\\fisier.txt";
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
    }
}
