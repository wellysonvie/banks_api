package com.banks.api;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.banks.dao.BankDAO;
import com.banks.entities.*;;

@Path("/banks")
public class BanksService {
	
	private BankDAO bankDAO;
	
	@PostConstruct
	private void init() {
		this.bankDAO = new BankDAO();
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Bank> listAllBanks(){
		
		ArrayList<Bank> banks = null;
		banks = bankDAO.getAll();
		
		return banks;
	}
	
	@GET
	@Path("/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Bank getBankByCompensationCode(@PathParam("code") int code){
		
		Bank bank = null;
		bank = bankDAO.getByCompensationCode(code);
		
		return bank;
	}

}
