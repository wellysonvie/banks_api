package com.banks.api;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	public Response listAllBanks(){
		
		ArrayList<Bank> banks = null;
		banks = bankDAO.getAll();
		
		if(banks.size() == 0) {
			return Response.status(204).entity("Nenhum banco cadastrado!").build();
		}
		
		return Response.status(200).entity(banks).build();
	}
	
	@GET
	@Path("/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBankByCompensationCode(@PathParam("code") int code){
		
		Bank bank = null;
		bank = bankDAO.getByCompensationCode(code);
		
		if(bank == null) {
			return Response.status(404).entity("Nenhum banco encontrado!").build();
		}
		
		return Response.status(200).entity(bank).build();
	}

}
