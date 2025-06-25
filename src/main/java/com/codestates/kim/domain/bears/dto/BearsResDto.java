package com.codestates.kim.domain.bears.dto;


import com.codestates.kim.domain.bears.Bears;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)

public class BearsResDto {
    private Integer bearId;
    private String bearName;
    private String bearColor;

    public BearsResDto(Bears bears){
    }

    public static BearsResDto fromBears(Bears bears) {
        BearsResDto bearsResDto = new BearsResDto();
        bearsResDto.bearId = bears.getBearId();
        bearsResDto.bearColor = bears.getBearColor();
        bearsResDto.bearName = bears.getBearName();
        return bearsResDto;
    }
}
