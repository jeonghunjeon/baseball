import java.util.Scanner;

public class BaseBall {
    public static void main(String[] args) {
        int     idx1, idx2, idx3;
        Scanner sc = new Scanner(System.in);

        System.out.println("컴퓨터가 숫자를 생성하였습니다.");
        System.out.println("답을 맞춰보세요!");

        while (true) {
            // 난수 생성
            idx1 = (int)Math.floor(Math.random() * 10);
            idx2 = (int)Math.floor(Math.random() * 10);
            idx3 = (int)Math.floor(Math.random() * 10);
            // 중복 방지
            if (!((idx1 == idx2) || (idx1 == idx3) || (idx2 == idx3))) {
                break;
            }
        }

        for (int i = 0; i < 100; i++) {
            // 돌릴 때마다 초기화
            int     strike = 0, ball = 0;
            System.out.println((i + 1) + "번째 시도: ");
            String  answer = sc.nextLine();
            // String으로 받아서 int로 변환
            int     answerNum1 = answer.charAt(0) - '0';
            int     answerNum2 = answer.charAt(1) - '0';
            int     answerNum3 = answer.charAt(2) - '0';

            // 스트라이크 체크
            if (idx1 == answerNum1)
                ++strike;
            if (idx2 == answerNum2)
                ++strike;
            if (idx3 == answerNum3)
                ++strike;

            // 볼 체크
            if (idx1 == answerNum2 || idx1 == answerNum3)
                ++ball;
            if (idx2 == answerNum1 || idx2 == answerNum3)
                ++ball;
            if (idx3 == answerNum1 || idx3 == answerNum2)
                ++ball;

            // 정답 확인
            if (strike == 3) {
                System.out.println(strike + "S\n" + (i + 1) + "번만에 맞히셨습니다." + '\n' + "게임을 종료합니다.");
                break;
            } else { // 전부 틀렸을 때
                if (strike == 0 && ball == 0) {
                    System.out.println("OUT!");
                } else if (ball == 3){ // 현황 출력
                    System.out.println(ball + "B");
                } else {
                    System.out.println(ball + "B" + strike + "S");
                }
            }
        }
    }
}
