package July6;

public class Code4 {
    public static void main(String[] args) {
        String name="Ram Ram";
        System.out.println(name.charAt(4));
        System.out.println(name.substring(0,5));
        System.out.println(name.replace("a","A"));

        String add=new String();
        add=name.concat(" Jai Ram ");
        System.out.println(add);
    }
}
