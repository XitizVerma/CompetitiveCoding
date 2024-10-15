package Temp;

public class Test extends ContructorTesting {

    Test(){
        System.out.println("Inside default cons");
    }

    Test(String name){
        System.out.println("Inside params cons " + name);
    }

    void print(){
        System.out.println("Printing Anything");
    }

    public static void main(String[] args) {

        Test test1 = new Test();
        test1.print();
        Test test2 = new Test("abc");
    }
}

class ContructorTesting {

    ContructorTesting(){
        System.out.println("Another Test Inside default cons");
    }

    ContructorTesting(String name){
        System.out.println("Another Test Inside params cons " + name);
    }

    void print(){
        System.out.println("Printing Anything");
    }

}

class Test3{

    Test3(){
        System.out.println("Aree bhai Inside Test3 ");

    }
}
