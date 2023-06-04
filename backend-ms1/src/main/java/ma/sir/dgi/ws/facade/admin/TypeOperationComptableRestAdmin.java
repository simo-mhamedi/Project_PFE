package  ma.sir.dgi.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.dgi.bean.core.TypeOperationComptable;
import ma.sir.dgi.bean.history.TypeOperationComptableHistory;
import ma.sir.dgi.dao.criteria.core.TypeOperationComptableCriteria;
import ma.sir.dgi.dao.criteria.history.TypeOperationComptableHistoryCriteria;
import ma.sir.dgi.service.facade.admin.TypeOperationComptableAdminService;
import ma.sir.dgi.ws.converter.TypeOperationComptableConverter;
import ma.sir.dgi.ws.dto.TypeOperationComptableDto;
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

@Api("Manages typeOperationComptable services")
@RestController
@RequestMapping("/api/admin/typeOperationComptable/")
public class TypeOperationComptableRestAdmin  extends AbstractController<TypeOperationComptable, TypeOperationComptableDto, TypeOperationComptableHistory, TypeOperationComptableCriteria, TypeOperationComptableHistoryCriteria, TypeOperationComptableAdminService, TypeOperationComptableConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody TypeOperationComptableDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one typeOperationComptable")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple typeOperationComptables")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all typeOperationComptables")
    @GetMapping("")
    public ResponseEntity<List<TypeOperationComptableDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all typeOperationComptables")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeOperationComptableDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a typeOperationComptable by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeOperationComptableDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  typeOperationComptable")
    @PostMapping("")
    public ResponseEntity<TypeOperationComptableDto> save(@RequestBody TypeOperationComptableDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  typeOperationComptable")
    @PutMapping("")
    public ResponseEntity<TypeOperationComptableDto> update(@RequestBody TypeOperationComptableDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of typeOperationComptable")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeOperationComptableDto>> delete(@RequestBody List<TypeOperationComptableDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified typeOperationComptable")
    @DeleteMapping("")
    public ResponseEntity<TypeOperationComptableDto> delete(@RequestBody TypeOperationComptableDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified typeOperationComptable")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple typeOperationComptables by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds typeOperationComptables by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeOperationComptableDto>> findByCriteria(@RequestBody TypeOperationComptableCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated typeOperationComptables by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeOperationComptableCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports typeOperationComptables by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TypeOperationComptableCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets typeOperationComptable data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeOperationComptableCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets typeOperationComptable history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets typeOperationComptable paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody TypeOperationComptableHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports typeOperationComptable history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody TypeOperationComptableHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets typeOperationComptable history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody TypeOperationComptableHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public TypeOperationComptableRestAdmin (TypeOperationComptableAdminService service, TypeOperationComptableConverter converter) {
        super(service, converter);
    }


}