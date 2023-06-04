package  ma.sir.dgi.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.dgi.zynerator.util.StringUtil;
import ma.sir.dgi.zynerator.converter.AbstractConverter;
import ma.sir.dgi.zynerator.util.DateUtil;
import ma.sir.dgi.bean.history.EtatOperationComptableHistory;
import ma.sir.dgi.bean.core.EtatOperationComptable;
import ma.sir.dgi.ws.dto.EtatOperationComptableDto;

@Component
public class EtatOperationComptableConverter extends AbstractConverter<EtatOperationComptable, EtatOperationComptableDto, EtatOperationComptableHistory> {


    public  EtatOperationComptableConverter(){
        super(EtatOperationComptable.class, EtatOperationComptableDto.class, EtatOperationComptableHistory.class);
    }

    @Override
    public EtatOperationComptable toItem(EtatOperationComptableDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatOperationComptable item = new EtatOperationComptable();
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
    public EtatOperationComptableDto toDto(EtatOperationComptable item) {
        if (item == null) {
            return null;
        } else {
            EtatOperationComptableDto dto = new EtatOperationComptableDto();
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
