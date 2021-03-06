package br.com.usp.willianerodrigues.course.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import br.com.usp.willianerodrigues.course.CourseApplication;
import br.com.usp.willianerodrigues.course.R;
import br.com.usp.willianerodrigues.course.activity.FinishExerciceActivity;

public class FragmentExerciceSO3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercice_so_3, container, false);

        movimentarProgressBar(inflater, container);

        ((view.findViewById(R.id.exercice_advanced_3_o1))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Resposta Incorreta!")
                        .setMessage("Errado!.\n" +
                                "Os processos representam tarefas em execução, mas nem todas têm relação direta com algum aplicativo.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    ((CourseApplication) getActivity().getApplicationContext()).inserirPontuacaoUser(28);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                Intent intent = new Intent(getActivity(), FinishExerciceActivity.class);
                                intent.putExtra("passou", getActivity().getResources().getString(R.string.operational_systems));
                                getActivity().startActivity(intent);
                                getActivity().finish();
                            }
                        })
                        .create().show();
            }
        });

        ((view.findViewById(R.id.exercice_advanced_3_o2))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Resposta Correta!")
                        .setMessage("Correto!\n" +
                                "Os processos representam tarefas em execução, mas nem todas têm relação direta com algum aplicativo.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    ((CourseApplication) getActivity().getApplicationContext()).inserirPontuacaoUser(33);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                Intent intent = new Intent(getActivity(), FinishExerciceActivity.class);
                                intent.putExtra("passou", getActivity().getResources().getString(R.string.operational_systems));
                                getActivity().startActivity(intent);
                                getActivity().finish();
                            }
                        })
                        .create().show();
            }
        });

        ((view.findViewById(R.id.exercice_advanced_3_nao_sei))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Ops!")
                        .setMessage("Parece que você não sabe a resposta! Então vamos lá, a resposta correta é Errado, porque " +
                                "os processos representam tarefas em execução, mas nem todas têm relação direta com algum aplicativo.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    ((CourseApplication) getActivity().getApplicationContext()).inserirPontuacaoUser(30);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                Intent intent = new Intent(getActivity(), FinishExerciceActivity.class);
                                intent.putExtra("passou", getActivity().getResources().getString(R.string.operational_systems));
                                getActivity().startActivity(intent);
                                getActivity().finish();
                            }
                        })
                        .create().show();
            }
        });

        return view;
    }

    private void movimentarProgressBar(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.activity_exercice, container, false);

        ProgressBar bar = (ProgressBar) view.findViewById(R.id.progressBar_exercice);
        bar.setProgress(33);
    }
}
