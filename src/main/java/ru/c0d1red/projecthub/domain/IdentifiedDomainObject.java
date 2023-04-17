package ru.c0d1red.projecthub.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class IdentifiedDomainObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
