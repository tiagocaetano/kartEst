/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kartodromo;
/**
 *
 * @author lca
 */
public class Kart {
	private Piloto piloto;
	private static short count=0;
	private short kartID;
	
	public Kart(){
		piloto=null;
		count++;
		kartID=count;
	}
	
	public void assignPiloto(Piloto piloto){
		this.piloto = piloto;
	}
	
	public void removePiloto(){
		this.piloto = null;
	}
}
