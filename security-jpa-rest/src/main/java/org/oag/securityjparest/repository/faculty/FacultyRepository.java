package org.oag.securityjparest.repository.faculty;

import org.oag.securityjparest.entity.faculty.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<FacultyEntity, Long> {
}