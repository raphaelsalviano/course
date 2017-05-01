package br.com.usp.willianerodrigues.course.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.sql.SQLException;

import br.com.usp.willianerodrigues.course.CourseApplication;
import br.com.usp.willianerodrigues.course.R;
import br.com.usp.willianerodrigues.course.model.Usuario;

public class FinishExerciceActivity extends AppCompatActivity {

    private CourseApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_exercice);

        application = (CourseApplication) getApplicationContext();
        Usuario usuario = null;

        TextView pontuacao = (TextView) findViewById(R.id.text_pontuacao);
        ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar_finish_exercice);
        bar.setMax(16);
        bar.setIndeterminate(false);
        TextView porcentagemNivel = (TextView) findViewById(R.id.porcentagem_concluido);
        TextView textoMeta = (TextView) findViewById(R.id.texto_de_meta);
        TextView MenssagemMeta = (TextView) findViewById(R.id.messagem_texto_de_meta);

        try {
            usuario = application.getUserActive();
            if (usuario != null) {
                application.inserirPontuacaoUser();
                application.resetPontuacao();
                pontuacao.setText(usuario.getPontuacao());
                bar.setProgress(usuario.getPontuacao());
                porcentagemNivel.setText((usuario.getPontuacao() * 100) / 16);
            } else {
                Log.i("TAG", "Exception");
                pontuacao.setText(application.getPontuacao());
                bar.setProgress(application.getPontuacao());
                porcentagemNivel.setText((application.getPontuacao() * 100) / 46);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_finish_exercice);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setTitle("");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.finish_exerccie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.action_done){
            try{
                Usuario usuario = application.getUserActive();
                if(usuario == null){
                    Intent intent = new Intent(this, RegistroActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }catch (SQLException e){
                e.getMessage();
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
