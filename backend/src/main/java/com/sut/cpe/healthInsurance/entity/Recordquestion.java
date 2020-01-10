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
//import java.util.Date;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "RECORDQUESTION")

public class Recordquestion {
    @Id
    @SequenceGenerator(name = "RECORDQUESTION_SEQ", sequenceName = "RECORDQUESTION_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECORDQUESTION_SEQ")
    @Column(name = "RECORDQUESTION_ID ", unique = true, nullable = true)
    private @NonNull long id;
    private @NonNull String Detail;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Branch.class)
    @JoinColumn(name = "BRANCH_ID", insertable = true, nullable = true)
    private Branch branch;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Contact.class)
    @JoinColumn(name = "CONTACT_ID", insertable = true, nullable = true)
    private Contact contact;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "CUSTOMER_ID", insertable = true, nullable = true)
    private Customer createdBy;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Heading.class)
    @JoinColumn(name = "HEADING_ID", insertable = true, nullable = true)
    private Heading heading;

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        this.Detail = detail;
    }




}
