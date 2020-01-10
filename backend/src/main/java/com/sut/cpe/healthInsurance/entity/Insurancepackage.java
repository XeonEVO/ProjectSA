package com.sut.cpe.healthInsurance.entity;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Data
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name="INSURANCEPACKAGE")
public class Insurancepackage {
@Id
@SequenceGenerator(name="INSURANCEPACKAGE_SEQ",sequenceName="INSURANCEPACKAGE_SEQ")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="INSURANCEPACKAGE_SEQ")
@Column(name="INSURANCEPACKAGE_ID",unique = true, nullable = true)
private @NonNull Long id;
private @NonNull String pack;
@OneToMany(fetch = FetchType.EAGER)
private Collection<HealthInsurance> healthinsurance;
@OneToMany(fetch = FetchType.EAGER)
private Collection<Claim> Claim;

protected Insurancepackage(){}

public Insurancepackage(String pack){
this.pack = pack;


}
}