package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.contactos.Adapter.ContactAdapter;
import com.example.contactos.Entities.Contacto;
import com.example.contactos.Factories.RetrofitFactory;
import com.example.contactos.Services.IContactService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegistrarActivity extends AppCompatActivity{
    Contacto contacts = new Contacto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);



        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        EditText Nombre = findViewById(R.id.txtName);
        EditText Tipo = findViewById(R.id.txtTipo);
        EditText Region = findViewById(R.id.textRegion);

        String nombre = Nombre.getText().toString();
        String tipo = Tipo.getText().toString();
        String region = Region.getText().toString();
        Contacto contacto = new Contacto(1,nombre,tipo,region,"http://pngimg.com/uploads/pokemon/pokemon_PNG9.png");
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Retrofit retrofit = RetrofitFactory.build();
                IContactService service = retrofit.create(IContactService.class);
                Call<Contacto> call = service.create(contacts);
                call.enqueue(new Callback<Contacto>() {
                    @Override
                    public void onResponse(Call<Contacto> call, Response<Contacto> response) {

                    }

                    @Override
                    public void onFailure(Call<Contacto> call, Throwable t) {

                    }
                });


                Intent intent = new Intent(RegistrarActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}