package  ma.sir.dgi.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.dgi.zynerator.util.StringUtil;
import ma.sir.dgi.zynerator.converter.AbstractConverter;
import ma.sir.dgi.zynerator.util.DateUtil;
import ma.sir.dgi.bean.history.BilanHistory;
import ma.sir.dgi.bean.core.Bilan;
import ma.sir.dgi.ws.dto.BilanDto;

@Component
public class BilanConverter extends AbstractConverter<Bilan, BilanDto, BilanHistory> {

    @Autowired
    private EtatBilanConverter etatBilanConverter ;
    @Autowired
    private SocieteConverter societeConverter ;
    private boolean societe;
    private boolean etatBilan;

    public  BilanConverter(){
        super(Bilan.class, BilanDto.class, BilanHistory.class);
    }

    @Override
    public Bilan toItem(BilanDto dto) {
        if (dto == null) {
            return null;
        } else {
        Bilan item = new Bilan();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getAnnee()))
                item.setAnnee(dto.getAnnee());
            if(StringUtil.isNotEmpty(dto.getImmobilisationsIncorporelles()))
                item.setImmobilisationsIncorporelles(dto.getImmobilisationsIncorporelles());
            if(StringUtil.isNotEmpty(dto.getImmobilisationsCorporelles()))
                item.setImmobilisationsCorporelles(dto.getImmobilisationsCorporelles());
            if(StringUtil.isNotEmpty(dto.getImmobilisationsFinancieres()))
                item.setImmobilisationsFinancieres(dto.getImmobilisationsFinancieres());
            if(StringUtil.isNotEmpty(dto.getTotalActifImmobolise()))
                item.setTotalActifImmobolise(dto.getTotalActifImmobolise());
            if(StringUtil.isNotEmpty(dto.getStocks()))
                item.setStocks(dto.getStocks());
            if(StringUtil.isNotEmpty(dto.getCreancesClients()))
                item.setCreancesClients(dto.getCreancesClients());
            if(StringUtil.isNotEmpty(dto.getTotalActifCirculant()))
                item.setTotalActifCirculant(dto.getTotalActifCirculant());
            if(StringUtil.isNotEmpty(dto.getDepotEnBanque()))
                item.setDepotEnBanque(dto.getDepotEnBanque());
            if(StringUtil.isNotEmpty(dto.getAvoirEnCaisse()))
                item.setAvoirEnCaisse(dto.getAvoirEnCaisse());
            if(StringUtil.isNotEmpty(dto.getTotalTresorieActif()))
                item.setTotalTresorieActif(dto.getTotalTresorieActif());
            if(StringUtil.isNotEmpty(dto.getTotalActif()))
                item.setTotalActif(dto.getTotalActif());
            if(StringUtil.isNotEmpty(dto.getCapitalPersonnel()))
                item.setCapitalPersonnel(dto.getCapitalPersonnel());
            if(StringUtil.isNotEmpty(dto.getEmprunts()))
                item.setEmprunts(dto.getEmprunts());
            if(StringUtil.isNotEmpty(dto.getResultat()))
                item.setResultat(dto.getResultat());
            if(StringUtil.isNotEmpty(dto.getTotalFinnancementPermanant()))
                item.setTotalFinnancementPermanant(dto.getTotalFinnancementPermanant());
            if(StringUtil.isNotEmpty(dto.getDettesFournisseurs()))
                item.setDettesFournisseurs(dto.getDettesFournisseurs());
            if(StringUtil.isNotEmpty(dto.getAutresDettesCirculantes()))
                item.setAutresDettesCirculantes(dto.getAutresDettesCirculantes());
            if(StringUtil.isNotEmpty(dto.getTotalPassifCirculant()))
                item.setTotalPassifCirculant(dto.getTotalPassifCirculant());
            if(StringUtil.isNotEmpty(dto.getTotalPassif()))
                item.setTotalPassif(dto.getTotalPassif());
            if(this.societe && dto.getSociete()!=null)
                item.setSociete(societeConverter.toItem(dto.getSociete())) ;

            if(this.etatBilan && dto.getEtatBilan()!=null)
                item.setEtatBilan(etatBilanConverter.toItem(dto.getEtatBilan())) ;



        return item;
        }
    }

    @Override
    public BilanDto toDto(Bilan item) {
        if (item == null) {
            return null;
        } else {
            BilanDto dto = new BilanDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getAnnee()))
                dto.setAnnee(item.getAnnee());
            if(StringUtil.isNotEmpty(item.getImmobilisationsIncorporelles()))
                dto.setImmobilisationsIncorporelles(item.getImmobilisationsIncorporelles());
            if(StringUtil.isNotEmpty(item.getImmobilisationsCorporelles()))
                dto.setImmobilisationsCorporelles(item.getImmobilisationsCorporelles());
            if(StringUtil.isNotEmpty(item.getImmobilisationsFinancieres()))
                dto.setImmobilisationsFinancieres(item.getImmobilisationsFinancieres());
            if(StringUtil.isNotEmpty(item.getTotalActifImmobolise()))
                dto.setTotalActifImmobolise(item.getTotalActifImmobolise());
            if(StringUtil.isNotEmpty(item.getStocks()))
                dto.setStocks(item.getStocks());
            if(StringUtil.isNotEmpty(item.getCreancesClients()))
                dto.setCreancesClients(item.getCreancesClients());
            if(StringUtil.isNotEmpty(item.getTotalActifCirculant()))
                dto.setTotalActifCirculant(item.getTotalActifCirculant());
            if(StringUtil.isNotEmpty(item.getDepotEnBanque()))
                dto.setDepotEnBanque(item.getDepotEnBanque());
            if(StringUtil.isNotEmpty(item.getAvoirEnCaisse()))
                dto.setAvoirEnCaisse(item.getAvoirEnCaisse());
            if(StringUtil.isNotEmpty(item.getTotalTresorieActif()))
                dto.setTotalTresorieActif(item.getTotalTresorieActif());
            if(StringUtil.isNotEmpty(item.getTotalActif()))
                dto.setTotalActif(item.getTotalActif());
            if(StringUtil.isNotEmpty(item.getCapitalPersonnel()))
                dto.setCapitalPersonnel(item.getCapitalPersonnel());
            if(StringUtil.isNotEmpty(item.getEmprunts()))
                dto.setEmprunts(item.getEmprunts());
            if(StringUtil.isNotEmpty(item.getResultat()))
                dto.setResultat(item.getResultat());
            if(StringUtil.isNotEmpty(item.getTotalFinnancementPermanant()))
                dto.setTotalFinnancementPermanant(item.getTotalFinnancementPermanant());
            if(StringUtil.isNotEmpty(item.getDettesFournisseurs()))
                dto.setDettesFournisseurs(item.getDettesFournisseurs());
            if(StringUtil.isNotEmpty(item.getAutresDettesCirculantes()))
                dto.setAutresDettesCirculantes(item.getAutresDettesCirculantes());
            if(StringUtil.isNotEmpty(item.getTotalPassifCirculant()))
                dto.setTotalPassifCirculant(item.getTotalPassifCirculant());
            if(StringUtil.isNotEmpty(item.getTotalPassif()))
                dto.setTotalPassif(item.getTotalPassif());
        if(this.societe && item.getSociete()!=null) {
            dto.setSociete(societeConverter.toDto(item.getSociete())) ;
        }
        if(this.etatBilan && item.getEtatBilan()!=null) {
            dto.setEtatBilan(etatBilanConverter.toDto(item.getEtatBilan())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.societe = value;
        this.etatBilan = value;
    }


    public EtatBilanConverter getEtatBilanConverter(){
        return this.etatBilanConverter;
    }
    public void setEtatBilanConverter(EtatBilanConverter etatBilanConverter ){
        this.etatBilanConverter = etatBilanConverter;
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
    public boolean  isEtatBilan(){
        return this.etatBilan;
    }
    public void  setEtatBilan(boolean etatBilan){
        this.etatBilan = etatBilan;
    }
}
