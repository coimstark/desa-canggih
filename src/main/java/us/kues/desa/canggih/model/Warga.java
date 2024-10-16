package us.kues.desa.canggih.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WARGA")
public class Warga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // relation to user
    @OneToOne
    private User user;
    private String nik;
    private String kk;
    private String tempatLahir;
    private String tanggalLahir;
    private String alamat;

    @Enumerated(EnumType.STRING)
    private WargaStatus status;

}
