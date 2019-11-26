package br.com.douglasonofre.deephelper;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import br.com.douglasonofre.deephelper.banco.MetaDAO;
import br.com.douglasonofre.deephelper.dados.Meta;
import br.com.douglasonofre.deephelper.dados.Perfil;
import br.com.douglasonofre.deephelper.telas.CriarMeta;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    MetaDAO dao;
    Perfil jogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = new MetaDAO(this);
        jogador = new Perfil(1,0);
        ListAdapter adapter = new ListAdapter(this, dao.getMetas());
        listView = (ListView)findViewById(R.id.lstMetas);
        listView.setAdapter(adapter);
    }

    /*protected void onListItemClick(ListView l, View v, int posicao, long id) {
        Meta meta = (Meta) listView.getListAdapter().getItem(posicao);
        dao.atualizarMeta(meta.getId());
        if (meta.getPrioridade() == "baixa"){
            jogador.setXp(jogador.getXp()+250);
            jogador.levelUp();
        } else if (meta.getPrioridade() == "media") {
            jogador.setXp(jogador.getXp()+500);
            jogador.levelUp();
        } else if (meta.getPrioridade() == "alta") {
            jogador.setXp(jogador.getXp()+1000);
            jogador.levelUp();
        }
        listView.setListAdapter(new ListAdapter(this, dao.getMetas()));
        Toast.makeText(getApplicationContext(), "Concluido!", Toast.LENGTH_LONG).show();
    }
    */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, CriarMeta.class);
        startActivity(intent);
        dao.fechar();
        return super.onOptionsItemSelected(item);
    }
}
