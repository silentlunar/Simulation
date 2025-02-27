package src.main.java.com.silentlunar;

import src.main.java.com.silentlunar.entities.Entity;

public class Renderer {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001b[36m";


    public void render(MapWorld map) {
        System.out.println(ANSI_CYAN + " =============================================");
        int i = 0;
//        System.out.println("   0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 ");
        for (int height = 0; height < map.height; height++) {
            System.out.print(ANSI_CYAN + i++ + " ");
            for (int widht = 0; widht < map.width; widht++) {
                if (map.isCellEmpty(new Coordinates(widht, height)))
                System.out.print(" ◦ ");
                else {
                    Entity entity = map.getEntity(new Coordinates(widht, height));
                    System.out.print(entity);
                }
            }
            System.out.println(ANSI_RESET + "  ");
        }
        System.out.println(ANSI_CYAN + " =============================================" + ANSI_RESET);
    }
}
