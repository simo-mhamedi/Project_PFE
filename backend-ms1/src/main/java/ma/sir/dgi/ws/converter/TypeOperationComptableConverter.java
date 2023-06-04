package  ma.sir.dgi.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.dgi.zynerator.util.StringUtil;
import ma.sir.dgi.zynerator.converter.AbstractConverter;
import ma.sir.dgi.zynerator.util.DateUtil;
import ma.sir.dgi.bean.history.TypeOperationComptableHistory;
import ma.sir.dgi.bean.core.TypeOperationComptable;
import ma.sir.dgi.ws.dto.TypeOperationComptableDto;

@Component
public class TypeOperationComptableConverter extends AbstractConverter<TypeOperationComptable, TypeOperationComptableDto, TypeOperationComptableHistory> {


    public  TypeOperationComptableConverter(){
        super(TypeOperationComptable.class, TypeOperationComptableDto.class, TypeOperationComptableHistory.class);
    }

    @Override
    public TypeOperationComptable toItem(TypeOperationComptableDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeOperationComptable item = new TypeOperationComptable();
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
    public TypeOperationComptableDto toDto(TypeOperationComptable item) {
        if (item == null) {
            return null;
        } else {
            TypeOperationComptableDto dto = new TypeOperationComptableDto();
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
