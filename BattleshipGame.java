import java.util.Scanner;

public class BattleshipGame {
    private char[][] playerMap;
    private char[][] enemyMap;
    private int playerScore;
    private int enemyScore;
    private int numShips;

    public BattleshipGame(int size, int numShips) {
        playerMap = new char[size][size];
        enemyMap = new char[size][size];
        this.numShips = numShips;
        initializeMaps();
    }

    private void initializeMaps() {
        for (int i = 0; i < playerMap.length; i++) {
            for (int j = 0; j < playerMap[i].length; j++) {
                playerMap[i][j] = '-';
                enemyMap[i][j] = '-';
            }
        }
    }

    private void placeShips() {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Placing ships...");
        while (count < numShips) {
            System.out.print("Enter X coordinate for ship " + (count + 1) + ": ");
            int x = scanner.nextInt();
            System.out.print("Enter Y coordinate for ship " + (count + 1) + ": ");
            int y = scanner.nextInt();

            if (x < 0 || x >= playerMap.length || y < 0 || y >= playerMap.length) {
                System.out.println("Invalid coordinates! Try again.");
                continue;
            }

            if (playerMap[x][y] == 'S') {
                System.out.println("Ship already exists at this location! Try again.");
                continue;
            }

            playerMap[x][y] = 'S';
            count++;
        }
    }

    private void displayMaps() {
        System.out.println("\nYour Map:");
        for (int i = 0; i < playerMap.length; i++) {
            for (int j = 0; j < playerMap[i].length; j++) {
                System.out.print(playerMap[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nEnemy Map:");
        for (int i = 0; i < enemyMap.length; i++) {
            for (int j = 0; j < enemyMap[i].length; j++) {
                System.out.print(enemyMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void attack() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter X coordinate to attack: ");
        int x = scanner.nextInt();
        System.out.print("Enter Y coordinate to attack: ");
        int y = scanner.nextInt();

        if (x < 0 || x >= enemyMap.length || y < 0 || y >= enemyMap.length) {
            System.out.println("Invalid coordinates! Try again.");
            attack();
            return;
        }

        if (enemyMap[x][y] == '-') {
            System.out.println("Miss!");
            enemyMap[x][y] = 'O';
        } else if (enemyMap[x][y] == 'S') {
            System.out.println("Hit!");
            enemyMap[x][y] = 'X';
            enemyScore--;
        } else {
            System.out.println("Already attacked this location! Try again.");
            attack();
            return;
        }

        if (enemyScore == 0) {
            System.out.println("\nCongratulations! You won the game!");
            System.exit(0);
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Battleship Game!");
        System.out.print("Enter the size of the map: ");
        int size = scanner.nextInt();
        System.out.print("Enter the number of ships: ");
        numShips = scanner.nextInt();

        playerScore = numShips;
        enemyScore = numShips;

        placeShips();

        while (true) {
            displayMaps();
            attack();

            System.out.println("\nEnemy's turn to attack...");
            int x = (int) (Math.random() * size);
            int y = (int) (Math.random() * size);

            if (playerMap[x][y] == 'S') {
                System.out.println("Your ship at (" + x + ", " + y + ") got hit!");
                playerMap[x][y] = 'X';
                playerScore--;
            } else {
                System.out.println("Enemy missed!");
                playerMap[x][y] = 'O';
            }

            if (playerScore == 0) {
                System.out.println("\nGame Over! You lost.");
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame(8, 3);
        game.play();
    }
}