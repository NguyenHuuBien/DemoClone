public class DemoShallow implements Cloneable{
    String name;
    String id;
    Address1 address;


    public String toString() {
        return "Student@name=" + name + ",Id=" + id + ",address=" + address.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Address1 {
    String add;

    @Override
    public String toString() {
        return "Address{" +
                "address='" + add + '\'' +
                '}';
    }

}
class Running1 {
    public static void main(String[] args) throws CloneNotSupportedException{
        Address1 address = new Address1();
        address.add = "Ha Noi";

        DemoShallow demoShallow = new DemoShallow();
        demoShallow.name = "Bien";
        demoShallow.id = "123";
        demoShallow.address = address;

        DemoShallow demoShallow1 = (DemoShallow) demoShallow.clone();
        System.out.println(demoShallow.toString());
        System.out.println(demoShallow1.toString());
        System.out.println(demoShallow1.address.hashCode() + "......." + demoShallow.address.hashCode());

        demoShallow1.name = "Bieng";
        demoShallow1.id = "234";
        demoShallow1.address.add = "X";
        System.out.println(demoShallow.toString());
        System.out.println(demoShallow1.toString());

        System.out.println(demoShallow1.address.hashCode() + "......." + demoShallow.address.hashCode());
    }
}
