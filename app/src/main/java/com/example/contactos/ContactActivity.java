package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.contactos.Entities.Contacto;
import com.example.contactos.Factories.RetrofitFactory;
import com.example.contactos.Services.IContactService;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ContactActivity extends AppCompatActivity {
    List<Contacto> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        String contactJson = getIntent().getStringExtra("CONTACT");
        Contacto contact = new Gson().fromJson(contactJson, Contacto.class);



        ImageView ivAvatar = findViewById(R.id.ivAvatar);
        TextView tvName = findViewById(R.id.tvContactName);
        TextView tvTipo = findViewById(R.id.tvContactTipo);
        TextView tvRegion = findViewById(R.id.tvContactRegion);

        Picasso.get().load("http://pngimg.com/uploads/pokemon/pokemon_PNG9.png").into(ivAvatar);
        //Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/1.svg").into(ivAvatar);
        tvName.setText(contact.Nombre);
        tvTipo.setText(contact.Tipo);
        tvRegion.setText(contact.Region);


        Button btnDelete =  findViewById(R.id.idDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                Retrofit retrofit = RetrofitFactory.build();
                    IContactService service = retrofit.create(IContactService.class);

                    Call<Contacto> call = service.delete(contact.Id);
                    call.enqueue(new Callback<Contacto>() {
                        @Override
                        public void onResponse(Call<Contacto> call, Response<Contacto> response) {
                            contacts.remove(contact.Id);


                        }

                        @Override
                        public void onFailure(Call<Contacto> call, Throwable t) {

                        }
                    });



            }
        });

    }
}