package Products;

public  class Product {
    private String name;
    private ProductType type;
    private int price;
    private int weight;


    public Product(String name, ProductType type, int price, int weight) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }

    public String getName() {
        return name;
    }

    public ProductType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (price != product.price) return false;
        if (weight != product.weight) return false;
        if (!name.equals(product.name)) return false;
        return type.equals(product.type);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + price;
        result = 31 * result + weight;
        return result;
    }


}
