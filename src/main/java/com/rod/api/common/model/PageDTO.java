package com.rod.api.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component //Object 같은거
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class PageDTO {
    private Long pageSize;
    public static Long BLOCK_SIZE = 10L;
    private Long totalCount;
    private Long blockCount;
    private Long pageCount;

    private Long startRow;
    private Long endRow;

    private Long startPage;
    private Long endPage;

    private Long nextBlock;
    private Long prevBlock;

    private Long blockNum;
    private Long pageNum;

    private boolean existPrev;
    private boolean existNext;
}
