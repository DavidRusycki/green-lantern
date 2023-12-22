package com.dev.greenlantern.qrcode.reader;

import com.dev.greenlantern.infra.qrcode.reader.local.ZxingReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Reader {
    @Autowired
    private ZxingReader reader;

    public String read(MultipartFile filePart) {
        return reader.read(filePart);
    }
}
