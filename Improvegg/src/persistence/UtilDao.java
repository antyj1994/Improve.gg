package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilDao {

	private DataSource dataSource;
	
	public UtilDao(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	public void dropDatabase(){
		
		Connection connection = dataSource.getConnection();
		try {
			String delete = "drop SEQUENCE if EXISTS sequenza_id;"
					+ "drop table if exists account;"
					+ "drop table if exists champion;"
					+ "drop table if exists item;"
					+ "drop table if exists rune;"
					+ "drop table if exists skill;"
					+ "drop table if exists spell;"
					+ "drop table if exists misc;";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			System.out.println("Executed drop database");
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}
	
	public void createDatabase(){
		
		Connection connection = dataSource.getConnection();
		try {
			String delete = "create SEQUENCE sequenza_id;"
					+ "create table account (nome varchar(30) primary key, password varchar(30));"
					+ "create table champion (\"id\" int primary key, nome varchar(30));"
					+ "create table item (\"id\" int primary key, nome varchar(300));"
					+ "create table rune (\"id\" int primary key, nome varchar(30));"
					+ "create table skill (\"id\" int primary key, nome varchar(30));"
					+ "create table spell (\"id\" int primary key, nome varchar(30));"
					+ "create table misc (\"id\" int primary key, nome varchar(30));";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			System.out.println("Executed create database");
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}
	
	public  void resetDatabase() {
			
			Connection connection = dataSource.getConnection();
			try {
				String delete = "delete FROM account";
				PreparedStatement statement = connection.prepareStatement(delete);
				statement.executeUpdate();
	
				delete = "delete FROM champion";
				statement = connection.prepareStatement(delete);
				
				statement.executeUpdate();
				
				delete = "delete FROM item";
				statement = connection.prepareStatement(delete);
				
				statement.executeUpdate();
				
				delete = "delete FROM rune";
				statement = connection.prepareStatement(delete);
				
				statement.executeUpdate();
				

				delete = "delete FROM skill";
				statement = connection.prepareStatement(delete);
				
				statement.executeUpdate();
				

				delete = "delete FROM spell";
				statement = connection.prepareStatement(delete);
				
				statement.executeUpdate();
				
				delete = "delete FROM misc";
				statement = connection.prepareStatement(delete);
				
				statement.executeUpdate();
				
				
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new PersistenceException(e.getMessage());
			}
		}
	}
}
