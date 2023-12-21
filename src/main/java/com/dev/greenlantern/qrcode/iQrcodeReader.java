package com.dev.greenlantern.qrcode;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;

public interface iQrcodeReader {
    public String read(MultipartFile filePart);
}
