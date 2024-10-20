package com.sales.management.service;

import com.sales.management.model.Client;
import com.sales.management.model.ClientResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientService {
     List<Client> getAllClients();
     ClientResponseDTO getClientById(Long id);
     void addClient(Client client);
     void updateClient(Long id, Client updatedClient);
     void deleteClient(Long id);
}
