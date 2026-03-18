package br.com.nebulastar.modulo24.service;

import br.com.nebulastar.modulo24.Cliente;

import java.util.List;

/**
  * Created by Nebula Stardust
  */public interface IClienteService {
      Cliente buscarPorId(int id);
      void atualizar(Cliente cliente);
      void excluir(int id);
//        String salvar();
}
