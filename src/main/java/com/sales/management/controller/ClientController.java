package com.sales.management.controller;

import com.sales.management.model.Client;
import com.sales.management.model.ClientResponseDTO;
import com.sales.management.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<ClientResponseDTO> getClient(@PathVariable long id) {
            return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK);
        /*catch (Exception)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");

        }*/
    }

    //create new client
    @PostMapping("/addClient")
    private void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    //update client
    @PutMapping("/update/{id}")
    private void updateClient(@PathVariable Long id,@RequestBody Client updatedClient) {
        clientService.updateClient(id,updatedClient);
    }

    //delete client
    @GetMapping("/delete/{id}")
    private void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
