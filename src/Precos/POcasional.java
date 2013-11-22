
package Precos;

/**
 *
 * @author lca
 */
public class POcasional extends PDefault {
	
	@Override public String getNome(){
		return "Ocasional";
	}
	
	@Override public Precario getDefaultPrecario(){
		Precario tprecos = new Precario(this.getNome());		// Tabela de Preços
		tprecos.setPVolta(1.0);
		return tprecos;
	}
}
