package org.oag.securityjparest.repository.region;

import org.oag.securityjparest.entity.region.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<RegionEntity, Long> {
}