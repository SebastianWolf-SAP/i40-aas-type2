package com.sap.i40aas.datamanager.webService.controllers;

import com.sap.i40aas.datamanager.AASObjectsDeserializer;
import com.sap.i40aas.datamanager.webService.services.AASEnvObjectsService;
import identifiables.AssetAdministrationShellEnv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AASEnvController {


  @Autowired
  private final AASEnvObjectsService aasEnvService;

  //need for mock testing
  public AASEnvController(AASEnvObjectsService aasEnvService) {


    this.aasEnvService = aasEnvService;
  }


  @PostMapping("/env/")
  public void updateSubmodel(@RequestBody String body) {


    //NOTE: we give String in @Requestbody otherwise it will be deserialized with Jackson
    AssetAdministrationShellEnv env = AASObjectsDeserializer.Companion.deserializeAASEnv(body);
    aasEnvService.addAASEnv(env);
  }


}