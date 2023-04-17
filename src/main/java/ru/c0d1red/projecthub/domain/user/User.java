package ru.c0d1red.projecthub.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.c0d1red.projecthub.domain.IdentifiedDomainObject;

@Data
@Entity
@Table(name = "\"user\"")
@AllArgsConstructor
@NoArgsConstructor
public class User extends IdentifiedDomainObject {
    private String username;
    private String password;
}
