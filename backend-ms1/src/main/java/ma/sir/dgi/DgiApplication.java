package  ma.sir.dgi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.cache.annotation.EnableCaching;


import ma.sir.dgi.bean.core.*;
import ma.sir.dgi.service.facade.admin.*;

import ma.sir.dgi.zynerator.security.common.AuthoritiesConstants;
import ma.sir.dgi.zynerator.security.bean.User;
import ma.sir.dgi.zynerator.security.bean.Permission;
import ma.sir.dgi.zynerator.security.bean.Role;
import ma.sir.dgi.zynerator.security.service.facade.UserService;
import ma.sir.dgi.zynerator.security.service.facade.RoleService;


import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableFeignClients("ma.sir.dgi.required.facade")
public class DgiApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(DgiApplication.class, args);
    }


    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
    return (args) -> {
        if(true){



    // Role admin

        User userForAdmin = new User("admin");

        Role roleForAdmin = new Role();
        roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
        List<Permission> permissionsForAdmin = new ArrayList<>();
        addPermissionForAdmin(permissionsForAdmin);
        roleForAdmin.setPermissions(permissionsForAdmin);
        if(userForAdmin.getRoles()==null)
            userForAdmin.setRoles(new ArrayList<>());

        userForAdmin.getRoles().add(roleForAdmin);
        userService.save(userForAdmin);
            }
        };
    }




    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return  10L * i;
    }
    private static Integer fakeInteger(String attributeName, int i) {
        return  10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return  BigDecimal.valueOf(i*1L*10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }
    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }
    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("FactureProduit.edit"));
        permissions.add(new Permission("FactureProduit.list"));
        permissions.add(new Permission("FactureProduit.view"));
        permissions.add(new Permission("FactureProduit.add"));
        permissions.add(new Permission("FactureProduit.delete"));
        permissions.add(new Permission("TauxRetardTva.edit"));
        permissions.add(new Permission("TauxRetardTva.list"));
        permissions.add(new Permission("TauxRetardTva.view"));
        permissions.add(new Permission("TauxRetardTva.add"));
        permissions.add(new Permission("TauxRetardTva.delete"));
        permissions.add(new Permission("DeclarationIs.edit"));
        permissions.add(new Permission("DeclarationIs.list"));
        permissions.add(new Permission("DeclarationIs.view"));
        permissions.add(new Permission("DeclarationIs.add"));
        permissions.add(new Permission("DeclarationIs.delete"));
        permissions.add(new Permission("FactureCharge.edit"));
        permissions.add(new Permission("FactureCharge.list"));
        permissions.add(new Permission("FactureCharge.view"));
        permissions.add(new Permission("FactureCharge.add"));
        permissions.add(new Permission("FactureCharge.delete"));
        permissions.add(new Permission("Societe.edit"));
        permissions.add(new Permission("Societe.list"));
        permissions.add(new Permission("Societe.view"));
        permissions.add(new Permission("Societe.add"));
        permissions.add(new Permission("Societe.delete"));
        permissions.add(new Permission("EtatOperationComptable.edit"));
        permissions.add(new Permission("EtatOperationComptable.list"));
        permissions.add(new Permission("EtatOperationComptable.view"));
        permissions.add(new Permission("EtatOperationComptable.add"));
        permissions.add(new Permission("EtatOperationComptable.delete"));
        permissions.add(new Permission("CompteComptable.edit"));
        permissions.add(new Permission("CompteComptable.list"));
        permissions.add(new Permission("CompteComptable.view"));
        permissions.add(new Permission("CompteComptable.add"));
        permissions.add(new Permission("CompteComptable.delete"));
        permissions.add(new Permission("TauxIs.edit"));
        permissions.add(new Permission("TauxIs.list"));
        permissions.add(new Permission("TauxIs.view"));
        permissions.add(new Permission("TauxIs.add"));
        permissions.add(new Permission("TauxIs.delete"));
        permissions.add(new Permission("TypeOperationComptable.edit"));
        permissions.add(new Permission("TypeOperationComptable.list"));
        permissions.add(new Permission("TypeOperationComptable.view"));
        permissions.add(new Permission("TypeOperationComptable.add"));
        permissions.add(new Permission("TypeOperationComptable.delete"));
        permissions.add(new Permission("ClassComptable.edit"));
        permissions.add(new Permission("ClassComptable.list"));
        permissions.add(new Permission("ClassComptable.view"));
        permissions.add(new Permission("ClassComptable.add"));
        permissions.add(new Permission("ClassComptable.delete"));
        permissions.add(new Permission("Bilan.edit"));
        permissions.add(new Permission("Bilan.list"));
        permissions.add(new Permission("Bilan.view"));
        permissions.add(new Permission("Bilan.add"));
        permissions.add(new Permission("Bilan.delete"));
        permissions.add(new Permission("SousClassComptable.edit"));
        permissions.add(new Permission("SousClassComptable.list"));
        permissions.add(new Permission("SousClassComptable.view"));
        permissions.add(new Permission("SousClassComptable.add"));
        permissions.add(new Permission("SousClassComptable.delete"));
        permissions.add(new Permission("EtatBilan.edit"));
        permissions.add(new Permission("EtatBilan.list"));
        permissions.add(new Permission("EtatBilan.view"));
        permissions.add(new Permission("EtatBilan.add"));
        permissions.add(new Permission("EtatBilan.delete"));
        permissions.add(new Permission("DeclarationTva.edit"));
        permissions.add(new Permission("DeclarationTva.list"));
        permissions.add(new Permission("DeclarationTva.view"));
        permissions.add(new Permission("DeclarationTva.add"));
        permissions.add(new Permission("DeclarationTva.delete"));
        permissions.add(new Permission("OperationComptable.edit"));
        permissions.add(new Permission("OperationComptable.list"));
        permissions.add(new Permission("OperationComptable.view"));
        permissions.add(new Permission("OperationComptable.add"));
        permissions.add(new Permission("OperationComptable.delete"));
    }

}


