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
import br.com.usp.willianerodrigues.course.model.Usuario;

public class FragmentExerciceInitial3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercice_initial_3, container, false);

        movimentarProgressBar(inflater, container);

        final Usuario usuario = ((CourseApplication) getActivity().getApplicationContext()).getUsuario();

        ((view.findViewById(R.id.exercice_advanced_3_o1))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Resposta Incorreta!")
                        .setMessage("A resposta correta é o BIT.\n" +
                                "Bit (simplificação para dígito binário, \" Binary digit \" em inglês) é a menor unidade de informação que pode ser armazenada ou transmitida, usada na Computação e na Teoria da Informação. Um bit pode assumir somente 2 valores: 0 ou 1, corte ou passagem de energia respectivamente.\n" +
                                "Embora os computadores tenham instruções (ou comandos) que possam testar e manipular bits, geralmente são idealizados para armazenar instruções em múltiplos de bits, chamados bytes.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                usuario.setPontuacao(28);
                                ((CourseApplication) getActivity().getApplicationContext()).setUsuario(usuario);
                                Intent intent = new Intent(getActivity(), FinishExerciceActivity.class);
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
                        .setMessage("O OVERCLOCK," +
                                "Bit (simplificação para dígito binário, \" Binary digit \" em inglês) é a menor unidade de informação que pode ser armazenada ou transmitida, usada na Computação e na Teoria da Informação. Um bit pode assumir somente 2 valores: 0 ou 1, corte ou passagem de energia respectivamente.\n" +
                                "Embora os computadores tenham instruções (ou comandos) que possam testar e manipular bits, geralmente são idealizados para armazenar instruções em múltiplos de bits, chamados bytes.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                usuario.setPontuacao(33);
                                ((CourseApplication) getActivity().getApplicationContext()).setUsuario(usuario);
                                Intent intent = new Intent(getActivity(), FinishExerciceActivity.class);
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
                        .setMessage("Parece que você não sabe a resposta! Então vamos lá, a resposta correta é BIT." +
                                "Bit (simplificação para dígito binário, \" Binary digit \" em inglês) é a menor unidade de informação que pode ser armazenada ou transmitida, usada na Computação e na Teoria da Informação. Um bit pode assumir somente 2 valores: 0 ou 1, corte ou passagem de energia respectivamente.\n" +
                                "Embora os computadores tenham instruções (ou comandos) que possam testar e manipular bits, geralmente são idealizados para armazenar instruções em múltiplos de bits, chamados bytes.")
                        .setPositiveButton(R.string.alert_exercice_positive_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                usuario.setPontuacao(30);
                                ((CourseApplication) getActivity().getApplicationContext()).setUsuario(usuario);
                                Intent intent = new Intent(getActivity(), FinishExerciceActivity.class);
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
