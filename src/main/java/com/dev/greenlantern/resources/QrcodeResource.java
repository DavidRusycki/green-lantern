package com.dev.greenlantern.resources;

import com.dev.greenlantern.domain.entity.QrEntity;
import com.dev.greenlantern.qrcode.Generator;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(
        path = "/new",
        produces = MediaType.IMAGE_PNG_VALUE
    )
    public byte[] generate(@RequestBody QrEntity qrEntity) {
        return generator.generate(qrEntity.getContent());
    }

}
