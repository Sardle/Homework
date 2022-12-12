package lesson12.practice;

import java.util.Objects;

public class Product {
    private Double price;

    public Product(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
