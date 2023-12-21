package com.dev.greenlantern.qrcode;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.InputStream;
import java.util.Base64;

@Component
public class Reader implements iQrcodeReader {
    @Override
    public String read(MultipartFile filePart) {
        String content = "";

        try (InputStream fis = filePart.getInputStream()) {
            BinaryBitmap binaryBitmap = new BinaryBitmap(
                new HybridBinarizer(
                    new BufferedImageLuminanceSource(
                        ImageIO.read(fis)
                    )
                )
            );

            Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap);
            byte[] contentBytes = Base64.getDecoder().decode(qrCodeResult.getText());
            content = new String(contentBytes);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }
}
