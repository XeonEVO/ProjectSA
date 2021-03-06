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
@Table(name="PAYCHECKS")
public class Paychecks {
 @Id
 @SequenceGenerator(name="PAYCHECKS_SEQ",sequenceName="PAYCHECKS_SEQ")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PAYCHECKS_SEQ")
 @Column(name="PAYCHECKS_ID",unique = true, nullable = true)
 private @NonNull Long id;
 private @NonNull String payto;
 @OneToMany(fetch = FetchType.EAGER)
 private Collection<Claim> claim;
    protected Paychecks(){}
    public Paychecks(String payto){
        this.payto = payto;
    }
}