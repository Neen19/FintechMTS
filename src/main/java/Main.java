package main.java;



public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl impl = new CreateAnimalServiceImpl();
        try {
            impl.genAnimals();
            System.out.println("\n\n");
            impl.genAnimals(2);
        } catch (ReflectiveOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}

