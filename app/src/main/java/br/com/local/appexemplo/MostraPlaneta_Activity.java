package br.com.local.appexemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MostraPlaneta_Activity extends AppCompatActivity {

    TextView recebeNomePlanetas;
    ImageView recebeImagemPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostra_planeta_layout);

        recebeNomePlanetas = findViewById(R.id.recebeNomePlaneta);
        recebeImagemPlanetas = findViewById(R.id.recebeIMGPlaneta);

        //receber o nome e a imagem da outra janela

        Intent intent = getIntent();

        String nomePlaneta = intent.getStringExtra("nomePlaneta");
        int imgPlaneta = intent.getIntExtra("imagemPlaneta",0);

        recebeNomePlanetas.setText(nomePlaneta);
        recebeImagemPlanetas.setImageResource(imgPlaneta);


    }
}
