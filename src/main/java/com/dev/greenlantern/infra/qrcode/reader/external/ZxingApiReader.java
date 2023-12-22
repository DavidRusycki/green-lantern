package com.dev.greenlantern.infra.qrcode.reader.external;

import com.dev.greenlantern.qrcode.reader.iQrcodeReader;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ZxingApiReader implements iQrcodeReader {
    @Override
    public String read(MultipartFile filePart) {
        throw new RuntimeException("Not implemented");
    }
}
