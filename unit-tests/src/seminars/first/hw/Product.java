package seminars.first.hw;

public class Product implements Comparable<Product>{
    private Integer cost; // Стоимость продукта
    private String title; // Название

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int compareTo(Product product) {
        return this.getCost().compareTo(product.getCost());
    }
}
