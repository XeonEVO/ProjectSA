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
import java.util.Optional;


@Data
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="CLAIM")

public class Claim{
    @Id
    @SequenceGenerator(name="CLAIM_SEQ",sequenceName="CLAIM_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="CLAIM_SEQ")
    @Column(name="CLAIM_ID ",unique = true , nullable = true )
    private @NonNull Long id;

    @Column(name="CLAIM_DATE")
    private @NonNull Date claimDate;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Hospital.class)
    @JoinColumn(name = "HOSPITAL_ID", insertable = true)
    private @NonNull Hospital hospital;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Insurancepackage.class)
    @JoinColumn(name = "INSURANCEPACKAGE_ID",insertable = true)
    private @NonNull Insurancepackage insurancepackage;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Customer.class)
    @JoinColumn(name = "identificationNumber",insertable = true)
    private @NonNull Customer createdBy;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Treatmethod.class)
    @JoinColumn(name ="TREATMETHOD_ID",insertable = true)
    private @NonNull Treatmethod treatmethod;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Paychecks.class)
    @JoinColumn(name =" PAYCHECKS_ID",insertable = true)
    private @NonNull Paychecks paychecks;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Cureby.class)
    @JoinColumn(name =" CUREBY_ID",insertable = true)
    private @NonNull Cureby cureby;

    
        public Claim(Date claimDate ){
            this.claimDate = claimDate;
            }

}