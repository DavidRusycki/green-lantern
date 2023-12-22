package com.dev.greenlantern.resources;

import com.dev.greenlantern.domain.entity.QrEntity;
import com.dev.greenlantern.qrcode.provider.Provider;
import com.dev.greenlantern.qrcode.reader.Reader;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/qrcode")
public class QrcodeResource {
    @Autowired
    private Provider provider;
    @Autowired
    private Reader reader;

    @GetMapping(
        path = "/new",
        produces = MediaType.IMAGE_PNG_VALUE
    )
    public byte[] generate(@RequestBody QrEntity qrEntity) {
        return provider.generate(qrEntity.getContent());
    }

    @PostMapping(path = "/read")
    public String generate(@RequestPart(name = "file") MultipartFile filePart) {
        JSONObject response = new JSONObject();
        response.put("content", reader.read(filePart));

        return response.toString();
    }

}
