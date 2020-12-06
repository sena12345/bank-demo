package com.sena.bankdemo.controller;

import com.sena.bankdemo.entity.Client;
import com.sena.bankdemo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("api/client/register")
    public Client registerClient(@RequestBody Client client){
        return clientService.registerClient(client);
    }

    @GetMapping("api/client/clients")
    public List<Client> getClients(){
        return clientService.listClients();
    }


}
