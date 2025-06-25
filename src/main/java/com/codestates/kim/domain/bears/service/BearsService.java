package com.codestates.kim.domain.bears.service;


import com.codestates.kim.domain.bears.Bears;
import com.codestates.kim.domain.bears.dto.BearsResDto;
import com.codestates.kim.domain.bears.repository.BearsRepository;
import com.codestates.kim.exception.bears.NotFoundBearsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BearsService {
    private final BearsRepository bearsRepository;

    public BearsResDto showBears(Integer bearsId) {
        Bears bears = bearsRepository.findById(bearsId).orElseThrow(()->
                new NotFoundBearsException("존재하지 않는 곰입니다."));
        return BearsResDto.fromBears(bears);
    }

    public List<BearsResDto> showAllBears() {
        List<Bears> bears = bearsRepository.findAll();

        return bears.stream()
                .map(BearsResDto::fromBears)
                .collect(Collectors.toList());
    }
}
