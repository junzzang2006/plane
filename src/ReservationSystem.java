public class ReservationSystem {
    public static void main(String[] args) {
    }
    public static void makeSeats(int row, int col) {
        String[][] Seat = new String[row][col];
        for (int i = 65+row; i >= 65; i--) {
            for (int j = 0; j < col; j++) {
                Seat[i][j] =String.valueOf(j+(char)i);
            }
        }
    }

}
