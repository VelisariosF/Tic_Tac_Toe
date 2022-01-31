import java.util.Scanner;



public class TicTacToe{
    public static void menu(){
        System.out.println("--- Welcome to Tic Tac Toe ---");
        System.out.println("   A.Press 1 for single player");
        System.out.println("   B.Press 2 for 1 vs 1");
        System.out.println("   C.Press 3 to check leaderboard.");
        System.out.println("   D.Press 4 to exit");

        

    }

    public static void showboard(String board[][]){
       

          System.out.println(" --- BOARD ---");
          System.out.println("   " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
          System.out.println("  --- --- ---" );
          System.out.println("   " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
          System.out.println("  --- --- ---" );
          System.out.println("   " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
          
    }

    public static void setBoard(String[][] board,String symbol, int posi, int posj){
           board[posi][posj] = symbol;
    }
    
    public static boolean checkwinner(String[][] board){
        // horizontal
        if((board[0][0].equals(board[0][1]) == true && board[0][1].equals(board[0][2]) == true) || (board[1][0].equals(board[1][1]) == true && board[1][1].equals(board[1][2]) == true) || (board[2][0].equals(board[2][1]) == true && board[2][1].equals(board[2][2]) == true))
        {
            if((board[0][0].equals("X") == true && board[0][1].equals("X") == true && board[0][2].equals("X") == true) || (board[1][0].equals("X") == true && board[1][1].equals("X") == true && board[1][2].equals("X") == true) || (board[2][0].equals("X") == true && board[2][1].equals("X") == true && board[2][2].equals("X") == true)) {
                System.out.println("Winner is player X.");
                return true;
            }
            else if((board[0][0].equals("O") == true && board[0][1].equals("O") == true && board[0][2].equals("O") == true) || (board[1][0].equals("O") == true && board[1][1].equals("O") == true && board[1][2].equals("O") == true) || (board[2][0].equals("O") == true && board[2][1].equals("O") == true && board[2][2].equals("O") == true)){
                System.out.println("Winner is player O.");
                return true;
                
            }
        }
        // diagonal 
        if((board[0][0].equals(board[1][1]) == true && board[1][1].equals(board[2][2]) == true) || (board[0][2].equals(board[1][1]) == true && board[1][1].equals(board[2][0]) == true))
        {
            if((board[0][0].equals("X") == true && board[1][1].equals("X") == true && board[2][2].equals("X") == true) || (board[0][2].equals("X") == true && board[1][1].equals("X") == true && board[2][0].equals("X") == true)){
                System.out.println("Winner is player X.");
                return true;
            }
            else if((board[0][0].equals("O") == true && board[1][1].equals("O") == true && board[2][2].equals("O") == true) || (board[0][2].equals("O") == true && board[1][1].equals("O") == true && board[2][0].equals("O") == true)){
                System.out.println("Winner is player O.");
                return true;
            }
        }
        
        // downwards 
        if((board[0][0].equals(board[1][0]) == true && board[1][0].equals(board[2][0]) == true) || (board[0][1].equals(board[1][1]) == true && board[1][1].equals(board[2][1]) == true) || (board[0][2].equals(board[1][2]) == true && board[1][2].equals(board[2][2]) == true))
        {
            if((board[0][0].equals("X") == true && board[1][0].equals("X") == true && board[2][0].equals("X") == true) || (board[0][1].equals("X") == true && board[1][1].equals("X") == true && board[2][1].equals("X") == true) || (board[0][2].equals("X") == true && board[1][2].equals("X") == true && board[2][2].equals("X") == true)){
                System.out.println("Winner is player X.");
                return true;
            }
            else if((board[0][0].equals("O") == true && board[1][0].equals("O") == true && board[2][0].equals("O") == true) || (board[0][1].equals("O") == true && board[1][1].equals("O") == true && board[2][1].equals("O") == true) || (board[0][2].equals("O") == true && board[1][2].equals("O") == true && board[2][2].equals("O") == true)){
                System.out.println("Winner is player O.");
                return true;
            }
        }

        return false;
    }
    public static boolean checkifvalid(String[][] board, int posi, int posj){
        if(board[posi][posj].equals(" ")){
            return true;
        }
        else{
          return false; 
        }
    }

    public static void insert(String[][] board, int i){
       
        Scanner v = new Scanner(System.in);
        int posi,posj;
        if(i%2 == 0)
         {
             
             System.out.println("Player X give pos: ");
             posi = v.nextInt();
             posj = v.nextInt();
             while(!checkifvalid(board, posi - 1, posj - 1)){
                 System.out.println("Give pos again: ");
                 posi = v.nextInt();
                 posj = v.nextInt();

             }
             setBoard(board, "X", posi - 1, posj - 1);
         }
         else  if(i%2 == 1)
         {
             System.out.println("Player O give pos: ");
             posi = v.nextInt();
             posj = v.nextInt(); 
             while(!checkifvalid(board, posi - 1, posj - 1)){
                System.out.println("Give pos again: ");
                posi = v.nextInt();
                posj = v.nextInt();
                
            }
             setBoard(board, "O", posi - 1, posj - 1);
         }
    }
    public static void startgame(String[][] board){
        
       int i = 0;
       showboard(board);
     while(checkwinner(board) == false){
         insert(board, i);
         System.out.print("\033[H\033[2J");
         showboard(board);
         i ++ ; 
     }
    }

    public static void run(){
        String[][] board = {
         {" ", " ", " "},
         {" ", " ", " "},
         {" ", " ", " "}
       };
       menu();
       Scanner l = new Scanner(System.in);
       int  choice = l.nextInt();

       
       switch(choice)
       {
        case 1 :
            startgame(board);
            break; 
        case 4 :
            break;       
        default :
            System.out.println("Invalid input.");    
       }

          
            



    }

    public static void main(String[] args){
           run();
    }
}