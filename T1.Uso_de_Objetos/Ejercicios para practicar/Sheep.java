public class Sheep {

    private String name;

    private int weight;

    public Sheep(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    // copy constructor
    // copies the fields of other into the new object
    public Sheep(Sheep other) {
        this.name = other.name;
        this.weight = other.weight;
    }

    // Main method
    public static void main(String[] args){
        // create a sheep
        Sheep sheep = new Sheep("Dolly", 20);
        // clone the sheep
        Sheep dolly = new Sheep(sheep); // dolly.name is "Dolly" and dolly.weight is 20
    }
}

