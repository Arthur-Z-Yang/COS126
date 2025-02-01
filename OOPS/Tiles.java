public class Tile {
 
    // Returns a cols-by-rows tiling of the specified image.
    public static Picture tile(Picture pattern, int cols, int rows) {
 
        int height = pattern.height();
        int width = pattern.width();
 
        Picture template = new Picture(cols * width, rows * height);
 
        for (int i = 0; i < cols * width; i++) {
            for (int j = 0; j < rows * height; j++) {
                template.set(i, j, pattern.get(i % width, j % height));
            }
        }
 
        return template;
 
    }
 
    // Takes three command-line arguments (the name of the image, the number
    // of columns, and the number of rows), and displays a rectangular tiling
    // of the image with the specified number of columns and rows.
    public static void main(String[] args) {
        String filename = args[0];
        Picture pattern = new Picture(filename);
        int cols = Integer.parseInt(args[1]);
        int rows = Integer.parseInt(args[2]);
 
        Picture tiles = tile(pattern, cols, rows);
 
        tiles.show();
 
 
    }
}
