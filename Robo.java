package robo;

/*********************************************************************/
/** ACH 2002 - Introducao à Análise de Algoritmos                   **/
/** EACH-USP - Segundo Semestre de 2018                             **/
/**                                                                 **/
/** Julia Litvinoff Justus 8922177                                  **/
/**                                                                 **/
/*********************************************************************/

/**
	Classe que implementa os movimentos do robô.
*/
public class Robo implements IRobo {
	/** Coordenada x de início da busca */
	private static int x = ISala.X_INICIO_ARM;

	/** Coordenada y de início da busca */
	private static int y = ISala.Y_FIM_ARM+1;

	/** Mensageiro do robô **/
	public Mensageiro mensageiro;

	/** Construtor padrão para o robô **/
	public Robo() {
		// Aqui você deve inserir seu código
	}

	// Aqui você deve completar seu código


	/**
		Retorna instância do mensageiro do robô
	*/
	public Mensageiro mensageiro() {
		return(this.mensageiro);
	}
}
