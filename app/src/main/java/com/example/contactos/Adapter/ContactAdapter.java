package com.example.contactos.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactos.ContactActivity;
import com.example.contactos.Entities.Contacto;
import com.example.contactos.Factories.RetrofitFactory;
import com.example.contactos.R;
import com.example.contactos.Services.IContactService;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    List<Contacto> contacts;
    public ContactAdapter(List<Contacto> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder vh, int position) {

        View itemView = vh.itemView;

        Contacto contact = contacts.get(position);

        TextView tvContactName = itemView.findViewById(R.id.tvContactNombre);
        TextView tvContactTipo = itemView.findViewById(R.id.tvContactTipo);
        TextView tvContactRegion = itemView.findViewById(R.id.tvContactRegion);
        ImageView ivAvatar = itemView.findViewById(R.id.ivAvatar );


        tvContactName.setText(contact.Nombre);
        tvContactTipo.setText(contact.Tipo);
        tvContactRegion.setText(contact.Region);
       // Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/"+position+".svg").into(ivAvatar);
       Picasso.get().load("https://static.wikia.nocookie.net/dragonball/images/2/2e/Goku_Joven_Flashback.jpg/revision/latest?cb=20170809015919&path-prefix=es").into(ivAvatar);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), ContactActivity.class);

                String contactJSON = new Gson().toJson(contact);
                intent.putExtra("CONTACT", contactJSON);


                itemView.getContext().startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnItemClickListener {

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Contacto contact = contacts.get(i);
            Log.i("APP_VJ20202", "click en el elemento" + contact.Id);
        }
    }
}
