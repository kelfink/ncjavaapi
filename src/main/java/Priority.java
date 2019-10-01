import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "priority")
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    //bi-directional many-to-one association to Organization
    @ManyToOne
    @JoinColumn(name="organization_id", nullable = false)
    private Organization organization;


    @Column(name="name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
