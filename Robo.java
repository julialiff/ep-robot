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
		// sala[5][5] = sala.BLOCO_PRESENTE;
		// System.out.println(sala[0][0]);

	}

	// Aqui você deve completar seu código

	public void buscaBlocos() {
		// while (true) {
		buscaBloco(x, y);
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
		if (sala.marcadorEm(x, y) == sala.BLOCO_PRESENTE) {
				System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
      	mensageiro.mensagem(mensageiro.CAPTURA, x, y);
      	return true;
    } else {
			mensageiro.mensagem(mensageiro.BUSCA, x, y);
    }
		System.out.println("posicao " + x + "x" + y);
		System.out.println("buscaBloco");
		int up = y + 1;
		int right = x + 1;
		int down = y - 1;
		int left = x - 1;

		// System.out.println(x);
		// System.out.println(up);
		// System.out.println(sala.posicaoBuscaValida(x, up));
		// System.out.println((sala.areaArmazenagem(x, up)) + "\n\n");


		boolean armazenagem = sala.areaArmazenagem(x, up);


		if (sala.posicaoBuscaValida(x, up) & !armazenagem) {
			if (sala.marcadorEm(x, up) == sala.OBSTACULO_PRESENTE) {
				// System.out.println("posicao " + x + "x" + up);
				mensageiro.mensagem(mensageiro.OBSTACULO, x, up);

			} else {
				// System.out.println("sem obstáculo lek!");
				y = up;
				buscaBloco(x, y);
			}
		}

		if (sala.posicaoBuscaValida(right, y) & !armazenagem) {
      if (sala.marcadorEm(right, y) == sala.OBSTACULO_PRESENTE) {
        // System.out.println("posicao " + x + "x" + right);
        mensageiro.mensagem(mensageiro.OBSTACULO, right, y);
        buscaBloco(x, y);
      } else {
      	x = right;
      	buscaBloco(x, y);
      }
    }

    if (sala.posicaoBuscaValida(x, down) & !armazenagem) {
      if (sala.marcadorEm(x, y) == sala.OBSTACULO_PRESENTE) {
        // System.out.println("posicao " + x + "x" + down);
        mensageiro.mensagem(mensageiro.OBSTACULO, x, down);
        buscaBloco(x, y);
      } else {
      	y = down;
      	buscaBloco(x, y);
      }
    }

    if (sala.posicaoBuscaValida(left, y) & !armazenagem) {
      if (sala.marcadorEm(x, y) == sala.OBSTACULO_PRESENTE) {
        // System.out.println("posicao " + x + "x" + left);
        mensageiro.mensagem(mensageiro.OBSTACULO, left, y);
        buscaBloco(x, y);
      } else {
      	x = left;
      	buscaBloco(x, y);

      }
    }


      // System.out.println("sem obstáculo lek!");


		return true;
	}

	/**
		Retorna instância do mensageiro do robô
	*/
	public Mensageiro mensageiro() {
		return(this.mensageiro);
	}
}
