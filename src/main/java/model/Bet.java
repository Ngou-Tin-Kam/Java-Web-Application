package model;

import java.io.Serializable;

public class Bet implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int numbets;
	private String game;
	private Double stake;
	private Double returns;
	private int clientid;
	private String date;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getNumbets() {
		return numbets;
	}
	
	public void setNumbets(int numbets) {
		this.numbets = numbets;
	}
	
	public String getGame() {
		return game;
	}
	
	public void setGame(String game) {
		this.game = game;
	}
	
	public Double getStake() {
		return stake;
	}
	
	public void setStake(Double stake) {
		this.stake = stake;
	}
	
	public Double getReturns() {
		return returns;
	}
	
	public void setReturns(Double returns) {
		this.returns = returns;
	}
	
	public int getClientId() {
		return clientid;
	}
	
	public void SetClientId(int clientid) {
		this.clientid = clientid;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
}
