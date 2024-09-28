package com.sales.management.service;

import com.sales.management.model.Client;

import java.util.List;

public interface ClientService {
     List<Client> getAllClients();
     void addClient(Client client);
     void updateClient(Long id, Client updatedClient);
     void deleteClient(Long id);
}
