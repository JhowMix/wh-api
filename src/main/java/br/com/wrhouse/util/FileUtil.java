package br.com.wrhouse.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtil {
    private static String TEMP_DIR = System.getProperty("java.io.tmpdir");

    public static void convertBase64ToFile(String base64, File file) throws IOException {
        byte[] decoded = Base64.decodeBase64(
                base64.substring(base64.indexOf(",")+ 1,
                        base64.length() - 1));

        FileUtils.writeByteArrayToFile(file, decoded);
    }

    public static File createTemp(String fileName) {
        return new File(TEMP_DIR + fileName);
    }
}
