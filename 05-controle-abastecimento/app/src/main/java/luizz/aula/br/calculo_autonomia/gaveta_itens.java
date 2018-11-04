package luizz.aula.br.calculo_autonomia;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
//classe que ira mostrar os conteudos da lista
public class gaveta_itens extends RecyclerView.ViewHolder {

    private TextView  tvdata, tvfuel, tvposto, tvkm;

    public gaveta_itens(@NonNull View itemView) {
        super(itemView);

        this.tvkm = itemView.findViewById(R.id.distance_view);
        this.tvdata = itemView.findViewById(R.id.date_view);
       // this.tvposto = itemView.findViewById(R.id.image_posto);
        this.tvfuel = itemView.findViewById(R.id.liters_view);

    }

    public void atualiza_ItemLista(Info_List_Item item){
        this.tvkm.setText("Km: "+item.getDistancia());
        this.tvdata.setText(item.getData());
        //this.tvposto.setText(item.getPosto());
        this.tvfuel.setText(item.getLitros()+"L");
    }
}
