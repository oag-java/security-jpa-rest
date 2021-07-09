package org.oag.securityjparest.repository.user;

import org.oag.securityjparest.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}