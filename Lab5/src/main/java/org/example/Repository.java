package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private String directory;
    private Map<Person, List<Document>> documents = new HashMap<>();

    public Repository(String directory) {
        this.directory = directory;
        loadDocuments();
}

    private void loadDocuments() {

    }

    public Object findDocument(String s) {

        return null;
    }
}
