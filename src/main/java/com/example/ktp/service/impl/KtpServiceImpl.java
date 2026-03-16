package com.example.ktp.service.impl;

import com.example.ktp.dto.KtpDto;
import com.example.ktp.entity.Ktp;
import com.example.ktp.mapper.KtpMapper;
import com.example.ktp.repository.KtpRepository;
import com.example.ktp.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Autowired
    private KtpMapper ktpMapper;

    @Override
    public KtpDto createKtp(KtpDto ktpDto) {
        if (ktpRepository.existsByNomorKtp(ktpDto.getNomorKtp())) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }
        Ktp ktp = ktpMapper.toEntity(ktpDto);
        return ktpMapper.toDto(ktpRepository.save(ktp));
    }

    @Override
    public List<KtpDto> getAllKtp() {
        return ktpRepository.findAll().stream()
                .map(ktpMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public KtpDto getKtpById(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan!"));
        return ktpMapper.toDto(ktp);
    }

    @Override
    public KtpDto updateKtp(Integer id, KtpDto ktpDto) {
        Ktp existingKtp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan!"));

        // Cek duplikasi jika nomor KTP diubah
        if (!existingKtp.getNomorKtp().equals(ktpDto.getNomorKtp()) &&
                ktpRepository.existsByNomorKtp(ktpDto.getNomorKtp())) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }

        existingKtp.setNomorKtp(ktpDto.getNomorKtp());
        existingKtp.setNamaLengkap(ktpDto.getNamaLengkap());
        existingKtp.setAlamat(ktpDto.getAlamat());
        existingKtp.setTanggalLahir(ktpDto.getTanggalLahir());
        existingKtp.setJenisKelamin(ktpDto.getJenisKelamin());

        return ktpMapper.toDto(ktpRepository.save(existingKtp));
    }

    @Override
    public void deleteKtp(Integer id) {
        if (!ktpRepository.existsById(id)) {
            throw new RuntimeException("Data KTP tidak ditemukan!");
        }
        ktpRepository.deleteById(id);
    }
}