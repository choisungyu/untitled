public class User {
    String name;
    String lastPhoneNumber;
    int point;

    public User(String name, String lastPhoneNumber, int point) {
        this.name = name;
        this.lastPhoneNumber = lastPhoneNumber;
        this.point = point;
    }

    @Override
    public String toString() {
        return name+" 님"+"안녕하세요~ 포인트 현황: "+point+"입니다.\n";
    }
}