package br.com.wrhouse.service;

import javax.enterprise.context.Dependent;
import java.io.File;
import java.util.Base64;

@Dependent
public class FileService {

    private static String TEMP_DIR = System.getProperty("java.io.tmpdir");

    public File convertBase64ToFile(String base64) {
        byte[] decoded = Base64.getDecoder().decode(base64);
        return null;
    }

//    public static createTempFile
}
