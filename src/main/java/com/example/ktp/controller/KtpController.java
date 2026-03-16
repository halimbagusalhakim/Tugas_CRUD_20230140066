package com.example.ktp.controller;

import com.example.ktp.dto.KtpDto;
import com.example.ktp.service.KtpService;
import com.example.ktp.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ktp")
@CrossOrigin(origins = "*") // Penting agar bisa diakses oleh frontend HTML
public class KtpController {

    @Autowired
    private KtpService ktpService;

    @PostMapping
    public ResponseEntity<ApiResponse<KtpDto>> createKtp(@RequestBody KtpDto ktpDto) {
        KtpDto savedKtp = ktpService.createKtp(ktpDto);
        return ResponseEntity.ok(new ApiResponse<>("success", "Data berhasil ditambahkan", savedKtp));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<KtpDto>>> getAllKtp() {
        List<KtpDto> data = ktpService.getAllKtp();
        return ResponseEntity.ok(new ApiResponse<>("success", "Berhasil mengambil data", data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<KtpDto>> getKtpById(@PathVariable Integer id) {
        KtpDto data = ktpService.getKtpById(id);
        return ResponseEntity.ok(new ApiResponse<>("success", "Data ditemukan", data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<KtpDto>> updateKtp(@PathVariable Integer id, @RequestBody KtpDto ktpDto) {
        KtpDto updatedKtp = ktpService.updateKtp(id, ktpDto);
        return ResponseEntity.ok(new ApiResponse<>("success", "Data berhasil diperbarui", updatedKtp));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteKtp(@PathVariable Integer id) {
        ktpService.deleteKtp(id);
        return ResponseEntity.ok(new ApiResponse<>("success", "Data berhasil dihapus", null));
    }
}