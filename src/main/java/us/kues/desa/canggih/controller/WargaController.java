package us.kues.desa.canggih.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import us.kues.desa.canggih.model.User;
import us.kues.desa.canggih.model.Warga;
import us.kues.desa.canggih.repository.UserRepository;
import us.kues.desa.canggih.security.dto.WargaDtoRequest;
import us.kues.desa.canggih.security.dto.WargaDtoResponse;
import us.kues.desa.canggih.security.service.WargaService;

import java.util.List;

/**
 * REST controller for managing Warga entities.
 * Handles HTTP requests and routes them to the appropriate service methods.
 */
@RestController
@RequiredArgsConstructor
public class WargaController {
    @Autowired
    private final WargaService wargaService;
    @Autowired
    private final UserRepository userRepository;
    /**
     * Handles GET requests to fetch a warga entity by its ID.
     * @param wargaId the ID of the warga to fetch
     * @return the warga entity
     */
    @GetMapping("/warga/{wargaId}")
    public WargaDtoResponse getWarga(@PathVariable Long wargaId) {
        return wargaService.findById(wargaId);
    }
    

    /**
     * Handles POST requests to save a new warga.
     * @param warga the warga entity to be saved
     * @return the saved warga entity
     */
    @PostMapping("/warga")
    public ResponseEntity<Warga> saveWarga(@Valid @RequestBody WargaDtoRequest warga) {
        User user = userRepository.findById(warga.getUserId()).orElse(null);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        // check whether the user is already a warga
        if (wargaService.findByUserId(user.getId()) != null) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(wargaService.save(warga));
    }

    /**
     * Handles GET requests to fetch all warga entities.
     * @return a list of warga entities
     */
    @GetMapping("/warga")
    public List<WargaDtoResponse> getAllWarga() {
        return wargaService.findAll();
    }

    /**
     * Handles PATCH requests to update an existing warga entity.
     * @param warga the updated warga entity
     * @param wargaId the ID of the warga to update
     * @return the updated warga entity
     */
    @PatchMapping("/warga/{wargaId}")
    public Warga updateWarga(@Valid @RequestBody Warga warga, Long wargaId) {
        return wargaService.update(warga, wargaId);
    }

    /**
     * Handles DELETE requests to delete a warga entity by its ID.
     * @param wargaId the ID of the warga to delete
     */
    @DeleteMapping("/warga/{wargaId}")
    public void deleteWarga(@PathVariable Long wargaId) {
        wargaService.delete(wargaId);
    }
}
