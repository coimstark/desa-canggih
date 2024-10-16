package us.kues.desa.canggih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import us.kues.desa.canggih.model.Warga;


public interface WargaRepository extends JpaRepository<Warga, Long> {

    Warga findByUserId(Long userId);
}
