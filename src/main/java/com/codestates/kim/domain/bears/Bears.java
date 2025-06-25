package com.codestates.kim.domain.bears;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="bears")
public class Bears {

    @Id
    @Column(name="bearId", nullable = false)
    private Integer bearId;

    @Column(name="bearName")
    private String bearName;

    @Column(name="bearColor")
    private String bearColor;
}
