package ru.netology.jdata_homework8_4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persons {

    @EmbeddedId
    private Person person;

    @Column
    private long phoneNumber;

    @Column(length = 50)
    private String cityOfLiving;

}
