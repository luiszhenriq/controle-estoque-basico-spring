package br.com.luis.estoque.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int quantity;

    public Product(ProductRegisterData data) {
        this.name = data.name();
        this.quantity = data.quantity();
    }

    public void updateProduct(ProductUpdateData data) {

        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.quantity() != 0) {
            this.quantity = data.quantity();
        }
    }
}
