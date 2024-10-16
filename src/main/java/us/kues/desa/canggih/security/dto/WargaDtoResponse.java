package us.kues.desa.canggih.security.dto;

import lombok.Value;
import us.kues.desa.canggih.model.Warga;
import us.kues.desa.canggih.model.WargaStatus;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO for {@link us.kues.desa.canggih.model.Warga}
 */
@Value
public class WargaDtoResponse implements Serializable {
    Long id;
    UserDto user;
    String nik;
    String kk;
    String tempatLahir;
    String tanggalLahir;
    String alamat;
    WargaStatus status;

    /**
     * DTO for {@link us.kues.desa.canggih.model.User}
     */
    @Value
    public static class UserDto implements Serializable {
        String name;
        String email;
    }

    public static WargaDtoResponse fromWarga(Warga warga) {
        return new WargaDtoResponse(
                warga.getId(),
                new UserDto(warga.getUser().getName(), warga.getUser().getEmail()),
                warga.getNik(),
                warga.getKk(),
                warga.getTempatLahir(),
                warga.getTanggalLahir(),
                warga.getAlamat(),
                warga.getStatus()
        );
    }

    public static List<WargaDtoResponse> fromWargaList(List<Warga> wargaList) {
        return wargaList.stream()
                .map(WargaDtoResponse::fromWarga)
                .collect(Collectors.toList());
    }
}
