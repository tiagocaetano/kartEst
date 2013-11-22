package Precos;

/**
 *
 * @author lca
 */
public class Precario {
	private String nome;		// nome do preçário
	private int bonus;			// bonus de voltas mensal/aluguer
	private int lapsForBonus;	// número de voltas para ter o bonus por aluguer
	private double volta;		// preço da volta
	private double taxas;		// valor da taxas de cronometragem
	private double mensalidade;	// mensalidade
	
	public Precario(String nome, int bonus, int lfBonus, double lapp, double taxap, double mesp){
		this.nome = nome;
		this.bonus = bonus;
		this.lapsForBonus = lfBonus;
		this.mensalidade = mesp;
		this.taxas = taxap;
		this.volta = lapp;
	}
	
	public Precario(String nome){
		this(nome, 0, 0, 1, 0, 0);
	}
	
	public void setBonus(int bonus) { this.bonus = bonus; }
	
	public void setlfBonus(int lfbonus){ this.lapsForBonus = lfbonus; }
	
	public void setPVolta(double lapp){ this.volta = lapp; }
	
	public void setPTaxa(double taxap){ this.taxas = taxap; }
	
	public void setMensalidade(double mesp){ this.mensalidade = mesp; }
	
	public String getNome() { return this.nome; }
	
	public int getBonus() { return this.bonus; }
	
	public int getlfBonus(){ return this.lapsForBonus; }
	
	public double getPVolta(){ return this.volta; }
	
	public double getPTaxa(){ return this.taxas; }
	
	public double getMensalidade(){ return this.mensalidade; }
	
}
