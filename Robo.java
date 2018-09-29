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
  public boolean achouBloco;

  /** Construtor padrão para o robô **/
  public Robo() {
    // Aqui você deve inserir seu código
    sala = new Sala();
    mensageiro = new Mensageiro();
  }

  // Aqui você deve completar seu código

  public void buscaBlocos() {
    int blocos = 0;
    for (int i = 0; i < 5; i++) {
      buscaBloco(x, y);
      novaBusca();
      if (sala.matriz[1][1] == sala.BLOCO_PRESENTE) {
        mensageiro.msgFim();
        break;
      }
      if (achouBloco == false) {
        mensageiro.msgNaoAchou();
      } else {
        achouBloco = false;
      }
    }
  }

  public void novaBusca() {
    sala.removeMarcador(sala.MARCA_PRESENTE);
  }

  public void adicionaBloco(int x, int y) {
    sala.marcaPosicaoBusca(x, y, sala.BLOCO_PRESENTE);
  }

  public void adicionaObstaculo(int x, int y) {
    sala.marcaPosicaoBusca(x, y, sala.OBSTACULO_PRESENTE);
  }

  public boolean guardaBloco() {
    for (int i = 0; i <= 1; i++) {
      for (int j = 0; j <=1; j++) {
        boolean guarda = sala.marcaPosicaoArmazenagem(j, i);
        if (guarda == true) {
          mensageiro.mensagem(mensageiro.ARMAZENAGEM, j, i);
          return true;
        }
      }
    }
    return false;
  }

  public boolean buscaBloco(int x, int y){
    if (!sala.posicaoBuscaValida(x, y) || sala.areaArmazenagem(x, y)) {
      return false;
    }

    if (sala.marcadorEm(x, y) == sala.BLOCO_PRESENTE) {
      mensageiro.mensagem(mensageiro.BUSCA, x, y);
      mensageiro.mensagem(mensageiro.CAPTURA, x, y);
      sala.marcaPosicaoBusca(x, y, sala.POSICAO_VAZIA);
      achouBloco = true;
      return true;
    }

    if (sala.marcadorEm(x, y) == sala.OBSTACULO_PRESENTE) {
      mensageiro.mensagem(mensageiro.OBSTACULO, x, y);
      return false;
    }

    if(sala.marcadorEm(x, y) == sala.MARCA_PRESENTE) {
      return false;
    }

    sala.marcaPosicaoBusca(x, y, sala.MARCA_PRESENTE);
    mensageiro.mensagem(mensageiro.BUSCA, x, y);

    if (!achouBloco) buscaBloco(x, (y + 1)); // cima
    if (!achouBloco) buscaBloco((x + 1), y); // direita
    if (!achouBloco) buscaBloco(x, (y - 1)); // baixo
    if (!achouBloco) buscaBloco((x - 1), y); // esquerda
    mensageiro.mensagem(mensageiro.RETORNO, x, y);
    if (achouBloco && x == 0 && y == 2) {
      guardaBloco();
    }
    return false;

  }

  /**
    Retorna instância do mensageiro do robô
  */
  public Mensageiro mensageiro() {
    return(this.mensageiro);
  }
}
