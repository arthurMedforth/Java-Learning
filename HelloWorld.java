public class HelloWorld{

    int age;

    public HelloWorld(int age){
        this.age = age;
    }
    public static void main(String[] args){
        System.out.println("Hello World");
        HelloWorld newHelloWorld = new HelloWorld(22);
        System.out.println(newHelloWorld.age);
        System.out.println("Is this working?");
    }

}