package com.sut.cpe.healthInsurance.entity;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
import java.util.Date;
@Data
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="HEALTHINSURANCE")
public class HealthInsurance{
 @Id
 @SequenceGenerator(name="HEALTHINSURANCE_SEQ",sequenceName="HEALTHINSURANCE_SEQ")
 @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="HEALTHINSURANCE_SEQ")
 @Column(name="HEALTHINSURANCE_ID ",unique = true , nullable = true )
 private @NonNull Long id;

 @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
 @JoinColumn(name = "CUSTOMER_ID", insertable = true)
 private Customer customerHealthInsurance;

 @ManyToOne(fetch = FetchType.EAGER,targetEntity = Employee.class)
 @JoinColumn(name = "EMPLOYEE_ID", insertable = true)
 private Employee employee;

 @ManyToOne(fetch = FetchType.EAGER,targetEntity = Insurancetype.class)
 @JoinColumn(name = "INSURANCETYPE_ID",insertable = true)
 private Insurancetype insurancetype;

 @ManyToOne(fetch = FetchType.EAGER,targetEntity = Insurancepackage.class)
 @JoinColumn(name = "INSURANCEPACKAGE_ID",insertable = true)
 private Insurancepackage insurancepackage;

 @ManyToOne(fetch = FetchType.EAGER,targetEntity = Paidtype.class)
 @JoinColumn(name = "PAIDTYPE_ID",insertable = true)
 private Paidtype paidtype;
}

 
