package com.nicollas.bancoapiemployees.application.usecases;

import com.nicollas.bancoapiemployees.domain.model.Employee;
import com.nicollas.bancoapiemployees.domain.ports.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    private EmployeeRepository repository;
    private EmployeeService service;

    @BeforeEach
    void setUp() {
        repository = mock(EmployeeRepository.class);
        service = new EmployeeService(repository);
    }

    @Test
    void deveCadastrarFuncionarioComSucesso() {
        Employee novo = new Employee(null, "Joana", "joana@banco.com", "Financeiro");
        Employee salvo = new Employee(1L, "Joana", "joana@banco.com", "Financeiro");

        when(repository.save(novo)).thenReturn(salvo);

        Employee resultado = service.create(novo);

        assertNotNull(resultado.getId());
        assertEquals("Joana", resultado.getName());
        verify(repository, times(1)).save(novo);
    }

    @Test
    void deveListarTodosOsFuncionarios() {
        List<Employee> lista = Arrays.asList(
                new Employee(1L, "A", "a@banco.com", "TI"),
                new Employee(2L, "B", "b@banco.com", "RH")
        );

        when(repository.findAll()).thenReturn(lista);

        List<Employee> resultado = service.listAll();

        assertEquals(2, resultado.size());
        verify(repository).findAll();
    }

    @Test
    void deveDeletarFuncionarioPorId() {
        Long id = 1L;

        service.delete(id);

        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void deveRetornarFuncionarioPorIdSeExistir() {
        Employee emp = new Employee(1L, "Carlos", "carlos@banco.com", "TI");
        when(repository.findById(1L)).thenReturn(Optional.of(emp));

        Optional<Employee> resultado = service.findById(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Carlos", resultado.get().getName());
    }

    @Test
    void deveRetornarVazioQuandoFuncionarioNaoExiste() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        Optional<Employee> resultado = service.findById(99L);

        assertTrue(resultado.isEmpty());
        verify(repository).findById(99L);
    }

    @Test
    void devePermitirDeletarMesmoSeFuncionarioNaoExiste() {
        Long id = 999L;

        // Não precisa configurar comportamento extra, apenas verifica chamada
        service.delete(id);

        verify(repository).deleteById(id);
    }

    @Test
    void deveRetornarListaVaziaQuandoNaoHaFuncionarios() {
        when(repository.findAll()).thenReturn(List.of());

        List<Employee> resultado = service.listAll();

        assertTrue(resultado.isEmpty());
        verify(repository).findAll();
    }

    @Test
    void deveSalvarMesmoComCamposNulosNoDominio() {
        Employee funcionario = new Employee(null, null, null, null);

        when(repository.save(funcionario)).thenReturn(funcionario);

        Employee resultado = service.create(funcionario);

        assertNull(resultado.getName());
        assertNull(resultado.getEmail());
        verify(repository).save(funcionario);
    }

    @Test
    void naoDeveChamarDeleteSeIdForNulo() {
        service.delete(null);

        verify(repository, never()).deleteById(any());
    }

    @Test
    void deveAtualizarFuncionarioExistenteSeIdNaoForNulo() {
        Employee existente = new Employee(1L, "Carlos", "carlos@banco.com", "TI");

        when(repository.save(existente)).thenReturn(existente);

        Employee resultado = service.create(existente);

        assertEquals(1L, resultado.getId());
        assertEquals("Carlos", resultado.getName());
        verify(repository).save(existente);
    }

//    @Test
//    void deveListarGrandeQuantidadeDeFuncionarios() {
//        List<Employee> lista = new java.util.ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            lista.add(new Employee((long) i, "Nome" + i, "email" + i + "@teste.com", "Depto"));
//        }
//
//        when(repository.findAll()).thenReturn(lista);
//
//        List<Employee> resultado = service.listAll();
//
//        assertEquals(1000, resultado.size());
//        verify(repository).findAll();
//    }

    @Test
    void devePropagarExcecaoAoSalvarFuncionario() {
        Employee funcionario = new Employee(null, "Erro", "erro@teste.com", "TI");

        when(repository.save(funcionario)).thenThrow(new RuntimeException("Erro ao salvar"));

        assertThrows(RuntimeException.class, () -> service.create(funcionario));
    }


}
