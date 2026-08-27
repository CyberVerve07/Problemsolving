package august.augest26;
interface Father {

    default void walk() {
        System.out.println("Father said to walk");
    }
}

interface Mother {

    default void walk() {
        System.out.println("Mother said to walk ");
    }
}
