package org.oag.securityjparest.repository.group;

import org.oag.securityjparest.entity.group.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
}