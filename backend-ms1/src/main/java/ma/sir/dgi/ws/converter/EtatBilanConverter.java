package  ma.sir.dgi.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.dgi.zynerator.util.StringUtil;
import ma.sir.dgi.zynerator.converter.AbstractConverter;
import ma.sir.dgi.zynerator.util.DateUtil;
import ma.sir.dgi.bean.history.EtatBilanHistory;
import ma.sir.dgi.bean.core.EtatBilan;
import ma.sir.dgi.ws.dto.EtatBilanDto;

@Component
public class EtatBilanConverter extends AbstractConverter<EtatBilan, EtatBilanDto, EtatBilanHistory> {


    public  EtatBilanConverter(){
        super(EtatBilan.class, EtatBilanDto.class, EtatBilanHistory.class);
    }

    @Override
    public EtatBilan toItem(EtatBilanDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatBilan item = new EtatBilan();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());


        return item;
        }
    }

    @Override
    public EtatBilanDto toDto(EtatBilan item) {
        if (item == null) {
            return null;
        } else {
            EtatBilanDto dto = new EtatBilanDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
