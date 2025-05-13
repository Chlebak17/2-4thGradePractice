package letsWorkWithFiles;

import javax.crypto.spec.PSource;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TonsOfReaders{
    //prostě tady bude hromada metod a u nich popisky, co která dělá
    //Pak si vyberu nejpoužívanější
    //src
    static String filePath = "file.txt";
    static File sourceFile = new File(filePath);

    //readers:
    static BufferedReader br;
    static Scanner sc;
    static FileReader fr;

    //taky děláme často tohle:
    static List<String> lines;

    //writers:
    static BufferedWriter bw;
    static PrintWriter pw;
    static FileWriter fw;


    public static void main(String[] args) throws IOException, FileNotFoundException {
        //Reader
        //BufferedReader
        br = new BufferedReader(new FileReader(filePath));//            tohle funguje
        br = new BufferedReader(new InputStreamReader(System.in));//    tohle taky
        br.read();//                                                    přečte char
        br.readLine();//                                                přečte řádek
        br.skip(2);//                                                přeskočí n počet řádků
        br.lines();//                                                   vrátí stream Stringů
        br.close();//                                                   důležité!!

        //Scanner
        sc = new Scanner(sourceFile);
        sc.next(); //       Čte další token (slovo, číslo...) oddělené mezerou nebo dle patternu
        sc.nextLine(); //	Čte celý řádek jako String
        sc.hasNext();//     Zjistí, jestli je další řádek k přečtení
        sc.close();//       důležitý!!

        //FileReader
        fr = new FileReader(filePath);
        fr.read();//        vrátí char nebo -1 když už nezbývá žádný char
        fr.skip(3);//    taky to umí
        fr.close();//       důležité!!

        //Writer
        //FileWriter
        //umí pracovat s filePath i se souborem
        fw = new FileWriter(filePath);
        fw  = new FileWriter(sourceFile);

        fw.write("neco");//         napíše char,String,nebo i pole charů. A vrací void
        char[] array = {'a','s','s'};
        fw.write(array);

        fw.append("neco");//            appendne něco do tohoto writeru, funguje v podstatě stejně jako write ale vrací Writer
        fw.flush();//                   vyprázdní stream ve writeru a pak ho zavře
        fw.close();//                   pouze zavře writer

        //PrintWriter
        pw = new PrintWriter(new FileWriter(filePath));//   taky je to možné
        pw = new PrintWriter(filePath);
        pw = new PrintWriter(sourceFile);

        pw.print("hello");//            napíše string aniž by ukončil řádek
        pw.printf("Jsem starý %d",25);//napíše formátovaný String aniž by ukončil řádek
        pw.printf("Jsem starý %s","34");
        pw.println("hello");//          napíše string a pokračuje na dalším řádku(pritnout můžu snad všechny datové typy v javě)

        pw.write("afsfa");//         napíše char,String,nebo i pole charů(za sebe)
        pw.append("safasf");//          appendne něco do tohoto writeru, funguje v podstatě stejně jako write ale vrací PrintWriter

        pw.flush();
        pw.close();

        //readAllLines
        lines = Files.readAllLines(Paths.get(filePath));
        OutputStream stream = (OutputStream) lines;// tohle jsem prostě tipnul a funguje(možná) to LOL

        //BufferedWriter(tohle bude sranda)
        bw = new BufferedWriter(new FileWriter(filePath));
        bw = new BufferedWriter(new OutputStreamWriter(stream));
        bw = new BufferedWriter(new PrintWriter(new FileWriter(sourceFile)));

        bw.write("Hello");//    klasicky
        bw.append("World");//       furt to funguje stejně
        bw.newLine();//             ukončí řádek
        bw.flush();
        bw.close();

        //Další možnosti:
        PrintWriter crazy = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
        crazy.println("lol");




    }
}
