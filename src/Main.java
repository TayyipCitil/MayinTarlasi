import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Oyun alanı boyutu");
        System.out.print("Satır sayısı: ");
        int row = input.nextInt();
        System.out.print("Stun sayısı: ");
        int col = input.nextInt();

        MineSweeper game = new MineSweeper(row, col);

        System.out.println("________________");
        game.bomb();
        game.gameGround();
        game.numbers();
        //game.printGround(game.solutionGround);
        System.out.println("________________");


        boolean select = true;
        game.printGround(game.nowGround);
        int emptyBoxNum = (row * col) - game.bombCounter;

        while (select && emptyBoxNum >= 0) {
            if (emptyBoxNum == 0) {
                System.out.println("===Kazandınız===");
                game.printGround(game.solutionGround);
                break;
            }

            int selectNum;
            do {
                System.out.print("Bayrak(1), Bölge Seç(2) : ");
                selectNum = input.nextInt();
                if (selectNum == 2) {
                    break;
                } else if (selectNum == 1) {
                    System.out.print("Seçilen Satır: ");
                    int slctRow = input.nextInt();
                    System.out.print("Seçilen Stun: ");
                    int slctCol = input.nextInt();
                    System.out.println("________________");
                    if (game.nowGround[slctRow - 1][slctCol - 1].equals("⬜")) {
                        game.nowGround[slctRow - 1][slctCol - 1] = "🚩";
                    }else if(game.nowGround[slctRow - 1][slctCol - 1].equals("🚩")){
                        game.nowGround[slctRow - 1][slctCol - 1] = "⬜";
                    }else{
                        System.out.println("Bu alan açık");
                    }
                    game.printGround(game.nowGround);
                } else {
                    System.out.println("Sadece 1 veya 2 yi seçebilrsiniz");
                    selectNum = 1;
                }
            } while (selectNum == 1);

            System.out.print("Seçilen Satır: ");
            int slctRow = input.nextInt();
            System.out.print("Seçilen Stun: ");
            int slctCol = input.nextInt();
            System.out.println("________________");


            if (game.solutionGround[slctRow - 1][slctCol - 1].equals("💣")) {
                System.out.println("===Kaybettiniz===");
                game.printGround(game.solutionGround);
                select = false;
            } else {
                game.nowGround[slctRow - 1][slctCol - 1] = game.solutionGround[slctRow - 1][slctCol - 1];
                game.printGround(game.nowGround);
                emptyBoxNum--;
            }


        }
    }
}
