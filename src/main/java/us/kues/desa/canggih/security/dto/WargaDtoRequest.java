package us.kues.desa.canggih.security.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Value;
import us.kues.desa.canggih.model.User;
import us.kues.desa.canggih.model.Warga;
import us.kues.desa.canggih.model.WargaStatus;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * DTO for {@link us.kues.desa.canggih.model.Warga}
 */
@Value
public class WargaDtoRequest implements Serializable {
    
    @NotNull(message = "User ID must not be empty")
    Long userId;

    @NotEmpty(message = "NIK must not be empty")
    @Size(min = 16, max = 16, message = "NIK must be 16 characters long")
    String nik;

    @NotEmpty(message = "KK must not be empty")
    @Size(min = 16, max = 16, message = "KK must be 16 characters long")
    String kk;

    @NotEmpty(message = "Tempat lahir must not be empty")
    String tempatLahir;

    @NotEmpty(message = "Tanggal lahir must not be empty")
    String tanggalLahir;

    @NotEmpty(message = "Alamat must not be empty")
    String alamat;

    WargaStatus status;

    public Warga toWarga() {
        return Warga.builder()
                .user(User.builder().id(userId).build())
                .nik(nik)
                .kk(kk)
                .tempatLahir(tempatLahir)
                .tanggalLahir(tanggalLahir)
                .alamat(alamat)
                .status(WargaStatus.PENDING)
                .build();
    }
}
