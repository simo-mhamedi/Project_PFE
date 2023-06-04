package  ma.sir.dgi.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.dgi.bean.core.FactureCharge;
import ma.sir.dgi.bean.history.FactureChargeHistory;
import ma.sir.dgi.dao.criteria.core.FactureChargeCriteria;
import ma.sir.dgi.dao.criteria.history.FactureChargeHistoryCriteria;
import ma.sir.dgi.service.facade.admin.FactureChargeAdminService;
import ma.sir.dgi.ws.converter.FactureChargeConverter;
import ma.sir.dgi.ws.dto.FactureChargeDto;
import ma.sir.dgi.zynerator.controller.AbstractController;
import ma.sir.dgi.zynerator.dto.AuditEntityDto;
import ma.sir.dgi.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.dgi.zynerator.process.Result;

import org.springframework.http.HttpEntity;

import org.springframework.web.multipart.MultipartFile;
import ma.sir.dgi.zynerator.dto.FileTempDto;

@Api("Manages factureCharge services")
@RestController
@RequestMapping("/api/admin/factureCharge/")
public class FactureChargeRestAdmin  extends AbstractController<FactureCharge, FactureChargeDto, FactureChargeHistory, FactureChargeCriteria, FactureChargeHistoryCriteria, FactureChargeAdminService, FactureChargeConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody FactureChargeDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one factureCharge")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple factureCharges")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all factureCharges")
    @GetMapping("")
    public ResponseEntity<List<FactureChargeDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a factureCharge by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FactureChargeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  factureCharge")
    @PostMapping("")
    public ResponseEntity<FactureChargeDto> save(@RequestBody FactureChargeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  factureCharge")
    @PutMapping("")
    public ResponseEntity<FactureChargeDto> update(@RequestBody FactureChargeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of factureCharge")
    @PostMapping("multiple")
    public ResponseEntity<List<FactureChargeDto>> delete(@RequestBody List<FactureChargeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified factureCharge")
    @DeleteMapping("")
    public ResponseEntity<FactureChargeDto> delete(@RequestBody FactureChargeDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified factureCharge")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple factureCharges by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by societe id")
    @GetMapping("societe/id/{id}")
    public List<FactureCharge> findBySocieteId(@PathVariable Long id){
        return service.findBySocieteId(id);
    }
    @ApiOperation("delete by societe id")
    @DeleteMapping("societe/id/{id}")
    public int deleteBySocieteId(@PathVariable Long id){
        return service.deleteBySocieteId(id);
    }
    @ApiOperation("find by declarationIs id")
    @GetMapping("declarationIs/id/{id}")
    public List<FactureCharge> findByDeclarationIsId(@PathVariable Long id){
        return service.findByDeclarationIsId(id);
    }
    @ApiOperation("delete by declarationIs id")
    @DeleteMapping("declarationIs/id/{id}")
    public int deleteByDeclarationIsId(@PathVariable Long id){
        return service.deleteByDeclarationIsId(id);
    }
    @ApiOperation("Finds factureCharges by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FactureChargeDto>> findByCriteria(@RequestBody FactureChargeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated factureCharges by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FactureChargeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports factureCharges by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FactureChargeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets factureCharge data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FactureChargeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets factureCharge history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets factureCharge paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody FactureChargeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports factureCharge history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody FactureChargeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets factureCharge history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody FactureChargeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public FactureChargeRestAdmin (FactureChargeAdminService service, FactureChargeConverter converter) {
        super(service, converter);
    }


}