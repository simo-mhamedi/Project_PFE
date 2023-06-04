package  ma.sir.dgi.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.dgi.bean.core.DeclarationIs;

import ma.sir.dgi.zynerator.util.StringUtil;
import ma.sir.dgi.zynerator.converter.AbstractConverter;
import ma.sir.dgi.zynerator.util.DateUtil;
import ma.sir.dgi.bean.history.FactureChargeHistory;
import ma.sir.dgi.bean.core.FactureCharge;
import ma.sir.dgi.ws.dto.FactureChargeDto;

@Component
public class FactureChargeConverter extends AbstractConverter<FactureCharge, FactureChargeDto, FactureChargeHistory> {

    @Autowired
    private DeclarationIsConverter declarationIsConverter ;
    @Autowired
    private SocieteConverter societeConverter ;
    private boolean societe;
    private boolean declarationIs;

    public  FactureChargeConverter(){
        super(FactureCharge.class, FactureChargeDto.class, FactureChargeHistory.class);
    }

    @Override
    public FactureCharge toItem(FactureChargeDto dto) {
        if (dto == null) {
            return null;
        } else {
        FactureCharge item = new FactureCharge();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateFacuture()))
                item.setDateFacuture(DateUtil.stringEnToDate(dto.getDateFacuture()));
            if(StringUtil.isNotEmpty(dto.getIce()))
                item.setIce(dto.getIce());
            if(StringUtil.isNotEmpty(dto.getMontantHt()))
                item.setMontantHt(dto.getMontantHt());
            if(StringUtil.isNotEmpty(dto.getMontantTtc()))
                item.setMontantTtc(dto.getMontantTtc());
            if(StringUtil.isNotEmpty(dto.getMontantTva()))
                item.setMontantTva(dto.getMontantTva());
            if(this.societe && dto.getSociete()!=null)
                item.setSociete(societeConverter.toItem(dto.getSociete())) ;

            if(dto.getDeclarationIs() != null && dto.getDeclarationIs().getId() != null){
                item.setDeclarationIs(new DeclarationIs());
                item.getDeclarationIs().setId(dto.getDeclarationIs().getId());
            }



        return item;
        }
    }

    @Override
    public FactureChargeDto toDto(FactureCharge item) {
        if (item == null) {
            return null;
        } else {
            FactureChargeDto dto = new FactureChargeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateFacuture()!=null)
                dto.setDateFacuture(DateUtil.dateTimeToString(item.getDateFacuture()));
            if(StringUtil.isNotEmpty(item.getIce()))
                dto.setIce(item.getIce());
            if(StringUtil.isNotEmpty(item.getMontantHt()))
                dto.setMontantHt(item.getMontantHt());
            if(StringUtil.isNotEmpty(item.getMontantTtc()))
                dto.setMontantTtc(item.getMontantTtc());
            if(StringUtil.isNotEmpty(item.getMontantTva()))
                dto.setMontantTva(item.getMontantTva());
        if(this.societe && item.getSociete()!=null) {
            dto.setSociete(societeConverter.toDto(item.getSociete())) ;
        }
        if(this.declarationIs && item.getDeclarationIs()!=null) {
            dto.setDeclarationIs(declarationIsConverter.toDto(item.getDeclarationIs())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.societe = value;
        this.declarationIs = value;
    }


    public DeclarationIsConverter getDeclarationIsConverter(){
        return this.declarationIsConverter;
    }
    public void setDeclarationIsConverter(DeclarationIsConverter declarationIsConverter ){
        this.declarationIsConverter = declarationIsConverter;
    }
    public SocieteConverter getSocieteConverter(){
        return this.societeConverter;
    }
    public void setSocieteConverter(SocieteConverter societeConverter ){
        this.societeConverter = societeConverter;
    }
    public boolean  isSociete(){
        return this.societe;
    }
    public void  setSociete(boolean societe){
        this.societe = societe;
    }
    public boolean  isDeclarationIs(){
        return this.declarationIs;
    }
    public void  setDeclarationIs(boolean declarationIs){
        this.declarationIs = declarationIs;
    }
}
