package com.example.paymentsystem.dtoService.impl;

import com.example.paymentsystem.dto.BankDto;
import com.example.paymentsystem.dto.ClientDto;
import com.example.paymentsystem.dto.CreateClientDto;
import com.example.paymentsystem.dto.UpdateClientDto;
import com.example.paymentsystem.entity.Bank;
import com.example.paymentsystem.entity.Client;
import com.example.paymentsystem.mapper.ClientMapper;
import com.example.paymentsystem.service.BankService;
import com.example.paymentsystem.service.ClientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class DefaultClientDtoServiceTest {
    @InjectMocks
    private DefaultClientDtoService defaultClientDtoService;

    @Mock
    private ClientService clientService;

    @Mock
    private ClientMapper clientMapper;

    @Mock
    private BankService bankService;

    private Client client;
    private CreateClientDto createClientDto;
    private UpdateClientDto updateClientDto;
    private ClientDto clientDto;
    private Bank bank;
    private BankDto bankDto;

    private String string;
    private BigDecimal decimal;

    @BeforeEach
    void setUp() {
        defaultClientDtoService = new DefaultClientDtoService(clientMapper, clientService, bankService);

        string = "some";
        decimal = new BigDecimal(10);

        bank = new Bank();
        bank.setId(1L);
        bank.setName(string);

        bankDto = new BankDto();
        bankDto.setId(1L);
        bankDto.setName(string);

        client = new Client();
        client.setId(1L);
        client.setUsername(string);
        client.setAccountNumber(string);
        client.setPassword(string);
        client.setCurrentBalance(decimal);
        client.setBank(bank);
        client.setDeleted(false);

        clientDto = new ClientDto();
        clientDto.setId(1L);
        clientDto.setUsername(string);
        clientDto.setAccountNumber(string);
        clientDto.setPassword(string);
        clientDto.setCurrentBalance(decimal);
        clientDto.setBankDto(bankDto);

        createClientDto = new CreateClientDto();
        createClientDto.setUsername(string);
        createClientDto.setAccountNumber(string);
        createClientDto.setPassword(string);
        createClientDto.setCurrentBalance(decimal);
        createClientDto.setBankId(bankDto.getId());

        updateClientDto = new UpdateClientDto();
        updateClientDto.setUsername(string);
        updateClientDto.setAccountNumber(string);
        updateClientDto.setPassword(string);
        updateClientDto.setCurrentBalance(decimal);
        updateClientDto.setBankId(1L);
    }

    @AfterEach
    void tearDown() {
        client = null;
        clientDto = null;
        createClientDto = null;
        updateClientDto = null;
        bank = null;
        bankDto = null;
    }

    @Test
    void getById_withValidId_shouldReturnClientDto() {
        when(clientService.getById(1L)).thenReturn(client);
        when(clientMapper.toClientDto(client)).thenReturn(clientDto);

        ClientDto response = defaultClientDtoService.getById(1L);

        assertEquals(1L, response.getId());
        assertEquals(string, response.getUsername());
        assertEquals(string, response.getPassword());
        assertEquals(string, response.getAccountNumber());
        assertEquals(decimal, response.getCurrentBalance());
        assertEquals(1L, response.getBankDto().getId());

        verify(clientService, times(1)).getById(1L);
    }

    @Test
    void getAll_withValidData_shouldReturnClientDtoList() {
        when(clientService.getAll()).thenReturn(Collections.singletonList(client));
        when(clientMapper.toClientDto(client)).thenReturn(clientDto);

        List<ClientDto> response = defaultClientDtoService.getAll();

        assertThat(response).hasSize(1);
        verify(clientService, times(1)).getAll();
    }

    @Test
    void create_withValidData_shouldReturnClientDto() {
        if (createClientDto.getBankId() != null) {
            when(bankService.getById(createClientDto.getBankId())).thenReturn(bank);
        }

        when(clientService.save(any())).thenReturn(client);
        when(clientMapper.toClientDto(client)).thenReturn(clientDto);

        ClientDto response = defaultClientDtoService.create(createClientDto);

        assertEquals(string, response.getUsername());
        assertEquals(string, response.getPassword());
        assertEquals(string, response.getAccountNumber());
        assertEquals(decimal, response.getCurrentBalance());
        assertEquals(bankDto, response.getBankDto());

        verify(clientService, times(1)).save(any());
    }

    @Test
    void update_withValidData_shouldReturnClientDto() {
        when(clientService.getById(createClientDto.getBankId())).thenReturn(client);

        if (updateClientDto.getBankId() != null) {
            when(bankService.getById(updateClientDto.getBankId())).thenReturn(bank);
        }

        when(clientService.save(any())).thenReturn(client);
        when(clientMapper.toClientDto(client)).thenReturn(clientDto);

        ClientDto response = defaultClientDtoService.update(1L, updateClientDto);

        assertEquals(string, response.getUsername());
        assertEquals(string, response.getPassword());
        assertEquals(string, response.getAccountNumber());
        assertEquals(decimal, response.getCurrentBalance());
        assertEquals(bankDto, response.getBankDto());

        verify(clientService, times(1)).save(any());
    }

    @Test
    void delete_withValidId_shouldReturnVoid() {
        when(clientService.getById(1L)).thenReturn(client);
        when(clientService.save(any())).thenReturn(client);

        defaultClientDtoService.delete(1L);
        verify(clientService).save(any());
    }
}