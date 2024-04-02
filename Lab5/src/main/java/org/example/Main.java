package org.example;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        Main app = new Main();
        var p = new Person(1001, "Popescu");
        var p1 = new Person(1002, "Aaa");
        p.createDirectory();
        p1.createDirectory();
        System.out.println(p);
        System.out.println(p.name());
        app.testRepo();
        app.testLoadView();
    }

    private void testLoadView() {
    }

    private void testRepo() throws IOException {
        var repo = new Repository("C:\\documents");
        Document doc= new Document("C:\\documents");
        String path = "C:\\documents";
        Files.walkFileTree(Path.of(path), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("pre visit dir:" + dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("visit file: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("visit file failed: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("post visit directory: " + dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}