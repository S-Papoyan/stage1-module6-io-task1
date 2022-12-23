package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder builder = new StringBuilder();
        try (FileInputStream in = new FileInputStream(file)) {
            int ch;
            while ((ch = in.read()) != -1) {
                builder.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String string = builder.toString();
        String[] split = string.split("\n");
        String[] values = new String[4];
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split(":", 2);
            values[i] = split1[1].trim();
        }
        return new Profile(values[0], Integer.parseInt(values[1]), values[2], Long.parseLong(values[3]));
    }
}