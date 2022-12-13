package lesson12.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class AppPet {
    private static HashMap<String, Pet> mapPets = fillMapOfPet();

    public static void main(String[] args) {
        beginAppPet();
    }

    private static boolean deletePet(String name) {
        if (mapPets.containsKey(name)) {
            mapPets.remove(name);
            return true;
        }
        return false;
    }

    private static String enterNamePet() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the name pet: ");
        try {
            String name = bufferedReader.readLine();
            return name;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void beginAppPet() {
        if (mapPets.isEmpty()) {
            System.out.println("All pets have been removed!");
        } else if (deletePet(enterNamePet())) {
            System.out.println("The pet has been removed!\n");
            printInfo(mapPets);
            beginAppPet();
        } else {
            System.out.println("\nInvalid input. Try again!");
            beginAppPet();
        }
    }

    private static HashMap<String, Pet> fillMapOfPet() {
        Pet cat = new Cat("Alex", "egyptian", 5);
        Pet dog = new Dog("Qwerty", "husky", 17);
        Pet horse = new Horse("Fast", "arabian", 180);
        Pet catMya = new Cat("Mya", "british", 0);
        Pet dogSharik = new Dog("Sharik", "sheepdog", 19);

        HashMap<String, Pet> mapPets = new HashMap<>();
        mapPets.put(cat.getName(), cat);
        mapPets.put(dog.getName(), dog);
        mapPets.put(horse.getName(), horse);
        mapPets.put(catMya.getName(), catMya);
        mapPets.put(dogSharik.getName(), dogSharik);
        printInfo(mapPets);
        return mapPets;
    }

    private static void printInfo(HashMap<String, Pet> mapPets) {
        for (Pet pet : mapPets.values()) {
            System.out.println(pet.toString());
        }
    }
}
