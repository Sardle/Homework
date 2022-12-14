package lesson12.homework;

public class Cat extends Pet {
    private int countKittens;

    public int getCountKittens() {
        return countKittens;
    }

    public Cat(String name, String breed, int countKittens) {
        super(name, breed);
        this.countKittens = countKittens;
    }

    @Override
    public String toString() {
        return "Cat. Name: " + getName()
                + ". Breed: " + getBreed() + ". Count kittens: " + getCountKittens();
    }
}
