package luizz.aula.br.calculo_autonomia;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Info_ListDAO {

    private static ArrayList<Info_List_Item> Cache = new ArrayList<Info_List_Item>();
    private static final String Nome_Arquivo = "dados1.txt";

    //salva o dado no arquivo e na cahce
    public static boolean salvar(Context c, Info_List_Item itemSave){
        //Cache.add(0,itemSave);
        Cache.add(itemSave);

        String adpt = "";
        adpt+= itemSave.getPosto()+";";
        adpt+= itemSave.getDistancia()+";";
        adpt+= itemSave.getLitros()+";";
        adpt+= itemSave.getData()+"\n";

        File refArquivo = new File(c.getFilesDir().getPath()+Nome_Arquivo);
        try {
            FileWriter escritor = new FileWriter(refArquivo, true);
            escritor.write(adpt);
            escritor.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //carrega a cache com a lista de itens
    public static  ArrayList<Info_List_Item> carrega_Lista(Context c){
        Cache = new ArrayList<Info_List_Item>();

        File refArquivo = new File(c.getFilesDir().getPath() + Nome_Arquivo);

        try{
            FileReader leitor = new FileReader(refArquivo);
            BufferedReader leitor_Linha = new BufferedReader(leitor);

            String linha=null;

            while((linha = leitor_Linha.readLine()) != null){

                String[] parte_Linha = linha.split(";");
                Info_List_Item item = new Info_List_Item();
                item.setPosto(Integer.parseInt(parte_Linha[0]));
                item.setDistancia(Double.parseDouble(parte_Linha[1]));
                item.setLitros(Double.parseDouble(parte_Linha[2]));
                item.setData(parte_Linha[3]);
                Cache.add(item);
                //Cache.add(0, item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Cache;
    }

}
