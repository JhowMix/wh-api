package br.com.wrhouse.repository;

import br.com.wrhouse.model.Image;
import br.com.wrhouse.util.FileUtil;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;

import javax.enterprise.context.ApplicationScoped;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

@ApplicationScoped
public class ImageRepository implements PanacheRepository<Image> {

    public void create(InputPart inputPart) throws IOException {
        try (InputStream inputStream = inputPart.getBody(InputStream.class, null)) {
            byte[] data = IOUtils.toByteArray(inputStream);

            Image image = new Image();
            image.setTitle("item-");
        }
    }
}
