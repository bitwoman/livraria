package com.example.teste.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.teste.R;
import com.example.teste.databinding.FragmentGerenciandoLivrosBinding;

public class GerenciandoLivrosFragment extends Fragment {

    private GerenciandoLivrosViewModel gerenciandoLivrosViewModel;
    private FragmentGerenciandoLivrosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        gerenciandoLivrosViewModel = new ViewModelProvider(this).get(GerenciandoLivrosViewModel.class);

        binding = FragmentGerenciandoLivrosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textGallery;
        gerenciandoLivrosViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView ImagemAtualizar = view.findViewById(R.id.idImagemAtualizar);
        ImageView ImagemExcluir = view.findViewById(R.id.idImagemExcluir);


        ImagemAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        ImagemExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}