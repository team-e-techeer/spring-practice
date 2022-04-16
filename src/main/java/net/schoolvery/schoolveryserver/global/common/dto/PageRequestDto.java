package net.schoolvery.schoolveryserver.global.common.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageRequestDto {
    private int page;
    private int size;
    private String type;
    private String keyword;

    public PageRequestDto(){
        this.page = 1;
        this.size = 5;
    }

    public Pageable getPageable(Sort sort){
        // JPA를 이용하는 경우 페이지 번호가 0번부터 시작하기 때문에 page에서 1을 뺀다.
        return PageRequest.of(page - 1, size, sort);
    }
}
