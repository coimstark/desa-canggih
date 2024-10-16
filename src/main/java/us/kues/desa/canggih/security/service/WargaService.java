package us.kues.desa.canggih.security.service;

import us.kues.desa.canggih.model.Warga;
import us.kues.desa.canggih.security.dto.WargaDtoRequest;
import us.kues.desa.canggih.security.dto.WargaDtoResponse;

import java.util.List;

/**
 * Service interface for Warga entity.
 * Defines methods for CRUD operations and additional business logic.
 */
public interface WargaService {

        /**
         * Fetches a Warga entity by its ID.
         * @param wargaId the ID of the warga to fetch
         * @return the warga entity
         */
        WargaDtoResponse findById(Long wargaId);

        /**
         * Saves a Warga entity.
         * @param warga the warga to save
         * @return the saved warga
         */
        Warga save(WargaDtoRequest warga);

        /**
         * Fetches the list of all warga entities.
         * @return a list of wargas
         */
        List<WargaDtoResponse> findAll();
        
        /**
        * Updates an existing warga entity.
        * @param warga the warga with updated information
        * @param wargaId the ID of the warga to update
        * @return the updated warga
        */

        Warga update(Warga warga, Long wargaId);

        /**
         * Deletes a warga entity by its ID.
         * @param wargaId the ID of the warga to delete
         */
        void delete(Long wargaId);

        /**
         * Fetches a Warga entity by its user ID.
         * @param userId the ID of the user
         * @return the warga entity
         */
        Warga findByUserId(Long userId);

        
}
