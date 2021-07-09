package org.oag.securityjparest.entity.university;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;
import org.oag.securityjparest.entity.district.DistrictEntity;


import javax.persistence.*;

@Entity(name = "university")
@AllArgsConstructor
@NoArgsConstructor
@Data
@PackagePrivate
public class UniversityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    String name;
    @ManyToOne
    DistrictEntity districtEntity;

}
