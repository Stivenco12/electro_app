package electro_app.electro_app.domain.entities;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Table(name = "regions")
@Entity
public class region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true, unique = true)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_country")
    @JsonBackReference
    private Country idCountry;

    @Column(name = "name_Regions", length = 50, nullable = true, unique = true)
    private String nameRegion;

    @OneToMany(mappedBy = "idRegion",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<City> cities = new HashSet<>();
}
