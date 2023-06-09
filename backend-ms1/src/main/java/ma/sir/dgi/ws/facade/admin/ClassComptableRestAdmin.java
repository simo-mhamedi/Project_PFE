package  ma.sir.dgi.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.dgi.bean.core.ClassComptable;
import ma.sir.dgi.bean.history.ClassComptableHistory;
import ma.sir.dgi.dao.criteria.core.ClassComptableCriteria;
import ma.sir.dgi.dao.criteria.history.ClassComptableHistoryCriteria;
import ma.sir.dgi.service.facade.admin.ClassComptableAdminService;
import ma.sir.dgi.ws.converter.ClassComptableConverter;
import ma.sir.dgi.ws.dto.ClassComptableDto;
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

@Api("Manages classComptable services")
@RestController
@RequestMapping("/api/admin/classComptable/")
public class ClassComptableRestAdmin  extends AbstractController<ClassComptable, ClassComptableDto, ClassComptableHistory, ClassComptableCriteria, ClassComptableHistoryCriteria, ClassComptableAdminService, ClassComptableConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ClassComptableDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one classComptable")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple classComptables")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all classComptables")
    @GetMapping("")
    public ResponseEntity<List<ClassComptableDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all classComptables")
    @GetMapping("optimized")
    public ResponseEntity<List<ClassComptableDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a classComptable by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ClassComptableDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  classComptable")
    @PostMapping("")
    public ResponseEntity<ClassComptableDto> save(@RequestBody ClassComptableDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  classComptable")
    @PutMapping("")
    public ResponseEntity<ClassComptableDto> update(@RequestBody ClassComptableDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of classComptable")
    @PostMapping("multiple")
    public ResponseEntity<List<ClassComptableDto>> delete(@RequestBody List<ClassComptableDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified classComptable")
    @DeleteMapping("")
    public ResponseEntity<ClassComptableDto> delete(@RequestBody ClassComptableDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified classComptable")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple classComptables by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds classComptables by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ClassComptableDto>> findByCriteria(@RequestBody ClassComptableCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated classComptables by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ClassComptableCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports classComptables by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ClassComptableCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets classComptable data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ClassComptableCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets classComptable history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets classComptable paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ClassComptableHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports classComptable history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ClassComptableHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets classComptable history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ClassComptableHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ClassComptableRestAdmin (ClassComptableAdminService service, ClassComptableConverter converter) {
        super(service, converter);
    }


}