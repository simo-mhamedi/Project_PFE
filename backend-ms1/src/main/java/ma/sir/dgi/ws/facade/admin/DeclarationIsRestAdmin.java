package  ma.sir.dgi.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.dgi.bean.core.DeclarationIs;
import ma.sir.dgi.bean.history.DeclarationIsHistory;
import ma.sir.dgi.dao.criteria.core.DeclarationIsCriteria;
import ma.sir.dgi.dao.criteria.history.DeclarationIsHistoryCriteria;
import ma.sir.dgi.service.facade.admin.DeclarationIsAdminService;
import ma.sir.dgi.ws.converter.DeclarationIsConverter;
import ma.sir.dgi.ws.dto.DeclarationIsDto;
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

@Api("Manages declarationIs services")
@RestController
@RequestMapping("/api/admin/declarationIs/")
public class DeclarationIsRestAdmin  extends AbstractController<DeclarationIs, DeclarationIsDto, DeclarationIsHistory, DeclarationIsCriteria, DeclarationIsHistoryCriteria, DeclarationIsAdminService, DeclarationIsConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody DeclarationIsDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one declarationIs")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple declarationIss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all declarationIss")
    @GetMapping("")
    public ResponseEntity<List<DeclarationIsDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a declarationIs by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DeclarationIsDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  declarationIs")
    @PostMapping("")
    public ResponseEntity<DeclarationIsDto> save(@RequestBody DeclarationIsDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  declarationIs")
    @PutMapping("")
    public ResponseEntity<DeclarationIsDto> update(@RequestBody DeclarationIsDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of declarationIs")
    @PostMapping("multiple")
    public ResponseEntity<List<DeclarationIsDto>> delete(@RequestBody List<DeclarationIsDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified declarationIs")
    @DeleteMapping("")
    public ResponseEntity<DeclarationIsDto> delete(@RequestBody DeclarationIsDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified declarationIs")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple declarationIss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by societe id")
    @GetMapping("societe/id/{id}")
    public List<DeclarationIs> findBySocieteId(@PathVariable Long id){
        return service.findBySocieteId(id);
    }
    @ApiOperation("delete by societe id")
    @DeleteMapping("societe/id/{id}")
    public int deleteBySocieteId(@PathVariable Long id){
        return service.deleteBySocieteId(id);
    }
    @ApiOperation("find by tauxIs id")
    @GetMapping("tauxIs/id/{id}")
    public List<DeclarationIs> findByTauxIsId(@PathVariable Long id){
        return service.findByTauxIsId(id);
    }
    @ApiOperation("delete by tauxIs id")
    @DeleteMapping("tauxIs/id/{id}")
    public int deleteByTauxIsId(@PathVariable Long id){
        return service.deleteByTauxIsId(id);
    }
    @ApiOperation("Finds a declarationIs and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<DeclarationIsDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds declarationIss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DeclarationIsDto>> findByCriteria(@RequestBody DeclarationIsCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated declarationIss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DeclarationIsCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports declarationIss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DeclarationIsCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets declarationIs data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DeclarationIsCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets declarationIs history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets declarationIs paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DeclarationIsHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports declarationIs history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DeclarationIsHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets declarationIs history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DeclarationIsHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DeclarationIsRestAdmin (DeclarationIsAdminService service, DeclarationIsConverter converter) {
        super(service, converter);
    }


}