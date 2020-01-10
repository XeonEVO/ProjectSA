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
@Table(name="PAIDTYPE")
public class Paidtype {
@Id
@SequenceGenerator(name="PAIDTYPE_SEQ",sequenceName="PAIDTYPE_SEQ")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PAIDTYPE_SEQ")
@Column(name="PAIDTYPE_ID",unique = true, nullable = true)
private @NonNull Long id;
private @NonNull String paid;
private @NonNull int price;
@OneToMany(fetch = FetchType.EAGER)
private Collection<HealthInsurance> healthinsurance;
protected Paidtype(){}
public Paidtype(String paid,int price){
 this.paid = paid;
 this.price = price;
}
}