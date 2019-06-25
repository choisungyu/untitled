import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; //
import java.util.Scanner;

public class Main {

    private static Scanner scanner=new Scanner(System.in);
    private static Menu[] HamburgerArray;
    private static Menu[] DrinkArray=new Menu[2];
    private static Menu[] SetMenuArray =new Menu[3];
    private static User[] userArray=new User[100];
    private static User tmpUser = null;
    private static String name;
    private static String lastPhoneNum;
    private static int lastIndex=0;
    private static int menuFlag;

    static {
        HamburgerArray = new Menu[3];
    }

    public static void main(String args[]){

        InitArray();

        while(true){
            getNamePhone();

            if(!UserExist())
                InsertUser();

            selectMenu();
        }
    }

    static void InitArray(){
        for(int i=0; i<100;i++){
            userArray[i]=new User("","",0);
        }
        getHamburgerFile();
        getDrinkFile();
        getSetFile();
    }

    static void getNamePhone(){
        System.out.println("안녕하세요! 먼저 로그인을 해주세요");
        System.out.println("성함입력");
        name=scanner.next();
        System.out.println("번호입력");
        lastPhoneNum=scanner.next();
    }

    private static Boolean UserExist(){
        for(int i=0; i<userArray.length; i++){
            //기존 회원
            if(name.equals(userArray[i].name)&&lastPhoneNum.equals(userArray[i].lastPhoneNumber)){
                System.out.print(userArray[i].name+"님 다시 찾아주셔서 감사합니다");
                tmpUser=userArray[i];
                return true;
            }
        }
        return false;
    }

    private static void InsertUser(){
        System.out.print(name+"님 저희 매장에 처음 오신것을 환영합니다.");
        userArray[lastIndex]=new User(name,lastPhoneNum,0);
        tmpUser=userArray[lastIndex];
        lastIndex++;
    }

    private  static void selectMenu(){
        while (true){
            System.out.println(" 1.고객확인\t 2.메뉴확인 3.주문\t4.회원 로그아웃");
            int flag = scanner.nextInt();
            switch (flag){
                case 1:
                    System.out.print(tmpUser.toString());
                    break;
                case 2:
                    ShowMenu();
                    break;
                case 3:
                    Order();
                    break;


            }
            if(flag ==4){
                break;
            }

        }

    }


    private static void ShowMenu(){

        System.out.println("보실 메뉴를 선택하세요. 1.햄버거\t 2.음료\t 3.세트\n");
        menuFlag=scanner.nextInt();
        if(menuFlag==1){
            for(int i=0; i<HamburgerArray.length;i++){
                System.out.print(i+1+"."+HamburgerArray[i].toString());
            }
        }else if(menuFlag==2){

            for(int i=0; i<DrinkArray.length;i++){
                System.out.print(i+1+"."+DrinkArray[i].toString());
            }
        }else{
            for(int i = 0; i< SetMenuArray.length; i++){
                System.out.print(i+1+"."+ SetMenuArray[i].toString());
            }
        }


    }


    private static void Order(){
        ShowMenu();
        System.out.println("주문하실 제품의 번호를 입력하세요.");
        int selectMenuNum=scanner.nextInt();

        switch (menuFlag){
            case 1:
                System.out.println(HamburgerArray[selectMenuNum-1].name+"를 주문하시겠습니까?");
                System.out.println("1. 예 2. 아니오");
                int orderFlag=scanner.nextInt();
                if(orderFlag==1){
                    tmpUser.point+=(HamburgerArray[selectMenuNum-1].price*0.1);
                    System.out.println("주문이 완료되었습니다.");
                    System.out.println("포인트금액은 결제금액의 10%임을 알려드립니다^^");
                }
                break;
            case 2:
                System.out.println(DrinkArray[selectMenuNum-1].name+"을 주문하시겠습니까?");
                System.out.println("1. 예 2. 아니오");
                orderFlag=scanner.nextInt();
                if(orderFlag==1){
                    tmpUser.point+=(DrinkArray[selectMenuNum-1].price*0.1);
                    System.out.println("주문이 완료되었습니다.");
                    System.out.println("포인트금액은 결제금액의 10%임을 알려드립니다^^");
                }
                break;
            case 3:
                System.out.println(SetMenuArray[selectMenuNum-1].name+"을 주문하시겠습니까?");
                System.out.println("1. 예 2. 아니오");
                orderFlag=scanner.nextInt();
                if(orderFlag==1){
                    tmpUser.point+=(SetMenuArray[selectMenuNum-1].price*0.1);
                    System.out.println("주문이 완료되었습니다.");
                    System.out.println("포인트금액은 결제금액의 10%임을 알려드립니다^^");
                }
                break;
        }
    }
    static void getSetFile(){
        try{
            String s;
            int i=0;
            FileReader fr =new FileReader("C:\\Users\\7\\untitled\\src\\/SetFile.txt");
            BufferedReader reader = new BufferedReader(fr);
            while ((s = reader.readLine()) != null) {
                String[] menuSplit=s.split(",");
                SetMenuArray[i]=new Menu(menuSplit[0],Integer.parseInt(menuSplit[1]));

                i++;
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }

    static void getDrinkFile(){
        try{
            String s;
            int i=0;
            FileReader fr =new FileReader("C:\\Users\\7\\untitled\\src\\/DrinkFile.txt");
            BufferedReader reader = new BufferedReader(fr);
            while ((s = reader.readLine()) != null) {
                String[] menuSplit=s.split(",");
                DrinkArray[i]=new Menu(menuSplit[0],Integer.parseInt(menuSplit[1]));

                i++;
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }
    static void getHamburgerFile(){
        try{
            String s;
            int i=0;
            FileReader fr =new FileReader("C:\\Users\\7\\untitled\\src\\/HamburgerFile.txt");
            BufferedReader reader = new BufferedReader(fr);
            while ((s = reader.readLine()) != null) {
                String[] menuSplit=s.split(",");
                HamburgerArray[i]=new Menu(menuSplit[0],Integer.parseInt(menuSplit[1]));
                i++;
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }

}