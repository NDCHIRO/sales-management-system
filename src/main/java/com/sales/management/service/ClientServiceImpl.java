package com.sales.management.service;

import com.sales.management.model.Client;
import com.sales.management.model.ClientResponseDTO;
import com.sales.management.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public ClientResponseDTO getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();
        if (client.isPresent()) {
            clientResponseDTO = new ClientResponseDTO();
            clientResponseDTO.setClient(client.get());
        } else {
            throw  new EntityNotFoundException();
        }
        return clientResponseDTO;
    }

    @Override
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void updateClient(Long id,Client updatedClient) {
        Optional<Client> existingClient = clientRepository.findById(id);

        if(existingClient.isPresent())
        {
            Client client = existingClient.get();
            client.setName(updatedClient.getName());
            client.setLastName(updatedClient.getLastName());
            client.setMobileNumber(updatedClient.getMobileNumber());
            client.setAddress(updatedClient.getAddress());
            client.setMail(updatedClient.getMail());
            clientRepository.save(client);
        }
        else {
            throw new RuntimeException("user doesn't exist");
        }
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }


}
