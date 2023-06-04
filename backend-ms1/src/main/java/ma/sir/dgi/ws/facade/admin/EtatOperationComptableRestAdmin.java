package  ma.sir.dgi.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.dgi.bean.core.EtatOperationComptable;
import ma.sir.dgi.bean.history.EtatOperationComptableHistory;
import ma.sir.dgi.dao.criteria.core.EtatOperationComptableCriteria;
import ma.sir.dgi.dao.criteria.history.EtatOperationComptableHistoryCriteria;
import ma.sir.dgi.service.facade.admin.EtatOperationComptableAdminService;
import ma.sir.dgi.ws.converter.EtatOperationComptableConverter;
import ma.sir.dgi.ws.dto.EtatOperationComptableDto;
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

@Api("Manages etatOperationComptable services")
@RestController
@RequestMapping("/api/admin/etatOperationComptable/")
public class EtatOperationComptableRestAdmin  extends AbstractController<EtatOperationComptable, EtatOperationComptableDto, EtatOperationComptableHistory, EtatOperationComptableCriteria, EtatOperationComptableHistoryCriteria, EtatOperationComptableAdminService, EtatOperationComptableConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatOperationComptableDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one etatOperationComptable")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple etatOperationComptables")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all etatOperationComptables")
    @GetMapping("")
    public ResponseEntity<List<EtatOperationComptableDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all etatOperationComptables")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatOperationComptableDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a etatOperationComptable by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatOperationComptableDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  etatOperationComptable")
    @PostMapping("")
    public ResponseEntity<EtatOperationComptableDto> save(@RequestBody EtatOperationComptableDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  etatOperationComptable")
    @PutMapping("")
    public ResponseEntity<EtatOperationComptableDto> update(@RequestBody EtatOperationComptableDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of etatOperationComptable")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatOperationComptableDto>> delete(@RequestBody List<EtatOperationComptableDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified etatOperationComptable")
    @DeleteMapping("")
    public ResponseEntity<EtatOperationComptableDto> delete(@RequestBody EtatOperationComptableDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified etatOperationComptable")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple etatOperationComptables by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds etatOperationComptables by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatOperationComptableDto>> findByCriteria(@RequestBody EtatOperationComptableCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated etatOperationComptables by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatOperationComptableCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatOperationComptables by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatOperationComptableCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets etatOperationComptable data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatOperationComptableCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets etatOperationComptable history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets etatOperationComptable paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EtatOperationComptableHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatOperationComptable history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EtatOperationComptableHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets etatOperationComptable history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EtatOperationComptableHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EtatOperationComptableRestAdmin (EtatOperationComptableAdminService service, EtatOperationComptableConverter converter) {
        super(service, converter);
    }


}