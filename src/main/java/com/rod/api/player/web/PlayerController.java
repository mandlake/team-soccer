package com.rod.api.player.web;

import com.rod.api.player.service.PlayerServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api/player")
@RequiredArgsConstructor
@Slf4j
public class PlayerController {
    private final PlayerServiceImpl service;
    private final PlayerRouter router;

    @GetMapping(path = "/search")
    public ResponseEntity<?> searchPlayer(
            @RequestParam(value = "q") String q,
            @RequestParam(value = "playerName", required = false) String playerName,
            @RequestParam(value = "position", required = false) String position,
            @RequestParam(value = "teamId", required = false) String teamId,
            @RequestParam(value = "regionName", required = false) String regionName,
            @RequestParam(value = "height", required = false) String height,
            @RequestParam(value = "team1", required = false) String teamName1,
            @RequestParam(value = "team2", required = false) String teamName2,
            @RequestParam(value = "min", required = false) String min,
            @RequestParam(value = "max", required = false) String max,
            Pageable pageable
    ){
        log.info("MY-INFO : Controller searchPlayer q is {}", q);
        log.info("MY-INFO : Controller searchPlayer page is {}", pageable.getPageNumber());
        log.info("MY-INFO : Controller searchPlayer limit is {}", pageable.getPageSize());
        log.info("MY-INFO : Controller searchPlayer sortField is {}", pageable.getSort());

        int pageSize = pageable.getPageSize();
        int BLOCK_SIZE = 10;

        Long totalCount = service.count();
        long pageCount = (totalCount % pageSize == 0) ? totalCount / pageSize : totalCount / pageSize + 1;
        Long blockCount = (pageCount % BLOCK_SIZE == 0) ? pageCount / BLOCK_SIZE : pageCount / BLOCK_SIZE + 1;

        int pageNum = pageable.getPageNumber();
        int blockNum = pageNum / BLOCK_SIZE + 1;

        int startRow = (pageNum - 1) * pageSize;
        int endRow = startRow + pageSize - 1;

        int startPage = (blockNum - 1) * BLOCK_SIZE;
        int endPage = startPage + BLOCK_SIZE - 1;

        int prevBlock = blockNum - 1;
        int nextBlock = blockNum + 1;

        boolean existPrev = prevBlock > 0;
        boolean existNext = nextBlock > 0;

        log.info("MY-INFO : Controller searchPlayer totalCount is {}", totalCount);
        log.info("MY-INFO : Controller searchPlayer pageCount is {}", pageCount);
        log.info("MY-INFO : Controller searchPlayer blockCount is {}", blockCount);
        log.info("MY-INFO : Controller searchPlayer startRow is {}", startRow);
        log.info("MY-INFO : Controller searchPlayer endRow is {}", endRow);
        log.info("MY-INFO : Controller searchPlayer blockNum is {}", blockNum);
        log.info("MY-INFO : Controller searchPlayer startPage is {}", startPage);
        log.info("MY-INFO : Controller searchPlayer endPage is {}", endPage);
        log.info("MY-INFO : Controller searchPlayer existPrev is {}", existPrev);
        log.info("MY-INFO : Controller searchPlayer existNext is {}", existNext);
        log.info("MY-INFO : Controller searchPlayer nextBlock is {}", nextBlock);
        log.info("MY-INFO : Controller searchPlayer prevBlock is {}", prevBlock);

        List<?> o = router.execute(q,playerName,position,teamId,regionName, height, teamName1,teamName2,min,max);
        return ResponseEntity.ok(o);
    }
}


