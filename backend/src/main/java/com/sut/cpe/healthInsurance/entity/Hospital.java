package com.sut.cpe.healthInsurance.entity;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Collection;
@Data
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="HOSPITAL")

public class Hospital{
    @Id
    @SequenceGenerator(name="HOSPITAL_SEQ",sequenceName="HOSPITAL_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="HOSPITAL_SEQ")
    @Column(name="HOSPITAL_ID ",unique = true , nullable = true )
    private @NonNull Long id;
    private String hname;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Clinichospital.class)
    @JoinColumn(name = "CLINICHOSPITAL_ID",insertable = true)
    private Clinichospital clinichospital;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Hospitaltype.class)
    @JoinColumn(name = "HOSPITALTYPE_ID", insertable = true)
    private Hospitaltype hospitaltype;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Province.class)
    @JoinColumn(name = "PROVINCE_ID",insertable = true)
    private Province province;

    @OneToMany(fetch = FetchType.EAGER)
	private Collection<Claim> Claim;
}