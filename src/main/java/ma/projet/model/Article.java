package ma.projet.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "articles")
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Double price;
    private Integer quantite;

    @Column(name = "date_expiration")
    private LocalDate dateExpiration;

    public Article() {}

    public Article(String description, Double price, Integer quantite, LocalDate dateExpiration) {
        this.description = description;
        this.price = price;
        this.quantite = quantite;
        this.dateExpiration = dateExpiration;
    }

    public Long getId() { return id; }
    public String getDescription() { return description; }
    public Double getPrice() { return price; }
    public Integer getQuantite() { return quantite; }
    public LocalDate getDateExpiration() { return dateExpiration; }

    public void setId(Long id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(Double price) { this.price = price; }
    public void setQuantite(Integer quantite) { this.quantite = quantite; }
    public void setDateExpiration(LocalDate dateExpiration) { this.dateExpiration = dateExpiration; }
}
