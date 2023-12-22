package com.dev.greenlantern.qrcode.provider;

import com.dev.greenlantern.infra.qrcode.provider.local.QrgenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Provider {
    @Autowired
    private QrgenProvider provider;

    public byte[] generate(String content) {
        return provider.generate(content);
    }
}
