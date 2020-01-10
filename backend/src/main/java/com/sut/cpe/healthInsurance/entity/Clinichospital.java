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
@Table(name="CLINICHOSPITAL")
public class Clinichospital {
 @Id
 @SequenceGenerator(name="CLINICHOSPITAL_SEQ",sequenceName="CLINICHOSPITAL_SEQ")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CLINICHOSPITAL_SEQ")
 @Column(name="CLINICHOSPITAL_ID",unique = true, nullable = true)
 private @NonNull Long id;
 private @NonNull String clinichospitalName;

 @OneToMany(fetch = FetchType.EAGER)
    
 private Collection<Hospital> data;

 protected Clinichospital(){}
 public Clinichospital(String clinichospitalName ){
     this.clinichospitalName = clinichospitalName;
     }
}