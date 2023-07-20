package ma.sir.dgi.ws.facade.admin;

import ma.sir.dgi.service.facade.admin.TvaAdminService;
import ma.sir.dgi.ws.dto.DeclarationIsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tva")
public class TvaWsAdmin {
    @Autowired
    private final TvaAdminService tvaAdminService;

    public TvaWsAdmin(TvaAdminService tvaAdminService) {
        this.tvaAdminService = tvaAdminService;
    }
    @PostMapping("/")
    public  int save(@RequestBody DeclarationIsDto declarationIsDto)
    {
        return this.tvaAdminService.save(declarationIsDto);
    }
}
