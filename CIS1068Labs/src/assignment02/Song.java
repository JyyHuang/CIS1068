package assignment02;
/*Joey Huang
 * CIS1068
 * Section 003
 * 09/08/2023
 * Assignment 2. Get You a Cat
 * 
 * This program prints verses from a song called Bought Me a Cat.
 */

public class Song {
    public static void animalTemplate(String animal) {
        System.out.printf("Bought me a %s and the %s pleased me,\nI fed my %s under yonder tree.\n",
                animal, animal, animal);
    }

    public static void animalSound(String animal, String sound) {
        String animalUpperCased = animal.substring(0, 1).toUpperCase() + animal.substring(1);
        if (animal.toLowerCase() != "cat") {
            System.out.printf("%s goes %s, %s,\n", animalUpperCased, sound, sound);
        } else {
            System.out.printf("%s goes %s.\n", animalUpperCased, sound, sound);
        }
    }
    
    public static void catGoes() {
        animalSound("cat", "fiddle-i-fee");
    }

    public static void henGoes() {
        animalSound("hen", "chimmy-chuck");
        catGoes();
    }

    public static void duckGoes() {
        animalSound("duck", "quack");
        henGoes();
    }

    public static void gooseGoes() {
        animalSound("goose", "hissy");
        duckGoes();
    }

    public static void sheepGoes() {
        animalSound("sheep", "baa");
        gooseGoes();
    }

    public static void pigGoes() {
        animalSound("pig", "oink");
        sheepGoes();
    }

    public static void verse1() {
        animalTemplate("cat");
        catGoes();
        System.out.println();
    }

    public static void verse2() {
        animalTemplate("hen");
        henGoes();
        System.out.println();
    }

    public static void verse3() {
        animalTemplate("duck");
        duckGoes();
        System.out.println();
    }

    public static void verse4() {
        animalTemplate("goose");
        gooseGoes();
        System.out.println();
    }

    public static void verse5() {
        animalTemplate("sheep");
        sheepGoes();
        System.out.println();
    }

    public static void verse6() {
        animalTemplate("pig");
        pigGoes();
    }

    public static void main(String[] args) {
        verse1();
        verse2();
        verse3();
        verse4();
        verse5();
        verse6();
    }
}
