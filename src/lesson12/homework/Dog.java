package lesson12.homework;

public class Dog extends Pet {
    private double weight;

    public double getWeight() {
        return weight;
    }

    public Dog(String name, String breed, double weight) {
        super(name, breed);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dog. Name: " + getName()
                + ". Breed: " + getBreed() + ". Weight: " + getWeight();
    }
}
