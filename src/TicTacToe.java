import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    // Computer goes first
    static Scanner in = new Scanner(System.in);
    static String cpuToken;
    static String name;
    static String choice;
    static String[] boardIndex={"1","2","3","4","5","6","7","8","9"};
    static boolean[] isEmpty= new boolean[]{true,true,true,true,true,true,true,true,true};
    static int turns =0;
    static boolean hasWon=false;
    static boolean playAgain= true;
    static String again;
    static String winStatement="Congrats, %s, You have won the game.";
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("What is your name?");
        name=in.next();


        while(playAgain){
            System.out.println("Do you want to be X or O?");
            choice= in.next().toUpperCase();
            if(choice.equals("X"))
            {
                cpuToken="O";
            }
            else if(choice.equals("O"))
            {
                cpuToken="X";
            }
            else
            {
                System.out.println("Choose a X or an O");
                while(!choice.equals("X")&&!choice.equals("O"))
                {
                    choice = in.next();
                }
            }
            int x=0;
        while(x<=9) {
            if(!winGame()){
           int moves= turns%2==0?rand.nextInt(9)+1:in.nextInt();
           while(moves>=10)
           {
               System.out.println("Choose number between 1-9");
               moves=in.nextInt();
           }


           while(!isEmpty[moves-1])
           {
               if(turns%2==0)
               {
                  moves= rand.nextInt(9)+1;
               }else
                   {
                       System.out.println("Try Again Choose between space 1-9");
                        moves= in.nextInt();
                   }
           }
           makeMove(moves);
            printGame();
            System.out.println("");
            x++;
        }
            else{
            break;}
            if (x==9)
            {
                System.out.println("Cat game");
                break;
            }
        }
            System.out.println("Do you want to play again (Yes or No)");
            again=in.next().toLowerCase();
            if(again.equals("no"))
            {
                playAgain=false;
            }
            else if(again.equals("yes"))
            {
                playAgain=true;
                hasWon=false;
                reset();
                turns=0;

            }
            else
                {
                    while(!again.equals("no")&&!again.equals("yes"))
                    {
                        System.out.println("Try again");
                        again=in.next();
                    }
                }
        }
    }
    public static void makeMove(int move)
    {
        if(boardIndex[move-1]!="X"&& boardIndex[move-1]!="O")
        boardIndex[move-1] = turns%2==0?cpuToken:choice;
        isEmpty[move-1]=false;
        turns++;
    }
    public static boolean winGame()
    {
        if(boardIndex[0].equals(choice) && boardIndex[1].equals(choice) && boardIndex[2].equals(choice))// [1,1,1,0,0,0,0,0,0]
        {
            System.out.println(String.format(winStatement,name));
            hasWon=true;
        }
        else if(boardIndex[3].equals(choice) && boardIndex[4].equals(choice) && boardIndex[5].equals(choice))// [0,0,0,1,1,1,0,0,0]
        {
            System.out.println(String.format(winStatement,name));
            hasWon=true;
        }
        else if(boardIndex[6].equals(choice) && boardIndex[7].equals(choice) && boardIndex[8].equals(choice))// [0,0,0,0,0,0,1,1,1]
        {
            System.out.println(String.format(winStatement,name));
            hasWon=true;
        }
        else if(boardIndex[0].equals(choice) && boardIndex[3].equals(choice) && boardIndex[6].equals(choice))// [1,0,0,1,0,0,1,0,0]
        {
            System.out.println(String.format(winStatement,name));
            hasWon=true;
        }
        else if(boardIndex[1].equals(choice) && boardIndex[4].equals(choice) && boardIndex[7].equals(choice))// [0,1,0,0,1,0,0,1,0]
        {
            System.out.println(String.format(winStatement,name));
            hasWon=true;
        }
        else if(boardIndex[2].equals(choice) && boardIndex[5].equals(choice) && boardIndex[8].equals(choice))// [0,0,1,0,0,1,0,0,1]
        {
            System.out.println(String.format(winStatement,name));
            hasWon=true;
        }
        else if(boardIndex[0].equals(choice) && boardIndex[4].equals(choice) && boardIndex[8].equals(choice))// [1,0,0,0,1,0,0,0,1]
        {
            System.out.println(String.format(winStatement,name));
            hasWon=true;
        }
        else if(boardIndex[2].equals(choice) && boardIndex[4].equals(choice) && boardIndex[6].equals(choice))// [0,0,1,0,1,0,1,0,0]
        {
            System.out.println(String.format(winStatement,name));
            hasWon=true;
        }

        else if(boardIndex[0].equals(cpuToken) && boardIndex[1].equals(cpuToken) && boardIndex[2].equals(cpuToken))// [1,1,1,0,0,0,0,0,0]
        {
            System.out.println(String.format(winStatement,"Computer"));
            hasWon=true;
        }
        else if(boardIndex[3].equals(cpuToken) && boardIndex[4].equals(cpuToken) && boardIndex[5].equals(cpuToken))// [0,0,0,1,1,1,0,0,0]
        {
            System.out.println(String.format(winStatement,"Computer"));
            hasWon=true;
        }
        else if(boardIndex[6].equals(cpuToken) && boardIndex[7].equals(cpuToken) && boardIndex[8].equals(cpuToken))// [0,0,0,0,0,0,1,1,1]
        {
            System.out.println(String.format(winStatement,"Computer"));
            hasWon=true;
        }
        else if(boardIndex[0].equals(cpuToken) && boardIndex[3].equals(cpuToken) && boardIndex[6].equals(cpuToken))// [1,0,0,1,0,0,1,0,0]
        {
            System.out.println(String.format(winStatement,"Computer"));
            hasWon=true;
        }
        else if(boardIndex[1].equals(cpuToken) && boardIndex[4].equals(cpuToken) && boardIndex[7].equals(cpuToken))// [0,1,0,0,1,0,0,1,0]
        {
            System.out.println(String.format(winStatement,"Computer"));
            hasWon=true;
        }
        else if(boardIndex[2].equals(cpuToken) && boardIndex[5].equals(cpuToken) && boardIndex[8].equals(cpuToken))// [0,0,1,0,0,1,0,0,1]
        {
            System.out.println(String.format(winStatement,"Computer"));
            hasWon=true;
        }
        else if(boardIndex[0].equals(cpuToken) && boardIndex[4].equals(cpuToken) && boardIndex[8].equals(cpuToken))// [1,0,0,0,1,0,0,0,1]
        {
            System.out.println(String.format(winStatement,"Computer"));
            hasWon=true;
        }
        else if(boardIndex[2].equals(cpuToken) && boardIndex[4].equals(cpuToken) && boardIndex[6].equals(cpuToken))// [0,0,1,0,1,0,1,0,0]
        {
            System.out.println(String.format(winStatement,"Computer"));
            hasWon=true;
        }

        return hasWon;
    }
    public static void printGame()
    {
        String board=String.format("""
                 %s |%s |%s
                ----------
                 %s |%s |%s
                ----------
                 %s |%s |%s""",


                boardIndex[0].equals("1")?" ":boardIndex[0],
                boardIndex[1].equals("2")?" ":boardIndex[1],
                boardIndex[2].equals("3")?" ":boardIndex[2],
                boardIndex[3].equals("4")?" ":boardIndex[3],
                boardIndex[4].equals("5")?" ":boardIndex[4],
                boardIndex[5].equals("6")?" ":boardIndex[5],
                boardIndex[6].equals("7")?" ":boardIndex[6],
                boardIndex[7].equals("8")?" ":boardIndex[7],
                boardIndex[8].equals("9")?" ":boardIndex[8]



                );
        System.out.println(board);
    }
    public static void reset()
    {
        int x=0;
        for (String b:boardIndex)
        {
            boardIndex[x]=String.valueOf(x+1);
            x++;
        }

        int y=0;
        for(boolean c:isEmpty)
        {
            isEmpty[y]=true;
            y++;
        }
    }
}

