public class ReservationSystem {
    static String[][] Seat;
    static String Blank = "                                                            ";
    public static void makeSeats(int row, int col) {
        Seat = new String[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 각 좌석을 "A1", "A2" 형식으로 저장
                Seat[i][j] =  String.valueOf(j + 1) + (char)(65 + i);
            }
        }
    }
    public static void displaySeat(String systemTitle) {
        for (int i = Seat.length-1; i >= 0; i--) {
            for (int j = 0; j < Seat[i].length; j++) {
                System.out.print('[' + "%3s".formatted(Seat[i][j]) +']'+ ' ');
            }
            System.out.println("\n"+Blank);
            if (i == 2){
                System.out.println("-----------------------------------------------------------\n" +
                        "앞\t\t\t\t\t\t\t통로\t\t\t\t\t\t\t\t뒤\n" +
                        "-----------------------------------------------------------\n");
            }
        }

    }

    public static boolean reserveSeat(String seatName){

        return true;
    }

    public static boolean cancelSeat(String seatName){

        return true;
    }

    public static boolean	getSeatIndex(String	seatName,int seatArray[]){
        String num = seatName.substring(0,seatName.length()-1);

        if ((seatName.length() >= 4) || (seatName.charAt(seatName.length()-1) < 65 )|| (seatName.charAt(seatName.length()-1) > 68 || Integer.valueOf(num) > Seat[0].length)){
            System.out.println("좌석번호: 잘못된 좌석 번호입니다");
        }
        else{
            if (seatName.length() == 2){
                seatArray[0] = Seat.length - seatName.charAt(1) + 64;
                seatArray[1] = seatName.charAt(0) - 49;
                System.out.println(seatArray[0] + " " + seatArray[1]);
            }
            if (seatName.length() == 3){
                seatArray[0] = Seat.length - seatName.charAt(2) + 64;
                seatArray[1] = Integer.valueOf(num) - 1;
                System.out.println(seatArray[0] + " " + seatArray[1]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        makeSeats(4, 10);
        displaySeat("_");
    }


}