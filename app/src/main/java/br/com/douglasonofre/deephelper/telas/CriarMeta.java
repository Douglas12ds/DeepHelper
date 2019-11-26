package br.com.douglasonofre.deephelper.telas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.douglasonofre.deephelper.R;
import br.com.douglasonofre.deephelper.banco.MetaDAO;

public class CriarMeta extends AppCompatActivity {

    private EditText txtTextoMeta;
    private EditText txtPrioridade;
    private Button btnSalvar;

    private MetaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_meta);

        dao = new MetaDAO(this);

        txtTextoMeta = (EditText) findViewById(R.id.txtTexto);
        txtPrioridade = (EditText) findViewById(R.id.txtPrioridade);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String metaTexto = txtTextoMeta.getText().toString();
                String metaPrioridade = txtPrioridade.getText().toString();

                txtTextoMeta.setText("");
                txtPrioridade.setText("");

                dao.criarMeta(metaTexto, "falso", metaPrioridade);

                Toast.makeText(getApplicationContext(), "Nova meta adicionada!", Toast.LENGTH_LONG).show();
                CriarMeta.super.finish();
            }
        });
    }

}
