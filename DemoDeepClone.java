public class DemoDeepClone implements Cloneable{
    String name;
    String id;
    Address address;


    public String toString() {
            return "Student@name=" + name + ",Id=" + id + ",address=" + address.toString();
        }

    @Override
    protected DemoDeepClone clone() throws CloneNotSupportedException {
        DemoDeepClone demoDeepClone = (DemoDeepClone) super.clone();
        demoDeepClone.address = this.address.clone();
        return demoDeepClone;
    }
}

class Address implements Cloneable{
    String add;

    @Override
    public String toString() {
        return "Address{" +
                "address='" + add + '\'' +
                '}';
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

}
class Running {
    public static void main(String[] args) throws CloneNotSupportedException{
        Address address = new Address();
        address.add = "Ha Noi";

        DemoDeepClone demoDeepClone = new DemoDeepClone();
        demoDeepClone.name = "Bien";
        demoDeepClone.id = "123";
        demoDeepClone.address = address;

        DemoDeepClone demoDeepClone1 = (DemoDeepClone) demoDeepClone.clone();
        System.out.println(demoDeepClone.toString());
        System.out.println(demoDeepClone1.toString());

        demoDeepClone1.name = "Bieng";
        demoDeepClone1.id = "234";
        demoDeepClone1.address.add = "X";
        System.out.println(demoDeepClone.toString());
        System.out.println(demoDeepClone1.toString());

        System.out.println(demoDeepClone1.address.hashCode() + "......." + demoDeepClone.address.hashCode());
    }
}
