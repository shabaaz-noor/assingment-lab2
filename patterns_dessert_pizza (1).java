import java.util.*;


abstract class PizzaStore {
//     SimplePizzaFactory factory;
//     public PizzaStore(SimplePizzaFactory factory) {
//         this.factory = factory;
//  }

public Pizza orderPizza(String type) {
    Pizza pizza;
    pizza = createPizza(type);
    pizza.prepare();
    pizza.boil();
    pizza.bake();
    pizza.cut();
    pizza.box();
    return pizza;
}
    protected abstract Pizza createPizza(String type);

}


// Implementing Factory pattern
class DessertPizzaStore extends PizzaStore {
    protected Pizza createPizza(String item) {
    if (item.equals("vanilla")) {
    return new DessertStylePizza();
    } else return null;
    }
}


class DessertStylePizza extends Pizza {
    public DessertStylePizza() {
    name = "Dessert Style Deep Dish Pizza";
    dough = "Extra Thick Crust Dough";
    sauce = "Creamy Sweet Vanilla Sauce";
    toppings.add("Shredded Chocolate Balls");
    }
    void cut() {
    System.out.println("Cutting the pizza into traingle slices");
    }
}

abstract class Pizza {
    String name;
    String dough;
    String sauce;
    // Implemeting Singleton Pattern
    private static VanillaBoiler uniqueInstance;
    private VanillaBoiler() {
        boiled = false;
    }
    public static ChocolateBoiler getInstance() {
        if (uniqueInstance == null) {
        uniqueInstance = new VanillaBoiler();
        }
        return uniqueInstance;
    }
    
    ArrayList<String> toppings = new ArrayList<String>();
    void prepare() {
    System.out.println("Preparing " + name);
    System.out.println("Tossing dough...");
    System.out.println("Adding sauce...");
    System.out.println("Adding toppings: ");
    for (int i = 0; i < toppings.size(); i++) {
    System.out.println(" " + toppings.get(i));
    }
    }
    void boil() {
    System.out.println("Boil Vanilla for 10 mins for dessert");
    }
    void bake() {
    System.out.println("Bake for 25 minutes at 350");
    }
    void cut() {
    System.out.println("Cutting the pizza into diagonal slices");
    }
   
    void box() {
    System.out.println("Place pizza in official PizzaStore box");
    }
    public String getName() {
    return name;
    }
}


public class patterns_dessert_pizza {
    public static void main(String[] args) {
        PizzaStore chicagoStore = new DessertPizzaStore();
        Pizza pizza = chicagoStore.orderPizza("vanilla");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");
        pizza = chicagoStore.orderPizza("vanilla");
        System.out.println("Joel ordered a"+ pizza.getName() + "\n");
        }
}