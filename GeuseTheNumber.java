import java.util.Random;
import java.util.Scanner;

class Game{
    public int number;
    public int inputnumb;

    Game(){
        Random random=new Random();
        number=random.nextInt(100);
    }
    public void takeInput(){
        Scanner sc=new Scanner(System.in);
        inputnumb=sc.nextInt();

    }
    public boolean iscorrect(){
        if(number==inputnumb){
            System.out.println("Yes you are right");
            return true;
        }
        else if(number>inputnumb){
            System.out.println("Try to big one");
        }
        else if(number<inputnumb){
            System.out.println("Try to small one");
        }return false;
    }
}

public class GeuseTheNumber{
    public static void main(String[] args) {
        Game g=new Game();
        boolean b=false;
        System.out.println("Geuse The Number :\nNumber is in between 1 to 100");
        while(!b){
            g.takeInput();
            b=g.iscorrect();
        }
    }
}