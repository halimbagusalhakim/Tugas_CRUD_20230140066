package com.example.ktp.service;

import com.example.ktp.dto.KtpDto;
import java.util.List;

public interface KtpService {
    KtpDto createKtp(KtpDto ktpDto);
    List<KtpDto> getAllKtp();
    KtpDto getKtpById(Integer id);
    KtpDto updateKtp(Integer id, KtpDto ktpDto);
    void deleteKtp(Integer id);
}