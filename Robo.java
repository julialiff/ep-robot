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
	public Sala sala;

	/** Construtor padrão para o robô **/
	public Robo() {
		// Aqui você deve inserir seu código

		sala = new Sala();
		mensageiro = new Mensageiro();
		sala[0][0] = 0;
		// System.out.println(sala[0][0]);

	}

	// Aqui você deve completar seu código

	public void buscaBlocos() {
		// while (true) {
		// 	buscaBloco(x, y);
		// }
	}

	public void novaBusca() {
		System.out.println("oi");
	}

	public void adicionaBloco(int x, int y) {
		sala.marcaPosicaoBusca(x, y, sala.BLOCO_PRESENTE);
	}

	public void adicionaObstaculo(int x, int y) {
		sala.marcaPosicaoBusca(x, y, sala.OBSTACULO_PRESENTE);
	}

	public boolean guardaBloco() {
		System.out.println("oi");
		return true;
	}

	public boolean buscaBloco(int x, int y){
		int up = y + 1;
		int right = x + 1;
		int down = y - 1;
		int left = x - 1;

		return true;
	}

	/**
		Retorna instância do mensageiro do robô
	*/
	public Mensageiro mensageiro() {
		return(this.mensageiro);
	}
}
