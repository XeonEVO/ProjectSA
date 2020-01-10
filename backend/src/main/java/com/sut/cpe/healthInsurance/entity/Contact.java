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
@Table(name="CONTACT")
public class Contact {
 @Id
 @SequenceGenerator(name="CONTACT_SEQ",sequenceName="CONTACT_SEQ")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CONTACT_SEQ")
 @Column(name="CONTACT_ID",unique = true, nullable = true)
 private @NonNull Long id;
 private @NonNull String contactname;
 @OneToMany(fetch = FetchType.EAGER)
 private Collection<Recordquestion> recordquestion;

 
    protected Contact(){}
    public Contact(String contactname ){
        this.contactname = contactname;
        }
}