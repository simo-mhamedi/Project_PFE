package  ma.sir.dgi.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.dgi.bean.core.EtatBilan;
import ma.sir.dgi.bean.history.EtatBilanHistory;
import ma.sir.dgi.dao.criteria.core.EtatBilanCriteria;
import ma.sir.dgi.dao.criteria.history.EtatBilanHistoryCriteria;
import ma.sir.dgi.service.facade.admin.EtatBilanAdminService;
import ma.sir.dgi.ws.converter.EtatBilanConverter;
import ma.sir.dgi.ws.dto.EtatBilanDto;
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

@Api("Manages etatBilan services")
@RestController
@RequestMapping("/api/admin/etatBilan/")
public class EtatBilanRestAdmin  extends AbstractController<EtatBilan, EtatBilanDto, EtatBilanHistory, EtatBilanCriteria, EtatBilanHistoryCriteria, EtatBilanAdminService, EtatBilanConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatBilanDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one etatBilan")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple etatBilans")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all etatBilans")
    @GetMapping("")
    public ResponseEntity<List<EtatBilanDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all etatBilans")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatBilanDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a etatBilan by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatBilanDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  etatBilan")
    @PostMapping("")
    public ResponseEntity<EtatBilanDto> save(@RequestBody EtatBilanDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  etatBilan")
    @PutMapping("")
    public ResponseEntity<EtatBilanDto> update(@RequestBody EtatBilanDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of etatBilan")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatBilanDto>> delete(@RequestBody List<EtatBilanDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified etatBilan")
    @DeleteMapping("")
    public ResponseEntity<EtatBilanDto> delete(@RequestBody EtatBilanDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified etatBilan")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple etatBilans by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds etatBilans by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatBilanDto>> findByCriteria(@RequestBody EtatBilanCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated etatBilans by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatBilanCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatBilans by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatBilanCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets etatBilan data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatBilanCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets etatBilan history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets etatBilan paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EtatBilanHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatBilan history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EtatBilanHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets etatBilan history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EtatBilanHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EtatBilanRestAdmin (EtatBilanAdminService service, EtatBilanConverter converter) {
        super(service, converter);
    }


}