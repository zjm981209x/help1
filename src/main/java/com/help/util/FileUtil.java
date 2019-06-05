package com.help.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zhao
 *
 */
public class FileUtil {
    public static void upload(byte[] file,String path,String name) throws IOException {
        File target = new File(path);
        if(!target.exists()) {
            target.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(path + name);
        out.write(file);
        out.flush();
        out.close();
    }
}
