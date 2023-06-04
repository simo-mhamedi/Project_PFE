package  ma.sir.dgi.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.dgi.zynerator.util.StringUtil;
import ma.sir.dgi.zynerator.converter.AbstractConverter;
import ma.sir.dgi.zynerator.util.DateUtil;
import ma.sir.dgi.bean.history.DeclarationTvaHistory;
import ma.sir.dgi.bean.core.DeclarationTva;
import ma.sir.dgi.ws.dto.DeclarationTvaDto;

@Component
public class DeclarationTvaConverter extends AbstractConverter<DeclarationTva, DeclarationTvaDto, DeclarationTvaHistory> {

    @Autowired
    private TauxRetardTvaConverter tauxRetardTvaConverter ;
    @Autowired
    private SocieteConverter societeConverter ;
    private boolean societe;
    private boolean tauxRetardTva;

    public  DeclarationTvaConverter(){
        super(DeclarationTva.class, DeclarationTvaDto.class, DeclarationTvaHistory.class);
    }

    @Override
    public DeclarationTva toItem(DeclarationTvaDto dto) {
        if (dto == null) {
            return null;
        } else {
        DeclarationTva item = new DeclarationTva();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateDeclaration()))
                item.setDateDeclaration(DateUtil.stringEnToDate(dto.getDateDeclaration()));
            if(StringUtil.isNotEmpty(dto.getTrimistre()))
                item.setTrimistre(dto.getTrimistre());
            if(StringUtil.isNotEmpty(dto.getAnnee()))
                item.setAnnee(dto.getAnnee());
            if(StringUtil.isNotEmpty(dto.getTotalTvaCollecte()))
                item.setTotalTvaCollecte(dto.getTotalTvaCollecte());
            if(StringUtil.isNotEmpty(dto.getTotalTvaDue()))
                item.setTotalTvaDue(dto.getTotalTvaDue());
            if(StringUtil.isNotEmpty(dto.getDifferenceTva()))
                item.setDifferenceTva(dto.getDifferenceTva());
            if(StringUtil.isNotEmpty(dto.getMontantTva()))
                item.setMontantTva(dto.getMontantTva());
            if(this.societe && dto.getSociete()!=null)
                item.setSociete(societeConverter.toItem(dto.getSociete())) ;

            if(this.tauxRetardTva && dto.getTauxRetardTva()!=null)
                item.setTauxRetardTva(tauxRetardTvaConverter.toItem(dto.getTauxRetardTva())) ;



        return item;
        }
    }

    @Override
    public DeclarationTvaDto toDto(DeclarationTva item) {
        if (item == null) {
            return null;
        } else {
            DeclarationTvaDto dto = new DeclarationTvaDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateDeclaration()!=null)
                dto.setDateDeclaration(DateUtil.dateTimeToString(item.getDateDeclaration()));
            if(StringUtil.isNotEmpty(item.getTrimistre()))
                dto.setTrimistre(item.getTrimistre());
            if(StringUtil.isNotEmpty(item.getAnnee()))
                dto.setAnnee(item.getAnnee());
            if(StringUtil.isNotEmpty(item.getTotalTvaCollecte()))
                dto.setTotalTvaCollecte(item.getTotalTvaCollecte());
            if(StringUtil.isNotEmpty(item.getTotalTvaDue()))
                dto.setTotalTvaDue(item.getTotalTvaDue());
            if(StringUtil.isNotEmpty(item.getDifferenceTva()))
                dto.setDifferenceTva(item.getDifferenceTva());
            if(StringUtil.isNotEmpty(item.getMontantTva()))
                dto.setMontantTva(item.getMontantTva());
        if(this.societe && item.getSociete()!=null) {
            dto.setSociete(societeConverter.toDto(item.getSociete())) ;
        }
        if(this.tauxRetardTva && item.getTauxRetardTva()!=null) {
            dto.setTauxRetardTva(tauxRetardTvaConverter.toDto(item.getTauxRetardTva())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.societe = value;
        this.tauxRetardTva = value;
    }


    public TauxRetardTvaConverter getTauxRetardTvaConverter(){
        return this.tauxRetardTvaConverter;
    }
    public void setTauxRetardTvaConverter(TauxRetardTvaConverter tauxRetardTvaConverter ){
        this.tauxRetardTvaConverter = tauxRetardTvaConverter;
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
    public boolean  isTauxRetardTva(){
        return this.tauxRetardTva;
    }
    public void  setTauxRetardTva(boolean tauxRetardTva){
        this.tauxRetardTva = tauxRetardTva;
    }
}
