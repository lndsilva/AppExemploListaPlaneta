package br.com.local.appexemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listaplanetas;

    String[] nomePlanetas = {"Marte", "Terra"};

    int[] imagemPlanetas = {R.drawable.marte, R.drawable.terra};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaplanetas = findViewById(R.id.listaPlanetas);

        MeuAdaptador meuAdaptador = new MeuAdaptador();
        listaplanetas.setAdapter(meuAdaptador);

        //fazendo o clique

        listaplanetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),
                        MostraPlaneta_Activity.class);
                //passando o nome e a imagem para outra janela
                intent.putExtra("nomePlaneta",nomePlanetas[position]);
                intent.putExtra("imagemPlaneta",imagemPlanetas[position]);

                startActivity(intent);
            }
        });


    }

    public class MeuAdaptador extends BaseAdapter {

        @Override
        public int getCount() {
            return imagemPlanetas.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView txtNomePlaneta;
            ImageView IMGImagemPlaneta;

            View view = getLayoutInflater().inflate(R.layout.modeloplanetas, null);

            txtNomePlaneta = view.findViewById(R.id.nomedoplaneta);
            IMGImagemPlaneta = view.findViewById(R.id.imagemdoplaneta);

            txtNomePlaneta.setText(nomePlanetas[position]);
            IMGImagemPlaneta.setImageResource(imagemPlanetas[position]);


            return view;
        }
    }
}
