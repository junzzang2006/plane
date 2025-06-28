import java.util.Objects;
public class ReservationSystem {

    String[][] Seat;
    String Blank;
    String[][] Check;
    int count;
    int row;
    int col;
    public ReservationSystem() {
        Blank = "                                                           ";
        count = 0;
        row = 0;
        col = 0;
    }

    public  void makeSeats(int row, int col) {
        Seat = new String[row][col];
        this.row = row;
        this.col = col;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Seat[i][j] = String.valueOf(j + 1) + (char) (65 + i);
            }
        }
        Check = new String[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Check[i][j] = " ";
            }
        }

    }
    public  void displaySeat(String systemTitle) {
        System.out.println(systemTitle +" 예약 시스템 예약 현황] 예약 좌석:" + count +"/ 총 좌석:" + (row * col));
        for (int i = Seat.length-1; i >= 0; i--) {
            for (int j = 0; j < Seat[i].length; j++) {
                System.out.printf('[' + "%3s".formatted(Seat[i][j]) +']'+ ' ');
            }
            System.out.print("\n");
            for (int j = 0; j < Seat[i].length; j++) {
                System.out.printf( "%4s".formatted(Check[i][j]) + "  ");
            }
            System.out.print("\n");
            if (i == 2){
                System.out.println("-----------------------------------------------------------\n" +
                        "앞\t\t\t\t\t\t\t통로\t\t\t\t\t\t\t뒤\n" +
                        "-----------------------------------------------------------");
            }
        }

    }

    public boolean reserveSeat(String seatName){
        int[] seatArray = new int[2];
        getSeatIndex(seatName,seatArray);

        if ((seatName.length() >= 4) || (seatName.charAt(seatName.length()-1) < 65 )|| (seatName.charAt(seatName.length()-1) > 68 || Integer.valueOf(seatName.substring(0,seatName.length()-1)) > Seat[0].length)){
            System.out.println("[예약 실패] "+ seatName);
            return false;
        }
        if (Objects.equals(Check[Seat.length-seatArray[0]-1][seatArray[1]], "O")){
            System.out.println("[예약 실패] "+seatName+": 이미 예약된 좌석입니다.");
            return false;
        }
        else{
            System.out.println("[예약 성공] "+ seatName);
            Check[Seat.length-seatArray[0]-1][seatArray[1]] = "O";
            count++;
            displaySeat("_");
            return true;
        }
    }

    public boolean cancelSeat(String seatName){
        int[] seatArray = new int[2];
        getSeatIndex(seatName,seatArray);

        if ((seatName.length() >= 4) || (seatName.charAt(seatName.length()-1) < 65 )|| (seatName.charAt(seatName.length()-1) > 68 || Integer.valueOf(seatName.substring(0,seatName.length()-1)) > Seat[0].length)) {
            System.out.println("[예약 취소 실패] "+ seatName);
            return false;
        }
        if (Objects.equals(Check[Seat.length-seatArray[0]-1][seatArray[1]], "O")){
            Check[Seat.length-seatArray[0]-1][seatArray[1]] = " ";
            System.out.println("[예약 취소 성공] "+ seatName);
        }
        else{
            System.out.println("[예약 취소 실패] "+seatName+": 예약되지 않은 좌석입니다.");
        }
        return true;
    }

    public boolean getSeatIndex(String seatName,int seatArray[]){
        String num = seatName.substring(0,seatName.length()-1);

        if ((seatName.length() >= 4) || (seatName.charAt(seatName.length()-1) < 65 )|| (seatName.charAt(seatName.length()-1) > 68 || Integer.valueOf(num) > Seat[0].length)){
            System.out.println(seatName+": 잘못된 좌석 번호입니다");
            return false;
        }
        else{
            if (seatName.length() == 2){
                seatArray[0] = Seat.length - seatName.charAt(1) + 64;
                seatArray[1] = seatName.charAt(0) - 49;
                //System.out.println(seatArray[0] + " " + seatArray[1]);
            }
            if (seatName.length() == 3){
                seatArray[0] = Seat.length - seatName.charAt(2) + 64;
                seatArray[1] = Integer.valueOf(num) - 1;
                //System.out.println(seatArray[0] + " " + seatArray[1]);
            }
            return true;
        }

    }


}