package guru.springframework.domain;

import gov.nasa.jpf.symbc.Debug;

import java.math.BigDecimal;

public class Product {

    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // @Version
    private Integer version;

    private String productId;
    private String description;
    private String imageUrl;
    private BigDecimal price;

    // Default constructor
    public Product() {}

    // Symbolic constructor for JPF
    public Product(Integer id) {
        this.id = id;
        this.version = Debug.makeSymbolicInteger("version");
        this.productId = Debug.makeSymbolicString("productId");
        this.description = Debug.makeSymbolicString("description");
        this.imageUrl = Debug.makeSymbolicString("imageUrl");
        this.price = new BigDecimal(10); // symbolic values for BigDecimal aren't supported directly
    }

    // Copy constructor (optional, useful in symbolic state tracking)
    public Product(Product p) {
        this.id = p.id;
        this.version = p.version;
        this.productId = p.productId;
        this.description = p.description;
        this.imageUrl = p.imageUrl;
        this.price = p.price;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // equals and hashCode (based on id)
    //@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;
        return id != null && id.equals(product.id);
    }

    //@Override
    public int hashCode() {
        return (id != null) ? id.hashCode() : 0;
    }
}

