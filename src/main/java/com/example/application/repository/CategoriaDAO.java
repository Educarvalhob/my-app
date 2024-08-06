package com.example.application.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.application.model.Categoria;

public class CategoriaDAO {
    
    public boolean inserir(Categoria categoria) {
		
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			
			String insert = "INSERT INTO categoria (nome)" + "values" + "(?)";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(insert);
			preparedStatement1.setString(1, categoria.getDescricao());
			
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

    public boolean alterar (Categoria categoria) {
	
		try {
			
			Connection connection = DBConnection.getInstance().getConnection();
			
			String alterar = "UPDATE categoria SET nome = ? where id = ?";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(alterar);
			
			preparedStatement1.setString(1, categoria.getDescricao());
			preparedStatement1.setInt(2, categoria.getId());
			
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

    public boolean excluir (Categoria categoria) {
	
		try {
			
			Connection connection = DBConnection.getInstance().getConnection();
			
			String excluir = "DELETE FROM categoria WHERE id = ?";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(excluir);
			preparedStatement1.setInt(1, categoria.getId());
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

    public Categoria pesquisar (int id) {
		try {
			
			Connection connection = DBConnection.getInstance().getConnection();
			
			String busca = "SELECT * FROM categoria WHERE id = ?";
			
			Categoria categoria = new Categoria();
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(busca);
			preparedStatement1.setInt(1, id);
			ResultSet resultSet = preparedStatement1.executeQuery();
			while (resultSet.next()) {
				categoria.setId(resultSet.getInt("id"));
				categoria.setDescricao(resultSet.getString("nome"));
			}
			
			return categoria;
			
		}catch(Exception e) {
				e.printStackTrace();
			return null;
		}
	}
}
