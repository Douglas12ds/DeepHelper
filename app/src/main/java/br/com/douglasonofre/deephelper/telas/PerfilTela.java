package br.com.douglasonofre.deephelper.telas;

import androidx.appcompat.app.AppCompatActivity;
import br.com.douglasonofre.deephelper.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.douglasonofre.deephelper.dados.Perfil;

public class PerfilTela extends AppCompatActivity {
    
    
    TextView txtNivel;
    TextView txtXp;
    Button btnResetar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        
        final Perfil perfil = new Perfil(0,0);
    
        txtNivel = (TextView) findViewById(R.id.txtNivel);
        txtXp = (TextView) findViewById(R.id.txtXp);
        btnResetar = (Button) findViewById(R.id.btnResetar);
        
        btnResetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              perfil.reiniciar();
            }
            });
    }
}
