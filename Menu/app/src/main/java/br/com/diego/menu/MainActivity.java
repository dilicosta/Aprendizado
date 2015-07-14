package br.com.diego.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import java.lang.reflect.Type;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla o menu com os botoes do action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Pega o item de menu "Pesquisar"
        MenuItem menuItem = menu.findItem(R.id.action_search);
        // Pega a Action responsavel por este item que foi declarada no menu_main.xml
        SearchView searchView = (SearchView) menuItem.getActionView();
        // Sobrescreve o evento que sera executado apos a digitacao
        searchView.setOnQueryTextListener(onSearch());


        // Pega a Action (declarada no menu_main.xml) responsavel por este item
        ShareActionProvider shareActionProvider = (ShareActionProvider)
                menu.findItem(R.id.action_share).getActionProvider();
        shareActionProvider.setShareIntent(getIntentForShare());

        return true;
    }

    // Implementa o conteudo a ser compartilhado
    private Intent getIntentForShare() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_TEXT, "Texto para compartilhar.");
        return intent;
    }

    // Implementa as acoes de entrada de texto na caixa de pesquisa
    private SearchView.OnQueryTextListener onSearch() {
        return new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // Usuario fez a busca
                mensagem("Buscar o texto: " + query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Mudou o texto digitado
                return false;
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // OBS: uma vez incluido uma actionView para tratar o evento do "Procurar"
        // sua acao nao ira mais passar por este metodod
        if (id == R.id.action_search) {
            mensagem("Clicou em Procurar");
            return true;
        } else if (id == R.id.action_refresh) {
            mensagem("Clicou em Atualizar");
            return true;
        } else if (id == R.id.action_settings) {
            mensagem("Clicou em Configurações");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void mensagem(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
