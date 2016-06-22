import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * mt para mostrar todos los archivos utilizando un bucle "for each"...............................0042
     */
    public void listAllFiles(){
        int cont = 1;
        for(String file: files ){
            System.out.println(cont+ " " +file);
            cont ++;
        }
    }

    /**
     * imprime por pantalla aquellos archivo que contienen una cadena dada. ..............................0044
     */
    public void listMatching(String searchString){
        boolean contieneCadena = false;
        for(String filename: files){
            if(filename.contains(searchString)){
                System.out.println(filename);
                contieneCadena = true;
            }
        }
        if( !contieneCadena){
            System.out.println("Error, el texto escrito no se encuentra en ningún archivo.");
        }
    }

    /**
     * reproduzca los primeros segundos de todas las canciones de un determinado artista pasado como parámetro. 
     */
    public void startAllSongArtist(String nameArtist){   //---------------------- 0044
        for(String nameFile: files){
            if(nameFile.contains(nameArtist)){
                player.playSample(nameFile);
            }
        }
    }

    /**
     * A partir del código terminado de la actividad 0044, añade el método findFirst. Este método debe 
     * recibir una cadena como parámetro y devolver el índice del primer archivo que contiene dicha cadena o
     * el valor -1 en caso de que no se encuentre ningún archivo que cumpla la condición. Debe usar un bucle while y
     * la condición debe ser exactamente:   while (!found && index < files.size())
     */
    public int findFirst(String cadena){ //------------------------------ 0048
        int index = 0;
        boolean found = false;
        int sizeColection = files.size();
        while (!found && index < sizeColection){
            if(files.get(index).contains(cadena)){
                found = true;
            }
            else{
                index += 1;
            }
        }
        if(!found){
            index = -1;
        }
        return index;
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
}
