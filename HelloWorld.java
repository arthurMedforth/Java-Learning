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

        int[][] numbers = {{1,2,3},{3,4,5}};
        System.out.println(numbers[1][1]);
    }

}