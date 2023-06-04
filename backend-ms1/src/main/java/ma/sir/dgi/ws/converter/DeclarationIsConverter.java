package  ma.sir.dgi.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.dgi.zynerator.util.ListUtil;


import ma.sir.dgi.zynerator.util.StringUtil;
import ma.sir.dgi.zynerator.converter.AbstractConverter;
import ma.sir.dgi.zynerator.util.DateUtil;
import ma.sir.dgi.bean.history.DeclarationIsHistory;
import ma.sir.dgi.bean.core.DeclarationIs;
import ma.sir.dgi.ws.dto.DeclarationIsDto;

@Component
public class DeclarationIsConverter extends AbstractConverter<DeclarationIs, DeclarationIsDto, DeclarationIsHistory> {

    @Autowired
    private FactureProduitConverter factureProduitConverter ;
    @Autowired
    private SocieteConverter societeConverter ;
    @Autowired
    private TauxIsConverter tauxIsConverter ;
    @Autowired
    private FactureChargeConverter factureChargeConverter ;
    private boolean societe;
    private boolean tauxIs;
    private boolean factureCharges;
    private boolean factureProduits;

    public  DeclarationIsConverter(){
        super(DeclarationIs.class, DeclarationIsDto.class, DeclarationIsHistory.class);
        init(true);
    }

    @Override
    public DeclarationIs toItem(DeclarationIsDto dto) {
        if (dto == null) {
            return null;
        } else {
        DeclarationIs item = new DeclarationIs();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateDeclaration()))
                item.setDateDeclaration(DateUtil.stringEnToDate(dto.getDateDeclaration()));
            if(StringUtil.isNotEmpty(dto.getTrimistre()))
                item.setTrimistre(dto.getTrimistre());
            if(StringUtil.isNotEmpty(dto.getAnnee()))
                item.setAnnee(dto.getAnnee());
            if(StringUtil.isNotEmpty(dto.getTotalCharge()))
                item.setTotalCharge(dto.getTotalCharge());
            if(StringUtil.isNotEmpty(dto.getTotalProduit()))
                item.setTotalProduit(dto.getTotalProduit());
            if(StringUtil.isNotEmpty(dto.getResultatAvantImpot()))
                item.setResultatAvantImpot(dto.getResultatAvantImpot());
            if(StringUtil.isNotEmpty(dto.getMontantImpot()))
                item.setMontantImpot(dto.getMontantImpot());
            if(StringUtil.isNotEmpty(dto.getResultatApresImpot()))
                item.setResultatApresImpot(dto.getResultatApresImpot());
            if(this.societe && dto.getSociete()!=null)
                item.setSociete(societeConverter.toItem(dto.getSociete())) ;

            if(this.tauxIs && dto.getTauxIs()!=null)
                item.setTauxIs(tauxIsConverter.toItem(dto.getTauxIs())) ;


            if(this.factureCharges && ListUtil.isNotEmpty(dto.getFactureCharges()))
                item.setFactureCharges(factureChargeConverter.toItem(dto.getFactureCharges()));
            if(this.factureProduits && ListUtil.isNotEmpty(dto.getFactureProduits()))
                item.setFactureProduits(factureProduitConverter.toItem(dto.getFactureProduits()));

        return item;
        }
    }

    @Override
    public DeclarationIsDto toDto(DeclarationIs item) {
        if (item == null) {
            return null;
        } else {
            DeclarationIsDto dto = new DeclarationIsDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateDeclaration()!=null)
                dto.setDateDeclaration(DateUtil.dateTimeToString(item.getDateDeclaration()));
            if(StringUtil.isNotEmpty(item.getTrimistre()))
                dto.setTrimistre(item.getTrimistre());
            if(StringUtil.isNotEmpty(item.getAnnee()))
                dto.setAnnee(item.getAnnee());
            if(StringUtil.isNotEmpty(item.getTotalCharge()))
                dto.setTotalCharge(item.getTotalCharge());
            if(StringUtil.isNotEmpty(item.getTotalProduit()))
                dto.setTotalProduit(item.getTotalProduit());
            if(StringUtil.isNotEmpty(item.getResultatAvantImpot()))
                dto.setResultatAvantImpot(item.getResultatAvantImpot());
            if(StringUtil.isNotEmpty(item.getMontantImpot()))
                dto.setMontantImpot(item.getMontantImpot());
            if(StringUtil.isNotEmpty(item.getResultatApresImpot()))
                dto.setResultatApresImpot(item.getResultatApresImpot());
        if(this.societe && item.getSociete()!=null) {
            dto.setSociete(societeConverter.toDto(item.getSociete())) ;
        }
        if(this.tauxIs && item.getTauxIs()!=null) {
            dto.setTauxIs(tauxIsConverter.toDto(item.getTauxIs())) ;
        }
        if(this.factureCharges && ListUtil.isNotEmpty(item.getFactureCharges())){
            factureChargeConverter.init(true);
            factureChargeConverter.setDeclarationIs(false);
            dto.setFactureCharges(factureChargeConverter.toDto(item.getFactureCharges()));
            factureChargeConverter.setDeclarationIs(true);

        }
        if(this.factureProduits && ListUtil.isNotEmpty(item.getFactureProduits())){
            factureProduitConverter.init(true);
            factureProduitConverter.setDeclarationIs(false);
            dto.setFactureProduits(factureProduitConverter.toDto(item.getFactureProduits()));
            factureProduitConverter.setDeclarationIs(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.factureCharges = value;
        this.factureProduits = value;
    }

    public void initObject(boolean value) {
        this.societe = value;
        this.tauxIs = value;
    }


    public FactureProduitConverter getFactureProduitConverter(){
        return this.factureProduitConverter;
    }
    public void setFactureProduitConverter(FactureProduitConverter factureProduitConverter ){
        this.factureProduitConverter = factureProduitConverter;
    }
    public SocieteConverter getSocieteConverter(){
        return this.societeConverter;
    }
    public void setSocieteConverter(SocieteConverter societeConverter ){
        this.societeConverter = societeConverter;
    }
    public TauxIsConverter getTauxIsConverter(){
        return this.tauxIsConverter;
    }
    public void setTauxIsConverter(TauxIsConverter tauxIsConverter ){
        this.tauxIsConverter = tauxIsConverter;
    }
    public FactureChargeConverter getFactureChargeConverter(){
        return this.factureChargeConverter;
    }
    public void setFactureChargeConverter(FactureChargeConverter factureChargeConverter ){
        this.factureChargeConverter = factureChargeConverter;
    }
    public boolean  isSociete(){
        return this.societe;
    }
    public void  setSociete(boolean societe){
        this.societe = societe;
    }
    public boolean  isTauxIs(){
        return this.tauxIs;
    }
    public void  setTauxIs(boolean tauxIs){
        this.tauxIs = tauxIs;
    }
    public boolean  isFactureCharges(){
        return this.factureCharges ;
    }
    public void  setFactureCharges(boolean factureCharges ){
        this.factureCharges  = factureCharges ;
    }
    public boolean  isFactureProduits(){
        return this.factureProduits ;
    }
    public void  setFactureProduits(boolean factureProduits ){
        this.factureProduits  = factureProduits ;
    }
}
