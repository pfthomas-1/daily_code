// SuperStore Exercise: Access Modifiers & Object Modeling Focus

// TODO: Define a class called Product with:
class Product {
    // - A protected String field called name
    protected String name; // protected since Product has child classes

    // - A protected double field called price
    protected double price; // protected since Product has child classes

    // - A private final int productId
    final private int productId; // private because the user shouldn't access or modify productId

    // - A public static int nextId to help generate unique
    public static int nextId = 1; // public because every object of Product and its subclasses use nextId when constructing their ids

    // - A constructor that sets name, price, and assigns a unique ID

    /**
     * Constructor method for Product class
     * @param name The name
     * @param price The price
     */
    public Product(String name, double price) { // Constructors are public for maximum accessibility
        this.name = name;
        this.price = price;
        this.productId = nextId;
        nextId++;
    }

    // - Public getters for all fields
    public String getName() { // getters are public to allow access
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getProductId() {
        return this.productId;
    }

    // - Override toString() to return formatted product details
    /**
     * @return formatted product details
     */
    @Override
    public String toString() { // public for maximum accessibility
        return "Product #" + this.productId + " - " + this.name + " - $" + this.price;
    }

    // - Override equals(Object o) to compare name and productId
    /**
     * compares to Object o
     * if this and o point to the same thing -> true
     * if o isn't a Product (or a subclass) -> false
     * cast o to Product
     * if name.equals(o.name) and productId == o.productId -> true
     * @param o The object being compared to this
     * @return boolean
     */
    @Override
    public boolean equals(Object o) { // public for maximum accessibility
        // Are this and o the same thing?
        if (this == o) return true;

        // What if o isn't a Product?
        if (!(o instanceof  Product)) return false;

        // Cast o to Product so to access name and id
        Product p1 = (Product) o;

        // Are the names and ids the same?
        return ((this.name.equals(p1.name)) && (this.productId == p1.productId));
    }
}


// TODO: Define a subclass Electronics that extends Product
class Electronics extends Product {
    // - Add a private String field called brand
    private String brand;

    // - Add a private boolean field called hasBattery
    private boolean hasBattery;

    // - Constructor takes all fields and uses super for shared ones
    /**
     * Constructor for Electronics subclass of Product
     * @param name The name (for super)
     * @param price The price (for super)
     * @param brand The brand
     * @param hasBattery does it have batteries?
     */
    public Electronics(String name, double price, String brand, boolean hasBattery) { // Constructors are public for maximum accessibility
        super(name, price);
        this.brand = brand;
        this.hasBattery = hasBattery;
    }

    // - Override toString() to include brand and battery status
    @Override
    public String toString() { // public for maximum accessibility
        return "Product #" + this.getProductId() + " - " + this.name + " by " + this.brand + " - $" + this.price + " - batteries? " + this.hasBattery;
    }

    // 3. Add a method to Electronics called warrantyInfo() and mark it final
    public final String warrantyInfo() { // public for maximum accessibility
        return "This " + this.brand + " " + this.name + " has a warranty. For more information check with an employee";
    }
}


// TODO: Define a subclass Grocery that extends Product
class Grocery extends Product {
    // - Add a private double field called weight (in kg)
    private double weight;

    // - Add a private boolean field called isPerishable
    private boolean isPerishable;

    // - Constructor takes all fields and uses super for shared ones
    /**
     * Constructor for Grocery subclass of Product
     * @param name The name (for super)
     * @param price The price (for super)
     * @param weight The weight in kg
     * @param isPerishable Whether it is perishable
     */
    public Grocery(String name, double price, double weight, boolean isPerishable) { // Constructors are public for maximum accessibility
        super(name, price);
        this.weight = weight;
        this.isPerishable = isPerishable;
    }

    // - Override toString() to include weight and perishability
    /**
     * @return formatted product info including weight and perishability
     */
    @Override
    public String toString() { // public for maximum accessibility
        return "Product #" + this.getProductId() + " - " + this.weight + " kg " + this.name + " - $" + this.price + " - perishable? " + this.isPerishable;
    }
}

// TODO: Define a final class Toy that extends Product
final class Toy extends Product {
    // - Add a private int field called minAge
    private int minAge;

    // - Constructor takes all fields and uses super for shared ones

    /**
     * Constructor method for Toy class
     * @param name Product name
     * @param price Product price
     * @param minAge minimum age recommendation
     */
    public Toy(String name, double price, int minAge) { // Constructors are public for maximum accessibility
        super(name, price);
        this.minAge = minAge;
    }

    // - Override toString() to include minAge

    /**
     * method to yield formatted product info
     * @return formatted product info
     */
    @Override
    public String toString() {
        return "Product #" + this.getProductId() + " - " + this.name + " - $" + this.price + " - minimum age: " + this.minAge;
    }
}


// TODO: Define class SuperStoreTest with a main method
class SuperStoreTest {
    public static void main(String[] args) {
        // - Create at least one instance of each subclass
        Product e1 = new Electronics("ePhone", 500.0, "Orange", true);
        Product g1 = new Grocery("Watermelon", 5.0, 1.0, true);
        Product t1 = new Toy("100-Piece Puzzle", 8.50, 8);

        // - Store them in a Product[] array
        Product[] productsArray = {e1, g1, t1};
        // - Loop through and print each item
        for (Product product : productsArray) {
            System.out.println(product);
        }

        // - Call equals() to compare two products with the same ID and name
        Product e2 = e1;
        System.out.println("Product e2 = e1; e1.equals(e2)? " + e1.equals(e2));

        // 2. Make a class Coupon with a final discountRate and apply it to a Product
        System.out.println("=== Apply Coupon to a Product ===");
        Coupon c1 = new Coupon(10.0);
        System.out.println(t1.name + " costs $" + t1.price + " before a 10% coupon is applied and $" + c1.getDiscountRate(t1) + " after");

        // 3. Add a method to Electronics called warrantyInfo() and mark it final
        System.out.println("=== warrantyInfo() ===");
        Electronics electronicsProduct = (Electronics) e1;

        System.out.println(electronicsProduct.warrantyInfo());
    }
}

// Additional TODOs:
// 1. Try to extend Toy — what happens and why?
// Trying to extend Toy causes an error because Toy is a final class

// 2. Make a class Coupon with a final discountRate and apply it to a Product
class Coupon {
    final double discountRate; // Default since coupon doesn't have any child classes

    /**
     * Default Constructor for Coupon, sets discountRate to 0
     */
    public Coupon() { // Constructors are public for maximum accessibility
        this.discountRate = 0;
    }

    /**
     * Constructor for Coupon when a discount as listed
     * @param discountRate the discount rate inputted
     */
    public Coupon(double discountRate) { // Constructors are public for maximum accessibility
        this.discountRate = discountRate;
    }

    /**
     * Method to get the number which a product's price is multiplied by (Example: a 25% off discount would yield 0.75)
     * @param p The Product that the discount is being applied to
     * @return the percent of the price remaining after the coupon is applied, which a products price will be multiplied by
     */
    public double getDiscountRate(Product p) { // public for maximum accessibility
        return p.getPrice() * (1.0 - (this.discountRate / 100));
    }
}

// 4. Use access modifiers appropriately and explain your choices in comments
