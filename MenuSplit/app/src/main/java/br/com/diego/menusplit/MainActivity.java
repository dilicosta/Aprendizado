package br.com.diego.menusplit;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Altera o titulo do menu dinamicamente
        super.getActionBar().setTitle("Menu Dividido");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla o menu com os botoes do action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
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
