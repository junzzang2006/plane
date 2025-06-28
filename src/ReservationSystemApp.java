import java.util.Scanner;
public class ReservationSystemApp {
    static int select;
    public static void airlinereservation(Scanner sc, AirlineSystem airlinesystem) {
        while (true) {
            System.out.println("-------------------------");
            System.out.println("항공사 예약 시스템");
            System.out.println("1. 좌석 예약");
            System.out.println("2. 예약 취소");
            System.out.println("3. 예약 현황 조회");
            System.out.println("4. 메인 메뉴로 돌아가기");
            System.out.println("-------------------------");
            System.out.print("메뉴를 선택해주세요: ");
            select = sc.nextInt();
            sc.nextLine();
            if (select > 4 || select < 1) {
                System.out.println("잘못된 메뉴 선택입니다. 다시 입력해주세요 (1~4)");
            }
            if (select == 1){
                System.out.printf("예약할 좌석 이름을 입력하세요: ");
                String seatName = sc.nextLine();
                char ch = seatName.charAt(0);
                if(Character.isDigit(ch) ==	false)	{
                    System.out.println(seatName +	":	숫자가 아닙니다. ");
                    continue;
                }
                Boolean tf = airlinesystem.reserveSeat(seatName);
            }
            else if (select == 2){
                System.out.printf("취소할 좌석 이름을 입력하세요: ");
                String seatName = sc.nextLine();
                Boolean tf = airlinesystem.cancelSeat(seatName);
            } else if (select == 3) {
                airlinesystem.displaySeat("항공사");
            }
            else if (select == 4){
                break;
            }
        }
    }
    public static void busreservation(Scanner sc, BusSystem bussystem) {
        while (true) {
            System.out.println("-------------------------");
            System.out.println("버스 예약 시스템");
            System.out.println("1. 좌석 예약");
            System.out.println("2. 예약 취소");
            System.out.println("3. 예약 현황 조회");
            System.out.println("4. 메인 메뉴로 돌아가기");
            System.out.println("-------------------------");
            System.out.print("메뉴를 선택해주세요: ");
            select = sc.nextInt();
            sc.nextLine();
            if (select > 4 || select < 1) {
                System.out.println("잘못된 메뉴 선택입니다. 다시 입력해주세요 (1~4)");
            }
            if (select == 1){
                System.out.printf("예약할 좌석 이름을 입력하세요: ");
                String seatName = sc.nextLine();
                char ch =	seatName.charAt(0);
                if(Character.isDigit(ch) == false)	{
                    System.out.println(seatName +	":	숫자가 아닙니다. ");
                    continue;
                }
                Boolean tf = bussystem.reserveSeat(seatName);
            }
            else if (select == 2){
                System.out.printf("취소할 좌석 이름을 입력하세요: ");
                String seatName = sc.nextLine();
                Boolean tf = bussystem.cancelSeat(seatName);
                bussystem.displaySeat("버스");
            } else if (select == 3) {
                bussystem.displaySeat("버스");
            }
            else if (select == 4){
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AirlineSystem airlinesystem = new AirlineSystem();
        BusSystem busSystem = new BusSystem();
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("    통합 예약 시스템을 방문해 주셔서 감사합니다.");
            System.out.println("      1. 항공사 예약 시스템");
            System.out.println("      2. 버스 예약 시스템");
            System.out.println("      0. 통합 예약 시스템 종료");
            System.out.println("--------------------------------------------");
            System.out.print("메뉴를 선택해주세요: ");
            select = sc.nextInt();
            sc.nextLine();
            if (select > 2 || select < 0) {
                System.out.println("잘못된 메뉴 선택입니다. 다시 입력해주세요 (0~2)");
                continue;
            }
            if (select == 1){
                airlinereservation(sc,airlinesystem);
            }
            else if (select == 2){
                busreservation(sc,busSystem);
            }
            if (select == 0){
                break;
            }
        }
    }
}
