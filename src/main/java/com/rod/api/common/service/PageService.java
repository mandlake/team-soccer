package com.rod.api.common.service;

import com.rod.api.common.model.PageDTO;
import org.springframework.data.domain.Pageable;

public interface PageService {
    PageDTO getPageDTO(Pageable pageable, Long totalCount);
}
