package org.oag.securityjparest.entity.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;
import org.oag.securityjparest.entity.group.GroupEntity;
import org.oag.securityjparest.entity.state.StateEntity;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@PackagePrivate
@Entity(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String firstName;
    @Column(nullable = false)
    String lastName;
    @ManyToOne
    GroupEntity groupEntity;
}
