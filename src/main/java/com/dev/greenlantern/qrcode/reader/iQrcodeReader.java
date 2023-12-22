package com.dev.greenlantern.qrcode.reader;

import org.springframework.web.multipart.MultipartFile;

public interface iQrcodeReader {
    public String read(MultipartFile filePart);
}
