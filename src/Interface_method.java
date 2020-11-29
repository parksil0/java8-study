public class Interface_method implements Foo{

    public static void main(String[] args) {
        Interface_method test = new Interface_method();
        test.printNameUpperCase();

        //static method 호출
        //Foo.printAnything();

    }

    String name;

    public Interface_method(String name) {
        this.name = name;
    }

    public Interface_method() {}

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    /*
    *  인터페이스에서 기본 메서드로 지정해도 재정의할 수 있다.
    *  지금은 해당 클래스에서 Foo만 implements 했는데, Bar까지 implements 한다면,
    *  기본 메서드 지정과 추상 메서드 지정 간의 충돌로 컴파일 에러가 발생한다.
    *  그럴 경우에는 override 해야한다.
    * */

    @Override
    public void printNameUpperCase() {
        System.out.println("재정의했음.");
    }

}

interface Foo {

    void printName();

    /*
    *  @implSpec
    *  이 구현체는 getName()으로 가져온 문자열을 대문자로 바꾸어 출력한다.
    * */
    default void printNameUpperCase() {
        System.out.println(getName());
    }

    /*
    *  인터페이스의 스태틱 메소드는 구현부가 있어야한다.
    * */
    static void printAnything() {
        System.out.println("hi hello foo");
    }

    String getName();
}

interface Bar extends Foo {

    /*
    *  Foo를 extends한 Bar 인터페이스이다.
    *  Foo의 기본 메서드인 printNameUpperCase()를 기본메서드로 지정하고 싶지 않다면,
    *  Bar에서 추상메서드로 재정의하면 된다.
    *  대신 Bar를 구현한 메소드는 Bar에서 다시 정의한 printNameUpperCase()를 다시 재정의 해야 한다.
    * */
    void printNameUpperCase();
}
