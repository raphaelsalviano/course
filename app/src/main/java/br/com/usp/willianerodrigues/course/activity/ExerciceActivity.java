package br.com.usp.willianerodrigues.course.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.usp.willianerodrigues.course.CourseApplication;
import br.com.usp.willianerodrigues.course.R;
import br.com.usp.willianerodrigues.course.fragments.FragmentExerciceAdvanced1;
import br.com.usp.willianerodrigues.course.fragments.FragmentExerciceConhecaPc1;
import br.com.usp.willianerodrigues.course.fragments.FragmentExerciceEditText1;
import br.com.usp.willianerodrigues.course.fragments.FragmentExerciceInitial1;
import br.com.usp.willianerodrigues.course.fragments.FragmentExerciceSO1;
import br.com.usp.willianerodrigues.course.fragments.FragmentUserAdvancedWill;
import br.com.usp.willianerodrigues.course.model.ItemMenu;
import br.com.usp.willianerodrigues.course.model.Usuario;

public class ExerciceActivity extends AppCompatActivity implements View.OnClickListener {

    private String local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);

        CourseApplication application = (CourseApplication) getApplicationContext();
        List<ItemMenu> itemMenus = new ArrayList<>();

        try {
            itemMenus = application.getAllItens();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        if (getIntent().getExtras() != null) {
            local = getIntent().getExtras().getString("exercice");
        }

        ((findViewById(R.id.close_exercice))).setOnClickListener(this);

        if (local.equalsIgnoreCase("advanced")) {
            application.setUsuario(new Usuario());
            getSupportFragmentManager().beginTransaction().replace(R.id.container_exercice,
                    new FragmentExerciceAdvanced1()).commit();
        } else if (local.equalsIgnoreCase("apresentacao")) {
            application.setUsuario(new Usuario());
            getSupportFragmentManager().beginTransaction().replace(R.id.container_exercice,
                    new FragmentExerciceInitial1()).commit();
        } else if (local.equalsIgnoreCase("main")) {
            String itemText = getIntent().getExtras().getString("item");
            if (itemText != null && itemText.equalsIgnoreCase(itemMenus.get(0).getName())) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container_exercice,
                        new FragmentExerciceConhecaPc1()).commit();
            } else if (itemText != null && itemText.equalsIgnoreCase(itemMenus.get(1).getName())) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container_exercice,
                        new FragmentExerciceSO1()).commit();
            } else if (itemText != null && itemText.equalsIgnoreCase(itemMenus.get(2).getName())) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container_exercice,
                        new FragmentExerciceEditText1()).commit();
            } else if (itemText != null && itemText.equalsIgnoreCase(itemMenus.get(3).getName())) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container_exercice,
                        new FragmentExerciceInitial1()).commit();
            } else if (itemText != null && itemText.equalsIgnoreCase(itemMenus.get(4).getName())) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container_exercice,
                        new FragmentExerciceInitial1()).commit();
            } else if (itemText != null && itemText.equalsIgnoreCase(itemMenus.get(5).getName())) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container_exercice,
                        new FragmentExerciceInitial1()).commit();
            }

        }
    }

    @Override
    public void onClick(View v) {
        new AlertDialog.Builder(ExerciceActivity.this)
                .setTitle(R.string.alert_close_title)
                .setMessage(R.string.alert_close_message)
                .setPositiveButton(R.string.alert_close_positive_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = generateIntentBack();
                        if (intent != null) {
                            startActivity(intent);
                            finish();
                        }
                    }
                })
                .setNegativeButton(R.string.alert_close_negative_button, null)
                .create().show();
    }

    private Intent generateIntentBack() {

        Intent intent = null;
        if (local.equalsIgnoreCase("advanced")) {
            intent = new Intent(this, AssitVirtualActivit.class);
            intent.putExtra("will", local);
        } else if (local.equalsIgnoreCase("apresentacao")) {
            intent = new Intent(this, AssitVirtualActivit.class);
            intent.putExtra("will", local);
        } else if (local.equalsIgnoreCase("main")) {
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
        finish();
        return intent;
    }
}
