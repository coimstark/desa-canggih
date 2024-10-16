package us.kues.desa.canggih.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.kues.desa.canggih.model.User;
import us.kues.desa.canggih.model.Warga;

import java.util.List;

import us.kues.desa.canggih.repository.UserRepository;
import us.kues.desa.canggih.repository.WargaRepository;
import us.kues.desa.canggih.security.dto.WargaDtoRequest;
import us.kues.desa.canggih.security.dto.WargaDtoResponse;
import us.kues.desa.canggih.utils.GeneralMessageAccessor;

/**
 * Implementation of WargaService interface.
 * Provides business logic for handling warga-related operations.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WargaServiceImpl implements WargaService {
    
    @Autowired
    private final WargaRepository wargaRepository;

    @Autowired
    private final UserRepository userRepository;

    @Override
    public WargaDtoResponse findById(Long wargaId) {
        Warga warga = wargaRepository.findById(wargaId).orElse(null);
        if (warga == null) {
            log.error("Warga with ID {} not found", wargaId);
            return null;
        }
        return WargaDtoResponse.fromWarga(warga);
    }

    @Override
    public Warga save(WargaDtoRequest wargaDtoRequest) {
        Warga warga = wargaDtoRequest.toWarga();
        return wargaRepository.save(warga);
    }

    @Override
    public List<WargaDtoResponse> findAll() {
        List<Warga> wargaList = wargaRepository.findAll();
        return WargaDtoResponse.fromWargaList(wargaList);
    }

    @Override
    public Warga update(Warga warga, Long wargaId) {
        Warga existingWarga = wargaRepository.findById(wargaId).orElse(null);
        if (existingWarga == null) {
            log.error("Warga with ID {} not found", wargaId);
            return null;
        }
        existingWarga.setUser(warga.getUser());
        existingWarga.setNik(warga.getNik());
        existingWarga.setAlamat(warga.getAlamat());
        existingWarga.setKk(warga.getKk());
        existingWarga.setTempatLahir(warga.getTempatLahir());
        existingWarga.setTanggalLahir(warga.getTanggalLahir());
        existingWarga.setStatus(warga.getStatus());
        return wargaRepository.save(existingWarga);
    }

    @Override
    public void delete(Long wargaId) {
        wargaRepository.deleteById(wargaId);
    }

    @Override
    public Warga findByUserId(Long userId) {
        return wargaRepository.findByUserId(userId);
    }
}
