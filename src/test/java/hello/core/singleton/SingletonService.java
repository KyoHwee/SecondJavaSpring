package hello.core.singleton;

public class SingletonService {
    //싱글톤 자바 코드(싱글톤 방식에서는 값을 변경할 수 있는 필드가 있으면 안된다. 조회 서비스만 제공해야 한다)
    private static final SingletonService instance=new SingletonService();
    //본인 클래스에 본인의 객체를 private static final로 생성하면 단 한개의 객체만이 존재하게 됨
    public static SingletonService getInstance(){
        return instance;
        //다른 클래스에서 SingletonService 객체 받는법
    }
    private SingletonService(){
    }
    //private으로 기초 생성자를 설정하여 타 클래스에서 SingletonService 객체 생성 못하게 한다.
    public void logic(){
        System.out.println("싱글톤 객체 로직");
    }

    public static void main(String[] args) {

    }
}
