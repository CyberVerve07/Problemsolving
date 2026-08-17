package august.Ispprinciple;
class BackendDeveloper implements Developer {

    public void writeCode() {
        System.out.println("Writing code");
    }

    public void test() {
        System.out.println("Testing code");
    }

    public void deploy() {
        // Backend developer doesn't deploy
    }
}
