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
@Table(name="HOSPITALTYPE")
public class Hospitaltype {

    @Id
    @SequenceGenerator(name="HOSPITALTYPE_SEQ",sequenceName="HOSPITALTYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="HOSPITALTYPE_SEQ")
    @Column(name="HOSPITALTYPE_ID",unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String hospitaltypeName;

    @OneToMany(fetch = FetchType.EAGER)
    
    private Collection<Hospital> data;

	
    protected Hospitaltype(){}
    public Hospitaltype(String hospitaltypeName ){
        this.hospitaltypeName = hospitaltypeName;
        }	
}
