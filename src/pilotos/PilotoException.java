/*
 * Programa��o 3 - IPCB/EST 2013
 */

package pilotos;

/**
 *
 * @author lca
 */
@SuppressWarnings("serial")
public class PilotoException extends Exception{

	private short errNo;
	private int pilotoID;

	public PilotoException(short errid, int piloto) {
		errNo = errid;
		pilotoID = piloto;
	}

	public PilotoException(String msg) {
		super(msg);
	}

	public short getErrId() {
		return errNo;
	}

	public int getPilotoID() {
		return pilotoID;
	}

        @Override
	public String toString() {
		String str = "Opera��o n�o efectuada\n";
		switch (errNo) {
		case 1:
			str += "N�o h� saldo suficiente";
			break;
		case 2:
			str += "Ainda n�o existe registo de tempos";
			break;
		case 3:
			str += "O piloto n�o existe";
			break;
		default:
			str = "Erro de Piloto indefinido: " + errNo;
			break;
		}
		return str;
	}
    
}
