package robo;

/**
	Classe que define a sala por onde o robô passeia. A sala é uma matriz quadrada de largura ISala.TAMANHO_SALA.

	Essa classe deve ser implementada pelo aluno
*/
public class Sala implements ISala {

	// aqui você deve inserir seu código

  public void removeMarcador(int marcador) {
    System.out.println("oi");
  }

  public void removeMarcador(int x, int y) {
    System.out.println("oi");
  }

  public boolean areaArmazenagem(int x, int y) {
    if (x == X_INICIO_ARM || x == X_FIM_ARM && y == Y_INICIO_ARM || y == Y_FIM_ARM) {
      return true;
    } else {
      return false;
    }
  }

  public boolean marcaPosicaoArmazenagem(int x, int y) {
    System.out.println("oi");
    return true;
  }

  public boolean marcaPosicaoBusca(int x, int y, int marcador) {
    if (!posicaoBuscaValida(x, y) && areaArmazenagem(x, y)) {
      return false;
    }
    sala[x][y] = marcador;
    return true;
  }

  public int marcadorEm(int x, int y) {
    System.out.println("oi");
    return 1;
  }

  public boolean posicaoBuscaValida(int x, int y) {
    if (x < 0 || x > 9 || y < 0 || y > 9){
      return false;
    } else {
      return true;
    }
  }
}
