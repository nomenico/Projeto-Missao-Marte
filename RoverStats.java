public class RoverStats {

    private static int energia = 100; // A energia do rover
    private static int integridade = 100; // A vida do Rover
    private static int posX = 0; // Posição do Rover no eixo X (horizontal)
    private static int posY = 0; // Posição do Rover no eixo Y (vertical)

    public static int getEnergia() {
        return energia;
    }

    public static void setEnergia(int energia) {
        RoverStats.energia = energia;
    }

    public static int getIntegridade() {
        return integridade;
    }

    public static void setIntegridade(int integridade) {
        RoverStats.integridade = integridade;
    }

    public static int getPosX() {
        return posX;
    }

    public static void setPosX(int posX) {
        RoverStats.posX = posX;
    }

    public static int getPosY() {
        return posY;
    }

    public static void setPosY(int posY) {
        RoverStats.posY = posY;
    }
}
