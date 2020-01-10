package com.sut.cpe.healthInsurance.entity;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Data
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name="CUREBY")
public class Cureby {
 @Id
 @SequenceGenerator(name="CUREBY_SEQ",sequenceName="CUREBY_SEQ")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CUREBY_SEQ")
 @Column(name="CUREBY_ID",unique = true, nullable = true)
 private @NonNull Long id;
 private @NonNull String curemeth;
 @OneToMany(fetch = FetchType.EAGER)
 private Collection<Claim> claim;
    protected Cureby(){}
    public Cureby(String curemeth ){
        this.curemeth = curemeth;
        }
}