package org.oag.securityjparest.entity.district;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;
import org.oag.securityjparest.entity.region.RegionEntity;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@PackagePrivate
@Entity(name = "district")
public class DistrictEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    String name;
    @ManyToOne
    RegionEntity regionEntity;
}
