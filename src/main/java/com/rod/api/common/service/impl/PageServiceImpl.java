package com.rod.api.common.service.impl;

import com.rod.api.common.model.PageDTO;
import com.rod.api.common.service.PageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PageServiceImpl implements PageService {
    private final PageDTO pageDTO;

    @Override
    public PageDTO getPageDTO(Pageable pageable, Long totalCount) {
        Long pageSize = (long) pageable.getPageSize();
        long BLOCK_SIZE = 10L;
        long pageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        long blockCount = pageCount % BLOCK_SIZE == 0 ? pageCount / BLOCK_SIZE : pageCount / BLOCK_SIZE + 1;

        long pageNum = pageable.getPageNumber();
        long blockNum = pageNum % BLOCK_SIZE == 0 ? pageNum / BLOCK_SIZE : pageNum / BLOCK_SIZE + 1;

        Long startRow = (pageNum - 1) * pageSize;
        Long endRow = startRow + pageSize - 1;

        long startPage = (blockNum - 1) * BLOCK_SIZE + 1;
        Long endPage = startPage + BLOCK_SIZE - 1;

        long prevBlock = blockNum - 1;
        long nextBlock = blockNum + 1;

        boolean existPrev = prevBlock >= 0;
        boolean existNext = nextBlock <= blockCount;

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

        return PageDTO.builder()
                .pageSize(pageSize)
                .pageCount(pageCount)
                .blockCount(blockCount)
                .pageNum(pageNum)
                .blockNum(blockNum)
                .startRow(startRow)
                .endRow(endRow)
                .startPage(startPage)
                .endPage(endPage)
                .prevBlock(prevBlock)
                .nextBlock(nextBlock)
                .existPrev(existPrev)
                .existNext(existNext)
                .build();
    }
}
