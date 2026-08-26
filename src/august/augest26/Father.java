package august.augest26;
interface Father {

    default void walk() {
        System.out.println("Father");
    }
}

interface Mother {

    default void walk() {
        System.out.println("Mother");
    }
}
