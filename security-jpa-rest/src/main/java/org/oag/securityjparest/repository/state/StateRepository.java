package org.oag.securityjparest.repository.state;

import org.oag.securityjparest.entity.state.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<StateEntity, Long> {
    boolean existsByName(String name);
}