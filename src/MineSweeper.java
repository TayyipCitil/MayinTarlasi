import java.util.Random;

public class MineSweeper {//Gpt ile !sadece! semboleri buldum
    int row;
    int col;
    int bombCounter=0;
    String[][] solutionGround;
    String[][] nowGround;


    MineSweeper(int row, int col) {
        this.row = row;
        this.col = col;
        this.solutionGround = new String[row][col];
        this.nowGround=new String[row][col];
    }

    void gameGround() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (this.solutionGround[i][j] == null) {
                    this.solutionGround[i][j] = "⬜";
                }
                this.nowGround[i][j]="⬜";
            }
        }
    }


    void bomb() {
        Random rnd = new Random();

        for (int i = 0; i < (this.row * this.col) / 4; i++) {
            int randRow = rnd.nextInt(this.row);
            int randCol = rnd.nextInt(this.col);
            this.solutionGround[randRow][randCol] = "💣";
            this.bombCounter++;
        }
    }

    void numbers() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (!(this.solutionGround[i][j].equals("💣"))) {//kutuda bomba yok
                    int counter = 0;
                    if (i == 0) {//kutunun daha üstünde kutu yok

                        if (j == 0) {//kutunun daha solunda kutu yok
                            for (int r = i; r <= i + 1; r++) {
                                for (int c = j; c <= j + 1; c++) {
                                    if (this.solutionGround[r][c].equals("💣")) {//bomba varsa
                                        counter++;
                                    }
                                }
                            }
                            this.solutionGround[i][j] = String.valueOf(counter);
                        } else if (j == this.col - 1) {//kutunun daha sağında kutu yok
                            for (int r = i; r <= i + 1; r++) {
                                for (int c = j - 1; c <= j; c++) {
                                    if (this.solutionGround[r][c].equals("💣")) {//bomba varsa
                                        counter++;
                                    }
                                }
                            }
                            this.solutionGround[i][j] = String.valueOf(counter);
                        } else {//kutunun sağ,sol ve altında kutu var
                            for (int r = i; r <= i + 1; r++) {
                                for (int c = j - 1; c <= j + 1; c++) {
                                    if (this.solutionGround[r][c].equals("💣")) {//etrafda bomba var
                                        counter++;
                                    }
                                }
                            }
                            this.solutionGround[i][j] = String.valueOf(counter);
                        }

                    } else if (i == this.row - 1) {//kutunun daha altında kutu yok

                        if (j == 0) {//kutunun daha solunda kutu yok
                            for (int r = i - 1; r <= i; r++) {
                                for (int c = j; c <= j + 1; c++) {
                                    if (this.solutionGround[r][c].equals("💣")) {//bomba varsa
                                        counter++;
                                    }
                                }
                            }
                            this.solutionGround[i][j] = String.valueOf(counter);
                        } else if (j == this.col - 1) {//kutunun daha sağında kutu yok
                            for (int r = i - 1; r <= i; r++) {
                                for (int c = j - 1; c <= j; c++) {
                                    if (this.solutionGround[r][c].equals("💣")) {//bomba varsa
                                        counter++;
                                    }
                                }
                            }
                            this.solutionGround[i][j] = String.valueOf(counter);
                        } else {//kutunun sağ,sol ve üstünde kutu var
                            for (int r = i - 1; r <= i; r++) {
                                for (int c = j - 1; c <= j + 1; c++) {
                                    if (this.solutionGround[r][c].equals("💣")) {//bomba varsa
                                        counter++;
                                    }
                                }
                            }
                            this.solutionGround[i][j] = String.valueOf(counter);
                        }

                    } else {//kutunun altında ve üstünde kutu var

                        if (j == 0) {//kutunun solunda kutu yok
                            for (int r = i - 1; r <= i + 1; r++) {
                                for (int c = j; c <= j + 1; c++) {
                                    if (this.solutionGround[r][c].equals("💣")) {//bomba varsa
                                        counter++;
                                    }
                                }
                            }
                            this.solutionGround[i][j] = String.valueOf(counter);
                        } else if (j == this.col - 1) {//kutunun sağında kutu yok
                            for (int r = i - 1; r <= i + 1; r++) {
                                for (int c = j - 1; c <= j; c++) {
                                    if (this.solutionGround[r][c].equals("💣")) {//bomba varsa
                                        counter++;
                                    }
                                }
                            }
                            this.solutionGround[i][j] = String.valueOf(counter);
                        } else {//kutunun dört tarafında da kutu var
                            for (int r = i - 1; r <= i + 1; r++) {
                                for (int c = j - 1; c <= j + 1; c++) {
                                    if (this.solutionGround[r][c].equals("💣")) {//bomba varsa
                                        counter++;
                                    }
                                }
                            }
                            this.solutionGround[i][j] = String.valueOf(counter);
                        }
                    }
                }
            }
        }
    }

    void printGround(String[][] ground) {
        for (String[] r : ground) {
            for (String c : r) {
                System.out.print(c + "\t");
            }
            System.out.println();
        }
    }
}

