package ma.sir.dgi.service.facade.admin;

import ma.sir.dgi.ws.dto.DeclarationIsDto;
import ma.sir.dgi.ws.dto.DeclarationTvaDto;

public interface TvaAdminService {
    int save(DeclarationTvaDto declarationIsDto);

    }
