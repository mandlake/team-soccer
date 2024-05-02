import com.rod.api.soccer.player.model.Player;
import com.rod.api.soccer.stadium.model.Stadium;
import com.rod.api.soccer.team.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SoccerRepository extends JpaRepository<Player, Long> {

    // 1. 전체 축구팀 목록을 팀이름 오름차순으로 출력
    List<Team> findAllByOrderByTeamNameAsc();

    // 2. 플레이어의 포지션 종류를 나열
    @Query("SELECT DISTINCT p.position FROM Player p")
    List<String> findDistinctPositions();

    // 3. 중복 제거하고, 포지션이 없으면 '신입'으로 기재
    @Query("SELECT COALESCE(p.position, '신입') FROM Player p")
    List<String> findUniquePositionsOrNew();

    // 4. 수원팀에서 골키퍼(GK)의 이름 출력
    List<Player> findByTeamKeyTeamIdAndPosition(String teamId, String position);

    // 4-1. 수원팀에서 골키퍼(GK)의 이름 출력 (ID 모를 경우)
    @Query("SELECT p.playerName FROM Player p WHERE p.teamKey.stadiumKey.stadiumName = 'Suwon' AND p.position = 'GK'")
    List<String> findGoalkeepersForSuwon();

    // 5. 수원팀에서 성이 고씨이고 키가 170 이상인 선수 출력
    List<Player> findByTeamKeyTeamIdAndPlayerNameStartingWithAndHeightGreaterThanEqual(String teamId, String prefix, String height);

    // 5-1. 수원팀에서 성이 고씨이고 키가 170 이상인 선수 출력 (ID 모를 경우)
    @Query("SELECT p FROM Player p WHERE p.playerName LIKE %:prefix% AND p.height >= :height AND p.teamKey.stadiumKey.stadiumName = 'Suwon'")
    List<Player> findPlayersWithLastNameAndHeightForSuwon(String prefix, String height);

    // 6. 조건에 맞는 선수 출력
    @Query("SELECT p FROM Player p WHERE (p.teamKey.teamName = '삼성블루윙즈' OR p.teamKey.teamName = '드래곤즈') AND p.position = '미드필더' AND p.height BETWEEN 170 AND 180")
    List<Player> findPlayersByConditions();

    // 7. 수원을 연고지로 하는 골키퍼 이름 출력
    @Query("SELECT p.playerName FROM Player p WHERE p.teamKey.stadiumKey.address = '수원'")
    List<String> findGoalkeeperForSuwon();

    // 8. 서울팀 선수들 이름, 키, 몸무게 목록으로 출력
    @Query("SELECT p.playerName, p.height, p.weight FROM Player p WHERE p.teamKey.stadiumKey.address = '서울'")
    List<Object[]> findPlayerNamesHeightsWeightsForSeoul();

    // 9. 서울팀 선수들 이름, 포지션, 키, 몸무게, BMI 출력
    @Query("SELECT p.playerName, p.position, p.height, p.weight, (p.weight / ((p.height / 100) * (p.height / 100))) AS bmi FROM Player p WHERE p.teamKey.stadiumKey.address = '서울'")
    List<Object[]> findPlayerInfoAndBMIForSeoul();

    // 10. 수원팀과 대전팀 선수들 중 골키퍼 출력
    @Query("SELECT p FROM Player p WHERE (p.teamKey.teamId = 'K02' OR p.teamKey.teamId = 'K10') AND p.position = 'GK'")
    List<Player> findGoalkeepersForSuwonAndDaejeon();

    // 11. 팀과 연고지 연결 출력
    @Query("SELECT t.teamName, s.stadiumName FROM Team t JOIN t.stadiumKey s")
    List<Object[]> findTeamAndStadiumConnection();

    // 12. 수원팀과 대전팀 선수 중 180 이상 183 이하인 선수 출력
    @Query("SELECT p FROM Player p WHERE (p.teamKey.teamId = 'K02' OR p.teamKey.teamId = 'K10') AND p.height BETWEEN 180 AND 183")
    List<Player> findPlayersBetween180And183ForSuwonAndDaejeon();

    // 13. 포지션을 배정 받지 못한 선수들의 팀명과 선수이름 출력
    @Query("SELECT t.teamName, p.playerName FROM Player p RIGHT JOIN p.teamKey t WHERE p.position IS NULL ORDER BY t.teamName, p.playerName")
    List<Object[]> findUnassignedPlayers();

    // 14. 팀과 스타디움, 스케줄을 조인하여 2012년 3월 17일에 열린 각 경기의 팀이름, 스타디움, 어웨이팀 이름 출력
    @Query("SELECT s.hometeamKey.teamName, s.stadiumName, s.awayteamKey.teamName FROM Schedule s WHERE s.scheDate = '2012-03-17'")
    List<Object[]> findMatchesForMarch17th2012();

    // 15. 2012년 3월 17일 경기에 포항 스틸러스 소속 골키퍼 선수, 포지션, 팀명, 스타디움, 경기날짜 구하기
    @Query("SELECT p.playerName, p.position, t.teamName, s.stadiumName, s.scheDate FROM Player p JOIN p.teamKey t JOIN t.stadiumKey s JOIN s.schedules sch WHERE p.teamKey.teamId = 'K05' AND p.position = 'GK' AND sch.scheDate = '2012-03-17'")
    List<Object[]> findPlayerPositionTeamStadiumMatchDateForPohangStadium();

    // 16. STADIUM에 등록된 운동장 중에서 홈팀이 없는 경기장까지 전부 나오도록
    @Query("SELECT s FROM Stadium s WHERE s.teams IS EMPTY")
    List<Stadium> findStadiumsWithoutHomeTeams();

    // 17. 페이지네이션 로직을 위한 플레이어 테이블에서 최상단 5개 로우를 출력
    List<Player> findTop5ByOrderByPlayerIdAsc();

    // 18. 평균키가 인천 유나이티스팀('K04')의 평균키보다 작은 팀의 팀ID, 팀명, 평균키 추출
    @Query("SELECT t.teamId, t.teamName, AVG(p.height) AS avgHeight FROM Player p JOIN p.teamKey t GROUP BY t.teamId, t.teamName HAVING AVG(p.height) < (SELECT AVG(p2.height) FROM Player p2 JOIN p2.teamKey t2 WHERE t2.teamId = 'K04')")
    List<Object[]> findTeamsWithAverageHeightLessThanIncheon();

    // 19. 포지션이 MF 인 선수들의 소속팀명 및 선수명, 백넘버 출력
    @Query("SELECT t.teamName, p.playerName, p.backNo FROM Player p JOIN p.teamKey t WHERE p.position = 'MF'")
    List<Object[]> findPlayersWithMFPosition();

    // 20. 가장 키큰 선수 5명의 소속팀명 및 선수명, 백넘버 출력
    @Query(value = "SELECT t.team_name, p.player_name, p.back_no FROM player p JOIN team t ON p.team_id = t.team_id ORDER BY p.height DESC LIMIT 5", nativeQuery = true)
    List<Object[]> findTop5TallestPlayers();

    // 21. 선수 자신이 속한 팀의 평균키보다 작은 선수 정보 출력
    @Query("SELECT p2.playerName FROM Player p1 JOIN p1.teamKey t JOIN t.players p2 WHERE p2.height < (SELECT AVG(p3.height) FROM Player p3 WHERE p3.teamKey = t) AND p1 = ?1")
    List<String> findPlayersShorterThanTeamAverage(Player player);

    // 22. 2012년 5월 한달간 경기가 있는 경기장 조회
    @Query("SELECT DISTINCT s.stadiumName FROM Schedule s WHERE s.scheDate BETWEEN '2012-05-01' AND '2012-05-31'")
    List<String> findStadiumsWithMatchesInMay2012();
}
