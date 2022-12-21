package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder temp = new StringBuilder();
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            int ch;
            while ((ch = in.read()) != -1) {
                char a = (char) ch;
                temp.append(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String[] split = temp.toString().split("\r\n");
        String[] values = new String[4];
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split(": ");
            values[i] = split1[1];
        }
        return new Profile(values[0], Integer.parseInt(values[1]), values[2], Long.parseLong(values[3]));
    }
}