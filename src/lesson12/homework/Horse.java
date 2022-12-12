package lesson12.homework;

public class Horse extends Pet {
    private double height;

    public double getHeight() {
        return height;
    }

    public Horse(String name, String breed, double height) {
        super(name, breed);
        this.height = height;
    }

    @Override
    public String toString() {
        return "Horse. Name: " + getName()
                + ". Breed: " + getBreed() + ". Height: " + getHeight();
    }
}
