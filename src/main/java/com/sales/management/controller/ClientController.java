package com.sales.management.controller;

import com.sales.management.model.Client;
import com.sales.management.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    //get all clients
    @GetMapping("/clients")
    private List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    //get specific client
    @GetMapping("/clients/{id}")
    private Client getClient(@PathVariable int id) {
        return clientService.getAllClients().get(id);
    }

    //create new client
    @PostMapping("/addClient")
    private void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    //update client
    @PostMapping("/update/{id}")
    private void updateClient(@PathVariable Long id,@RequestBody Client updatedClient) {
        clientService.updateClient(id,updatedClient);
    }
    //delete client
    @GetMapping("/delete/{id}")
    private void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
