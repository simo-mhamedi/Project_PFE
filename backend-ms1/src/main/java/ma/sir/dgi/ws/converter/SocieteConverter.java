package  ma.sir.dgi.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.dgi.zynerator.util.StringUtil;
import ma.sir.dgi.zynerator.converter.AbstractConverter;
import ma.sir.dgi.zynerator.util.DateUtil;
import ma.sir.dgi.bean.history.SocieteHistory;
import ma.sir.dgi.bean.core.Societe;
import ma.sir.dgi.ws.dto.SocieteDto;

@Component
public class SocieteConverter extends AbstractConverter<Societe, SocieteDto, SocieteHistory> {


    public  SocieteConverter(){
        super(Societe.class, SocieteDto.class, SocieteHistory.class);
    }

    @Override
    public Societe toItem(SocieteDto dto) {
        if (dto == null) {
            return null;
        } else {
        Societe item = new Societe();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getIce()))
                item.setIce(dto.getIce());
            if(StringUtil.isNotEmpty(dto.getSiege()))
                item.setSiege(dto.getSiege());
            if(StringUtil.isNotEmpty(dto.getDernierAnneePayerIs()))
                item.setDernierAnneePayerIs(dto.getDernierAnneePayerIs());
            if(StringUtil.isNotEmpty(dto.getDernierTrimestrePayerIs()))
                item.setDernierTrimestrePayerIs(dto.getDernierTrimestrePayerIs());
            if(StringUtil.isNotEmpty(dto.getDernierAnneePayerTva()))
                item.setDernierAnneePayerTva(dto.getDernierAnneePayerTva());
            if(StringUtil.isNotEmpty(dto.getDernierTrimestrePayerTva()))
                item.setDernierTrimestrePayerTva(dto.getDernierTrimestrePayerTva());
            if(dto.getBloqued() != null)
                item.setBloqued(dto.getBloqued());


        return item;
        }
    }

    @Override
    public SocieteDto toDto(Societe item) {
        if (item == null) {
            return null;
        } else {
            SocieteDto dto = new SocieteDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getIce()))
                dto.setIce(item.getIce());
            if(StringUtil.isNotEmpty(item.getSiege()))
                dto.setSiege(item.getSiege());
            if(StringUtil.isNotEmpty(item.getDernierAnneePayerIs()))
                dto.setDernierAnneePayerIs(item.getDernierAnneePayerIs());
            if(StringUtil.isNotEmpty(item.getDernierTrimestrePayerIs()))
                dto.setDernierTrimestrePayerIs(item.getDernierTrimestrePayerIs());
            if(StringUtil.isNotEmpty(item.getDernierAnneePayerTva()))
                dto.setDernierAnneePayerTva(item.getDernierAnneePayerTva());
            if(StringUtil.isNotEmpty(item.getDernierTrimestrePayerTva()))
                dto.setDernierTrimestrePayerTva(item.getDernierTrimestrePayerTva());
                dto.setBloqued(item.getBloqued());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
