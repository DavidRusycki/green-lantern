package com.dev.greenlantern.resources;

import com.dev.greenlantern.domain.entity.QrEntity;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/api/v1/qrcode")
public class QrcodeResource {

    @GetMapping("/new")
    public String generate(@RequestBody QrEntity qrEntity) {
        File file = QRCode.from(qrEntity.getContent()).file();

        return file.getAbsolutePath();
    }

}
