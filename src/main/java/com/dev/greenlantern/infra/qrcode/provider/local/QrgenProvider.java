package com.dev.greenlantern.infra.qrcode.provider.local;

import com.dev.greenlantern.qrcode.provider.iQrcodeProvider;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

@Component
public class QrgenProvider implements iQrcodeProvider {
    @Override
    public byte[] generate(String content) {
        byte[] base64Bytes = Base64.getEncoder().encode(content.getBytes());
        File file = QRCode.from(new String(base64Bytes)).file();
        byte[] fileBytes = null;

        try (FileInputStream fis = new FileInputStream(file)) {
            fileBytes = fis.readAllBytes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return fileBytes;
    }
}
