package br.com.wrhouse.service;

import br.com.wrhouse.util.FileUtil;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import lombok.val;

import javax.enterprise.context.Dependent;
import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

@Dependent
public class CodeService {

    /**
     * 
     * @see br.com.wrhouse.resource.BarCodeResource
     * */
    // FIXME push into a detached thread <--
    public String readBarCode(String base64) throws IOException, NotFoundException {
        val file = FileUtil.createTemp("image");

        FileUtil.convertBase64ToFile(base64, file);

        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(
                ImageIO.read(new FileInputStream(file))
        )));

        Result result = new MultiFormatReader().decode(binaryBitmap);

        return result.getText();
    }
}
