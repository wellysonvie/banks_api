package com.banks.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.banks.config.BDConfig;
import com.banks.entities.Bank;

public class BankDAO {

	public ArrayList<Bank> getAll() {
		ArrayList<Bank> banks = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM banks";
			
			PreparedStatement preparedStatement = BDConfig.getConnection().prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Bank bank = new Bank();
				bank.setId(rs.getInt("id"));
				bank.setCompensationCode(rs.getInt("compensation_code"));
				bank.setInstitutionName(rs.getString("institution_name"));
				banks.add(bank);
			}
			
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		
		return banks;
	}

	public Bank getByCompensationCode(int code) {
		
		Bank bank = null;
		
		try {
			String sql = "SELECT * FROM banks WHERE compensation_code = ?";
			
			PreparedStatement preparedStatement = BDConfig.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, code);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				bank = new Bank();
				bank.setId(rs.getInt("id"));
				bank.setCompensationCode(rs.getInt("compensation_code"));
				bank.setInstitutionName(rs.getString("institution_name"));
			}
			
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		
		return bank;
	}
}
