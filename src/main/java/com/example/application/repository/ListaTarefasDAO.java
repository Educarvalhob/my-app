package com.example.application.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.application.model.Categoria;
import com.example.application.model.ListaTarefas;
import com.example.application.model.Prioridade;
import com.example.application.model.Responsavel;
import com.example.application.model.Status;

public class ListaTarefasDAO {
    
    public boolean inserir(ListaTarefas listaTarefas) {
		
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			
			String insert = "INSERT INTO lista_tarefas (data_tarefa, descricao_tarefa, observacao, id_categoria, id_prioridade, id_responsavel, id_status)" + "values" + "(?)" + "(?)" + "(?)" + "(?)" + "(?)" + "(?)" + "(?)" + "(?)";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(insert);
            preparedStatement1.setString(1, listaTarefas.getData_tarefa());
            preparedStatement1.setString(2, listaTarefas.getDescricao_tarefa());
            preparedStatement1.setString(3, listaTarefas.getObservacao());
            preparedStatement1.setInt(4, listaTarefas.getCategoria_tarefa().getId());
            preparedStatement1.setInt(5, listaTarefas.getPrioridade_tarefa().getId());
            preparedStatement1.setInt(6, listaTarefas.getResponsavel_tarefa().getId());
            preparedStatement1.setInt(7, listaTarefas.getStatus_tarefa().getId());
			
			int resultado = preparedStatement1.executeUpdate();
			if (resultado > 0) {
				return true;
			}else {
				return false;
			}
		} catch(Exception e) {
				e.printStackTrace();
			return false;
		}
	}

    public boolean alterar (ListaTarefas listaTarefas) {
	
		try {
			
			Connection connection = DBConnection.getInstance().getConnection();
			
			String alterar = "UPDATE lista_tarefas SET data_tarefa = ? descricao_tarefa = ? observacao = ? id_categoria = ? id_prioridade = ? id_responsavel = ? id_status = ? where id = ?";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(alterar);
			
			preparedStatement1.setString(1, listaTarefas.getData_tarefa());
            preparedStatement1.setString(2, listaTarefas.getDescricao_tarefa());
            preparedStatement1.setString(3, listaTarefas.getObservacao());
            preparedStatement1.setInt(4, listaTarefas.getCategoria_tarefa().getId());
            preparedStatement1.setInt(5, listaTarefas.getPrioridade_tarefa().getId());
            preparedStatement1.setInt(6, listaTarefas.getResponsavel_tarefa().getId());
            preparedStatement1.setInt(7, listaTarefas.getStatus_tarefa().getId());
			preparedStatement1.setInt(8, listaTarefas.getId());
			
			int resultado = preparedStatement1.executeUpdate();
			if (resultado > 0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
				e.printStackTrace();
			return false;
		}
	}

    public boolean excluir (ListaTarefas listaTarefas) {
	
		try {
			
			Connection connection = DBConnection.getInstance().getConnection();
			
			String excluir = "DELETE FROM listaTarefas WHERE id = ?";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(excluir);
			preparedStatement1.setInt(1, listaTarefas.getId());
			int resultado = preparedStatement1.executeUpdate();
			if (resultado > 0) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
				e.printStackTrace();
			return false;
		}
	}

    public ListaTarefas pesquisar (int id) {
		try {
			
			Connection connection = DBConnection.getInstance().getConnection();
			
			String busca = "SELECT * FROM listaTarefas WHERE id = ?";
			
			ListaTarefas listaTarefas = new ListaTarefas();
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(busca);
			preparedStatement1.setInt(1, id);
			ResultSet resultSet = preparedStatement1.executeQuery();
			while (resultSet.next()) {
				listaTarefas.setId(resultSet.getInt("id"));
                listaTarefas.setData_tarefa(resultSet.getString("data"));
				listaTarefas.setDescricao_tarefa(resultSet.getString("descricao"));
                listaTarefas.setObservacao(resultSet.getString("observacao"));
                listaTarefas.setCategoria_tarefa(Categoria.fromId(resultSet.getInt("categoria")));
                listaTarefas.setPrioridade_tarefa(Prioridade.fromId(resultSet.getInt("prioridade")));
                listaTarefas.setResponsavel_tarefa(Responsavel.fromId(resultSet.getInt("responsavel")));
                listaTarefas.setStatus_tarefa(Status.fromId(resultSet.getInt("status")));
			}
			
			return listaTarefas;
			
		}catch(Exception e) {
				e.printStackTrace();
			return null;
		}
	}

	public List<ListaTarefas> pesquisarTodos() {
		
		List<ListaTarefas> lista = new ArrayList<>();
		
		try {
		
			Connection connection = DBConnection.getInstance().getConnection();
		
			String consulta = "SELECT * from lista_tarefas";
		
			ListaTarefas listaTarefa;
		
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listaTarefa = new ListaTarefas();
				listaTarefa.setId(resultSet.getInt("id"));
				listaTarefa.setData_tarefa(resultSet.getString("data_tarefa"));
				listaTarefa.setDescricao_tarefa(resultSet.getString("descricao_tarefa"));
				listaTarefa.setObservacao(resultSet.getString("observacao"));
				Prioridade prioridade = new PrioridadeDAO().pesquisar(resultSet.getInt("idPrioridade"));
				Categoria categoria = new CategoriaDAO().pesquisar(resultSet.getInt("idCategoriaTarefa"));
				Responsavel responsavel = new ResponsavelDAO().pesquisar(resultSet.getInt("idResponsavel")); 
				Status status = new StatusDAO().pesquisar(resultSet.getInt("idStatus"));                  
				listaTarefa.setPrioridade_tarefa(prioridade);
				listaTarefa.setCategoria_tarefa(categoria);
				listaTarefa.setResponsavel_tarefa(responsavel);
				listaTarefa.setStatus_tarefa(status);
				lista.add(listaTarefa);
			}

		} catch (Exception e) {
				e.printStackTrace();
		}
		
		return lista;
	}
}
