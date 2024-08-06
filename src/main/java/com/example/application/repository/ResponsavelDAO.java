package com.example.application.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.application.model.Responsavel;

public class ResponsavelDAO {
    
    public boolean inserir(Responsavel responsavel) {
		
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			
			String insert = "INSERT INTO responsavel (nome)" + "values" + "(?)";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(insert);
			preparedStatement1.setString(1, responsavel.getNome());
			
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

    public boolean alterar (Responsavel responsavel) {
	
		try {
			
			Connection connection = DBConnection.getInstance().getConnection();
			
			String alterar = "UPDATE responsavel SET nome = ? where id = ?";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(alterar);
			
			preparedStatement1.setString(1, responsavel.getNome());
			preparedStatement1.setInt(2, responsavel.getId());
			
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

    public boolean excluir (Responsavel responsavel) {
	
		try {
			
			Connection connection = DBConnection.getInstance().getConnection();
			
			String excluir = "DELETE FROM responsavel WHERE id = ?";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(excluir);
			preparedStatement1.setInt(1, responsavel.getId());
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

    public Responsavel pesquisar (int id) {
		try {
			
			Connection connection = DBConnection.getInstance().getConnection();
			
			String busca = "SELECT * FROM responsavel WHERE id = ?";
			
			Responsavel responsavel = new Responsavel();
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(busca);
			preparedStatement1.setInt(1, id);
			ResultSet resultSet = preparedStatement1.executeQuery();
			while (resultSet.next()) {
				responsavel.setId(resultSet.getInt("id"));
				responsavel.setNome(resultSet.getString("nome"));
			}
			
			return responsavel;
			
		}catch(Exception e) {
				e.printStackTrace();
			return null;
		}
	}

	public List<Responsavel> pesquisarTodos() {
        try {
            
			Connection connection = DBConnection.getInstance().getConnection();
            
			String consulta = "SELECT * from responsavel";
            
			List<Responsavel> lista = new ArrayList<Responsavel>();
            
			Responsavel responsavel;
            
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                responsavel = new Responsavel();
                responsavel.setId(resultSet.getInt("id"));
                responsavel.setNome(resultSet.getString("nome"));
                lista.add(responsavel);
            }
            
			return lista;

        }catch (Exception e) {
            	e.printStackTrace();
            return null;
        }
    }
}
