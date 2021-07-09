package org.oag.securityjparest.repository.student;

import org.oag.securityjparest.entity.student.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}