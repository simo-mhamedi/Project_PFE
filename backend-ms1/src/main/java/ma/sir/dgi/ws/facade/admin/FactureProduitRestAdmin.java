package  ma.sir.dgi.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.dgi.bean.core.FactureProduit;
import ma.sir.dgi.bean.history.FactureProduitHistory;
import ma.sir.dgi.dao.criteria.core.FactureProduitCriteria;
import ma.sir.dgi.dao.criteria.history.FactureProduitHistoryCriteria;
import ma.sir.dgi.service.facade.admin.FactureProduitAdminService;
import ma.sir.dgi.ws.converter.FactureProduitConverter;
import ma.sir.dgi.ws.dto.FactureProduitDto;
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

@Api("Manages factureProduit services")
@RestController
@RequestMapping("/api/admin/factureProduit/")
public class FactureProduitRestAdmin  extends AbstractController<FactureProduit, FactureProduitDto, FactureProduitHistory, FactureProduitCriteria, FactureProduitHistoryCriteria, FactureProduitAdminService, FactureProduitConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody FactureProduitDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one factureProduit")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple factureProduits")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all factureProduits")
    @GetMapping("")
    public ResponseEntity<List<FactureProduitDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a factureProduit by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FactureProduitDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  factureProduit")
    @PostMapping("")
    public ResponseEntity<FactureProduitDto> save(@RequestBody FactureProduitDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  factureProduit")
    @PutMapping("")
    public ResponseEntity<FactureProduitDto> update(@RequestBody FactureProduitDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of factureProduit")
    @PostMapping("multiple")
    public ResponseEntity<List<FactureProduitDto>> delete(@RequestBody List<FactureProduitDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified factureProduit")
    @DeleteMapping("")
    public ResponseEntity<FactureProduitDto> delete(@RequestBody FactureProduitDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified factureProduit")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple factureProduits by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by societe id")
    @GetMapping("societe/id/{id}")
    public List<FactureProduit> findBySocieteId(@PathVariable Long id){
        return service.findBySocieteId(id);
    }
    @ApiOperation("delete by societe id")
    @DeleteMapping("societe/id/{id}")
    public int deleteBySocieteId(@PathVariable Long id){
        return service.deleteBySocieteId(id);
    }
    @ApiOperation("find by declarationIs id")
    @GetMapping("declarationIs/id/{id}")
    public List<FactureProduit> findByDeclarationIsId(@PathVariable Long id){
        return service.findByDeclarationIsId(id);
    }
    @ApiOperation("delete by declarationIs id")
    @DeleteMapping("declarationIs/id/{id}")
    public int deleteByDeclarationIsId(@PathVariable Long id){
        return service.deleteByDeclarationIsId(id);
    }
    @ApiOperation("Finds factureProduits by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FactureProduitDto>> findByCriteria(@RequestBody FactureProduitCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated factureProduits by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FactureProduitCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports factureProduits by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FactureProduitCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets factureProduit data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FactureProduitCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets factureProduit history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets factureProduit paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody FactureProduitHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports factureProduit history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody FactureProduitHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets factureProduit history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody FactureProduitHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public FactureProduitRestAdmin (FactureProduitAdminService service, FactureProduitConverter converter) {
        super(service, converter);
    }


}