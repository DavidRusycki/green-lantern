package com.dev.greenlantern.resources;

import com.dev.greenlantern.domain.entity.QrEntity;
import com.dev.greenlantern.qrcode.Generator;
import com.dev.greenlantern.qrcode.Reader;
import net.glxn.qrgen.javase.QRCode;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/api/v1/qrcode")
public class QrcodeResource {
    @Autowired
    private Generator generator;
    @Autowired
    private Reader reader;

    @GetMapping(
        path = "/new",
        produces = MediaType.IMAGE_PNG_VALUE
    )
    public byte[] generate(@RequestBody QrEntity qrEntity) {
        return generator.generate(qrEntity.getContent());
    }

    @PostMapping(path = "/read")
    public String generate(@RequestPart(name = "file") MultipartFile filePart) {
        JSONObject response = new JSONObject();
        response.put("content", reader.read(filePart));

        return response.toString();
    }

}
