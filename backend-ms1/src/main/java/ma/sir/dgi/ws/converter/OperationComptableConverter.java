package  ma.sir.dgi.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.dgi.zynerator.util.StringUtil;
import ma.sir.dgi.zynerator.converter.AbstractConverter;
import ma.sir.dgi.zynerator.util.DateUtil;
import ma.sir.dgi.bean.history.OperationComptableHistory;
import ma.sir.dgi.bean.core.OperationComptable;
import ma.sir.dgi.ws.dto.OperationComptableDto;

@Component
public class OperationComptableConverter extends AbstractConverter<OperationComptable, OperationComptableDto, OperationComptableHistory> {

    @Autowired
    private EtatOperationComptableConverter etatOperationComptableConverter ;
    @Autowired
    private CompteComptableConverter compteComptableConverter ;
    @Autowired
    private SocieteConverter societeConverter ;
    @Autowired
    private TypeOperationComptableConverter typeOperationComptableConverter ;
    private boolean societe;
    private boolean compteComptable;
    private boolean typeOperationComptable;
    private boolean etatOperationComptable;

    public  OperationComptableConverter(){
        super(OperationComptable.class, OperationComptableDto.class, OperationComptableHistory.class);
    }

    @Override
    public OperationComptable toItem(OperationComptableDto dto) {
        if (dto == null) {
            return null;
        } else {
        OperationComptable item = new OperationComptable();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getAnnee()))
                item.setAnnee(dto.getAnnee());
            if(StringUtil.isNotEmpty(dto.getMois()))
                item.setMois(dto.getMois());
            if(StringUtil.isNotEmpty(dto.getDateOperationComptable()))
                item.setDateOperationComptable(DateUtil.stringEnToDate(dto.getDateOperationComptable()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(this.societe && dto.getSociete()!=null)
                item.setSociete(societeConverter.toItem(dto.getSociete())) ;

            if(this.compteComptable && dto.getCompteComptable()!=null)
                item.setCompteComptable(compteComptableConverter.toItem(dto.getCompteComptable())) ;

            if(this.typeOperationComptable && dto.getTypeOperationComptable()!=null)
                item.setTypeOperationComptable(typeOperationComptableConverter.toItem(dto.getTypeOperationComptable())) ;

            if(this.etatOperationComptable && dto.getEtatOperationComptable()!=null)
                item.setEtatOperationComptable(etatOperationComptableConverter.toItem(dto.getEtatOperationComptable())) ;



        return item;
        }
    }

    @Override
    public OperationComptableDto toDto(OperationComptable item) {
        if (item == null) {
            return null;
        } else {
            OperationComptableDto dto = new OperationComptableDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getAnnee()))
                dto.setAnnee(item.getAnnee());
            if(StringUtil.isNotEmpty(item.getMois()))
                dto.setMois(item.getMois());
            if(item.getDateOperationComptable()!=null)
                dto.setDateOperationComptable(DateUtil.dateTimeToString(item.getDateOperationComptable()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
        if(this.societe && item.getSociete()!=null) {
            dto.setSociete(societeConverter.toDto(item.getSociete())) ;
        }
        if(this.compteComptable && item.getCompteComptable()!=null) {
            dto.setCompteComptable(compteComptableConverter.toDto(item.getCompteComptable())) ;
        }
        if(this.typeOperationComptable && item.getTypeOperationComptable()!=null) {
            dto.setTypeOperationComptable(typeOperationComptableConverter.toDto(item.getTypeOperationComptable())) ;
        }
        if(this.etatOperationComptable && item.getEtatOperationComptable()!=null) {
            dto.setEtatOperationComptable(etatOperationComptableConverter.toDto(item.getEtatOperationComptable())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.societe = value;
        this.compteComptable = value;
        this.typeOperationComptable = value;
        this.etatOperationComptable = value;
    }


    public EtatOperationComptableConverter getEtatOperationComptableConverter(){
        return this.etatOperationComptableConverter;
    }
    public void setEtatOperationComptableConverter(EtatOperationComptableConverter etatOperationComptableConverter ){
        this.etatOperationComptableConverter = etatOperationComptableConverter;
    }
    public CompteComptableConverter getCompteComptableConverter(){
        return this.compteComptableConverter;
    }
    public void setCompteComptableConverter(CompteComptableConverter compteComptableConverter ){
        this.compteComptableConverter = compteComptableConverter;
    }
    public SocieteConverter getSocieteConverter(){
        return this.societeConverter;
    }
    public void setSocieteConverter(SocieteConverter societeConverter ){
        this.societeConverter = societeConverter;
    }
    public TypeOperationComptableConverter getTypeOperationComptableConverter(){
        return this.typeOperationComptableConverter;
    }
    public void setTypeOperationComptableConverter(TypeOperationComptableConverter typeOperationComptableConverter ){
        this.typeOperationComptableConverter = typeOperationComptableConverter;
    }
    public boolean  isSociete(){
        return this.societe;
    }
    public void  setSociete(boolean societe){
        this.societe = societe;
    }
    public boolean  isCompteComptable(){
        return this.compteComptable;
    }
    public void  setCompteComptable(boolean compteComptable){
        this.compteComptable = compteComptable;
    }
    public boolean  isTypeOperationComptable(){
        return this.typeOperationComptable;
    }
    public void  setTypeOperationComptable(boolean typeOperationComptable){
        this.typeOperationComptable = typeOperationComptable;
    }
    public boolean  isEtatOperationComptable(){
        return this.etatOperationComptable;
    }
    public void  setEtatOperationComptable(boolean etatOperationComptable){
        this.etatOperationComptable = etatOperationComptable;
    }
}
