package br.com.diego.login;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;


public class BemVindoActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_bem_vindo);

        Bundle args = getIntent().getExtras();
        String nome = args.getString("nome");

        TextView text = (TextView) findViewById(R.id.text);
        text.setText(nome + ", seja bem vindo.");

        // Adiciona o botão "up navigation"
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {
            // O método finish() vai encerrar essa activity
            super.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
