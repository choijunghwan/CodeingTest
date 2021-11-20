package TestCodeReview.WinterCoding;

public class Solve1 {
    public static void main(String[] args) {
        String character = "10 5 2";
        String[] monsters = {"Knight 3 10 10 3", "Wizard 5 10 15 1", "Beginner 1 1 15 1"};
        String result = solution(character, monsters);
    }

    public static String solution(String character, String[] monsters) {

        String answer = "";
        double experience = 0; // 1초당 경험치
        int totalEx = 0;  // 총 경험치
        String[] player = character.split(" ");

        for (String monster : monsters) {
            String[] enemy = monster.split(" ");

            // 몬스터가 받는 피해량
            int enemyGetDamage = Integer.parseInt(player[1]) - Integer.parseInt(enemy[4]);
            if (enemyGetDamage <= 0) {
                continue;  // 몬스터를 잡을 수 없다.
            }

            // 플레이어가 받는 피해량
            int playerGetDamage = Integer.parseInt(enemy[3]) - Integer.parseInt(player[2]);

            int monster_hp = Integer.parseInt(enemy[2]);
            int player_hp = Integer.parseInt(player[0]);

            if (player_hp <= playerGetDamage) { // 플레이어가 몬스터에게 죽는다면
                if (monster_hp <= enemyGetDamage) { // 플레이어가 죽기전에 몬스터를 한번에 잡는다면
                    if (experience < Double.parseDouble(enemy[1])) {
                        experience = Double.parseDouble(enemy[1]);
                        totalEx = Integer.parseInt(enemy[1]);
                        answer = enemy[0];
                    } else if (experience == Double.parseDouble(enemy[1])) {
                        if (totalEx < Integer.parseInt(enemy[1])) {
                            totalEx = Integer.parseInt(enemy[1]);
                            answer = enemy[0];
                        }
                    }
                }
                continue;
            }

            int cnt = 0;
            while (monster_hp > 0) {
                monster_hp -= enemyGetDamage;
                cnt++;
            }

            double currentEx = Double.parseDouble(enemy[1]) / cnt;
            if (experience < currentEx) {
                experience = currentEx;
                totalEx = Integer.parseInt(enemy[1]);
                answer = enemy[0];
            } else if (experience == currentEx) {
                if (totalEx < Integer.parseInt(enemy[1])) {
                    totalEx = Integer.parseInt(enemy[1]);
                    answer = enemy[0];
                }
            }
        }
        return answer;
    }
}
