package com.sena.bankdemo.service;

import com.sena.bankdemo.entity.Client;
import com.sena.bankdemo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client registerClient(Client client){
        return clientRepository.save(client);
    }

    public List<Client> listClients(){
        return  clientRepository.findAll();
    }

}
