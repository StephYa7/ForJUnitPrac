package Shop;

import java.util.Objects;

public class Product {
    private Integer cost;
    private String title;

    public Product(Integer cost, String title) {
        this.cost = cost;
        this.title = title;
    }

    public Product() {

    }

    // Геттеры, сеттеры:
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getCost(), product.getCost()) && Objects.equals(getTitle(), product.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCost(), getTitle());
    }
}