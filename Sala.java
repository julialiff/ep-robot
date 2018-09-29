package robo;

/**
	Classe que define a sala por onde o robô passeia. A sala é uma matriz quadrada de largura ISala.TAMANHO_SALA.

	Essa classe deve ser implementada pelo aluno
*/
public class Sala implements ISala {

	// aqui você deve inserir seu código

  public int[][] matriz = new int[TAMANHO_SALA][TAMANHO_SALA];

  public void removeMarcador(int marcador) {
    for (int x = 0; x < TAMANHO_SALA; x++) {
      for (int y = 0; y < TAMANHO_SALA; y++) {
        if (posicaoBuscaValida(x, y) && !areaArmazenagem(x, y) && this.matriz[x][y] == marcador) {
          marcaPosicaoBusca(x, y, POSICAO_VAZIA);
        }
      }
    }
  }

  public void removeMarcador(int x, int y) {
    if (posicaoBuscaValida(x, y) && !areaArmazenagem(x, y) && this.matriz[x][y] != OBSTACULO_PRESENTE && this.matriz[x][y] != BLOCO_PRESENTE) {
      marcaPosicaoBusca(x, y, POSICAO_VAZIA);
    }
  }

  public boolean areaArmazenagem(int x, int y) {
    if (x == X_INICIO_ARM || x == X_FIM_ARM) {
      if (y == Y_INICIO_ARM || y == Y_FIM_ARM) {
        return true;
      }
    }
    return false;
  }

  public boolean marcaPosicaoArmazenagem(int x, int y) {
    if (!areaArmazenagem(x, y) || marcadorEm(x, y) == BLOCO_PRESENTE) {
      return false;
    } else {
      this.matriz[x][y] = BLOCO_PRESENTE;
      return true;
    }
  }

  public boolean marcaPosicaoBusca(int x, int y, int marcador) {
    if (!posicaoBuscaValida(x, y) && areaArmazenagem(x, y)) {
      return false;
    }
    this.matriz[x][y] = marcador;
    return true;
  }

  public int marcadorEm(int x, int y) {
    return this.matriz[x][y];
  }

  public boolean posicaoBuscaValida(int x, int y) {
    if (x < 0 || x > 9 || y < 0 || y > 9){
      return false;
    } else {
      return true;
    }
  }
}
