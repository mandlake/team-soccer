package com.rod.api.soccer.player.repository;

import com.rod.api.soccer.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long>, PlayerJpqlRepository{

    // 2. 플레이어의 포지션 종류를 나열
    List<Player> findDistinctByPosition(String position);

    // 3. 중복 제거하고, 포지션이 없으면 '신입'으로 기재
    List<Player> findByPositionNotNull();

    // 4. 수원팀에서 골키퍼(GK)의 이름 출력
    List<Player> findByTeamKeyTeamIdAndPosition(String teamId, String position);

    // 5. 수원팀에서 성이 고씨이고 키가 170 이상인 선수 출력
    List<Player> findByTeamKeyTeamIdAndPlayerNameStartingWithAndHeightGreaterThanEqual(String teamId, String playerName, String height);

    // 10. 수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK)인 선수를 출력하시오
    List<Player> findByTeamKeyTeamIdOrTeamKeyTeamIdAndPosition(String teamId1, String teamId2, String position);

    // 13. 모든 선수들 중 포지션을 배정 받지 못한 선수들의 팀명과 선수이름 출력 둘다 오름차순
    List<Player> findByPositionNullOrderByTeamKeyTeamNameAscPlayerNameAsc();
}