package io;

import java.util.ArrayList;
import java.io.File;
import io.FileFinder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 *
 * @author cooneyth
 */
public class FileDocSource extends DocSource {

    private ArrayList<File> files;

    public FileDocSource(String src) {
        files = new ArrayList<File>(FileFinder.GetAllFiles(src));
    }

    @Override
    public String getDoc(int id) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader fin = new BufferedReader(new FileReader(files.get(id)));

            while (fin.ready()) {
                sb.append(fin.readLine());
                sb.append(" ");
            }
        } catch (IOException e) {
        }
        return sb.toString();
    }

    @Override
    public int getNumDocs() {
        return files.size();
    }

}