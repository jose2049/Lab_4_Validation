package ie.atu.lab4validation.module;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import javax.xml.validation.Schema;

@Getter
@Setter
public class Product {
    //@Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "Product name required")
    private String name;

    @Positive(message = "Price must be greater than zero")
    private double price;
}

